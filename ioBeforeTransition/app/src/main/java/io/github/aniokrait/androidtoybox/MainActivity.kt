package io.github.aniokrait.androidtoybox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.github.aniokrait.androidtoybox.ui.MyNavigationCompose
import io.github.aniokrait.androidtoybox.ui.theme.AndroidToyBoxTheme
import io.github.aniokrait.androidtoybox.ui.viewmodel.BaseViewModel
import io.github.aniokrait.androidtoybox.ui.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToyBoxTheme {
                val mainVm: MainViewModel = hiltViewModel()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold {
                        MyNavigationCompose(modifier = Modifier.padding(it))

                        var isLoading = BaseViewModel.loadIndicatorState.value.isLoading
                        if(isLoading) {
                            Box(modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Black.copy(alpha = 0.4f))
                                ,
                                    contentAlignment = Alignment.Center
                                ) {
                                CircularProgressIndicator()
                                //isLoading = true
                            }
                        }

                    }
                }
            }
        }
    }
}
