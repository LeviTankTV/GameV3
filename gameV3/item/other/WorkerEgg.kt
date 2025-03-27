package gameV3.item.other

import gameV3.entities.allies.summonable.WorkerAntAlly
import gameV3.item.Item
import gameV3.main.Game

class WorkerEgg() : Item(name = "Яйцо призыв Worker Ant", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(WorkerAntAlly(level = game.player.level))
        println("Вы вылупили Worker Ant.")
    }
}