package com.ag.boot.app.room

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController {
    @Autowired
    private lateinit var roomServices: RoomServices

    @GetMapping("/rooms")
    fun getAllRooms(model: Model): List<Room> {
        return roomServices.getAllRooms()
    }
}
