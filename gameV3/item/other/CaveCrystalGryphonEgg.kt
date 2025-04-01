package gameV3.item.other

import gameV3.entities.allies.summonable.CaveCrystalGryphonAlly
import gameV3.item.Item
import gameV3.main.Game
import kotlin.random.Random

class CaveCrystalGryphonEgg: Item(name = "Яйцо грифона", description = "Из этого может вылупиться что-то интересное...") {
    override fun use(game: Game) {
        game.player.allies.add(CaveCrystalGryphonAlly(level = game.player.level + Random.nextInt(-2,2)))
    }
}