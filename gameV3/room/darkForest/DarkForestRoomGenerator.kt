package gameV3.room.darkForest

import gameV3.room.Room
import gameV3.room.RoomGenerator

class DarkForestRoomGenerator : RoomGenerator {
    override fun generateRoom(): Room {
        return DarkForestRoom("Лес Темноты", "Вы оказались в Лесу Темноты. Территория изменилась до неузнаваемости.")
    }
}
