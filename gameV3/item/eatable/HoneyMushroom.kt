package gameV3.item.eatable

import gameV3.item.Item
import gameV3.main.Game

class HoneyMushroom(name: String = "Медовый гриб", description: String = "Ароматный медовый гриб") : Item(name, description) {
    fun eat(game: Game) {
        game.player.health += 20
        println("Вы съели медовый гриб. Ваше здоровье увеличилось на 20.")
    }
}
