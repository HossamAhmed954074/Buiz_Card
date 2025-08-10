package com.demo.buiz_card


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.buiz_card.ui.theme.Buiz_cardTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Buiz_cardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BuizCardScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BuizCardScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF667eea),
                        Color(0xFF764ba2)
                    )
                )
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(24.dp),
                    ambientColor = Color.Black.copy(alpha = 0.3f)
                ),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            BuizCardbody()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewBuizCardScreen() {
    Buiz_cardTheme {
        BuizCardScreen()
    }
}

@Composable
fun BuizCardbody(modifier: Modifier = Modifier) {
    var onClickPortfolioShow by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val buttonScale by animateFloatAsState(targetValue = if (onClickPortfolioShow) 1.1f else 1f)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProfileImageCustom(isRotating = onClickPortfolioShow)
        ContentInfo()
        ContactSection()
        DividerHorizontal()

        Button(
            onClick = {
                scope.launch {
                    onClickPortfolioShow = !onClickPortfolioShow
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .scale(buttonScale),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF667eea))
        ) {
            Text(
                text = "View Portfolio",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
        }

        AnimatedVisibility(
            visible = onClickPortfolioShow,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            PortfolioContent(
                listOf(
                    "Restaurant APP",
                    "Quiz Minds APP",
                    "Bus Booking App (Loopi)",
                    "Portfolio Web APP",
                    "Book Store App"
                )
            )
        }
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier, isVisible: Boolean = true) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ContactItem(
                icon = Icons.Default.Email,
                text = "eltohamehossam@gmail.com"
            )
            ContactItem(
                icon = Icons.Default.Phone,
                text = "+20 114 703 2347"
            )
            ContactItem(
                icon = Icons.Default.AccountBox,
                text = "github.com/HossamAhmed954074"
            )
        }
    }
}

@Composable
fun ContentInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Hossam Ahmed",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFF2D3748)
        )
        Text(
            text = "Mobile Developer",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF667eea),
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Flutter • JetPack Compose • Firebase Expert",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
        Text(
            text = "Cairo, Egypt",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun PortfolioItem(projectTitle: String, modifier: Modifier = Modifier) {
    val offsetX by animateFloatAsState(targetValue = 0f)
    val techStack = when (projectTitle) {
        "Restaurant APP" -> "Flutter • Firebase • BLoC • Go Router"
        "Quiz Minds APP" -> "Flutter • Firebase • BLoC • Firestore"
        "Bus Booking App (Loopi)" -> "Flutter • Firebase • Maps SDK • Real-time Chat"
        "Portfolio Web APP" -> "Flutter Web • Firebase • Responsive Design"
        "Book Store App" -> "Flutter • MVVM • BLoC • RESTful API"
        else -> "Flutter • Dart • Firebase"
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .offset(x = offsetX.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(48.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(Color(0xFF667eea).copy(alpha = 0.1f))
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = null,
                        tint = Color(0xFF667eea),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = projectTitle,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(
                    text = techStack,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun ContactItem(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF667eea),
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

//
@Composable
fun PortfolioContent(data: List<String>, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color(0xFFF8F9FA)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "My Portfolio",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF667eea)
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(data.size) { index ->
                    PortfolioItem(data[index])
                }
            }
        }
    }
}

@Composable
fun DividerHorizontal(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = modifier.fillMaxWidth(),
        thickness = 1.dp,
        color = Color.Gray.copy(alpha = 0.3f)
    )
}

@Composable
fun ProfileImageCustom(
    modifier: Modifier = Modifier,
    id: Int = R.drawable.me,
    isRotating: Boolean = false
) {
    val rotation by animateFloatAsState(targetValue = if (isRotating) 360f else 0f)

    Card(
        modifier = modifier
            .size(120.dp)
            .graphicsLayer(rotationZ = rotation),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Image(
            painter = painterResource(id),
            contentDescription = "Profile Image",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}
