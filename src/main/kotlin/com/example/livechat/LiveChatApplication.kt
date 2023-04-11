package com.example.livechat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LiveChatApplication

fun main(args: Array<String>) {
    runApplication<LiveChatApplication>(*args)
}
