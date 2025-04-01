package gameV3.player.spells

import gameV3.entities.Entity

class IceSpikeSpell() : Spell(name = "Магия Льда") {
    override fun cast(target: Entity) {
        target.health -= target.level * 25
        println("${target.name} получил ледяной урон в размере ${target.level * 20}!")
    }
}