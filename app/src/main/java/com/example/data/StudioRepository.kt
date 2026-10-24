package com.example.data

object StudioRepository {

    val contactInfo = StudioContactInfo()

    val services = listOf(
        ServiceItem(
            id = "web-apps",
            name = "Websites & Apps Design",
            shortTag = "Web & Mobile",
            category = "web-app",
            tagline = "Modern, responsive websites and app interfaces using AI-powered tools, WordPress, and Hostinger.",
            description = "We design modern, responsive websites and app interfaces using AI-powered design tools, WordPress, and modern web technologies. We create business websites, restaurant websites, e-commerce stores, company websites, clinics, and online shops.",
            heroHighlight = "AI-assisted design, WordPress customization, Hostinger hosting, and mobile-first responsive architecture.",
            deliverables = listOf(
                "AI-assisted website design and development",
                "WordPress website setup and customization",
                "Business, restaurant, company, and e-commerce websites",
                "Mobile-responsive website layouts",
                "Website pages, menus, forms, and contact sections",
                "Plugin installation and configuration as required",
                "Domain and hosting setup using Hostinger",
                "Basic SEO and website performance optimization",
                "Website testing, launch, and handover"
            ),
            techOrMaterials = listOf("WordPress", "Hostinger", "AI Website Builders", "React 19 & Next.js", "Mobile Responsive", "SEO Optimization"),
            estimatedTurnaround = "4 to 8 Weeks",
            startingPrice = "PKR 250,000",
            priceNumericPkr = 250000L,
            features = listOf(
                ServiceFeature("WordPress & AI-Assisted Architecture", "Clean theme customization, page builder flexibility, and AI-accelerated layout design tailored to your industry."),
                ServiceFeature("Hostinger Hosting Setup", "Assistance with domain connection, SSL security certificate, business email setup, and server configuration."),
                ServiceFeature("Responsive & Fast Loading", "Calibrated for lightning speed on smartphones, tablets, laptops, and desktop computers.")
            )
        ),
        ServiceItem(
            id = "logo-design",
            name = "Logo Design",
            shortTag = "Logo Identity",
            category = "logo",
            tagline = "Professional, memorable, and unique logos using CorelDRAW, Adobe Illustrator, and AI tools.",
            description = "We create professional, memorable, and unique logos using CorelDRAW, Adobe Illustrator, and AI-assisted concept generation. We design brand identities for businesses, startups, clinics, restaurants, and corporate enterprises.",
            heroHighlight = "Precision vector paths, geometric symmetry, color theory, and versatile scale across digital and print media.",
            deliverables = listOf(
                "Custom logo design from scratch",
                "AI-powered idea generation + human vector refinement",
                "Primary logo, secondary badge, and compact icon mark",
                "High-resolution vector files (.CDR and .AI)",
                "Transparent PNG for web, apps, and digital watermarking",
                "Print-ready PDF with CMYK color separation",
                "Color palette codes (HEX, RGB, CMYK)",
                "Black & white and inverted monochrome variations",
                "Full commercial copyright & ownership handover"
            ),
            techOrMaterials = listOf("CorelDRAW 2024", "Adobe Illustrator", "Vector Bezier Craft", "AI Ideation", "CMYK Calibrated", "Print Ready"),
            estimatedTurnaround = "5 to 7 Days",
            startingPrice = "PKR 45,000",
            priceNumericPkr = 45000L,
            features = listOf(
                ServiceFeature("CorelDRAW Vector Precision", "Crafted with exact bezier anchor math ensuring clean scalability to any size without pixelation."),
                ServiceFeature("Multi-Concept Iteration", "Multiple distinct creative directions developed before narrowing down to your final polished brand emblem."),
                ServiceFeature("Complete Master Package", "Delivered in transparent PNG, vector SVG, print PDF, and editable CorelDRAW / AI files.")
            )
        ),
        ServiceItem(
            id = "business-cards",
            name = "Business Card Design",
            shortTag = "Print & Cards",
            category = "business-card",
            tagline = "Premium business cards, corporate stationery, and letterheads ready for professional printing.",
            description = "We design elegant, modern, and striking business cards tailored for executives, entrepreneurs, medical doctors, and corporate representatives. Engineered strictly to commercial press standards with correct bleed margins and crop marks in CorelDRAW.",
            heroHighlight = "Double-sided layouts, precision 300 DPI CMYK, spot UV / gold foil mask callouts, and clean typographic hierarchy.",
            deliverables = listOf(
                "Double-sided premium business card layout",
                "Standard 3.5\" x 2\" or custom European dimensions",
                "Industry-standard 3mm bleed and safety margin setup",
                "Print-ready 300 DPI CMYK PDF/X-1a files",
                "Editable CorelDRAW (.CDR) and Adobe Illustrator (.AI) sources",
                "Special finish masks (Gold/Silver Foil, Spot UV, Emboss)",
                "Corporate letterhead and envelope layout companion",
                "Digital interactive business card proof"
            ),
            techOrMaterials = listOf("CorelDRAW 2024", "Adobe Illustrator", "300 DPI CMYK", "3mm Bleed Margins", "Foil / Spot UV Masks", "Press-Ready PDF"),
            estimatedTurnaround = "3 to 5 Days",
            startingPrice = "PKR 35,000",
            priceNumericPkr = 35000L,
            features = listOf(
                ServiceFeature("Press-Proof Calibration", "Files are formatted precisely to avoid rejection at offset and digital commercial printing presses."),
                ServiceFeature("Executive Finish Masks", "Dedicated vector layers prepared for spot gloss, foil stamping, or textured paper stocks."),
                ServiceFeature("Editable Typography Files", "Easily update employee names, phone numbers, or branch addresses anytime.")
            )
        ),
        ServiceItem(
            id = "products-packaging",
            name = "Products & Packaging Design",
            shortTag = "Packaging & Labels",
            category = "product",
            tagline = "Attractive product labels, packaging layouts, and box dielines crafted in CorelDRAW & Illustrator.",
            description = "We design distinctive packaging and label artwork that commands attention on retail shelves and e-commerce stores. Specialized in cosmetic boxes, food packaging, herbal supplements, bottle labels, pouches, and shipping cartons.",
            heroHighlight = "Accurate dieline vector templates, barcode/QR integration, regulatory text compliance, and 3D mockup visualizations.",
            deliverables = listOf(
                "Custom structural dieline box/pouch layout",
                "Front, back, and side panel graphic design",
                "High-resolution 3D product mockup renders",
                "Barcode, QR code, and regulatory symbol placement",
                "Print-ready CMYK separated files with bleeds",
                "Foil stamping and spot varnish mask layers",
                "Full editable master files in CorelDRAW & Illustrator",
                "Printer consultation support during proofing"
            ),
            techOrMaterials = listOf("CorelDRAW", "Adobe Illustrator", "Structural Dielines", "3D Product Mockups", "Pantone Matching", "Barcode Testing"),
            estimatedTurnaround = "7 to 10 Days",
            startingPrice = "PKR 65,000",
            priceNumericPkr = 65000L,
            features = listOf(
                ServiceFeature("Structural Precision Dielines", "Fold lines, crease lines, and glue flaps verified for accurate machine or manual assembly."),
                ServiceFeature("3D Presentation Renders", "Preview your package on photorealistic bottle, jar, or carton models before printing."),
                ServiceFeature("Compliance & Barcode Ready", "Ingredients, net weights, certification icons, and scannable GS1 barcodes properly scaled.")
            )
        ),
        ServiceItem(
            id = "flex-banner",
            name = "Flex & Banner Design",
            shortTag = "Large-Format Print",
            category = "banner",
            tagline = "Professional flex banners, promotional posters, and large-format print graphics.",
            description = "We create high-visibility outdoor flex banners, store front signs, trade show backdrops, event standees, roll-up banners, and promotional posters. Designed with bold color contrast and large-scale typography in CorelDRAW.",
            heroHighlight = "Calibrated large-scale DPI resolution, solvent ink compatibility, eyelet/grommet placement guides, and long-distance legibility.",
            deliverables = listOf(
                "Custom large-format outdoor flex banner design",
                "Roll-up standees and trade-show backdrops",
                "Storefront vinyl signs and roadside billboards",
                "DPI-calibrated high-resolution print TIFF/PDF files",
                "Brass eyelet and pole-pocket margin guides",
                "Companion social media promo banner versions (1:1 & 16:9)",
                "Full editable master CorelDRAW vector file (.CDR)"
            ),
            techOrMaterials = listOf("CorelDRAW 2024", "Large-Format Calibration", "Solvent & UV Inks", "PVC Flex Material", "Eyelet Guides"),
            estimatedTurnaround = "3 to 5 Days",
            startingPrice = "PKR 30,000",
            priceNumericPkr = 30000L,
            features = listOf(
                ServiceFeature("High-Contrast Long-Distance Legibility", "Headlines and contact numbers structured to be easily read from moving highway traffic or street view."),
                ServiceFeature("Hardware & Pocket Templates", "Precise margins preserved around borders for metal eyelets, framing brackets, and pole pockets."),
                ServiceFeature("Lightweight Print Files", "Optimized file sizes delivering sharp clarity without overwhelming print-shop RIP processors.")
            )
        ),
        ServiceItem(
            id = "brand-identity",
            name = "Brand Identity Design",
            shortTag = "Brand Suite",
            category = "brand-identity",
            tagline = "Full corporate identity suites including logos, color palettes, typography, and stationery.",
            description = "We build holistic brand identity systems that establish trust, authority, and consistency across every digital and print touchpoint. Perfect for new enterprises, rebrands, and scaling companies looking for an elite corporate presence.",
            heroHighlight = "Unified visual language, comprehensive brand guideline manual, social media kits, and corporate office collateral.",
            deliverables = listOf(
                "Complete logo suite (primary, horizontal, emblem, monochrome)",
                "Official brand guidelines book (PDF manual)",
                "Color palette system (Pantone, CMYK, RGB, HEX)",
                "Corporate typography pairing rules & web font licenses",
                "Executive stationery (cards, letterhead, envelopes, invoice)",
                "Social media profile kit (banners, avatar icons, post frames)",
                "Staff ID card and email signature templates",
                "Full master vector source suite in CorelDRAW & Adobe Illustrator"
            ),
            techOrMaterials = listOf("CorelDRAW 2024", "Adobe Illustrator", "Brand Guide Manual", "Typography Standards", "Social Asset Kit"),
            estimatedTurnaround = "10 to 14 Days",
            startingPrice = "PKR 120,000",
            priceNumericPkr = 120000L,
            features = listOf(
                ServiceFeature("Unified Corporate Voice", "Every touchpoint—from digital website to physical letterhead—reflects cohesive luxury standards."),
                ServiceFeature("Comprehensive Brand Manual", "Clear rules explaining clearspace, minimum sizes, color codes, and do's & don'ts."),
                ServiceFeature("Turnkey Source Repository", "Complete intellectual property ownership with organized files ready for developers and print houses.")
            )
        )
    )

