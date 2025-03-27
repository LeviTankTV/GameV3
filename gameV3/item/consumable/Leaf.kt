package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.main.Game

class Leaf() : Consumable(name = "Листик", description = "Листик") {
    override fun eat(game: Game) {
        game.player.health += 80
        println("Вы съели листик.")
    }
}