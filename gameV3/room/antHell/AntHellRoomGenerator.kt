package gameV3.room.antHell

import gameV3.room.Room
import gameV3.room.RoomGenerator
import kotlin.random.Random

class AntHellRoomGenerator : RoomGenerator {
    override fun generateRoom(): Room {
        val random = Random.nextInt(100)

        return when {
            random <= 5 -> BombRoom()          // 6% (0-5)
            random <= 11 -> CelebrationRoom()   // 6% (6-11)
            random <= 17 -> DefenseRoom()        // 6% (12-17)
            random <= 23 -> FortificationRoom() // 6% (18-23)
            random <= 29 -> Granary()           // 6% (24-29)
            random <= 35 -> HealingRoom()         // 6% (30-35)
            random <= 41 -> HuntingChamber()    // 6% (36-41)
            random <= 51 -> TunnelChamber()     // 10% (42-51) -  Increased probability
            random <= 57 -> Nest()              // 6% (52-57)
            random <= 63 -> QueenChamber()      // 6% (58-63)
            random <= 69 -> RestingRoom()        // 6% (64-69)
            random <= 75 -> ScoutRoom()          // 6% (70-75)
            random <= 81 -> ToxicRoom()          // 6% (76-81)
            random <= 87 -> TrainingRoom()       // 6% (82-87)
            random <= 93 -> UndeadRoom()         // 6% (88-93)
            random <= 99 -> Workroom()          // 6% (94-99)
            else -> AntHoleRoom()           // 2% (always triggered by default with 0 value given the above implementation, this code will likely never trigger)
        }
    }

}
