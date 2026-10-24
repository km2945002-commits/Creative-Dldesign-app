package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DesktopWindows
import androidx.compose.material.icons.filled.FlipCameraAndroid
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Tablet
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.ViewCarousel
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.components.AmberButton
import com.example.ui.components.SecondaryGlassButton
import com.example.ui.components.SpecBadge
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
fun SpecStudioScreen(
    onNavigateToEstimator: () -> Unit
) {
    val context = LocalContext.current
    var selectedStudioMode by remember { mutableIntStateOf(0) } // 0: Web/App, 1: Card, 2: Logo, 3: Packaging

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Obsidian950)
            .testTag("spec_studio_screen")
    ) {
        // Title Bar
        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)) {
            SpecBadge(text = "LIVE INTERACTIVE SPEC STUDIO", textColor = AmberGold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Interactive Design Lab",
                style = MaterialTheme.typography.headlineSmall,
                color = TextPrimary
            )
            Text(
                text = "Simulate responsive websites, 3D foil business cards, and vector logo marks.",
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Studio Mode Tabs
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val modes = listOf(
                0 to "Web & App Layout",
                1 to "Business Cards",
                2 to "Logo Lab",
                3 to "Packaging & Banner"
            )
            items(modes) { (idx, title) ->
                val isSelected = selectedStudioMode == idx
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isSelected) AmberGold else Obsidian900)
                        .border(1.dp, if (isSelected) AmberGold else BorderSubtle, RoundedCornerShape(12.dp))
                        .clickable { selectedStudioMode = idx }
                        .padding(horizontal = 14.dp, vertical = 9.dp)
                ) {
                    Text(
                        text = title,
                        color = if (isSelected) Obsidian950 else TextSecondary,
                        fontSize = 11.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Studio Content
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 90.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when (selectedStudioMode) {
                0 -> {
                    item { WebSimulatorSection() }
                }
                1 -> {
                    item { BusinessCardSimulatorSection() }
                }
                2 -> {
                    item { LogoLabSimulatorSection() }
                }
                3 -> {
                    item { PackagingBannerSimulatorSection() }
                }
            }

            // Global Call to Action
            item {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = Obsidian800),
                    border = androidx.compose.foundation.BorderStroke(1.dp, BorderHighlight),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.AutoAwesome,
                                contentDescription = null,
                                tint = AmberGold,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Ready to turn this spec into reality?",
                                color = TextPrimary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Get a detailed commercial quote in Pakistani Rupees (PKR) with complete deliverables and fast turnaround.",
                            color = TextSecondary,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(14.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            AmberButton(
                                text = "Calculate Project Cost",
                                onClick = onNavigateToEstimator,
                                modifier = Modifier.weight(1f),
                                icon = Icons.AutoMirrored.Filled.ArrowForward
                            )
                            SecondaryGlassButton(
                                text = "WhatsApp Studio",
                                onClick = {
                                    openWhatsApp(
                                        context,
                                        "Hello Creative Design! I tried your Spec Studio and want to discuss a project."
                                    )
                                },
                                modifier = Modifier.weight(1f),
                                icon = Icons.Default.Send
                            )
                        }
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// 1. Web & Mobile App Simulator
// -------------------------------------------------------------
@Composable
fun WebSimulatorSection() {
    var selectedDevice by remember { mutableIntStateOf(0) } // 0: Mobile, 1: Tablet, 2: Desktop
    var selectedIndustry by remember { mutableStateOf("Corporate Enterprise") }
    var primaryAccent by remember { mutableStateOf(AmberGold) }

    Card(
        shape = RoundedCornerShape(20.dp),
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
                Text(
                    text = "Responsive Web Architecture",
                    style = MaterialTheme.typography.titleMedium,
                    color = TextPrimary
                )
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    IconButton(
                        onClick = { selectedDevice = 0 },
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (selectedDevice == 0) AmberGold else Obsidian800)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PhoneAndroid,
                            contentDescription = "Mobile Viewport",
                            tint = if (selectedDevice == 0) Obsidian950 else TextSecondary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    IconButton(
                        onClick = { selectedDevice = 1 },
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (selectedDevice == 1) AmberGold else Obsidian800)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Tablet,
                            contentDescription = "Tablet Viewport",
                            tint = if (selectedDevice == 1) Obsidian950 else TextSecondary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    IconButton(
                        onClick = { selectedDevice = 2 },
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (selectedDevice == 2) AmberGold else Obsidian800)
                    ) {
                        Icon(
                            imageVector = Icons.Default.DesktopWindows,
                            contentDescription = "Desktop Viewport",
                            tint = if (selectedDevice == 2) Obsidian950 else TextSecondary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Industry Selector Chips
            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                val industries = listOf("Corporate Enterprise", "Luxury Restaurant", "E-Commerce Retail", "Medical Clinic")
                items(industries) { ind ->
                    val isSel = selectedIndustry == ind
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (isSel) Obsidian700 else Obsidian900)
                            .border(1.dp, if (isSel) AmberGold else BorderSubtle, RoundedCornerShape(16.dp))
                            .clickable {
                                selectedIndustry = ind
                                primaryAccent = when (ind) {
                                    "Corporate Enterprise" -> AmberGold
                                    "Luxury Restaurant" -> Color(0xFFF97316)
                                    "E-Commerce Retail" -> NeonCyan
                                    else -> EmeraldSuccess
                                }
                            }
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Text(
                            text = ind,
                            color = if (isSel) AmberGold else TextSecondary,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Device Mockup Frame
            val frameWidth = when (selectedDevice) {
                0 -> 240.dp
                1 -> 310.dp
                else -> Modifier.fillMaxWidth()
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Obsidian950)
                    .border(1.dp, BorderHighlight, RoundedCornerShape(16.dp))
                    .padding(14.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .then(if (selectedDevice != 2) Modifier.width(frameWidth as androidx.compose.ui.unit.Dp) else Modifier.fillMaxWidth())
                        .clip(RoundedCornerShape(12.dp))
                        .background(Obsidian900)
                        .border(1.dp, primaryAccent.copy(alpha = 0.35f), RoundedCornerShape(12.dp))
                        .padding(12.dp)
                ) {
                    // Browser Top Bar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(Color(0xFFEF4444)))
                            Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(Color(0xFFFBBF24)))
                            Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(Color(0xFF10B981)))
                        }
                        Text(
                            text = "https://${selectedIndustry.lowercase().replace(" ", "")}.pk",
                            color = TextMuted,
                            fontSize = 9.sp,
                            fontFamily = FontFamily.Monospace
                        )
                        Icon(imageVector = Icons.Default.Language, contentDescription = null, tint = TextMuted, modifier = Modifier.size(12.dp))
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Mockup Header
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = selectedIndustry.split(" ").first().uppercase(),
                            color = primaryAccent,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text(text = "Home", color = TextPrimary, fontSize = 9.sp)
                            Text(text = "About", color = TextSecondary, fontSize = 9.sp)
                            Text(text = "Book", color = primaryAccent, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Mockup Hero
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                Brush.verticalGradient(
                                    listOf(primaryAccent.copy(alpha = 0.15f), Obsidian900)
                                )
                            )
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Premier $selectedIndustry Solutions",
                            color = TextPrimary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Engineered with WordPress, Hostinger LiteSpeed Caching, and mobile-first responsive architecture.",
                            color = TextSecondary,
                            fontSize = 10.sp,
                            lineHeight = 14.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(primaryAccent)
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "Get Started Now",
                                color = Obsidian950,
                                fontWeight = FontWeight.Bold,
                                fontSize = 9.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Features Grid in Mockup
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(6.dp))
                                .background(Obsidian800)
                                .padding(6.dp)
                        ) {
                            Text(text = "⚡ 0.68s Load Time", color = NeonCyan, fontSize = 8.sp, fontFamily = FontFamily.Monospace)
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(6.dp))
                                .background(Obsidian800)
                                .padding(6.dp)
                        ) {
                            Text(text = "🔒 SSL 256-bit", color = EmeraldSuccess, fontSize = 8.sp, fontFamily = FontFamily.Monospace)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Tech Specs Strip
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Platform: WordPress 6.7", color = TextMuted, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                Text(text = "Cloud: Hostinger LiteSpeed", color = NeonCyan, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                Text(text = "Responsive: 100%", color = EmeraldSuccess, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
            }
        }
    }
}