    val webSolutions = listOf(
        WebSolution(
            id = "corporate",
            title = "Business & Corporate Websites",
            subtitle = "Authority, Trust & Lead Generation",
            description = "Polished, authoritative digital platforms designed for consultancies, corporate enterprises, service providers, and agencies looking to win client trust.",
            keyFeatures = listOf(
                "Executive team profiles & case studies",
                "Direct inquiry forms & lead capture",
                "SEO-optimized service architecture",
                "SSL encryption & fast response times"
            ),
            recommendedTech = "WordPress or Custom React SPA",
            idealFor = "Law firms, financial services, consulting agencies, B2B companies"
        ),
        WebSolution(
            id = "restaurant",
            title = "Restaurant & Hospitality Websites",
            subtitle = "Visual Menus & Table Inquiries",
            description = "Appetizing, mobile-first websites designed for restaurants, cafes, cloud kitchens, and bakeries. Showcases mouth-watering menus and instant table bookings.",
            keyFeatures = listOf(
                "Categorized digital food & drink menus",
                "Direct table reservation & WhatsApp ordering",
                "Google Maps location & opening hours sync",
                "High-res food photography galleries"
            ),
            recommendedTech = "WordPress CMS with Mobile Responsive Menu",
            idealFor = "Restaurants, cafes, bistros, bakeries, cloud kitchens"
        ),
        WebSolution(
            id = "ecommerce",
            title = "E-Commerce & Online Stores",
            subtitle = "Product Catalogs & Seamless Checkout",
            description = "High-converting online shopping platforms configured with product variations, inventory tracking, secure payment gateways, and WhatsApp checkout integration.",
            keyFeatures = listOf(
                "Filterable product catalog with image galleries",
                "Shopping cart & fast checkout workflow",
                "Cash on Delivery & online card payment setup",
                "Instant WhatsApp order confirmation alerts"
            ),
            recommendedTech = "WordPress + WooCommerce or Headless E-Commerce",
            idealFor = "Fashion brands, electronics retailers, cosmetic brands, consumer goods"
        ),
        WebSolution(
            id = "clinic",
            title = "Medical & Dental Clinic Websites",
            subtitle = "Patient Trust & Appointment Booking",
            description = "Clean, reassuring healthcare websites designed for doctors, dental clinics, diagnostic centers, and wellness spas. Simplifies appointment scheduling and patient guidance.",
            keyFeatures = listOf(
                "Doctor credentials & treatment guides",
                "Interactive patient appointment booking",
                "Clinic location map, parking & contact",
                "Mobile-friendly emergency dial buttons"
            ),
            recommendedTech = "WordPress CMS with Booking System",
            idealFor = "Dental clinics, specialized doctors, diagnostic labs, therapy centers"
        ),
        WebSolution(
            id = "portfolio",
            title = "Portfolio & Creative Studio Websites",
            subtitle = "Bespoke Visual Impact & Client Showcases",
            description = "Bold, modern portfolio sites designed for architects, photographers, interior designers, and creative professionals to display their finest commissions.",
            keyFeatures = listOf(
                "Fullscreen project galleries & case studies",
                "Client testimonials & credential badges",
                "Downloadable CV / PDF presentation decks",
                "Direct booking link / commission inquiry form"
            ),
            recommendedTech = "Custom React SPA or Modern WordPress Theme",
            idealFor = "Architects, interior designers, photographers, artists"
        )
    )

