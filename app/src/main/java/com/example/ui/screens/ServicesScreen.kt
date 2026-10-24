package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ServiceItem
import com.example.data.StudioRepository
import com.example.data.WebSolution
import com.example.ui.components.AmberButton
import com.example.ui.components.SecondaryGlassButton
import com.example.ui.components.SpecBadge
import com.example.ui.components.ToolChip
import com.example.ui.components.openWhatsApp
import com.example.ui.theme.AmberGold
import com.example.ui.theme.BorderHighlight
import com.example.ui.theme.BorderSubtle
import com.example.ui.theme.CyanGlow
import com.example.ui.theme.ElectricPurple
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.NeonCyan
import com.example.ui.theme.Obsidian700
import com.example.ui.theme.Obsidian800
import com.example.ui.theme.Obsidian900
import com.example.ui.theme.Obsidian950
import com.example.ui.theme.SurfaceCard
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesScreen(
    initialServiceId: String? = null,
    onNavigateToEstimator: (String) -> Unit
) {
    val context = LocalContext.current
    val services = StudioRepository.services
    val solutions = StudioRepository.webSolutions

    var selectedMainTab by remember { mutableIntStateOf(0) }
    var selectedCategoryFilter by remember { mutableStateOf("all") }
    var detailService by remember {
        mutableStateOf(
            if (initialServiceId != null) services.find { it.id == initialServiceId } else null
        )
    }

    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    val filteredServices = if (selectedCategoryFilter == "all") {
        services
    } else {
        services.filter { it.category == selectedCategoryFilter }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Obsidian950)
            .testTag("services_screen")
    ) {
        // Top Section Title
        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)) {
            SpecBadge(text = "EXECUTIVE DESIGN & WEB CAPABILITIES")
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Services & Solutions",
                style = MaterialTheme.typography.headlineSmall,
                color = TextPrimary
            )
            Text(
                text = "Full-service digital engineering, CorelDRAW print layouts, and brand systems.",
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Main Tab Switcher: Services vs Web Architecture
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Obsidian900)
                .border(1.dp, BorderSubtle, RoundedCornerShape(12.dp))
                .padding(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (selectedMainTab == 0) AmberGold else Color.Transparent)
                    .clickable { selectedMainTab = 0 }
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Core Services (6)",
                    color = if (selectedMainTab == 0) Obsidian950 else TextSecondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (selectedMainTab == 1) AmberGold else Color.Transparent)
                    .clickable { selectedMainTab = 1 }
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Web Solutions (5)",
                    color = if (selectedMainTab == 1) Obsidian950 else TextSecondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (selectedMainTab == 0) {
            // Category Filter Pills
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val filters = listOf(
                    "all" to "All Services",
                    "web-app" to "Web & Apps",
                    "logo" to "Logos",
                    "business-card" to "Cards & Print",
                    "product" to "Packaging",
                    "banner" to "Banners",
                    "brand-identity" to "Brand Suite"
                )
                items(filters) { (id, label) ->
                    val isSelected = selectedCategoryFilter == id
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(if (isSelected) AmberGold else Obsidian900)
                            .border(1.dp, if (isSelected) AmberGold else BorderSubtle, RoundedCornerShape(20.dp))
                            .clickable { selectedCategoryFilter = id }
                            .padding(horizontal = 14.dp, vertical = 7.dp)
                    ) {
                        Text(
                            text = label,
                            color = if (isSelected) Obsidian950 else TextSecondary,
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Services List
            LazyColumn(
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 90.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(filteredServices) { service ->
                    ServiceDetailedCard(
                        service = service,
                        onViewDetails = { detailService = service },
                        onQuoteClick = { onNavigateToEstimator(service.id) }
                    )
                }
            }
        } else {
            // Web Solutions List
            LazyColumn(
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 90.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Obsidian900),
                        border = androidx.compose.foundation.BorderStroke(1.dp, NeonCyan.copy(alpha = 0.3f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            SpecBadge(text = "HOSTINGER & WORDPRESS ARCHITECTURE", textColor = NeonCyan)
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Engineered For Speed & Full Autonomy",
                                style = MaterialTheme.typography.titleMedium,
                                color = TextPrimary
                            )
                            Text(
                                text = "Every business gets the right foundation: WordPress CMS for easy self-editing, LiteSpeed caching on Hostinger for high speeds, and responsive mobile architecture.",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextSecondary
                            )
                        }
                    }
                }

                items(solutions) { solution ->
                    WebSolutionCard(
                        solution = solution,
                        onInquire = {
                            openWhatsApp(
                                context,
                                "Hello Creative Design Studio! I am interested in building a ${solution.title}."
                            )
                        }
                    )
                }
            }
        }
    }

    // Deliverables & Specs Bottom Sheet
    detailService?.let { service ->
        ModalBottomSheet(
            onDismissRequest = { detailService = null },
            sheetState = bottomSheetState,
            containerColor = Obsidian900,
            tonalElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SpecBadge(text = service.shortTag)
                    IconButton(onClick = { scope.launch { bottomSheetState.hide() }.invokeOnCompletion { detailService = null } }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = TextSecondary
                        )
                    }
                }

                Text(
                    text = service.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = TextPrimary
                )
                Text(
                    text = service.tagline,
                    style = MaterialTheme.typography.bodySmall,
                    color = AmberGold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "Starting Price", color = TextMuted, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                        Text(text = service.startingPrice, color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Column {
                        Text(text = "Turnaround", color = TextMuted, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                        Text(text = service.estimatedTurnaround, color = NeonCyan, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "Tools & Production Engines",
                    color = TextPrimary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    items(service.techOrMaterials) { tool ->
                        ToolChip(text = tool)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Deliverables Package Checklist",
                    color = TextPrimary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn(modifier = Modifier.height(180.dp)) {
                    items(service.deliverables) { item ->
                        Row(
                            verticalAlignment = Alignment.Top,
                            modifier = Modifier.padding(vertical = 3.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = EmeraldSuccess,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = item,
                                color = TextSecondary,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                AmberButton(
                    text = "Calculate Project Cost & Brief",
                    onClick = {
                        val sId = service.id
                        detailService = null
                        onNavigateToEstimator(sId)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    icon = Icons.AutoMirrored.Filled.ArrowForward
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun ServiceDetailedCard(
    service: ServiceItem,
    onViewDetails: () -> Unit,
    onQuoteClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpecBadge(
                    text = service.shortTag,
                    textColor = AmberGold,
                    backgroundColor = AmberGold.copy(alpha = 0.1f)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = null,
                        tint = TextMuted,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = service.estimatedTurnaround,
                        color = TextMuted,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.Monospace
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = service.name,
                style = MaterialTheme.typography.titleLarge,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = service.description,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Deliverables snippet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Obsidian900)
                    .padding(10.dp)
            ) {
                Text(
                    text = "Key Deliverables:",
                    color = TextMuted,
                    fontSize = 10.sp,
                    fontFamily = FontFamily.Monospace
                )
                Spacer(modifier = Modifier.height(4.dp))
                service.deliverables.take(3).forEach { deliverable ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 1.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(4.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(AmberGold)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = deliverable,
                            color = TextPrimary,
                            fontSize = 11.sp,
                            maxLines = 1
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "From ${service.startingPrice}",
                        color = AmberGold,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )
                    Text(
                        text = "Zero hidden fees · 100% IP",
                        color = TextMuted,
                        fontSize = 9.sp
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    SecondaryGlassButton(
                        text = "Specs",
                        onClick = onViewDetails,
                        icon = Icons.Default.Info
                    )
                    AmberButton(
                        text = "Quote",
                        onClick = onQuoteClick,
                        icon = Icons.AutoMirrored.Filled.ArrowForward
                    )
                }
            }
        }
    }
}

@Composable
fun WebSolutionCard(
    solution: WebSolution,
    onInquire: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            SpecBadge(
                text = solution.subtitle,
                textColor = NeonCyan,
                backgroundColor = NeonCyan.copy(alpha = 0.1f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = solution.title,
                style = MaterialTheme.typography.titleLarge,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = solution.description,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Obsidian900)
                    .padding(10.dp)
            ) {
                Text(
                    text = "Recommended Stack: ${solution.recommendedTech}",
                    color = AmberGold,
                    fontSize = 10.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                solution.keyFeatures.forEach { feature ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 1.5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = CyanGlow,
                            modifier = Modifier.size(12.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = feature,
                            color = TextPrimary,
                            fontSize = 11.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            AmberButton(
                text = "Inquire About ${solution.title.split(" ").first()}",
                onClick = onInquire,
                modifier = Modifier.fillMaxWidth(),
                icon = Icons.Default.Send
            )
        }
    }
}
