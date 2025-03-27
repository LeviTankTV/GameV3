package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.main.Game

class Wing() : Consumable(name = "Крылышки", description = "Вкусные крылышки"){
    override fun eat(game: Game) {
        game.player.health += 100
        println("Вы съели крылышки.")
    }
}