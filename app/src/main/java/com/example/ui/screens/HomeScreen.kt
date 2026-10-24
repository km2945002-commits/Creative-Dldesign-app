package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.ViewCarousel
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.ProcessStep
import com.example.data.ServiceItem
import com.example.data.StudioAssurance
import com.example.data.StudioRepository
import com.example.ui.components.AmberButton
import com.example.ui.components.GlassCard
import com.example.ui.components.SecondaryGlassButton
import com.example.ui.components.SpecBadge
import com.example.ui.components.ToolChip
import com.example.ui.components.dialPhone
import com.example.ui.components.openWhatsApp
import com.example.ui.theme.AmberGold
import com.example.ui.theme.AmberGoldDark
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

@Composable
fun HomeScreen(
    onNavigateToServices: () -> Unit,
    onNavigateToStudio: () -> Unit,
    onNavigateToEstimator: () -> Unit,
    onSelectService: (String) -> Unit
) {
    val context = LocalContext.current
    val contact = StudioRepository.contactInfo
    val services = StudioRepository.services
    val steps = StudioRepository.processSteps
    val assurances = StudioRepository.studioAssurances

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Obsidian950)
            .testTag("home_screen_column"),
        contentPadding = PaddingValues(bottom = 90.dp)
    ) {
        // Hero Section
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Obsidian900),
                    border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        // Hero Image with Gradient Overlay
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(210.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_studio_hero),
                                contentDescription = "Studio Creative Workspace",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            listOf(
                                                Color.Transparent,
                                                Obsidian950.copy(alpha = 0.5f),
                                                Obsidian900
                                            )
                                        )
                                    )
                            )
                            // Live Studio Pill
                            Box(
                                modifier = Modifier
                                    .padding(14.dp)
                                    .align(Alignment.TopStart)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(Obsidian950.copy(alpha = 0.85f))
                                    .border(1.dp, BorderHighlight, RoundedCornerShape(20.dp))
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(7.dp)
                                            .clip(CircleShape)
                                            .background(EmeraldSuccess)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "CREATIVE STUDIO · ISLAMABAD",
                                        color = AmberGold,
                                        fontSize = 10.sp,
                                        fontFamily = FontFamily.Monospace,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }

                        // Hero Copy & Actions
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text(
                                text = "Your Ideas. Our Creativity.",
                                style = MaterialTheme.typography.headlineMedium,
                                color = TextPrimary
                            )
                            Text(
                                text = "Smarter Solutions.",
                                style = MaterialTheme.typography.headlineMedium,
                                color = AmberGold
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "We transform concepts into professional websites, mobile apps, logos, business cards, product packaging, and flex banners using AI tools, WordPress, Hostinger, CorelDRAW, and Adobe Illustrator.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextSecondary,
                                lineHeight = 20.sp
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                AmberButton(
                                    text = "Get a Quote",
                                    onClick = onNavigateToEstimator,
                                    modifier = Modifier.weight(1f),
                                    icon = Icons.AutoMirrored.Filled.ArrowForward,
                                    testTag = "home_get_quote_btn"
                                )
                                SecondaryGlassButton(
                                    text = "Spec Studio",
                                    onClick = onNavigateToStudio,
                                    modifier = Modifier.weight(1f),
                                    icon = Icons.Default.DesignServices,
                                    testTag = "home_spec_studio_btn"
                                )
                            }
                        }
                    }
                }
            }
        }

        // Stats Row
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatCard(
                        value = "100%",
                        label = "Client Satisfaction",
                        color = AmberGold,
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        value = "300 DPI",
                        label = "CMYK Press Ready",
                        color = NeonCyan,
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatCard(
                        value = "CorelDRAW",
                        label = "Vector .CDR & .AI",
                        color = ElectricPurple,
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        value = "Hostinger",
                        label = "WordPress Launch",
                        color = EmeraldSuccess,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // Services Carousel Header
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    SpecBadge(text = "SERVICES & DELIVERABLES")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Core Design Specialties",
                        style = MaterialTheme.typography.titleLarge,
                        color = TextPrimary
                    )
                }
                Text(
                    text = "See All →",
                    color = AmberGold,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable { onNavigateToServices() }
                        .padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        // Horizontal Services Cards
        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(services) { service ->
                    ServiceQuickCard(
                        service = service,
                        onClick = { onSelectService(service.id) }
                    )
                }
            }
        }

        // Spec Studio Teaser
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Obsidian900),
                    border = androidx.compose.foundation.BorderStroke(1.dp, AmberGold.copy(alpha = 0.3f)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNavigateToStudio() }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                SpecBadge(
                                    text = "LIVE SPEC STUDIO",
                                    textColor = AmberGold,
                                    backgroundColor = AmberGold.copy(alpha = 0.12f)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Simulation",
                                    color = TextMuted,
                                    fontSize = 10.sp,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Interactive Visual Mockups",
                                style = MaterialTheme.typography.titleMedium,
                                color = TextPrimary
                            )
                            Text(
                                text = "Customize 3D Business Cards, test Web layouts, and view Logo color proofs live.",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextSecondary
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .clip(CircleShape)
                                .background(AmberGold)
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.DesignServices,
                                contentDescription = "Launch Studio",
                                tint = Obsidian950
                            )
                        }
                    }
                }
            }
        }

        // 4-Step Process Section
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                SpecBadge(text = "STRUCTURED WORKFLOW")
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "A Reliable 4-Step Framework",
                    style = MaterialTheme.typography.titleLarge,
                    color = TextPrimary
                )
                Text(
                    text = "Engineered for complete transparency, creative rigor, and on-time project execution.",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
                Spacer(modifier = Modifier.height(14.dp))

                steps.forEach { step ->
                    ProcessStepCard(step = step)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }

        // Why Choose Us Section
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                SpecBadge(text = "OUR COMMITMENTS")
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Why Creative Design Company?",
                    style = MaterialTheme.typography.titleLarge,
                    color = TextPrimary
                )
                Text(
                    text = "We blend AI acceleration with human mastery in CorelDRAW, WordPress, and commercial printing.",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
                Spacer(modifier = Modifier.height(14.dp))

                assurances.forEach { assurance ->
                    AssuranceCard(assurance = assurance)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }

        // Contact / Studio Location Footer
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Obsidian800),
                    border = androidx.compose.foundation.BorderStroke(1.dp, BorderHighlight),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = AmberGold,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = contact.address,
                                color = TextPrimary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Direct WhatsApp: ${contact.phone} · Email: ${contact.email}",
                            color = TextSecondary,
                            fontSize = 11.sp,
                            fontFamily = FontFamily.Monospace
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            AmberButton(
                                text = "WhatsApp Direct",
                                onClick = { openWhatsApp(context, "Hello! I am contacting you from the Creative Design App.") },
                                modifier = Modifier.weight(1f),
                                icon = Icons.Default.Send,
                                testTag = "home_whatsapp_footer"
                            )
                            SecondaryGlassButton(
                                text = "Call Studio",
                                onClick = { dialPhone(context, contact.phone) },
                                modifier = Modifier.weight(1f),
                                icon = Icons.Default.Call,
                                testTag = "home_call_footer"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StatCard(
    value: String,
    label: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                text = value,
                color = color,
                fontSize = 18.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = label,
                color = TextSecondary,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun ServiceQuickCard(
    service: ServiceItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(220.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
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
                Icon(
                    imageVector = getServiceIcon(service.id),
                    contentDescription = null,
                    tint = AmberGold,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = service.name,
                style = MaterialTheme.typography.titleMedium,
                color = TextPrimary,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = service.tagline,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = service.startingPrice,
                    color = AmberGold,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
                Text(
                    text = "Details →",
                    color = NeonCyan,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun ProcessStepCard(step: ProcessStep) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(AmberGold.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = step.number,
                            color = AmberGold,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = step.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = TextPrimary
                    )
                }
                Text(
                    text = step.tagline,
                    color = TextMuted,
                    fontSize = 10.sp,
                    fontFamily = FontFamily.Monospace
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = step.description,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(10.dp))

            step.inclusions.forEach { item ->
                Row(
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.padding(vertical = 2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = CyanGlow,
                        modifier = Modifier
                            .size(14.dp)
                            .padding(top = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = item,
                        color = TextPrimary,
                        fontSize = 11.sp,
                        lineHeight = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun AssuranceCard(assurance: StudioAssurance) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = assurance.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = TextPrimary,
                    modifier = Modifier.weight(1f)
                )
                SpecBadge(
                    text = assurance.badge,
                    textColor = NeonCyan,
                    backgroundColor = NeonCyan.copy(alpha = 0.1f)
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = assurance.description,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }
    }
}

fun getServiceIcon(id: String): ImageVector {
    return when (id) {
        "web-apps" -> Icons.Default.Language
        "logo-design" -> Icons.Default.AutoAwesome
        "business-cards" -> Icons.Default.CreditCard
        "products-packaging" -> Icons.Default.Inventory
        "flex-banner" -> Icons.Default.ViewCarousel
        else -> Icons.Default.Business
    }
}
