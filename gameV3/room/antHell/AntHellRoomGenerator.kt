package gameV3.room.antHell

import gameV3.room.Room
import gameV3.room.RoomGenerator

class AntHellRoomGenerator : RoomGenerator {
    override fun generateRoom(): Room {
        val rooms = listOf(

        )
        return DarkForestRoom("Лес Темноты", "Вы оказались в Лесу Темноты. Территория изменилась до неузнаваемости.")
    }
}
