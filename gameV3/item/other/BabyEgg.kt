package gameV3.item.other

import gameV3.entities.allies.summonable.BabyAntAlly
import gameV3.item.Item
import gameV3.main.Game

class BabyEgg() : Item(name = "Яйцо призыва Baby Ant", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(BabyAntAlly(level = game.player.level))
    }
}