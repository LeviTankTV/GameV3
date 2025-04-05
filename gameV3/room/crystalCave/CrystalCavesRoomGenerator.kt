package gameV3.room.crystalCave

import gameV3.room.Room
import gameV3.room.RoomGenerator
import kotlin.random.Random

class CrystalCavesRoomGenerator : RoomGenerator {
    override fun generateRoom(): Room {
        // Генерируем случайное число от 1 до 100
        val randomValue = Random.nextInt(1, 101)

        return if (randomValue <= 2) {
            // 2% шанс на ShinyRoom
            ShinyRoom()
        } else {
            // 98% шанс на одну из остальных комнат
            generateRandomRoom()
        }
    }

    private fun generateRandomRoom(): Room {
        val rooms = listOf(
            WormRoom(),
            Tunnel(),
            SpiritRoom(),
            RitualRoom(),
            MysteriousTrader(),
            MiningRoom(),
            MimicRoom(),
            LavaLake(),
            ElementRoom(),
            EchoFlowersRoom(),
            DragonNest(),
            DarkRoom(),
            AnimalRoom()
        )

        // Выбираем случайную комнату из списка
        return rooms.random()
    }
}