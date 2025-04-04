package gameV3.entities.crystalCavern

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class GlowingCrystalSpirit(name: String = "Сияющий Кристальный Дух", description: String = "Светящийся дух", health: Long = 425, attackPower: Long = 50, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        val random = Random
        game.player.gold += Random.nextInt(150)
    }
}