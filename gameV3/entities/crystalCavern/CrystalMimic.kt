package gameV3.entities.crystalCavern

import gameV3.item.other.CrimsonPandoraBox
import gameV3.main.Game
import gameV3.player.spells.*
import gameV3.room.Room
import kotlin.random.Random

class CrystalMimic(name: String = "Кристальный Мимик", description: String = "Искусный Маг", health: Long, attackPower: Long, defensePower: Long, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val allies = room.enemies.filter {t -> t != this}
        val action = Random.nextInt(7)
        val target = targets[Random.nextInt(targets.size)]
        when (action) {
            0 -> ArcaneMissile().cast(target)
            1 -> for (allie in allies) HealSpell().cast(allie)
            2 -> BloodMagicSpell().cast(this, target)
            3 -> EarthQuakeSpell().cast(targets)
            4 -> FireballSpell().cast(target)
            5 -> IceSpikeSpell().cast(target)
            6 -> ShadowBolt().cast(target)
        }
    }

    override fun dropLoot(game: Game) {
        game.player.inventory.addItem(CrimsonPandoraBox())
    }
}