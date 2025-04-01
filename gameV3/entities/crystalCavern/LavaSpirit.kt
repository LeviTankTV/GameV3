package gameV3.entities.crystalCavern

import gameV3.effects.BurningEffect
import gameV3.item.throwable.LavaDagger
import gameV3.item.weapon.swords.LavaSword
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class LavaSpirit(name: String = "Дух лавы", description: String = "Очень опасный дух", health: Long = 475, attackPower: Long = 0, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        target.addEffect(BurningEffect(2, 120))
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(15) == 0) {
            game.player.inventory.addItem(LavaSword())
        }
        if (Random.nextInt(15) == 0) {
            game.player.inventory.addItem(LavaDagger())
        }
    }
}