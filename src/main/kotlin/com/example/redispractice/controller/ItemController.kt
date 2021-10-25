package com.example.redispractice.controller

import com.example.redispractice.domain.Item
import com.example.redispractice.dto.ItemRequest
import com.example.redispractice.repository.ItemRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/items")
class ItemController(
    private val itemRepository: ItemRepository
) {
    @PostMapping
    fun save(@RequestBody itemRequest: ItemRequest): Item {
        val item = itemRequest.toEntity()
        return itemRepository.save(item)
    }

    @GetMapping
    fun get(@RequestParam id: String): Item? {
        return itemRepository.findById(id)
    }

    @GetMapping("/all")
    fun getAll(): MutableIterable<Item> {
        return itemRepository.findAll()
    }
}