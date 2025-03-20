package gameV3.item.eatable

import gameV3.item.Item
import gameV3.main.Game

class Raspberry(name: String = "Малина", description: String = "Вкусная малина") : Item(name, description) {
    fun eat(game: Game) {
        game.player.health += 20
        println("Вы съели малину.")
    }
}