package gameV3.item.other

import gameV3.entities.allies.summonable.NinjaAntAlly
import gameV3.item.Item
import gameV3.main.Game

class NinjaEgg() : Item(name = "Яйцо призыв Ninja Ant", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(NinjaAntAlly(level = game.player.level))
        println("Вы вылупили Ninja Ant.")
    }
}