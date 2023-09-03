package io.github.aniokrait.androidtoybox.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.aniokrait.androidtoybox.ui.screen.MainScreen
import io.github.aniokrait.androidtoybox.ui.screen.TwoFlowsScreen
import io.github.aniokrait.androidtoybox.ui.viewmodel.TwoFlowsViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navigate = { navController.navigate("twoFlows") })
        }
        composable("twoFlows") {
            val viewModel: TwoFlowsViewModel = hiltViewModel()
            TwoFlowsScreen(viewModel = viewModel)
        }
    }
}