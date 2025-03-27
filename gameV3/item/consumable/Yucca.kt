package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.main.Game

class Yucca() : Consumable(name = "Yucca", description = "Вкусный листик") {
    override fun eat(game: Game) {
        game.player.health += 80
        println("Вы съели листик.")
    }
}