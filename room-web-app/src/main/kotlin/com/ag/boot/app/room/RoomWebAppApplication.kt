package com.ag.boot.app.room

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RoomWebAppApplication

fun main(args: Array<String>) {
	runApplication<RoomWebAppApplication>(*args)
	println("hellos")
}
