package gameV3.item.other

import gameV3.entities.allies.summonable.SoldierAntAlly
import gameV3.item.Item
import gameV3.main.Game

class SoldierEgg() : Item(name = "Яйцо призыва Soldier Ant", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(SoldierAntAlly(level = game.player.level))
        println("Вы вылупили Soldier Ant.")
    }
}