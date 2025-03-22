package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.item.Item
import gameV3.main.Game
import kotlin.random.Random

class CrimsonNestPotion: Consumable(name = "Багровое зелье", description = "Интересно...") {
    override fun eat(game: Game) {
        val luck = Random.nextInt(12)
        when (luck) {
            0 -> game.player.health += 50
            1 -> game.player.health += 100
            2 -> game.player.health += 150
            3 -> game.player.health -= 50
            4 -> game.player.health -= 100
            5 -> game.player.health -= 150
            6 -> game.player.health -= 200
            7 -> game.player.health -= 250
            8 -> game.player.health -= 300
            9 -> game.player.health += 200
            10 -> game.player.health += 250
            11 -> game.player.health += 300
        }
    }
}