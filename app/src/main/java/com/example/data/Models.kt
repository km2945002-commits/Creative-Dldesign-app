package com.example.data

data class ServiceFeature(
    val title: String,
    val description: String
)

data class ServiceItem(
    val id: String,
    val name: String,
    val shortTag: String,
    val category: String,
    val tagline: String,
    val description: String,
    val heroHighlight: String,
    val deliverables: List<String>,
    val techOrMaterials: List<String>,
    val estimatedTurnaround: String,
    val startingPrice: String,
    val priceNumericPkr: Long,
    val features: List<ServiceFeature>
)

data class WebSolution(
    val id: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val keyFeatures: List<String>,
    val recommendedTech: String,
    val idealFor: String
)

data class PortfolioProject(
    val id: String,
    val title: String,
    val client: String,
    val category: String,
    val categoryLabel: String,
    val tagline: String,
    val toolsUsed: String,
    val deliverables: List<String>,
    val format: String,
    val finishOrStack: String,
    val timeline: String
)

data class ProcessStep(
    val number: String,
    val title: String,
    val tagline: String,
    val description: String,
    val inclusions: List<String>
)

data class StudioAssurance(
    val title: String,
    val description: String,
    val badge: String
)

data class StatItem(
    val label: String,
    val value: String
)

data class StudioContactInfo(
    val name: String = "Creative Design Company",
    val tagline: String = "Your Ideas. Our Creativity. Smarter Solutions.",
    val subTagline: String = "WEB · APPS · Business Identity · Products · Flex/Banner",
    val address: String = "Suhan Islamabad, Pakistan",
    val email: String = "km2945002@gmail.com",
    val phone: String = "+92 319 9774681",
    val whatsappUrl: String = "https://wa.me/923199774681",
    val stats: List<StatItem> = listOf(
        StatItem("Client Satisfaction", "100%"),
        StatItem("Core Platforms", "WordPress & Hostinger"),
        StatItem("Design Engines", "CorelDRAW & Illustrator"),
        StatItem("Deliverables", "300 DPI & Vector .CDR")
    )
)

data class EstimatorAddon(
    val id: String,
    val name: String,
    val pricePkr: Long,
    val description: String
)

data class ProjectCategoryOption(
    val id: String,
    val name: String,
    val basePkr: Long,
    val turnaround: String,
    val sampleDeliverables: String
)
