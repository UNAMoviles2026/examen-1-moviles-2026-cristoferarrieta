package com.moviles.examenmoviles.data

import com.moviles.examenmoviles.R
import com.moviles.examenmoviles.model.CoworkingSpace

object MockSpaces {
    val spaces = listOf(
        CoworkingSpace(
            id = 1,
            name = "Central Work Hub",
            description = "Modern coworking space with high-speed Wi-Fi, meeting rooms and coffee area.",
            location = "San José, Costa Rica",
            capacity = 12,
            pricePerHour = 10000.0,
            isAvailable = true,
            imageResId = R.drawable.coworking_placeholder1
        ),
        CoworkingSpace(
            id = 2,
            name = "Creative Studio",
            description = "Comfortable space designed for designers, developers and small teams.",
            location = "Heredia, Costa Rica",
            capacity = 8,
            pricePerHour = 8500.0,
            isAvailable = true,
            imageResId = R.drawable.coworking_placeholder1
        ),
        CoworkingSpace(
            id = 3,
            name = "Business Room Plus",
            description = "Private meeting room for presentations, interviews and business sessions.",
            location = "Alajuela, Costa Rica",
            capacity = 6,
            pricePerHour = 12000.0,
            isAvailable = false,
            imageResId = R.drawable.coworking_placeholder1
        )
    )
}