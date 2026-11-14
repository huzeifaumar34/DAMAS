package com.huzeifa.damas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.huzeifa.damas.engine.NativeEngine
import com.huzeifa.damas.ui.DamasHomeScreen
import com.huzeifa.damas.ui.theme.DamasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val engineVersion = NativeEngine.version()

        setContent {
            DamasTheme {
                DamasHomeScreen(engineVersion = engineVersion)
            }
        }
    }
}
