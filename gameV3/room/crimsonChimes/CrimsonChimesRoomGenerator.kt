package gameV3.room.crimsonChimes

import gameV3.room.Room
import gameV3.room.RoomGenerator
import kotlin.random.Random

class CrimsonChimesRoomGenerator : RoomGenerator {
    override fun generateRoom(): Room {
        val random = Random.nextInt(10)
        return when (random) {
            0 -> CrimsonChimesChestRoom()

            else -> CrimsonChimesChestRoom()
        }
    }
}
