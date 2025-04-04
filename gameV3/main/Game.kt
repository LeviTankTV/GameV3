package gameV3.main

import gameV3.player.Player
import gameV3.room.Room
import gameV3.room.antHell.AntHellEntrance
import gameV3.room.antHell.AntHellRoomGenerator
import gameV3.room.crimsonChimes.CrimsonChimesEntranceRoom
import gameV3.room.crimsonChimes.CrimsonChimesRoomGenerator
import gameV3.room.crystalCave.CrystalCaveEntrance
import gameV3.room.crystalCave.CrystalCavesRoomGenerator
import gameV3.room.darkForest.DarkForestMaze
import gameV3.room.darkForest.DarkForestRoom
import gameV3.room.darkForest.DarkForestRoomGenerator
import gameV3.room.darkForest.IntroCutscene
import java.util.*
import kotlin.system.exitProcess

class Game(var player: Player) {

    var currentRoom: Room? = null
    var previousRoom: Room? = null
    var gameStage = 0;
    var visitedRooms: LinkedList<Room> = LinkedList()
    private val roomManager = RoomManager()

    var usedAstralAdvice = false
    var darkForestRoomStepsCounter = 0
    var napCounter = 0
    var echoCounter = 0
    var escapedMindJail = false

    fun generateDungeon() {

        val darkForestRoomGenerator = DarkForestRoomGenerator()

        val firstRoom: Room = when {
//            gameStage == 5 -> TrueCastleEntranceRoom() // Пример для пятой стадии
//            gameStage == 4 -> FourthGamePartRoom() // Пример для четвертой стадии
            gameStage == 3 -> CrystalCaveEntrance() // Пример для третьей стадии
            gameStage == -1 -> AntHellEntrance()
            gameStage == 2 -> CrimsonChimesEntranceRoom() // Пример для второй стадии
            gameStage == 1 -> DarkForestRoom("Лес Темноты", "Вы оказались в Лесу Темноты. Территория изменилась до неузнаваемости.") // Первая стадия
            else -> IntroCutscene("Кат сцена начала игры", "...")
        }

        visitedRooms.clear()
        visitedRooms.add(firstRoom)
        roomManager.addRoom(firstRoom)

        var previousRoom: Room = firstRoom

        for (i in 1..<600) {
            val newRoom: Room = when {
//                gameStage == 5 -> .generateRoom()
//                gameStage == 4 -> .generateRoom()
                gameStage == 3 -> CrystalCavesRoomGenerator().generateRoom()
                gameStage == -1 -> AntHellRoomGenerator().generateRoom()
                gameStage == 2 && i == 15 -> AntHellEntrance()
                gameStage == 2 -> CrimsonChimesRoomGenerator().generateRoom()
                else -> darkForestRoomGenerator.generateRoom()
            }

            visitedRooms.add(newRoom)
            roomManager.addRoom(newRoom)
            previousRoom.nextRoom = newRoom
            newRoom.previousRoom = previousRoom
            previousRoom = newRoom
        }
        previousRoom.nextRoom = null
    }

    fun start() {
        val playername = player.name
        println("Время пришло. $playername выходит из замка и идет в темный лес.")
        gameLoop();
    }

    private fun gameLoop() {
        generateDungeon()
        currentRoom = visitedRooms[0]
        while(player.isAlive()) {
            currentRoom?.playerTurn(this, currentRoom!!)
        }
        if (!player.isAlive() || napCounter == 10 ) {
            println("Вы проиграли. Попробуйте еще раз.")
            exitProcess(0)
        }
    }

    fun gameTransition(newStage: Int) {
        // Очищаем списки комнат перед новой генерацией
        visitedRooms.clear()
        roomManager.clearRooms() // Предполагается, что в RoomManager есть метод для очистки

        gameStage = newStage
        generateDungeon() // Генерируем новые комнаты для новой стадии

        currentRoom = visitedRooms.firstOrNull() // Устанавливаем текущую комнату на первую сгенерированную
    }


    private fun exitGame() {
        println("Спасибо за игру!")
    }


    private fun goBack() {
        if (previousRoom != null) {
            currentRoom = previousRoom!!
            previousRoom = null // Сбрасываем предыдущую комнату
            println("Вы вернулись в ${currentRoom?.name}!")
        } else {
            println("Вы не можете вернуться, так как это первая комната.")
        }
    }

    fun moveForward() {
        val nextRoom = currentRoom?.nextRoom
//        nextRoom?.setEscaped(false) // Сбрасываем флаг escaped для новой комнаты
        if (nextRoom != null) {
            // Превращаем предыдущую комнату в NothingRoom
            previousRoom = currentRoom
            currentRoom = nextRoom
            println("Вы находитесь в " + currentRoom!!.javaClass.simpleName + ".")
        } else {
            println("Следующая комната недоступна.")
        }
    }

    fun moveBackward() {
        val previousRoom = currentRoom?.previousRoom
        if (previousRoom != null) {
            currentRoom = previousRoom
            println("Вы находитесь в " + currentRoom!!.javaClass.simpleName + ".")
        } else {
            println("Вы не можете вернуться назад.")
        }
    }

    fun getCurrentRoomIndex(): Int {
        return visitedRooms.indexOf(currentRoom)
    }
}