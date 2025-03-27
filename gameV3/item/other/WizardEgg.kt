package gameV3.item.other

import gameV3.entities.allies.summonable.ToxicAntAlly
import gameV3.entities.allies.summonable.WizardAntAlly
import gameV3.item.Item
import gameV3.main.Game

class WizardEgg() : Item(name = "Яйцо призыв Wizard Ant", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(WizardAntAlly(level = game.player.level))
        println("Вы вылупили Wizard Ant.")
    }
}