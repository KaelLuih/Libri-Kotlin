package com.example.libri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.collection.mutableObjectIntMapOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.CrossAxisAlignment.CenterCrossAxisAlignment.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libri.ui.theme.LibriTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibriTheme {
                Feed()
            }
        }
    }
}

@Composable
fun Feed(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding(),
        color = Color(0xFFFFFFFF)
    ) {

    }
}

private infix fun Unit.background(copy: Any) {

}

@Composable
fun LivrosCard(livros:Livro) {
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
                modifier = Modifier.size(76.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(livros.colorPlaceholder)
            ) {
                Image(
                    painter = painterResource(R.drawable.image_14), contentDescription = "imagem1",
                    modifier = Modifier
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
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favoritar",
                    modifier = Modifier.size(24.dp)
                )
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
        color = Color.White,

    ){
        Row(    modifier = Modifier
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
                Icon(painter = painterResource(R.drawable.union ) ,
                    contentDescription = "Home",
                    modifier = Modifier
                        .size(28.dp)
                        .border(1.dp, Color.Black, CircleShape)
                )
            }
            IconButton(onClick = { }) {
                Icon(painter = painterResource(R.drawable.add),
                    contentDescription = "Add",
                    Modifier
                        .size(28.dp)
                        .border(1.dp, Color.Black, CircleShape)
                    )

            }
            IconButton(onClick = { }) {
                Icon(painter = painterResource(R.drawable.vector),
                    contentDescription = "Map",
                    Modifier
                        .size(28.dp)
                        .border(1.dp, Color.Black, CircleShape),
                )

            }
            Box{
                Icon(painter = painterResource(R.drawable.add), contentDescription ="Notification",
                    Modifier.size(28.dp)
                )
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


