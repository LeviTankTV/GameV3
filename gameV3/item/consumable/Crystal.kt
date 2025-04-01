package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.main.Game

class Crystal() : Consumable(name = "Кристалл", description = "Вкусный кристалл") {
    override fun eat(game: Game) {
        game.player.health += 160
        println("Вы съели кристалл.")
    }
}