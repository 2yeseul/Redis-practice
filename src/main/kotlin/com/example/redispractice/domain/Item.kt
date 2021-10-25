package com.example.redispractice.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("item")
data class Item(
    @Id
    val id: String,
    val name: String,
    val description: String
)