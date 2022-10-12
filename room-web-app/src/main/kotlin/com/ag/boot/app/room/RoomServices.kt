package com.ag.boot.app.room

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

//val r = 1..10
//private val rooms = r.map { Room(it, "Room$it", "R$it", "Q") }

@Service
class RoomServices {

    @Autowired
    private lateinit var roomRepository: RoomRepository

    fun getAllRooms(): List<Room> {
        val rooms = mutableListOf<Room>()
        roomRepository.findAll().forEach(rooms::add)
        return rooms
    }
}
