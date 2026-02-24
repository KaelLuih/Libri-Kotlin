package com.example.libri

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun TelaInicial(QuandoAcabarOTempo: () -> Unit){
    LaunchedEffect(key1 = true) {

            delay(2000)
            QuandoAcabarOTempo()

    }
  Column(modifier = Modifier.fillMaxSize()
      .background(Color(0xFFFFF3B0)),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
  ) {
    Image(painter = painterResource(R.drawable.image_34), contentDescription = "logo",
        modifier = Modifier.size(150.dp))
      Spacer(modifier = Modifier.height(16.dp))
      Text(
          text = "LIBRI",
          fontSize = 28.sp,
          fontFamily = FontFamily.Serif,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          letterSpacing = 2.sp
      )
  }

    
    
    
}