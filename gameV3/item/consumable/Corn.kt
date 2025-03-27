package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.main.Game

class Corn() : Consumable(name = "Кукуруза", description = "Вкусная кукуруза") {
    override fun eat(game: Game) {
        game.player.health += 160
        println("Вы съели кукурузу.")
    }
}