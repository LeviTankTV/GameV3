package gameV3.item.other

import gameV3.item.Item
import gameV3.main.Game

class HealSpellBook() : Item(name = "Книга лечения", description = "Древняя книга лечения") {
    override fun use(game: Game) {
        game.player.health = game.player.maxHealth
        game.player.astral.health = game.player.astral.maxHealth
        for (ally in game.player.allies) {
            ally.health = ally.maxHealth
        }
        println("Вы восстановили здоровье всей группы.")
    }
}