package gameV3.item.eatable

import gameV3.item.Item
import gameV3.main.Game

class PorciniMushroom(name: String = "Белый гриб", description: String = "Вкусный белый гриб") : Item(name, description) {
    fun eat(game: Game) {
        game.player.health += 25
        println("Вы съели белый гриб. Ваше здоровье увеличилось на 25.")
    }
}
