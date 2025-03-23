package gameV3.item.talisman

import gameV3.item.Item
import gameV3.main.Game

class CrimsonTalisman: Item("Малиновый талисман", "Даёт вам силу малины") {

    fun equip (game: Game) {
        game.player.maxHealth += 200
        game.player.incomeDamageIncreasePercentage += 0.5
    }

    fun unequip (game: Game) {
        game.player.maxHealth -= 200
        game.player.incomeDamageIncreasePercentage -= 0.5
    }

}