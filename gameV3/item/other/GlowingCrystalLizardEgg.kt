package gameV3.item.other

import gameV3.entities.allies.summonable.GlowingCrystalLizardAlly
import gameV3.item.Item
import gameV3.main.Game

class GlowingCrystalLizardEgg : Item(name = "Яйцо призыва Glowing Crystal Lizard", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(GlowingCrystalLizardAlly(level = game.player.level))
    }
}