package com.huzeifa.damas.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DamasHomeScreen(engineVersion: String) {
    var showBoardPreview by remember { mutableStateOf(false) }

    if (showBoardPreview) {
        BoardPreviewScreen(onBack = { showBoardPreview = false })
    } else {
        HomeScreen(
            engineVersion = engineVersion,
            onPreviewBoard = { showBoardPreview = true }
        )
    }
}

@Composable
private fun HomeScreen(engineVersion: String, onPreviewBoard: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "DAMAS",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 42.sp,
                fontWeight = FontWeight.Black,
                letterSpacing = 8.sp
            )
            Text(
                text = "ESTRATÉGIA • PRECISÃO • DESAFIO",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(34.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(modifier = Modifier.padding(22.dp)) {
                    Text(
                        text = "O clássico está a ganhar uma nova forma.",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Damas brasileiras, sete níveis de inteligência e partidas locais. Uma experiência pensada para jogar offline.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(22.dp))
                    Button(
                        onClick = onPreviewBoard,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Ver tabuleiro de demonstração")
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "FUNDAÇÃO DO JOGO",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Interface Android e ligação Kotlin/C++ preparadas.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = engineVersion,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))
            Text(
                text = "FASE 1 • BASE ANDROID",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.labelSmall,
                letterSpacing = 2.sp
            )
        }
    }
}

@Composable
private fun BoardPreviewScreen(onBack: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TABULEIRO",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Demonstração visual • 8 × 8",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(20.dp))

            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(14.dp))
            ) {
                val cell = size.width / 8f
                val lightSquare = Color(0xFFE7D7B8)
                val darkSquare = Color(0xFF294438)
                val lightPiece = Color(0xFFF7F1E6)
                val darkPiece = Color(0xFF292D2A)
                val gold = Color(0xFFD6B56D)

                for (row in 0 until 8) {
                    for (column in 0 until 8) {
                        drawRect(
                            color = if ((row + column) % 2 == 0) lightSquare else darkSquare,
                            topLeft = Offset(column * cell, row * cell),
                            size = Size(cell, cell)
                        )

                        val isPlayable = (row + column) % 2 == 1
                        val hasPiece = row in 0..2 || row in 5..7
                        if (isPlayable && hasPiece) {
                            val center = Offset(
                                (column + 0.5f) * cell,
                                (row + 0.5f) * cell
                            )
                            val pieceColor = if (row <= 2) darkPiece else lightPiece
                            drawCircle(
                                color = Color(0xFF101411),
                                radius = cell * 0.37f,
                                center = Offset(center.x, center.y + cell * 0.025f)
                            )
                            drawCircle(
                                color = pieceColor,
                                radius = cell * 0.34f,
                                center = center
                            )
                            drawCircle(
                                color = gold,
                                radius = cell * 0.27f,
                                center = center,
                                style = Stroke(width = cell * 0.025f)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "Tabuleiro de apresentação. As regras, capturas e jogadas serão implementadas na próxima fase.",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(22.dp))
            OutlinedButton(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
                Text("Voltar ao início")
            }
        }
    }
}
