package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.entities.EntityFactory
import gameV3.item.consumable.Corn
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class AlarmAnt(name: String = "Муравей с мигалкой", description: String = "Опаснейший из них.", health: Long = 1, attackPower: Long = 1, defensePower: Long = 0, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        alarmTurns++
        if (alarmTurns == maxAlarmTurns) {
            this.health = 0
            summon(game, room)
        }
    }

    private var factory = EntityFactory()

    private var alarmTurns: Int = 0
    private val maxAlarmTurns: Int = 3
    private fun summon(game: Game, room: Room) {
        val random = Random.nextInt(7)
        repeat(random) {
            room.enemies.add(factory.antGenerator(game))
        }
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        val random = Random.nextInt(10)
        if (random == 0) {
            game.player.inventory.addItem(Corn())
            println("Вы получили Кукурузу.")
        }
    }

}
