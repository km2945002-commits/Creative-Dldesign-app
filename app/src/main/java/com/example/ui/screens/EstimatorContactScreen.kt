package com.example.ui.screens

import android.widget.Toast
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.data.EstimatorAddon
import com.example.data.ProjectCategoryOption
import com.example.data.StudioRepository
import com.example.ui.components.AmberButton
import com.example.ui.components.SecondaryGlassButton
import com.example.ui.components.SpecBadge
import com.example.ui.components.dialPhone
import com.example.ui.components.openWhatsApp
import com.example.ui.components.sendEmail
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
import java.text.NumberFormat
import java.util.Locale

@Composable
fun EstimatorContactScreen(
    preselectedProjectId: String? = null
) {
    val context = LocalContext.current
    val contact = StudioRepository.contactInfo
    val projectOptions = StudioRepository.projectOptions
    val availableAddons = StudioRepository.availableAddons

    var selectedOption by remember {
        mutableStateOf(
            if (preselectedProjectId != null) {
                projectOptions.find { it.id == preselectedProjectId } ?: projectOptions.first()
            } else {
                projectOptions.first()
            }
        )
    }

    val selectedAddonIds = remember { mutableStateListOf<String>() }

    // User brief form fields
    var clientName by remember { mutableStateOf("") }
    var clientPhone by remember { mutableStateOf("") }
    var projectNotes by remember { mutableStateOf("") }

    // Calculate total PKR
    val addonsTotal = availableAddons
        .filter { selectedAddonIds.contains(it.id) }
        .sumOf { it.pricePkr }
    val grandTotalPkr = selectedOption.basePkr + addonsTotal

    val formatter = remember { NumberFormat.getNumberInstance(Locale.US) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Obsidian950)
            .testTag("estimator_screen"),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 90.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Title
        item {
            Column {
                SpecBadge(text = "TRANSPARENT PKR ESTIMATOR & BRIEF BUILDER")
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Project Cost Calculator",
                    style = MaterialTheme.typography.headlineSmall,
                    color = TextPrimary
                )
                Text(
                    text = "Select your base scope, choose optional deliverables, and dispatch a structured brief directly to our creative studio.",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
            }
        }

        // Base Project Selection
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceCard),
                border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "1. Select Base Project Type",
                        style = MaterialTheme.typography.titleMedium,
                        color = TextPrimary
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    projectOptions.forEach { opt ->
                        val isSelected = selectedOption.id == opt.id
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (isSelected) Obsidian800 else Obsidian900)
                                .border(1.dp, if (isSelected) AmberGold else BorderSubtle, RoundedCornerShape(12.dp))
                                .clickable { selectedOption = opt }
                                .padding(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = opt.name,
                                        color = if (isSelected) AmberGold else TextPrimary,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp
                                    )
                                    Text(
                                        text = "${opt.turnaround} · ${opt.sampleDeliverables}",
                                        color = TextSecondary,
                                        fontSize = 10.sp,
                                        maxLines = 1
                                    )
                                }
                                Text(
                                    text = "PKR ${formatter.format(opt.basePkr)}",
                                    color = if (isSelected) AmberGold else TextPrimary,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                        }
                    }
                }
            }
        }

        // Add-ons Selection
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceCard),
                border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "2. Optional Deliverables & Add-ons",
                        style = MaterialTheme.typography.titleMedium,
                        color = TextPrimary
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    availableAddons.forEach { addon ->
                        val isChecked = selectedAddonIds.contains(addon.id)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Obsidian900)
                                .clickable {
                                    if (isChecked) selectedAddonIds.remove(addon.id) else selectedAddonIds.add(addon.id)
                                }
                                .padding(horizontal = 8.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = {
                                    if (isChecked) selectedAddonIds.remove(addon.id) else selectedAddonIds.add(addon.id)
                                },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = AmberGold,
                                    checkmarkColor = Obsidian950,
                                    uncheckedColor = TextMuted
                                )
                            )
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = addon.name,
                                    color = if (isChecked) AmberGold else TextPrimary,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 12.sp
                                )
                                Text(
                                    text = addon.description,
                                    color = TextSecondary,
                                    fontSize = 9.sp,
                                    lineHeight = 13.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "+PKR ${formatter.format(addon.pricePkr)}",
                                color = if (isChecked) NeonCyan else TextMuted,
                                fontSize = 11.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        // Live Calculated Total Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Obsidian800),
                border = androidx.compose.foundation.BorderStroke(1.5.dp, AmberGold),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            SpecBadge(text = "ESTIMATED INVESTMENT", textColor = AmberGold)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "PKR ${formatter.format(grandTotalPkr)}",
                                color = TextPrimary,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                        Column(horizontalAlignment = Alignment.End) {
                            Text(text = "Turnaround", color = TextMuted, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                            Text(text = selectedOption.turnaround, color = NeonCyan, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Includes ${selectedOption.name} with ${selectedAddonIds.size} optional add-ons, complete intellectual property ownership, and direct creative consultation.",
                        color = TextSecondary,
                        fontSize = 11.sp
                    )
                }
            }
        }

        // Client Details Brief Form
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceCard),
                border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "3. Client & Project Details",
                        style = MaterialTheme.typography.titleMedium,
                        color = TextPrimary
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = clientName,
                        onValueChange = { clientName = it },
                        label = { Text("Your Name / Company", fontSize = 12.sp) },
                        placeholder = { Text("e.g. Apex Dynamics Ltd", fontSize = 12.sp) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = AmberGold,
                            unfocusedBorderColor = BorderSubtle,
                            focusedTextColor = TextPrimary,
                            unfocusedTextColor = TextPrimary
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = clientPhone,
                        onValueChange = { clientPhone = it },
                        label = { Text("WhatsApp / Phone Number", fontSize = 12.sp) },
                        placeholder = { Text("e.g. +92 300 1234567", fontSize = 12.sp) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = AmberGold,
                            unfocusedBorderColor = BorderSubtle,
                            focusedTextColor = TextPrimary,
                            unfocusedTextColor = TextPrimary
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = projectNotes,
                        onValueChange = { projectNotes = it },
                        label = { Text("Project Brief / Special Notes", fontSize = 12.sp) },
                        placeholder = { Text("Describe specific requirements, color preferences, or target launch date...", fontSize = 12.sp) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = AmberGold,
                            unfocusedBorderColor = BorderSubtle,
                            focusedTextColor = TextPrimary,
                            unfocusedTextColor = TextPrimary
                        ),
                        minLines = 3,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Dispatch Buttons
                    AmberButton(
                        text = "Send Project Brief to WhatsApp",
                        onClick = {
                            val addonNames = availableAddons
                                .filter { selectedAddonIds.contains(it.id) }
                                .joinToString(", ") { it.name }
                            val briefMessage = """
                                *NEW PROJECT INQUIRY — CREATIVE DESIGN COMPANY*
                                • *Client:* ${clientName.ifBlank { "Not specified" }}
                                • *Contact:* ${clientPhone.ifBlank { "Not specified" }}
                                • *Base Project:* ${selectedOption.name} (PKR ${formatter.format(selectedOption.basePkr)})
                                • *Add-ons:* ${if (addonNames.isNotBlank()) addonNames else "None"}
                                • *Estimated Investment:* PKR ${formatter.format(grandTotalPkr)}
                                • *Estimated Turnaround:* ${selectedOption.turnaround}
                                • *Client Notes:* ${projectNotes.ifBlank { "Standard requirements" }}
                            """.trimIndent()
                            openWhatsApp(context, briefMessage)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        icon = Icons.Default.Send,
                        testTag = "btn_send_whatsapp_brief"
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    SecondaryGlassButton(
                        text = "Email Official Brief",
                        onClick = {
                            val subject = "Project Brief: ${selectedOption.name} - ${clientName.ifBlank { "New Client" }}"
                            val body = """
                                Creative Design Company Inquiry
                                
                                Client Name: ${clientName.ifBlank { "N/A" }}
                                Phone: ${clientPhone.ifBlank { "N/A" }}
                                Project Type: ${selectedOption.name}
                                Estimated Budget: PKR ${formatter.format(grandTotalPkr)}
                                Notes: ${projectNotes.ifBlank { "N/A" }}
                            """.trimIndent()
                            sendEmail(context, subject, body)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        icon = Icons.Default.Email,
                        testTag = "btn_send_email_brief"
                    )
                }
            }
        }

        // Studio Contact Details Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Obsidian900),
                border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Studio Direct Access",
                        style = MaterialTheme.typography.titleMedium,
                        color = TextPrimary
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = null, tint = AmberGold, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = contact.address, color = TextPrimary, fontSize = 12.sp)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Call, contentDescription = null, tint = NeonCyan, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = contact.phone,
                            color = NeonCyan,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier.clickable { dialPhone(context, contact.phone) }
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Email, contentDescription = null, tint = EmeraldSuccess, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = contact.email, color = TextSecondary, fontSize = 12.sp, fontFamily = FontFamily.Monospace)
                    }
                }
            }
        }
    }
}
