# 1. Configuration 
## application.properties
``` properties
# Redis
spring.redis.host=127.0.0.1
spring.redis.port=6379
``` 
## RedisConfig
```kotlin
@Configuration
@EnableRedisHttpSession
@EnableRedisRepositories
class RedisConfig(
    @Value("\${spring.redis.host}")
    private val redisHost: String,
    @Value("\${spring.redis.port}")
    private val redisPort: Int
) {
    @Bean
    fun redisConnectionFactory() = LettuceConnectionFactory(redisHost, redisPort)

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any> {
        return RedisTemplate<String, Any>().apply {
            setConnectionFactory(redisConnectionFactory())
            keySerializer = StringRedisSerializer()
        }
    }
}
``` 
# Domain
``` kotlin
@RedisHash("item")
data class Item(
    @Id
    val id: String,
    val name: String,
    val description: String
)
``` 
# Controller
``` kotlin
    @PostMapping("/users")
    fun save(@RequestBody itemRequest: ItemRequest): Item {
        val item = itemRequest.toEntity()
        return itemRepository.save(item)
    }
```

