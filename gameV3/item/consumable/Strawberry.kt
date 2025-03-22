package gameV3.item.consumable

import gameV3.item.Consumable
import gameV3.item.Item
import gameV3.main.Game

class Strawberry(name: String = "Клубника", description: String = "Сладкая и сочная клубника") : Consumable(name, description) {
    override fun eat(game: Game) {
        game.player.health += 15
        println("Вы съели клубнику. Ваше здоровье увеличилось на 15.")
    }
}
