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
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioProject
import com.example.data.StudioRepository
import com.example.ui.components.AmberButton
import com.example.ui.components.SecondaryGlassButton
import com.example.ui.components.SpecBadge
import com.example.ui.components.ToolChip
import com.example.ui.components.openWhatsApp
import com.example.ui.theme.AmberGold
import com.example.ui.theme.BorderHighlight
import com.example.ui.theme.BorderSubtle
import com.example.ui.theme.CyanGlow
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.NeonCyan
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
fun PortfolioScreen(
    onNavigateToEstimator: (String) -> Unit
) {
    val context = LocalContext.current
    val projects = StudioRepository.portfolioProjects
    var selectedCategory by remember { mutableStateOf("all") }
    var selectedProject by remember { mutableStateOf<PortfolioProject?>(null) }
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    val filteredProjects = if (selectedCategory == "all") {
        projects
    } else {
        projects.filter { it.category == selectedCategory }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Obsidian950)
            .testTag("portfolio_screen")
    ) {
        // Title
        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)) {
            SpecBadge(text = "CURATED WORK SHOWCASE")
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Portfolio Case Studies",
                style = MaterialTheme.typography.headlineSmall,
                color = TextPrimary
            )
            Text(
                text = "Real client deliverables engineered in CorelDRAW, Illustrator, WordPress, and Hostinger.",
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Categories Filter
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val categories = listOf(
                "all" to "All Projects",
                "web-app" to "Web & App Design",
                "logo" to "Logos",
                "business-card" to "Business Cards",
                "product" to "Packaging",
                "banner" to "Flex & Banners",
                "brand-identity" to "Brand Identity"
            )
            items(categories) { (id, label) ->
                val isSelected = selectedCategory == id
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(if (isSelected) AmberGold else Obsidian900)
                        .border(1.dp, if (isSelected) AmberGold else BorderSubtle, RoundedCornerShape(20.dp))
                        .clickable { selectedCategory = id }
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

        // Projects List
        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 90.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(filteredProjects) { project ->
                PortfolioProjectCard(
                    project = project,
                    onViewSpecs = { selectedProject = project },
                    onInquire = {
                        openWhatsApp(
                            context,
                            "Hello Creative Design Studio! I am reviewing your case study '${project.title}' for client ${project.client} and would like to build a similar project."
                        )
                    }
                )
            }
        }
    }

    // Specifications Modal Bottom Sheet
    selectedProject?.let { project ->
        ModalBottomSheet(
            onDismissRequest = { selectedProject = null },
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
                    SpecBadge(text = project.categoryLabel)
                    IconButton(onClick = { scope.launch { bottomSheetState.hide() }.invokeOnCompletion { selectedProject = null } }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = TextSecondary)
                    }
                }

                Text(
                    text = project.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = TextPrimary
                )
                Text(
                    text = "Client: ${project.client}",
                    color = AmberGold,
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Monospace
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = project.tagline,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary,
                    lineHeight = 18.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Technical Spec Grid
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Obsidian950)
                        .border(1.dp, BorderHighlight, RoundedCornerShape(12.dp))
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Format:", color = TextMuted, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                        Text(text = project.format, color = TextPrimary, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Finish/Stack:", color = TextMuted, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                        Text(text = project.finishOrStack, color = NeonCyan, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Timeline:", color = TextMuted, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                        Text(text = project.timeline, color = EmeraldSuccess, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Tools Used:", color = TextMuted, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                        Text(text = project.toolsUsed, color = AmberGold, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "Delivered Project Assets:",
                    color = TextPrimary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))

                LazyColumn(modifier = Modifier.height(130.dp)) {
                    items(project.deliverables) { del ->
                        Row(
                            verticalAlignment = Alignment.Top,
                            modifier = Modifier.padding(vertical = 2.dp)
                        ) {
                            Icon(imageVector = Icons.Default.Check, contentDescription = null, tint = EmeraldSuccess, modifier = Modifier.size(15.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = del, color = TextSecondary, fontSize = 11.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                AmberButton(
                    text = "Request Similar Project",
                    onClick = {
                        val pTitle = project.title
                        selectedProject = null
                        openWhatsApp(context, "Hello! I saw your work on '$pTitle' and would like to build something similar.")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    icon = Icons.Default.Send
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun PortfolioProjectCard(
    project: PortfolioProject,
    onViewSpecs: () -> Unit,
    onInquire: () -> Unit
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
                    text = project.categoryLabel,
                    textColor = AmberGold,
                    backgroundColor = AmberGold.copy(alpha = 0.1f)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Schedule, contentDescription = null, tint = TextMuted, modifier = Modifier.size(13.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = project.timeline, color = TextMuted, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Client: ${project.client}",
                color = TextMuted,
                fontSize = 11.sp,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = project.title,
                style = MaterialTheme.typography.titleLarge,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = project.tagline,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Stack tag
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Obsidian900)
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "⚙️ ${project.finishOrStack}",
                    color = NeonCyan,
                    fontSize = 10.sp,
                    fontFamily = FontFamily.Monospace
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "View Specs →",
                    color = AmberGold,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onViewSpecs() }
                )

                SecondaryGlassButton(
                    text = "Inquire",
                    onClick = onInquire,
                    icon = Icons.Default.Send
                )
            }
        }
    }
}