    val portfolioProjects = listOf(
        PortfolioProject(
            id = "creative-labs-web",
            title = "CreativeLabs Responsive Web Platform",
            client = "CreativeLabs Global",
            category = "web-app",
            categoryLabel = "Website & App UI Design",
            tagline = "Modern, responsive website and web application built with AI-assisted layout, WordPress, and Hostinger cloud deployment.",
            toolsUsed = "WordPress · Hostinger · React 19 · AI UI Tools",
            deliverables = listOf(
                "Interactive responsive desktop & smartphone layouts",
                "WordPress CMS customization with clean admin dashboard",
                "Hostinger domain setup, SSL security & email configuration",
                "SEO schema markup and 0.72s page transition speeds"
            ),
            format = "Responsive Web Platform & PWA",
            finishOrStack = "WordPress · Hostinger · Mobile Responsive",
            timeline = "4 Weeks"
        ),
        PortfolioProject(
            id = "apex-crest-logo",
            title = "Apex Dynamics Geometric Monogram & Logo",
            client = "Apex Industrial Technologies",
            category = "logo",
            categoryLabel = "Logo Design",
            tagline = "Precision vector logo created in CorelDRAW featuring geometric balance, optical kerning, and complete color separations.",
            toolsUsed = "CorelDRAW 2024 · Adobe Illustrator · Vector Bezier Math",
            deliverables = listOf(
                "Primary, horizontal, and compact icon mark variations",
                "Pantone coated & uncoated spot color calibrations",
                "High-resolution transparent PNG and print PDF/X-1a files",
                "Editable master CorelDRAW vector files (.CDR / .AI)"
            ),
            format = "Vector Bezier Master Package",
            finishOrStack = "CorelDRAW · Adobe Illustrator · SVG / EPS / CDR",
            timeline = "5 Days"
        ),
        PortfolioProject(
            id = "executive-black-cards",
            title = "Executive Corporate Business Cards & Stationery",
            client = "Khyber Strategic Capital",
            category = "business-card",
            categoryLabel = "Business Card Design",
            tagline = "Ultra-clean double-sided executive cards with 3mm press bleeds, gold foil callouts, and CorelDRAW print layouts.",
            toolsUsed = "CorelDRAW · Adobe Illustrator · CMYK Press Bleeds",
            deliverables = listOf(
                "Double-sided print-ready PDF/X files with crop & bleed marks",
                "Foil mask separation layer and matte finish callouts",
                "High-resolution JPG/PNG proofs for client review",
                "Full typography and vector logo layout source files"
            ),
            format = "Standard 3.5\" x 2\" with 3mm Bleeds",
            finishOrStack = "300 DPI CMYK · CorelDRAW Master",
            timeline = "3 Days"
        ),
        PortfolioProject(
            id = "lumina-botanical-packaging",
            title = "Lumina Herbal Skincare Bottle & Box Packaging",
            client = "Lumina Wellness Labs",
            category = "product",
            categoryLabel = "Product & Packaging Design",
            tagline = "Structural folding carton dielines, luxury bottle labels, and 3D product mockup visuals.",
            toolsUsed = "CorelDRAW · Adobe Illustrator · 3D Mockup Tools",
            deliverables = listOf(
                "Production-ready structural dieline with cut and crease guides",
                "Front, back, and side regulatory label layouts",
                "3D photorealistic product presentation mockups",
                "Layered CorelDRAW (.CDR) and Illustrator (.AI) source archives"
            ),
            format = "Custom Dieline + 3D Product Mockups",
            finishOrStack = "Soft-Touch Matte · Spot Foil · Barcode Tested",
            timeline = "8 Days"
        ),
        PortfolioProject(
            id = "grand-highway-flex",
            title = "Metro Expressway Grand-Scale Outdoor Flex Banner",
            client = "Capital Urban Real Estate",
            category = "banner",
            categoryLabel = "Flex & Banner Design",
            tagline = "High-contrast outdoor PVC vinyl advertising banner engineered in CorelDRAW for maximum long-distance impact.",
            toolsUsed = "CorelDRAW · Large-Format DPI Calibration · Solvent Inks",
            deliverables = listOf(
                "Grand-scale print master TIFF & PDF at 150 DPI calibrated scale",
                "Brass eyelet and pole-pocket placement template guide",
                "Digital companion social media banners (1:1 & 16:9)",
                "Editable CorelDRAW source files"
            ),
            format = "20ft x 10ft Outdoor Frontlit Flex",
            finishOrStack = "UV Solvent Inks · Weatherproof Hemming",
            timeline = "3 Days"
        ),
        PortfolioProject(
            id = "vanguard-brand-system",
            title = "Vanguard Complete Corporate Brand Identity System",
            client = "Vanguard Logistics & Fleet",
            category = "brand-identity",
            categoryLabel = "Brand Identity",
            tagline = "Full-spectrum visual identity system unifying logos, color codes, typography, letterheads, social assets, and brand rules.",
            toolsUsed = "CorelDRAW · Adobe Illustrator · Brand Guidelines Manual",
            deliverables = listOf(
                "30-page brand guidelines manual covering all logo usages",
                "Primary, secondary, and badge logo lockups",
                "CMYK, RGB, and HEX color code standards",
                "Corporate letterhead, envelope, and email signature templates"
            ),
            format = "Complete Brand Identity Manual & Asset Kit",
            finishOrStack = "Vector Suite + Brand Book PDF",
            timeline = "10 Days"
        )
    )

