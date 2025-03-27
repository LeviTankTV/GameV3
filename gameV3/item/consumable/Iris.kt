package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.main.Game

class Iris() : Consumable(name = "Ириска", description = "Сладкая ириска") {
    override fun eat(game: Game) {
        game.player.health += 160
        println("Вы съели ириску.")
    }
}