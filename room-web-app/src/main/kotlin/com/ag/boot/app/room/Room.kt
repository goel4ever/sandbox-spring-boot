package com.ag.boot.app.room

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="room")
data class Room(
    @Id
    @Column(name="room_id")
    @GeneratedValue
    val id: Int,

    @Column(name="name", nullable = false)
    val name: String,

    @Column(name="room_number", nullable = false)
    val number: String,

    @Column(name="bed_info", nullable = false)
    val info: String
)
