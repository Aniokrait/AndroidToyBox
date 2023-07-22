package io.github.aniokrait.androidsandbox.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.aniokrait.androidsandbox.ui.screen.TransitSourceScreen
import io.github.aniokrait.androidsandbox.ui.screen.TransitDestScreen
import io.github.aniokrait.androidsandbox.ui.viewmodel.TransitSourceViewModel
import io.github.aniokrait.androidsandbox.ui.viewmodel.TransitTargetViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun MyNavigationCompose(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController, startDestination = "transitSource"
    ) {
        composable("transitSource") {
            val vm: TransitSourceViewModel = hiltViewModel()
            TransitSourceScreen(
                transit = {
                    vm.fetchSomeData(navigate = {navController.navigate("transitTarget")})
                }
            )
        }
        composable("transitTarget") {
            val vm: TransitTargetViewModel = hiltViewModel()
            TransitDestScreen()
        }
    }
}