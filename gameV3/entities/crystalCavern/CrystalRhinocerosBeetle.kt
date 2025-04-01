package gameV3.entities.crystalCavern

import gameV3.item.other.CrystalRhinocerosBeetleEgg
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalRhinocerosBeetle(name: String = "Кристальный Жук - Носорог", description: String = "Очень опасный жук", health: Long = 375, attackPower: Long = 80, defensePower: Long = 80, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        this.attack(null, target)
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(10) == 0) game.player.inventory.addItem(CrystalRhinocerosBeetleEgg())
    }
}