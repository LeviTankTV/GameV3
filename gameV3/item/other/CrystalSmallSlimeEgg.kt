package gameV3.item.other

import gameV3.entities.allies.summonable.CrystalSmallSlimeAlly
import gameV3.item.Item
import gameV3.main.Game

class CrystalSmallSlimeEgg() : Item(name = "Яйцо призыва маленького слайма", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(CrystalSmallSlimeAlly(level = game.player.level))
    }
}