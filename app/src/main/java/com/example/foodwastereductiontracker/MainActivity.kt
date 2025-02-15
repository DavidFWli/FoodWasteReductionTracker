package com.example.foodwastereductiontracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TopAppBarDefaults
import com.example.foodwastereductiontracker.ui.theme.FoodWasteReductionTrackerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodWasteReductionTrackerTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Food Waste Tracker") },
                            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF6200EE))
                        )
                    }
                ) { padding ->
                    FoodItemList(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    )
                }
            }
        }
    }
}

@Composable
fun FoodItemList(modifier: Modifier = Modifier) {
    val foodItems = listOf(
        FoodItem("Bananas", "2024-10-01", 3, R.drawable.ic_banana),
        FoodItem("Milk", "2024-10-05", 1, R.drawable.ic_milk),
        FoodItem("Eggs", "2024-10-10", 6, R.drawable.ic_eggs)
    )

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(foodItems) { item ->
            FoodItemCard(foodItem = item)
        }
    }
}

@Composable
fun FoodItemCard(foodItem: FoodItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.your_image),
                contentDescription = "Your image description"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = foodItem.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Expires on: ${foodItem.expiryDate}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = "Quantity: ${foodItem.quantity}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

