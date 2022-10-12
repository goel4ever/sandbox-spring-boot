package com.ag.boot.app.room

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository: CrudRepository<Room, Long> {
}