package com.example.week4vp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainCarAppPreview() { MaterialTheme{
        MainCarApp()
    }
}

@Composable
fun MainCarApp() {
    val dummyCars = remember {
        mutableStateListOf(Car(1, "Tiggo 9 CSH", "PETROL", "Auto", "2024", "5,000 km", "Rp 450.000.000", "Jakarta", R.drawable.tiggo, "Premium SUV with modern features.", true),
            Car(2, "Honda CRV", "PETROL", "Auto", "2013", "15,200 km", "Rp 180.000.000", "Bandung", R.drawable.crv, "Reliable family SUV.", false),
            Car(3, "Toyota Yaris Cross", "HYBRID", "Auto", "2024", "30,500 km", "Rp 320.000.000", "Surabaya", R.drawable.yariscross, "Compact hybrid crossover.", true),
            Car(4, "Daihatsu Xenia", "PETROL", "Manual", "2022", "28,000 km", "Rp 160.000.000", "Semarang", R.drawable.xenia, "Spacious 7-seater MPV.", false),
            Car(5, "Toyota Yaris", "PETROL", "Auto", "2021", "52,400 km", "Rp 245.000.000", "Semarang", R.drawable.yaris, "Sporty compact hatchback with 1.5L dual VVT-i engine.", true),
            Car(6, "Ayla", "PETROL", "Manual", "2102", "5,000 km", "Rp 67.000.000", "UniggAstates", R.drawable.ayla, "NOt so premisujfdm.", true),
            Car(7, "J5", "Pentol", "Tungtungtung", "yes", "5,1000000000000000 km", "Rp Free", "Indognesia", R.drawable.j5, "Mythical Immortal.", false),
        )
    }

    var selectedCar by remember { mutableStateOf<Car?>(null) }

    if (selectedCar!= null) {
        CarDetailScreen(
            car = selectedCar!!,
            onBackClick= {selectedCar = null }
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(text = "On Sale", style = MaterialTheme.typography.headlineMedium)
            Text(text = "Find your ???????? ride", color = MaterialTheme.colorScheme.onSurfaceVariant)

            Spacer(modifier = Modifier.height(16.dp))


            LazyColumn {
                items(dummyCars) { car ->
                    CarCard(
                        car = car,
                        onCardClick = { selectedCar = car },
                        onFavoriteClick = {
                            val index = dummyCars.indexOf(car)
                            if (index != -1) {
                                dummyCars[index] = car.copy(isFavorite = !car.isFavorite)
                            }
                        }
                    )
                }
            }
        }
    }
}