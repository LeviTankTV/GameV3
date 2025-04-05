package gameV3.main

import gameV3.room.Room

class RoomManager {
    private val visitedRooms: MutableList<Room> = mutableListOf()

    fun addRoom(room: Room) {
        visitedRooms.add(room)
    }

    fun clearRooms() {
        visitedRooms.clear()
    }
}