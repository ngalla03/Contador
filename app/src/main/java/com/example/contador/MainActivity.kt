package com.example.contador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.* // Para Column, Row, Spacer, padding, fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.material3.Button // Botón
import androidx.compose.material3.ButtonDefaults // Para cambiar el color de los botones
import androidx.compose.material3.Scaffold // Layout base con barra de herramientas, fab, etc.
import androidx.compose.material3.Text // Para mostrar texto
import androidx.compose.runtime.* // Para remember, mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable // Para guardar estado al rotar pantalla
import androidx.compose.ui.Alignment // Para alinear elementos
import androidx.compose.ui.Modifier // Para modificar elementos (padding, size, etc.)
import androidx.compose.ui.graphics.Color // Para los colores
import androidx.compose.ui.tooling.preview.Preview // Para la vista previa
import androidx.compose.ui.unit.dp // Unidades de distancia (densidad independiente)
import androidx.compose.ui.unit.sp // Tamaño de letra
import com.example.contador.ui.theme.ContadorTheme // Tema de la app


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Permite que la app se dibuje bajo la barra de estado del teléfono

        // setContent es donde se "pinta" todo lo que se ve en la pantalla
        setContent {
            ContadorTheme {
                // Scaffold es un layout que te permite poner elementos base como barra superior, FAB, etc.
                Scaffold(
                    modifier = Modifier.fillMaxSize() // Ocupa toda la pantalla
                ) { innerPadding ->
                    // Aplicamos innerPadding para que los elementos no choquen con la barra del Scaffold
                    Count(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Count(modifier: Modifier = Modifier) {
    // --- VARIABLES DE ESTADO ---
    // count: contador principal
    var count by rememberSaveable { mutableStateOf(0) }
    // count2: contador de todas las pulsaciones en la pantalla
    var count2 by rememberSaveable { mutableStateOf(0) }
    // messageError: texto de advertencia cuando no se puede restar
    var messageError by rememberSaveable { mutableStateOf("") }

    // --- LAYOUT PRINCIPAL ---
    Column(
        modifier = modifier.fillMaxSize(), // Ocupa toda la pantalla
        horizontalAlignment = Alignment.CenterHorizontally, // Centrado horizontal
        verticalArrangement = Arrangement.Center // Centrado vertical
    ) {
        // Si hay messageError de advertencia, se muestra en rojo
        if (messageError.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .background(Color.Red, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp)
            ) {
                Text(
                    text = messageError,
                    color = Color.White,
                    fontSize = 32.sp
                )
            }
        }
        // Texto que muestra el contador principal
        Text(text = "Contador: $count", fontSize = 32.sp)


        Spacer(modifier = Modifier.height(32.dp)) // Espacio entre elementos

        // --- FILA BOTONES SUMA / RESTA 1 ---
        Row {
            // Botón para restar 1
            Button(
                onClick = {
                    if (count > 0) {
                        count--  // Decrementa contador principal
                        count2++ // Incrementa contador total
                        messageError = "" // Limpia messageError
                    } else {
                        messageError = "No puedes bajar de 0" // Advertencia
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF57C00)
                ),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text("Restar 1", fontSize = 32.sp)
            }

            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre botones

            // Botón para sumar 1
            Button(
                onClick = {
                    count++   // Incrementa contador principal
                    count2++  // Incrementa contador total
                    messageError = "" // Limpia messageError de advertencia
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                ),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp) // Espaciado interno del botón
            ) {
                Text("Sumar 1", fontSize = 32.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- FILA BOTONES SUMA / RESTA 5 ---
        Row {
            // Botón para restar 5
            Button(
                onClick = {
                    if (count > 0 && count >= 5) {
                        count = (count - 5).coerceAtLeast(0) // Nunca menor que 0
                        count2++
                        messageError = ""
                    }else if (count == 0){
                        messageError = "No puedes bajar de 0"
                    }else{
                        messageError = "Debe haber al menos un 5"
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF57C00)
                ),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text("Restar 5", fontSize = 32.sp)
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Botón para sumar 5
            Button(
                onClick = {
                    count += 5
                    count2++
                    messageError = ""
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                ),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text("Sumar 5", fontSize = 32.sp)
            }

        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- CONTADOR TOTAL DE PULSACIONES ---
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Pulsaciones totales en la pantalla:", fontSize = 25.sp)
            Text(text = "$count2", fontSize = 32.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- BOTÓN BORRAR ---
        Button(
            onClick = {
                count = 0
                count2 = 0
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE57373 )
            ),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text("Borrar", fontSize = 32.sp)
        }
    }
}

// --- VISTA PREVIA EN EL EDITOR ---
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CountPreview() {
    Count()
}