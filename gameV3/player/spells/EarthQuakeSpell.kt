package gameV3.player.spells

import gameV3.entities.Entity

class EarthQuakeSpell() : Spell(name = "Магия Земли") {
    fun cast(targets: List<Entity>) {
        for (target in targets) {
            target.health -= target.level * 5
            println("${target.name} получил урон в размере ${target.level * 5}!")
        }
    }
}