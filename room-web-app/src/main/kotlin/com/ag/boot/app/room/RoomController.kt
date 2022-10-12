package com.ag.boot.app.room

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/rooms")
class RoomController {
    @Autowired
    private lateinit var roomServices: RoomServices

    @GetMapping
    fun getAllRooms(model: Model): String {
        model.addAttribute("rooms", roomServices.getAllRooms())
        return "rooms"
    }
}
