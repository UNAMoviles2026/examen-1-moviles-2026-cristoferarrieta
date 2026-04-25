package com.moviles.examenmoviles.ui.screens.spaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviles.examenmoviles.model.CoworkingSpace
import com.moviles.examenmoviles.ui.components.AppBottomBar
import com.moviles.examenmoviles.ui.components.InfoRow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceDetailScreen(
    space: CoworkingSpace,
    onBack: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var reserved by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Space Detail") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            AppBottomBar()
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Image(
                painter = painterResource(id = space.imageResId),
                contentDescription = space.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Text(
                text = space.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(text = space.description)

            InfoRow("Location", space.location)
            InfoRow("Capacity", "${space.capacity} people")
            InfoRow("Price per hour", "₡${space.pricePerHour.toInt()}")
            InfoRow(
                "Availability",
                if (space.isAvailable) "Available" else "Not available"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    reserved = true

                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Reservation successful"
                        )
                    }
                },
                enabled = space.isAvailable && !reserved,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (reserved) "Reserved" else "Reserve space"
                )
            }
        }
    }
}