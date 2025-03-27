package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.main.Game

class Rice() : Consumable(name = "Рис", description = "Вкусный рис") {
    override fun use(game: Game) {
        game.player.health += 60
        println("Вы съели рис.")
    }
}