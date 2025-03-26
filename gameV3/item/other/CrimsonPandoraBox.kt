package gameV3.item.other

import gameV3.item.Item
import gameV3.item.consumable.CrimsonHealthPotion
import gameV3.item.consumable.CrimsonNestPotion
import gameV3.item.consumable.InvisibilityPotion
import gameV3.item.talisman.CrimsonTalisman
import gameV3.main.Game
import kotlin.random.Random

class CrimsonPandoraBox: Item("Малиновый ящик пандоры", "Интересно...") {

    override fun use(game: Game) {
        val dropNumber = Random.nextInt(8)
        when (dropNumber) {
            0 -> game.player.inventory.addItem(CrimsonHealthPotion())
            1 -> game.player.inventory.addItem(InvisibilityPotion())
            2 -> game.player.inventory.addItem(CrimsonPandoraBox())
            3 -> game.player.health /= 2
            4 -> game.player.astral.health /= 2
            5 -> if (Random.nextInt(2) == 0) game.player.astral.health += 100 else game.player.health += 100
            6 -> if (Random.nextInt(5) == 0) game.player.inventory.addItem(CrimsonTalisman())
            7 -> game.player.inventory.addItem(CrimsonNestPotion())
        }
    }
}