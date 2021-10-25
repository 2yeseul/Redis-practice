package com.example.redispractice.repository

import com.example.redispractice.domain.Item
import org.springframework.data.repository.CrudRepository

interface ItemRepository : CrudRepository<Item, Long>{
    fun findById(id: String): Item
}