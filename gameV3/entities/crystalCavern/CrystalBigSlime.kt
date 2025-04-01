package gameV3.entities.crystalCavern

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalBigSlime(name: String = "Большой Кристальный Слайм", description: String = "Просто слайм", health: Long = 500, attackPower: Long = 80, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun die(game: Game, room: Room) {
        super.die(game, room)
        repeat(2) {
            room.enemies.add(CrystalMediumSlime(level = this.level))
        }
    }

}