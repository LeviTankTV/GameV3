package gameV3.item.other

import gameV3.entities.allies.summonable.InvisibleAntAlly
import gameV3.item.Item
import gameV3.main.Game

class InvisibleEgg() : Item(name = "Яйцо призыва Invisible Ant", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(InvisibleAntAlly(level = game.player.level))
        println("Вы вылупили Invisible Ant.")
    }
}