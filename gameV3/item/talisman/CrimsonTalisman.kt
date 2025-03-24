package gameV3.item.talisman

import gameV3.item.Item
import gameV3.item.Talisman
import gameV3.main.Game

class CrimsonTalisman: Talisman("Малиновый талисман", "Даёт вам силу малины") {

    override fun equip (game: Game) {
        game.player.maxHealth += 200
        game.player.incomeDamageIncreasePercentage += 0.5
    }

    override fun unequip (game: Game) {
        game.player.maxHealth -= 200
        game.player.incomeDamageIncreasePercentage -= 0.5
    }

}