package gameV3.item.eatable

import gameV3.item.Item
import gameV3.main.Game

class Chanterelles(name: String = "Лисички", description: String = "Сочные лисички") : Item(name, description) {
    fun eat(game: Game) {
        game.player.health += 18
        println("Вы съели лисички. Ваше здоровье увеличилось на 18.")
    }
}