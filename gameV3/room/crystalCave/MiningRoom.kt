package gameV3.room.crystalCave

import gameV3.item.consumable.Crystal
import gameV3.item.other.Diamond
import gameV3.item.other.Emerald
import gameV3.item.other.GoldBar
import gameV3.item.other.IronBar
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class MiningRoom: Room(name = "Шахта", description = "Вы оказались в сверкающей пещере, наполненной кристаллами.") {
    override fun playerTurn(game: Game, room: Room) {
        mine(game)
        handleEmptyRoom(game)
    }

    private fun mine(game: Game) {
        println("Вы в шахте. Вы можете попытаться добыть кристаллы.")
        println("1. Добыть")
        println("2. Уйти")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
             if (Random.nextInt(100) < 40) {
                 println("Вы добыли один из кристаллов!")
                 val rand = Random.nextInt(5)
                 when (rand) {
                     0 -> game.player.inventory.addItem(Crystal())
                     1 -> game.player.inventory.addItem(IronBar())
                     2 -> game.player.inventory.addItem(GoldBar())
                     3 -> game.player.inventory.addItem(Diamond())
                     4 -> game.player.inventory.addItem(Emerald())
                 }
             }
            }
            2 -> return
            else -> println("Неверный выбор.")
        }
    }

}