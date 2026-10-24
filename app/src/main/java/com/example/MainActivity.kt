package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.Collections
import androidx.compose.material.icons.outlined.DesignServices
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.components.StudioTopAppBar
import com.example.ui.screens.EstimatorContactScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.PortfolioScreen
import com.example.ui.screens.ServicesScreen
import com.example.ui.screens.SpecStudioScreen
import com.example.ui.theme.AmberGold
import com.example.ui.theme.BorderSubtle
import com.example.ui.theme.CreativeDesignTheme
import com.example.ui.theme.Obsidian800
import com.example.ui.theme.Obsidian900
import com.example.ui.theme.Obsidian950
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

sealed class Screen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    data object Home : Screen("home", "Studio", Icons.Filled.Home, Icons.Outlined.Home)
    data object Services : Screen("services", "Services", Icons.Filled.DesignServices, Icons.Outlined.DesignServices)
    data object SpecStudio : Screen("spec_studio", "Spec Lab", Icons.Filled.Tune, Icons.Outlined.Tune)
    data object Portfolio : Screen("portfolio", "Work", Icons.Filled.Collections, Icons.Outlined.Collections)
    data object Estimator : Screen("estimator", "Quote", Icons.Filled.Calculate, Icons.Outlined.Calculate)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CreativeDesignTheme(darkTheme = true) {
                MainAppContent()
            }
        }
    }
}

@Composable
fun MainAppContent() {
    var currentScreenIndex by remember { mutableIntStateOf(0) }
    var targetServiceId by remember { mutableStateOf<String?>(null) }

    // Intercept back navigation if not on Home screen
    BackHandler(enabled = currentScreenIndex != 0) {
        currentScreenIndex = 0
    }

    val navItems = listOf(
        Screen.Home,
        Screen.Services,
        Screen.SpecStudio,
        Screen.Portfolio,
        Screen.Estimator
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeDrawing,
        topBar = {
            StudioTopAppBar(
                onContactClick = { currentScreenIndex = 4 }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Obsidian950,
                tonalElevation = 8.dp,
                modifier = Modifier
                    .background(Obsidian950)
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .testTag("studio_bottom_nav")
            ) {
                navItems.forEachIndexed { index, screen ->
                    val isSelected = currentScreenIndex == index
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            currentScreenIndex = index
                        },
                        icon = {
                            Icon(
                                imageVector = if (isSelected) screen.selectedIcon else screen.unselectedIcon,
                                contentDescription = screen.title,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        label = {
                            Text(
                                text = screen.title,
                                fontSize = 10.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Obsidian950,
                            selectedTextColor = AmberGold,
                            indicatorColor = AmberGold,
                            unselectedIconColor = TextMuted,
                            unselectedTextColor = TextSecondary
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Obsidian950)
        ) {
            when (currentScreenIndex) {
                0 -> HomeScreen(
                    onNavigateToServices = { currentScreenIndex = 1 },
                    onNavigateToStudio = { currentScreenIndex = 2 },
                    onNavigateToEstimator = { currentScreenIndex = 4 },
                    onSelectService = { serviceId ->
                        targetServiceId = serviceId
                        currentScreenIndex = 1
                    }
                )
                1 -> ServicesScreen(
                    initialServiceId = targetServiceId,
                    onNavigateToEstimator = { serviceId ->
                        targetServiceId = serviceId
                        currentScreenIndex = 4
                    }
                )
                2 -> SpecStudioScreen(
                    onNavigateToEstimator = { currentScreenIndex = 4 }
                )
                3 -> PortfolioScreen(
                    onNavigateToEstimator = { serviceId ->
                        targetServiceId = serviceId
                        currentScreenIndex = 4
                    }
                )
                4 -> EstimatorContactScreen(
                    preselectedProjectId = targetServiceId
                )
            }
        }
    }
}
