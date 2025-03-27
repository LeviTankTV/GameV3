package gameV3.item.other

import gameV3.entities.allies.summonable.DemolitionAntAlly
import gameV3.item.Item
import gameV3.main.Game

class DemoEgg() : Item(name = "Яйцо призыв Demolition Ant", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(DemolitionAntAlly(level = game.player.level))
        println("Вы вылупили Demolition Ant.")
    }
}