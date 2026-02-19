package com.example.libri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val imageRes: Int,
    val title: String,
    val location: String
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
        topBar = { TopBar()},
        bottomBar = { LibriBottom()}
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
        Livro( R.drawable.image_14,"CORTE DE NÉVOA E FÚRIA", "Via Verde - BR"),
        Livro( R.drawable.image_15,"NOITES BRANCAS", "Londres - UK"),
        Livro( R.drawable.image_13,"É ASSIM QUE ACABA", "Nova Iorque - EUA"),
        Livro( R.drawable.image_16,"EU QUERO A ÁRVORE...", "Sanaã - Iêmen"),
        Livro( R.drawable.image_19,"O ESTRANGEIRO", "Lima - Peru"),
        Livro( R.drawable.livro_7, "RELATOS DE UM GATO VIAJANTE", "Sidney - Austrália"),
        Livro( R.drawable.livro_6, "O SOL É PARA TODOS", "Praga - República Tcheca")
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
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(top = 24.dp)
            ) {
                items(livros){ livro ->
                    LivrosCard(livro)
                }
            }
        }
    }
}

@Composable
fun LivrosCard(livros:Livro) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(76.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(id = livros.imageRes),
                    contentDescription = "imagem1",
                    modifier = Modifier
                        .fillMaxSize()
                        .size(28.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = livros.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Black,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = livros.location,
                            fontSize = 12.sp
                        )
                    }
                    IconButton(onClick = { isFavorite = !isFavorite }) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favoritar",
                            tint = if (isFavorite) Color.Red else Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun LibriBottom(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .border(1.dp, Color.Black, CircleShape),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        color = Color.White
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(Color(0xFFFFEFA7), CircleShape)
                    .border(1.dp, Color.Black, CircleShape),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(R.drawable.union ) ,
                    contentDescription = "Home",
                    modifier = Modifier.size(28.dp)
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.add),
                    contentDescription = "Add",
                    Modifier.size(28.dp)
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.vector),
                    contentDescription = "Map",
                    Modifier.size(28.dp)
                )
            }
            Box{
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.vector__1_),
                        contentDescription ="Notification",
                        Modifier.size(28.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color(0xFFF0D785), CircleShape)
                        .align(Alignment.TopEnd)
                        .border(1.dp, Color.White, CircleShape)
                )
            }
        }
    }
}


