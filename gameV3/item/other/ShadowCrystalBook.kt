package gameV3.item.other

import gameV3.entities.allies.summonable.ShadowCrystalSpiritAlly
import gameV3.item.Item
import gameV3.main.Game

class ShadowCrystalBook() : Item(name = "Книга о теневом кристалле", description = "Призови своего духа!") {
    override fun use(game: Game) {
        game.player.allies.add(ShadowCrystalSpiritAlly(level = game.player.level))
    }
}