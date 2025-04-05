package gameV3.item.other

import gameV3.item.Item
import gameV3.main.Game

class Hope: Item(name = "Надежда", description = "Путь к избавлению от тьмы") {
    override fun use(game: Game) {
        game.escapedMindJail = true
        println("Вы избавились от тьмы внутри вас!")
    }
}