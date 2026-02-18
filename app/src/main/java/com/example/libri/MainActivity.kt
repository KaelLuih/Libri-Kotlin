package com.example.libri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libri.ui.theme.LibriTheme

data class Livro(
    val title: String,
    val location: String,
    val colorPlaceholder: Color
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibriTheme {
                Tela()
            }
        }
    }
}

@Composable
fun Tela(){
    Scaffold(
        containerColor = Color.White,
        topBar = { TopBar()}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LivroSection()
        }
    }
}

@Composable
fun TopBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .border(1.dp, Color.Black, CircleShape)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.livro),
                contentDescription = "Icon de livro",
                modifier = Modifier.size(23.dp)
            )
        }
        Text(
            text = "LIBRI",
            fontSize = 28.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFF0D785),
            letterSpacing = 2.sp
        )
        Box(
            modifier = Modifier
                .size(48.dp)
                .border(1.dp, Color.Black, CircleShape)
        ) {
            Image(
                painter = painterResource(R.drawable.iconuser),
                contentDescription = "Icon de usuario",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }
    }
}

@Composable
fun LivroSection(){
    val livros = listOf(
        Livro("CORTE DE NÉVOA E FÚRIA", "Via Verde - BR", Color(0xFFB39DDB)),
        Livro("NOITES BRANCAS", "Londres - UK", Color(0xFFFFCC80)),
        Livro("É ASSIM QUE ACABA", "Nova Iorque - EUA", Color(0xFF90CAF9)),
        Livro("EU QUERO A ÁRVORE...", "Sanaã - Iêmen", Color(0xFFA5D6A7)),
        Livro("O ESTRANGEIRO", "Lima - Peru", Color(0xFF80CBC4))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .background(
                    Color(0xFFFFEFA7),
                    shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)
                )
        ) {
            LazyColumn(
                contentPadding = PaddingValues(
                    start = 24.dp, end = 24.dp, bottom = 100.dp
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(livros){ livro ->
                    LivrosCard(livro)
                }
            }
        }
    }
}

