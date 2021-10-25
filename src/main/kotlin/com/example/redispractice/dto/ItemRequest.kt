package com.example.redispractice.dto

import com.example.redispractice.domain.Item
import java.util.*

data class ItemRequest(
    val name: String,
    val description: String
) {
    fun toEntity(): Item {
        return Item(
            id = UUID.randomUUID().toString(),
            name = this.name,
            description = this.description
        )
    }
}