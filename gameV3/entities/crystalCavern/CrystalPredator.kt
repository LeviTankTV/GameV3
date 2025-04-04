package gameV3.entities.crystalCavern

import gameV3.item.other.*
import gameV3.item.weapon.swords.CrystalSword
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrystalPredator(name: String = "Кристальный Хищник", description: String = "Очень опасный хищник", health: Long = 750, attackPower: Long = 99, defensePower: Long = 56, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        val target2 = targets[Random.nextInt(targets.size)]
        this.attack(CrystalSword(), target)
        this.attack(CrystalSword(), target2)
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        if (Random.nextInt(15) == 0) {
            game.player.inventory.addItem(CrystalSword())
        }
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(ShadowCrystalBook())
        }
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(CrystalSmallSlimeEgg())
        }
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(SlidingCrystalWormEgg())
        }
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(CaveCrystalGryphonEgg())
        }
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(GlowingCrystalLizardEgg())
        }
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(CrystalManticoreEgg())
        }
        if (Random.nextInt(10) == 0) {
            game.player.inventory.addItem(CrystalRhinocerosBeetleEgg())
        }
    }
}