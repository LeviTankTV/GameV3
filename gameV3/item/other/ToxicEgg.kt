package gameV3.item.other

import gameV3.entities.allies.summonable.ToxicAntAlly
import gameV3.item.Item
import gameV3.main.Game

class ToxicEgg() : Item(name = "Яйцо призыв Toxic Ant", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(ToxicAntAlly(level = game.player.level))
        println("Вы вылупили Toxic Ant.")
    }
}