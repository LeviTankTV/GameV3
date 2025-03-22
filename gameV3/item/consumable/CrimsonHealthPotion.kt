package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.item.Item
import gameV3.main.Game
import kotlin.random.Random

class CrimsonHealthPotion: Consumable(name = "Малиновое зелье здоровья", description = "Интересно...") {

    override fun eat(game: Game) {
        val luck = Random.nextInt(4)
        when (luck) {
            0 -> game.player.health += 50
            1 -> game.player.health += 100
            2 -> game.player.health += 150
        }
    }

}