    val processSteps = listOf(
        ProcessStep(
            number = "01",
            title = "Discover",
            tagline = "Briefing & Strategic Research",
            description = "Understand your business goals, target audience, brand aesthetic, and technical or print requirements.",
            inclusions = listOf(
                "In-depth project questionnaire & requirement audit",
                "Competitor visual benchmark & typography direction",
                "Transparent budget estimate & delivery timeline in PKR"
            )
        ),
        ProcessStep(
            number = "02",
            title = "Design",
            tagline = "AI Prototyping & Vector Crafting",
            description = "Explore layouts and visual concepts using AI tools, CorelDRAW, and Adobe Illustrator for bespoke aesthetics.",
            inclusions = listOf(
                "Multiple initial layout variations & logo concepts",
                "Photorealistic 3D mockups (screens, cards, packaging)",
                "Structured client review & revision feedback loop"
            )
        ),
        ProcessStep(
            number = "03",
            title = "Develop",
            tagline = "Engineering & Print Assembly",
            description = "Build websites with WordPress, AI tools, Hostinger, or custom technologies as appropriate.",
            inclusions = listOf(
                "WordPress theme setup, page building & plugin config",
                "Hostinger domain linkage, SSL security & email setup",
                "Print dieline separation (CMYK, bleeds, foil masks)"
            )
        ),
        ProcessStep(
            number = "04",
            title = "Deliver",
            tagline = "Testing, Launch & Handover",
            description = "Provide the agreed final website, design files, and project deliverables with complete ownership.",
            inclusions = listOf(
                "Cross-device responsive testing & SEO verification",
                "Full handover of editable source files (.CDR / .AI / Git)",
                "Post-launch orientation & print house coordination"
            )
        )
    )

