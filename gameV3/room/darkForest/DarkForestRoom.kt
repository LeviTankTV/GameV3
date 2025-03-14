package gameV3.room.darkForest

import gameV3.entities.CreatureFactory
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class DarkForestRoom(name: String, description: String) : Room(name, description) {
    private val creatureFactory = CreatureFactory();

    override fun playerTurn(game: Game, room: Room) {
        // Генерация случайного числа от 1 до 10
        val eventTrigger = Random.nextInt(1, 11)

        if (eventTrigger <= 3) { // 30% шанс на событие
            triggerEvent("Вы наткнулись на таинственное существо!", game)
        } else {
            handleEmptyRoom(game) // Обработка пустой комнаты
        }
    }

    fun getNextRoom(direction: Int, game: Game): Room {
        // Генерация случайного числа от 1 до 10
        val eventTrigger = Random.nextInt(1, 11)

        return when (direction) {
            1 -> {
                if (eventTrigger <= 3) { // 30% шанс на событие
                    triggerEvent("Вы наткнулись на таинственное существо!", game)
                    this // Возвращаем ту же комнату
                } else {
                    DarkForestRoom("Северная комната", "Вы идете на север и видите темный лес.")
                }
            }
            2 -> {
                if (eventTrigger <= 3) {
                    triggerEvent("Вы видете что-то вдалеке!", game)
                    this
                } else {
                    DarkForestRoom("Южная комната", "Вы идете на юг и слышите странные звуки.")
                }
            }
            3 -> {
                if (eventTrigger <= 3) {
                    triggerEvent("Вы увидели монстров вдалеке, но победили их одним ударом!", game)
                    this
                } else {
                    DarkForestRoom("Восточная комната", "Вы идете на восток и находите старую тропу.")
                }
            }
            4 -> {
                if (eventTrigger <= 3) {
                    triggerEvent("Вы увидели плакат вдалеке!", game)
                    this
                } else {
                    DarkForestRoom("Западная комната", "Вы идете на запад и видите свет вдалеке.")
                }
            }
            else -> this
        }
    }

    private fun triggerEvent(eventMessage: String, game: Game) {
        println(eventMessage)
        if (eventMessage == "Вы наткнулись на таинственное существо!") {
            // val randomCreature = creatureFactory.getRandomDarkForestCreature(game);

        }
        // Здесь вы можете добавить логику для обработки события, например, сражение или получение предмета
    }
}