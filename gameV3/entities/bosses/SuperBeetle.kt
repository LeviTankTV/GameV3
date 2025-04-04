package gameV3.entities.bosses

import gameV3.entities.EntityFactory
import gameV3.entities.crimsonChimes.CrimsonChimesMob
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class SuperBeetle(name : String = "Супер Жук", description : String = "Просто жук", health : Long = 3333, attackPower : Long = 100, defensePower : Long = 50, level : Int): CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]

        val originalEnemies = room.enemies.toMutableList() // Копируем список, чтобы не изменять оригинал
        originalEnemies.remove(this) // Удаляем себя из копии

        val randomAlly = if (originalEnemies.isNotEmpty()) {
            originalEnemies[Random.nextInt(originalEnemies.size)]
        } else {
            null // Or a default ally if appropriate.  Consider using an `Optional` if null is unexpected.
        }

        val action = Random.nextInt(4)

        when (action) {
            0 -> {
                for (target in targets) {
                    this.attack(null, target)
                }
            }
            1 -> {
                if (randomAlly != null) {
                    room.enemies.remove(randomAlly)
                    this.health += randomAlly.health * 2
                    println("Супер жук поглотил ${randomAlly.name}.")
                } else {
                    println("Супер жук не может поглотить никого.")
                }
            }
            2 -> {
                summonBeetles(game, room)
                println("Супер жук наполнил поле жуками.")
            }
            3 -> {
                this.attack(null, target)
                this.attack(null, target)
                this.attack(null, target)
                println("Супер жук нанес 3 удара.")
            }
        }

    }

    private val factory = EntityFactory()

    private fun summonBeetles(game: Game, room: Room) {
        val rand = Random.nextInt(1, 3)
        repeat(rand) {
            val beetle = factory.beetleGenerator(game)
            room.enemies.add(beetle)
        }
    }

    override fun dropLoot(game: Game) {
        val gold = Random.nextInt(750)
        game.player.gold += gold
        println("Вы получили $gold золота.")
    }
}