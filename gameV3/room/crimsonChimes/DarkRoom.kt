package gameV3.room.crimsonChimes

import gameV3.entities.bosses.BerryOverlord
import gameV3.entities.crimsonChimes.CrimsonWraith
import gameV3.item.keys.AncientKey
import gameV3.main.Game
import gameV3.player.Inventory
import gameV3.room.Room
import kotlin.random.Random

class DarkRoom() : Room(name = "Темная комната", description = "Вы находитесь в темной комнате") {
    override fun playerTurn(game: Game, room: Room) {
        println("\nВы находитесь в темной комнате.")
        println("Вы видите запертую дверь")

        if (!game.player.inventory.hasAncientKey()) {
            println("Вам нужен древний ключ, чтобы открыть дверь.")
            handleEmptyRoom(game)
        } else {
            println("Вы можете открыть дверь. Хотите это сделать? (да/нет)")
            val input = readlnOrNull()
            if (input == "да") {
                removeAncientKeyFromInventory(game.player.inventory)
                println("Вы открыли дверь и видите ягодного лорда.")
                Thread.sleep(2000)
                println("Время битвы!")
                waitForEnter()
                this.enemies.add(BerryOverlord(level = game.player.level + Random.nextInt(-2, 2)))
                this.enemies.add(CrimsonWraith(level = game.player.level + Random.nextInt(-2, 2)))
                this.enemies.add(CrimsonWraith(level = game.player.level + Random.nextInt(-2, 2)))
                handleCombat(game, room)
                if (!hasEnemies()) {
                    println("Вы победили ягодного лорда и видите впереди кристальную пещеру.")
                    Thread.sleep(2000)
                    println("Вы отправляетесь в новую часть вашего путешествия.")
                    waitForEnter()
                    // Переход к следующему этапу
                    game.gameTransition(3)
                }
            }
        }
    }

    fun removeAncientKeyFromInventory(inventory: Inventory) {
        // Ищем ключ в инвентаре
        val ancientKey = inventory.items.find { it is AncientKey }
        if (ancientKey != null) {
            inventory.removeItem(ancientKey) // Удаляем ключ из инвентаря
        } else {
            println("У вас нет Древнего Ключа в инвентаре.")
        }
    }
}