package gameV3.main

import gameV3.player.Player
import gameV3.room.Room
import gameV3.room.darkForest.DarkForestRoom
import gameV3.room.darkForest.DarkForestRoomGenerator
import java.util.*

class Game(private var player: Player) {
//    private var currentRoom: Room = DarkForestRoom("Лес Темноты", "Вы оказались в Лесу Темноты. Территория изменилась до неузнаваемости.")
    private var currentRoom: Room? = null
    private var previousRoom: Room? = null
    private var gameStage = 1;
    private var visitedRooms: LinkedList<Room> = LinkedList()

    fun generateDungeon() {

        val darkForestRoomGenerator = DarkForestRoomGenerator()

        val firstRoom: Room = when {
//            gameStage == 5 -> TrueCastleEntranceRoom() // Пример для пятой стадии
//            gameStage == 4 -> FourthGamePartRoom() // Пример для четвертой стадии
//            gameStage == 3 -> ThirdGamePartRoom() // Пример для третьей стадии
//            gameStage == 2 -> SecondGamePartRoom() // Пример для второй стадии
            else -> DarkForestRoom("Лес Темноты", "Вы оказались в Лесу Темноты. Территория изменилась до неузнаваемости.") // Первая стадия
        }

        visitedRooms.clear()
        visitedRooms.add(firstRoom)
        var previousRoom: Room = firstRoom

        for (i in 1..<600) {
            val newRoom: Room = when {
//                gameStage == 5 -> .generateRoom()
//                gameStage == 4 -> .generateRoom()
//                gameStage == 3 -> .generateRoom()
//                gameStage == 2 -> .generateRoom()
                else -> darkForestRoomGenerator.generateRoom()
            }

            visitedRooms.add(newRoom)
            previousRoom.nextRoom = newRoom
            newRoom.previousRoom = previousRoom
            previousRoom = newRoom
        }
        previousRoom.nextRoom = null
    }

    fun getPlayer(): Player {
        return player
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
            val input = readlnOrNull()
            handleInput(input)
        }
        if (!player.isAlive()) {
            println("Вы проиграли. Попробуйте еще раз.")
        }
    }


    private fun exitGame() {
        println("Спасибо за игру!")
    }


    private fun handleInput(input: String?) {
        when {
            input == "назад" -> goBack()
            input?.toIntOrNull() in 1..4 -> if (input != null) {
                changeRoom(input.toInt())
            }
            else -> println("Непонятная команда. Попробуйте снова.")
        }
    }

    private fun changeRoom(direction: Int) {
        previousRoom = currentRoom // Запоминаем предыдущую комнату
        currentRoom = (currentRoom as DarkForestRoom).getNextRoom(direction, this)
        println("Вы переместились в ${currentRoom?.name}!")
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

}