package gameV3.entities.bosses

import gameV3.entities.Entity
import gameV3.entities.EntityFactory
import gameV3.entities.antHell.QueenAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class AntHole(name: String = "Логово Муравьёв", description: String = "Финальный Босс", health: Long = 50000, attackPower: Long = 0, defensePower: Long = 0, level: Int = 1) : Entity(name, description, health, attackPower, defensePower, level) {
    private var lastSummonHealth: Long = health // Изначально здоровье для последнего вызова

    override fun performAction(game: Game, room: Room) {
        // Проверяем текущее здоровье
        if (health > 0) {
            val currentHealthPercentage = (health * 100) / 50000 // Предполагая, что 50000 - максимальное здоровье
            // Проверяем, нужно ли призывать
            if ((currentHealthPercentage % 2).toInt() == 0 && health < lastSummonHealth) {
                summon(game, room)
                lastSummonHealth = health // Обновляем здоровье для следующего вызова
            }
        } else {
            // Если здоровье 0, призываем 3 Queen Ant
            repeat(3) {
                room.enemies.add(QueenAnt(level = Random.nextInt(game.player.level) + Random.nextInt(-2,2))) // Предполагаем, что есть метод queenAntGenerator
            }
        }
    }

    private val factory = EntityFactory()

    private fun summon(game: Game, room: Room) {
        val random = Random.nextInt(3)
        repeat(random) {
            room.enemies.add(factory.antGenerator(game))
        }
    }

}
