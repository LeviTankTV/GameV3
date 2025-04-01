package gameV3.player.spells

import gameV3.entities.Entity
import kotlin.random.Random

class ShadowBolt() : Spell(name = "Темная стрела") {
    override fun cast(target: Entity) {
        val random = Random.nextInt(3)
        when (random) {
            0 -> { target.health -= target.level * 10
            println("${target.name} получил урон в размере ${target.level * 10}!") }
            1 -> { target.health -= target.level * 20
            println("${target.name} получил урон в размере ${target.level * 20}!") }
            2 -> { target.health -= target.level * 30
            println("${target.name} получил урон в размере ${target.level * 30}!") }
        }
    }
}