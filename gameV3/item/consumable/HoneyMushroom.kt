package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.item.Item
import gameV3.main.Game

class HoneyMushroom(name: String = "Медовый гриб", description: String = "Ароматный медовый гриб") : Consumable(name, description) {
    override fun eat(game: Game) {
        game.player.health += 20
        println("Вы съели медовый гриб. Ваше здоровье увеличилось на 20.")
    }
}
