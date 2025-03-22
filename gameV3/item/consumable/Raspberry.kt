package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.item.Item
import gameV3.main.Game

class Raspberry(name: String = "Малина", description: String = "Вкусная малина") : Consumable(name, description) {
    override fun eat(game: Game) {
        game.player.health += 20
        println("Вы съели малину.")
    }
}