    val studioAssurances = listOf(
        StudioAssurance(
            title = "AI Speed with Human Precision",
            description = "We use artificial intelligence to accelerate ideation and prototyping, but every final vector bezier, print cut line, and line of code is human-crafted and reviewed by experienced designers.",
            badge = "Smart Efficiency"
        ),
        StudioAssurance(
            title = "100% Print-Ready Deliverables",
            description = "Never worry about blurry prints or rejected files at the press. We prepare industry-standard 300 DPI CMYK PDFs, 3mm bleed margins, vector curves, and spot color masks in CorelDRAW.",
            badge = "Press Standard"
        ),
        StudioAssurance(
            title = "WordPress & Hostinger Expertise",
            description = "From custom WordPress theme styling to domain linking, LiteSpeed caching, SSL certificates, and custom corporate email setups on Hostinger, we manage your full web launch.",
            badge = "Full Web Launch"
        ),
        StudioAssurance(
            title = "Transparent PKR Pricing",
            description = "Clear, upfront packages quoted in Pakistani Rupees (PKR) with zero hidden fees. You know exactly what deliverables, revisions, and source files you are receiving from day one.",
            badge = "Honest Terms"
        ),
        StudioAssurance(
            title = "Direct WhatsApp & Email Support",
            description = "No dealing with middle managers or slow ticket systems. Connect directly with the creative engineer via WhatsApp or email for prompt revisions and project discussions.",
            badge = "Fast Response"
        ),
        StudioAssurance(
            title = "Complete Master File Ownership",
            description = "Upon project completion and sign-off, you receive full intellectual property ownership and all editable master source archives (.CDR, .AI, high-res PDF, PNG, or code repositories).",
            badge = "100% Ownership"
        )
    )

