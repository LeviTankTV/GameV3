package gameV3.player

import gameV3.entities.Entity
import gameV3.entities.allies.Ally
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class Player(
    name: String,
    description: String = "Игрок",
    health: Int = 100,
    attackPower: Int = 10,
    defensePower: Int = 5,
    level: Int = 100,
    var experience: Int = 0,
    var gold: Int = 0
//    var inventory: Inventory,
//    var allies: List<Ally>
) : Entity(name, description, health, attackPower, defensePower, level) {
    var inventory = Inventory()
    var allies = listOf<Ally>()
    var astral = Astral()

    fun addXP(xp: Int) {
        experience += xp
        if (experience >= level * 100) {
            levelUp();
            println("$name повышает свой уровень!")
        }
    }

    fun increaseStats() {
        attackPower += 2;
        defensePower += 1;
        health += 20;
    }

    fun levelUp() {
        level++
        experience -= level * 100
        increaseStats()
    }

    override fun performAction(game: Game, room: Room) {
        val enemies = room.enemies
        val allies = this.allies
        when (game.gameStage) {
            1 -> {
                val phrases = mutableListOf(
                    "Сердце леса не ждёт.",
                    "Ваша судьба в ваших руках.",
                    "Время наступило.",
                    "Вы наполнены решимостью.",
                    "Атакуйте!",
                    "Вам не сбежать от судьбы."
                )
                val random = Random.nextInt(phrases.size)
                println(phrases[random] + " Выберете действие:")
                println("1. Атаковать")
                println("2. Попытаться сломать главный корень")
                println("3. Попытаться сломать побочный корень 1")
                println("4. Попытаться сломать побочный корень 2")
                println("5. Попытаться сломать побочный корень 3")
                println("6. Попытаться сломать побочный корень 4")
                println("7. Попытаться сломать побочный корень 5")
                var choice = readlnOrNull()?.toInt()
                when (choice) {
                    1 -> {
                        println("Вы атакуете ${enemies[0].name}, но понимаете, что грубая сила здесь не подходит.")
                    }
                }
            }

            2 -> {

            }

            3 -> {

            }

            4 -> {

            }

            5 -> {

            }
        }
    }
}