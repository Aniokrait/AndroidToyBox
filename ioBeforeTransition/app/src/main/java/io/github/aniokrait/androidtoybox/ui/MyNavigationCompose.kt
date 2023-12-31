package io.github.aniokrait.androidtoybox.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.aniokrait.androidtoybox.ui.screen.TransitSourceScreen
import io.github.aniokrait.androidtoybox.ui.screen.TransitDestScreen
import io.github.aniokrait.androidtoybox.ui.viewmodel.TransitSourceViewModel
import io.github.aniokrait.androidtoybox.ui.viewmodel.TransitTargetViewModel

@Composable
fun MyNavigationCompose(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController, startDestination = "transitSource"
    ) {
        composable("transitSource") {
            val vm: TransitSourceViewModel = hiltViewModel()
            //Activityが破棄されても保持し続けるためにrememberではなくrememberSaveableで定義
            val isLoadCompleted = rememberSaveable { mutableStateOf(false) }
            var showIndicator = rememberSaveable { mutableStateOf(false) }
            TransitSourceScreen(
                showIndicator = showIndicator,
                transit = {
                    //navController.navigateではなく、BooleanのMutableStateを渡す
                    vm.fetchSomeData(isLoadCompleted)
                }
            )
            //isLoadCompletedがtrueになったら画面遷移を行う。
            LaunchedEffect(isLoadCompleted.value) {
                if (isLoadCompleted.value) {
                    showIndicator.value = false
                    navController.navigate("transitTarget")
                    isLoadCompleted.value = false
                }
            }
        }
        composable("transitTarget") {
            val vm: TransitTargetViewModel = hiltViewModel()
            TransitDestScreen()
        }
    }
}