// -------------------------------------------------------------
// 2. Business Card 3D Simulator (Double Sided)
// -------------------------------------------------------------
@Composable
fun BusinessCardSimulatorSection() {
    var companyName by remember { mutableStateOf("VANGUARD CORP") }
    var personName by remember { mutableStateOf("Hamza Tariq") }
    var personTitle by remember { mutableStateOf("Chief Executive Officer") }
    var selectedFinish by remember { mutableStateOf("Gold Foil on Matte Obsidian") }
    var isFlippedBack by remember { mutableStateOf(false) }

    val rotationY by animateFloatAsState(
        targetValue = if (isFlippedBack) 180f else 0f,
        animationSpec = tween(500),
        label = "card_flip"
    )

    Card(
        shape = RoundedCornerShape(20.dp),
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
                Column {
                    Text(
                        text = "3D Business Card Specimen",
                        style = MaterialTheme.typography.titleMedium,
                        color = TextPrimary
                    )
                    Text(
                        text = "Standard 3.5\" x 2\" with 3mm Press Bleeds",
                        color = TextMuted,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.Monospace
                    )
                }

                AmberButton(
                    text = if (isFlippedBack) "Flip Front" else "Flip Back",
                    onClick = { isFlippedBack = !isFlippedBack },
                    icon = Icons.Default.FlipCameraAndroid
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Card Canvas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.75f) // Standard 3.5:2 ratio
                    .graphicsLayer {
                        this.rotationY = rotationY
                        cameraDistance = 14f * density
                    }
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        when (selectedFinish) {
                            "Gold Foil on Matte Obsidian" -> Brush.radialGradient(listOf(Color(0xFF1E212D), Color(0xFF0C0D12)))
                            "Silver on Royal Navy" -> Brush.radialGradient(listOf(Color(0xFF1E293B), Color(0xFF0F172A)))
                            "Minimalist Crisp White" -> Brush.linearGradient(listOf(Color(0xFFF8FAFC), Color(0xFFE2E8F0)))
                            else -> Brush.radialGradient(listOf(Color(0xFF262626), Color(0xFF111111)))
                        }
                    )
                    .border(
                        1.5.dp,
                        when (selectedFinish) {
                            "Gold Foil on Matte Obsidian" -> AmberGold
                            "Silver on Royal Navy" -> NeonCyan
                            "Minimalist Crisp White" -> Color(0xFF94A3B8)
                            else -> ElectricPurple
                        },
                        RoundedCornerShape(12.dp)
                    )
                    .padding(16.dp)
            ) {
                val cardTextColor = if (selectedFinish == "Minimalist Crisp White") Obsidian950 else TextPrimary
                val accentColor = when (selectedFinish) {
                    "Gold Foil on Matte Obsidian" -> AmberGold
                    "Silver on Royal Navy" -> NeonCyan
                    "Minimalist Crisp White" -> AmberGoldDark
                    else -> ElectricPurple
                }

                if (rotationY <= 90f) {
                    // FRONT OF CARD
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(accentColor),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = companyName.take(1),
                                        color = Obsidian950,
                                        fontWeight = FontWeight.Black,
                                        fontSize = 13.sp
                                    )
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = companyName,
                                    color = accentColor,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    letterSpacing = 1.sp
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.QrCode,
                                contentDescription = "Digital VCard QR",
                                tint = accentColor,
                                modifier = Modifier.size(26.dp)
                            )
                        }

                        Column {
                            Text(
                                text = personName,
                                color = cardTextColor,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Text(
                                text = personTitle.uppercase(),
                                color = accentColor,
                                fontSize = 9.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "+92 319 9774681 · contact@${companyName.lowercase().replace(" ", "")}.com",
                                color = if (selectedFinish == "Minimalist Crisp White") Color(0xFF475569) else TextSecondary,
                                fontSize = 9.sp,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                    }
                } else {
                    // BACK OF CARD (Mirror compensated)
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .graphicsLayer { this.rotationY = 180f },
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(accentColor),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = companyName.take(1),
                                    color = Obsidian950,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 22.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = companyName,
                                color = accentColor,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                letterSpacing = 2.sp
                            )
                            Text(
                                text = "www.${companyName.lowercase().replace(" ", "")}.pk",
                                color = cardTextColor,
                                fontSize = 10.sp,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Inputs to customize card
            OutlinedTextField(
                value = companyName,
                onValueChange = { companyName = it },
                label = { Text("Company Name", fontSize = 11.sp) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AmberGold,
                    unfocusedBorderColor = BorderSubtle,
                    focusedTextColor = TextPrimary,
                    unfocusedTextColor = TextPrimary
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = personName,
                    onValueChange = { personName = it },
                    label = { Text("Cardholder Name", fontSize = 11.sp) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = AmberGold,
                        unfocusedBorderColor = BorderSubtle,
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary
                    ),
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = personTitle,
                    onValueChange = { personTitle = it },
                    label = { Text("Title", fontSize = 11.sp) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = AmberGold,
                        unfocusedBorderColor = BorderSubtle,
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary
                    ),
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Specialty Print Finish Mask:", color = TextSecondary, fontSize = 11.sp)
            Spacer(modifier = Modifier.height(6.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                val finishes = listOf(
                    "Gold Foil on Matte Obsidian",
                    "Silver on Royal Navy",
                    "Minimalist Crisp White",
                    "Spot UV on Carbon"
                )
                items(finishes) { finish ->
                    val isSel = selectedFinish == finish
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isSel) Obsidian700 else Obsidian900)
                            .border(1.dp, if (isSel) AmberGold else BorderSubtle, RoundedCornerShape(8.dp))
                            .clickable { selectedFinish = finish }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = finish,
                            color = if (isSel) AmberGold else TextSecondary,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// 3. Logo Lab Simulator
// -------------------------------------------------------------
@Composable
fun LogoLabSimulatorSection() {
    var logoText by remember { mutableStateOf("NEXUS") }
    var selectedStyle by remember { mutableStateOf("Geometric Monogram") }
    var showGridGuide by remember { mutableStateOf(true) }
    var backgroundLightness by remember { mutableStateOf("Obsidian #090A0E") }

    Card(
        shape = RoundedCornerShape(20.dp),
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
                Column {
                    Text(
                        text = "Vector Logo & Bezier Lab",
                        style = MaterialTheme.typography.titleMedium,
                        color = TextPrimary
                    )
                    Text(
                        text = "CorelDRAW 2024 & Illustrator Calibration",
                        color = TextMuted,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.Monospace
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Grid", color = TextSecondary, fontSize = 11.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Switch(
                        checked = showGridGuide,
                        onCheckedChange = { showGridGuide = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = AmberGold,
                            checkedTrackColor = AmberGoldDark.copy(alpha = 0.5f)
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Logo Viewport Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(
                        when (backgroundLightness) {
                            "Clean White #FFFFFF" -> Color.White
                            "Gold Foil Emboss" -> Color(0xFF251E11)
                            else -> Obsidian950
                        }
                    )
                    .border(1.dp, BorderHighlight, RoundedCornerShape(14.dp)),
                contentAlignment = Alignment.Center
            ) {
                // Construction Grid Lines Simulation
                if (showGridGuide) {
                    Box(
                        modifier = Modifier
                            .size(160.dp)
                            .border(1.dp, Color(0x3306B6D4), CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .size(110.dp)
                            .border(1.dp, Color(0x33FBBF24), CircleShape)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Emblem
                    Box(
                        modifier = Modifier
                            .size(62.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                Brush.linearGradient(listOf(AmberGold, Color(0xFFF97316), ElectricPurple))
                            )
                            .padding(2.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(14.dp))
                                .background(Obsidian950),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = logoText.take(1),
                                color = AmberGold,
                                fontWeight = FontWeight.Black,
                                fontSize = 30.sp,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = logoText,
                        color = if (backgroundLightness == "Clean White #FFFFFF") Obsidian950 else TextPrimary,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        letterSpacing = 4.sp,
                        fontFamily = FontFamily.SansSerif
                    )

                    Text(
                        text = "PRECISION VECTOR IDENTITY",
                        color = AmberGold,
                        fontSize = 9.sp,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 1.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            OutlinedTextField(
                value = logoText,
                onValueChange = { logoText = it.take(14) },
                label = { Text("Brand / Logo Name", fontSize = 11.sp) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AmberGold,
                    unfocusedBorderColor = BorderSubtle,
                    focusedTextColor = TextPrimary,
                    unfocusedTextColor = TextPrimary
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Background Contrast Mode:", color = TextSecondary, fontSize = 11.sp)
            Spacer(modifier = Modifier.height(6.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                val backgrounds = listOf("Obsidian #090A0E", "Clean White #FFFFFF", "Gold Foil Emboss")
                items(backgrounds) { bg ->
                    val isSel = backgroundLightness == bg
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isSel) Obsidian700 else Obsidian900)
                            .border(1.dp, if (isSel) AmberGold else BorderSubtle, RoundedCornerShape(8.dp))
                            .clickable { backgroundLightness = bg }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = bg,
                            color = if (isSel) AmberGold else TextSecondary,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// 4. Packaging & Banner Scaler
// -------------------------------------------------------------
@Composable
fun PackagingBannerSimulatorSection() {
    var specType by remember { mutableStateOf("20ft x 10ft Outdoor Flex Banner") }

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceCard),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = "Large-Format & Dieline Engineering",
                style = MaterialTheme.typography.titleMedium,
                color = TextPrimary
            )
            Text(
                text = "CorelDRAW print prepress with eyelet guides and fold tolerances.",
                color = TextMuted,
                fontSize = 10.sp,
                fontFamily = FontFamily.Monospace
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Switcher
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                val types = listOf("20ft x 10ft Outdoor Flex Banner", "Folding Carton Box Packaging")
                types.forEach { type ->
                    val isSel = specType == type
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isSel) AmberGold else Obsidian900)
                            .clickable { specType = type }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (type.contains("Flex")) "Flex Banner" else "Box Packaging",
                            color = if (isSel) Obsidian950 else TextSecondary,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            if (specType.contains("Flex")) {
                // Banner Preview
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF0F172A))
                        .border(2.dp, AmberGold, RoundedCornerShape(8.dp))
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "● EYELET 1FT INTERVALS", color = AmberGold, fontSize = 8.sp, fontFamily = FontFamily.Monospace)
                            Text(text = "SOLVENT INK CALIBRATION", color = NeonCyan, fontSize = 8.sp, fontFamily = FontFamily.Monospace)
                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "GRAND APEX PROPERTIES",
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                fontSize = 16.sp,
                                letterSpacing = 2.sp
                            )
                            Text(
                                text = "EXCLUSIVE PRE-LAUNCH INVESTMENTS · SUHAN ISLAMABAD",
                                color = AmberGold,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "CALL: +92 319 9774681", color = Color.White, fontSize = 9.sp, fontFamily = FontFamily.Monospace)
                            Text(text = "20 FT X 10 FT @ 150 DPI", color = EmeraldSuccess, fontSize = 8.sp, fontFamily = FontFamily.Monospace)
                        }
                    }
                }
            } else {
                // Dieline Box Preview
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Obsidian950)
                        .border(1.dp, BorderHighlight, RoundedCornerShape(8.dp))
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "3D STRUCTURAL CARTON DIELINE",
                            color = NeonCyan,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Cut lines: Red · Crease lines: Cyan Dashed · Bleed: 3mm",
                            color = TextSecondary,
                            fontSize = 9.sp,
                            fontFamily = FontFamily.Monospace
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            SpecBadge(text = "BARCODE TESTED")
                            SpecBadge(text = "SPOT UV MASK", textColor = ElectricPurple)
                            SpecBadge(text = "300 DPI CMYK", textColor = EmeraldSuccess)
                        }
                    }
                }
            }
        }
    }
}
