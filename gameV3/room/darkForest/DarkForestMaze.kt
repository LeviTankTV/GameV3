package gameV3.room.darkForest

import gameV3.item.Factories
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random
import kotlin.system.exitProcess

class DarkForestMaze(name: String, description: String) : Room(name, description) {
    private var movementSequence = mutableListOf<String>()
    private val correctSequence =
        listOf("вправо", "вперед", "вперед", "вперед", "влево", "вперед", "вперед", "вправо", "вправо", "вправо")
    private val Factories = Factories()

    override fun playerTurn(game: Game, room: Room) {
        while (!checkMovementSequence(game)) {
            println("Вы находитесь в комнате: $name. Что вы хотите сделать?")
            println("1. Идти вперед")
            println("2. Идти назад")
            println("3. Идти вправо")
            println("4. Идти влево")

            val choice = readlnOrNull()?.toIntOrNull()

            when (choice) {
                1 -> moveForward(game)
                2 -> moveBackward(game)
                3 -> moveRight(game)
                4 -> moveLeft(game)
                else -> println("Неверный выбор. Попробуйте снова.")
            }
        }

        // Когда последовательность правильная, можно выполнить какое-то действие
        println("Поздравляем! Вы собрали правильную последовательность движений!")
        waitOrChill(game)
        game.currentRoom = DarkForestBossFightRoom("Сердце Леса", "Вы находитесь в сердце Леса. Вам нужно убить босса.")
    }

    private fun waitOrChill(game: Game) {
        println("Вы видите вход в какую-то комнату в центре леса.")
        println("1. Продолжить приключение и зайти в комнату.")
        println("2. Остановиться и отдохнуть.")
        val choice = readlnOrNull()?.toIntOrNull()
        if (choice == 2) {
            game.napCounter++
            if (game.napCounter == 10) {
                game.player.health = 0
                println("Вы уснули и вас съели монстры.")
                exitProcess(0)
            }
            waitOrChill(game)
        }
    }

    private fun moveForward(game: Game) {
        validateAndAddMovement("вперед", game)
    }

    private fun moveBackward(game: Game) {
        validateAndAddMovement("назад", game)
    }

    private fun moveRight(game: Game) {
        validateAndAddMovement("вправо", game)
    }

    private fun moveLeft(game: Game) {
        validateAndAddMovement("влево", game)
    }

    private fun validateAndAddMovement(direction: String, game: Game) {
        // Проверяем, соответствует ли текущее движение правильной последовательности
        if (movementSequence.size < correctSequence.size && direction == correctSequence[movementSequence.size]) {
            movementSequence.add(direction)
            handleMovement(game)
        } else {
            println("Вы понимаете, что идёте куда-то не туда.")
            movementSequence.clear() // Сбрасываем последовательность
        }
    }

    private fun handleMovement(game: Game) {
        // Генерация случайного числа от 1 до 10 для события
        val eventTrigger = Random.nextInt(1, 11)

        // Генерация события
        if (eventTrigger <= 3) {
            triggerEvent("Вы нашли немного денег.", game)
        }
        if (eventTrigger in 4..6) {
            triggerEvent("Вы угодили в ловушку!", game)
        }
        if (eventTrigger == 7) {
            triggerEvent("Вы нашли случайный предмет.", game)
        }
    }

    private fun checkMovementSequence(game: Game): Boolean {
        // Проверка на правильность последовательности
        return movementSequence == correctSequence
    }

    private fun triggerEvent(eventMessage: String, game: Game) {
        when (eventMessage) {
            "Вы нашли немного денег." -> {
                game.player.gold += 10
                println("Вы нашли 10 золота! Теперь у вас ${game.player.gold} золота.")
            }
            "Вы угодили в ловушку!" -> {
                game.player.health -= 20
                println("Вы угодили в ловушку! Ваше здоровье уменьшено на 20.")
            }
            "Вы нашли случайный предмет." -> {
                val randomItem = Factories.darkForestMazeItemGenerator()
                game.player.inventory.addItem(randomItem)
                println("Вы нашли ${randomItem.name}!")
            }
            else -> {

            }
        }
    }
}