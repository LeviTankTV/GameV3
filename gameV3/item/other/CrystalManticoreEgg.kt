package gameV3.item.other

import gameV3.entities.allies.summonable.CrystalManticoreAlly
import gameV3.item.Item
import gameV3.main.Game
import kotlin.random.Random

class CrystalManticoreEgg() : Item(name = "Яйцо призыва Crystal Manticore", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(CrystalManticoreAlly(level = game.player.level + Random.nextInt(-2,2)))
    }
}