    val projectOptions = listOf(
        ProjectCategoryOption("web-app", "Websites & Apps Design", 250000L, "4-8 Weeks", "WordPress CMS, Hostinger setup, responsive layout, SEO"),
        ProjectCategoryOption("logo", "Logo & Visual Mark Design", 45000L, "5-7 Days", "CorelDRAW vector, transparent PNG, print PDF, colors"),
        ProjectCategoryOption("card", "Business Card & Stationery", 35000L, "3-5 Days", "3.5x2 inch, 3mm bleed, 300 DPI CMYK, foil mask"),
        ProjectCategoryOption("product", "Products & Packaging Design", 65000L, "7-10 Days", "Dieline vector, 3D mockups, barcodes, CMYK master"),
        ProjectCategoryOption("banner", "Flex & Large-Format Banner", 30000L, "3-5 Days", "Grand-scale calibration, eyelet guides, TIFF & PDF"),
        ProjectCategoryOption("brand", "Full Corporate Brand Identity", 120000L, "10-14 Days", "Brand guidelines manual, full logo suite, stationery")
    )

    val availableAddons = listOf(
        EstimatorAddon("hostinger-cloud", "Hostinger Cloud & Domain Setup", 25000L, "Domain linking, SSL certificate, 5 corporate email accounts & LiteSpeed caching"),
        EstimatorAddon("master-cdr-ai", "Editable Master .CDR & .AI Files", 15000L, "Complete layer hierarchy, unlocked fonts and open vector curves for future edits"),
        EstimatorAddon("mockups-3d", "3D Photorealistic Mockup Pack", 18000L, "High-res 4K presentation mockups for digital marketing, pitch decks and retail catalogs"),
        EstimatorAddon("rush-delivery", "Rush Priority Turnaround (48-72h)", 22000L, "Accelerated review sprint with dedicated priority queue and same-day revisions"),
        EstimatorAddon("social-kit", "Social Media Launch Asset Kit", 14000L, "Profile badges, header banners for Facebook, LinkedIn, X, and Instagram story frames")
    )
}
