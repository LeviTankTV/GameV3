package gameV3.item.other

import gameV3.entities.allies.summonable.SlidingCrystalWormAlly
import gameV3.item.Item
import gameV3.main.Game
import kotlin.random.Random

class SlidingCrystalWormEgg: Item(name = "Скользящее кристалловое яицо", description = "Скользящее кристалловое яицо") {
    override fun use(game: Game) {
        game.player.allies.add(SlidingCrystalWormAlly(level = game.player.level + Random.nextInt(-2,2)))
    }
}