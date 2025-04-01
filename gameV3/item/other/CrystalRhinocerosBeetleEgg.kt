package gameV3.item.other

import gameV3.entities.allies.summonable.CrystalRhinocerosBeetleAlly
import gameV3.item.Item
import gameV3.main.Game
import kotlin.random.Random

class CrystalRhinocerosBeetleEgg: Item(name = "Яйцо призыва Crystal Rhinoceros Beetle", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(CrystalRhinocerosBeetleAlly(level = game.player.level + Random.nextInt(-2,2)))
    }
}