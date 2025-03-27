package gameV3.item.other

import gameV3.entities.allies.summonable.ColossalAntAlly
import gameV3.item.Item
import gameV3.main.Game

class ColossalEgg() : Item(name = "Яйцо призыва Colossal Ant", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(ColossalAntAlly(level = game.player.level))
        println("Вы вылупили Colossal Ant.")
    }
}