package com.example.mylayoutperro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylayoutperro.ui.theme.MylayoutperroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MylayoutperroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaPrincipal(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        // ENCABEZADO
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF6ED3D2))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Encabezado",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // CAJAS
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {

            // CAJA 1
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFEDED4B)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text("Caja 1")

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {}) {
                    Text("Acción")
                }
            }

            // CAJA 2
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFF6EEB4A)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text("Caja 2")

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {}) {
                    Text("Acción")
                }
            }
        }

        // LISTA
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(10.dp)
                .weight(1f)
        ) {

            Text(
                text = "Lista de Elementos",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            val comidas = listOf("Hamburguesa", "Pizza", "Tacos", "Sushi")

            LazyColumn {

                items(comidas) { comida ->

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                            .background(
                                Color.Gray,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(16.dp)
                    ) {
                        Text(comida)
                    }

                }

            }
        }

        // PIE DE PAGINA
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Pie de página",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantalla() {
    MylayoutperroTheme {
        PantallaPrincipal()
    }
}