package gameV3.room.crimsonChimes

import gameV3.room.Room
import gameV3.room.RoomGenerator
import kotlin.random.Random
import kotlin.system.exitProcess

class CrimsonChimesRoomGenerator : RoomGenerator {
    override fun generateRoom(): Room {
        val random = Random.nextInt(10)
        return when (random) {
            0 -> CrimsonChimesChestRoom()
            1 -> SuperBeetleField()
            2 -> CrimsonWitchHouse()
            3 -> CrimsonMarketplace()
            4 -> CrimsonFieldThree()
            5 -> CrimsonHealthFountain()
            6 -> CrimsonFieldOne()
            7 -> CrimsonFieldTwo()
            8 -> BeetleField()
            9 -> DarkRoom()

            else -> exitProcess(1)
        }
    }
}
