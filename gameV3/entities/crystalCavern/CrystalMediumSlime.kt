package gameV3.entities.crystalCavern

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalMediumSlime(name: String = "Кристальный Средний Слайм", description: String = "Просто Слайм", health: Long = 250, attackPower: Long = 40, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun die(game: Game, room: Room) {
        super.die(game, room)
        repeat(2) {
            room.enemies.add(CrystalSmallSlime(level = this.level))
        }
    }
}