package gameV3.room.crystalCave

import gameV3.entities.crystalCavern.Ghost
import gameV3.item.other.Hope
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class MindBreakingRoom : Room(name = "Мир реален?" , description = "Хоть что-то здесь реалльно?") {
    override fun playerTurn(game: Game, room: Room) {
        println("Вы продолжаете идти по пещере...")
        Thread.sleep(2000)
        println("Вы входите в комнату, полностью окутанную тьмой...")
        Thread.sleep(2000)
        println("Астрал: не нравится мне аура данной комнаты...")
        Thread.sleep(2000)
        println("Вход заваливает кристаллами, комната заполняется тьмой и газом, вам становится тяжело сконцентрироваться на чём-либо...")
        game.player.inventory.sneakyAddItem(Hope())
        Thread.sleep(2000)
        println("Вы видите призраков прошлого, которые кажутся вам знакомыми")
        Thread.sleep(2000)
        println("Они приближаются к вам...")
        Thread.sleep(2000)
        println("Вы не знаете, что делать, сражаться ли?")
        waitForEnter()
        repeat(7) {
            room.enemies.add(Ghost(name = "Призрак", level = game.player.level + Random.nextInt(-5, 5)))
        }
        while (!game.escapedMindJail) {
            for (enemy in room.enemies) {
                enemy.performAction(game, room)
                Thread.sleep(1000)
                println("Бой с призраками прошлого. Выберите действие:")
                println("1. Атаковать")
                println("2. Использовать заклинание")
                println("3. Использовать инвентарь")
                println("4. Посмотреть характеристику игрока")
                println("5. Посмотреть характеристику астрала")
                println("6. Посмотреть характеристику врагов")
                if (game.player.allies.isNotEmpty()) { println("7. Посмотреть характеристику союзников") }

                val input = readlnOrNull()?.toInt()
                when (input) {
                    1 -> {
                        println("Выберите призрака:")
                        for (i in room.enemies.indices) {
                            println("${i + 1}. ${room.enemies[i].name}")
                        }
                        val enemyIndex = readlnOrNull()?.toInt() ?: 1
                        val enemy = room.enemies[enemyIndex - 1]
                        println("Вы атакуете ${enemy.name}!")
                    }
                    2 -> println("Походу, магия здесь не поможет...")
                    3 -> {
                        println("Выберите предмет из инвентаря:")
                        for (item in game.player.inventory.items) {
                            println("${game.player.inventory.items.indexOf(item) + 1}. ${item.name}")
                        }
                        val itemIndex = readlnOrNull()?.toInt() ?: 1
                        val item = game.player.inventory.items[itemIndex - 1]
                        item.use(game)
                    }
                    4 -> game.player.showStats()
                    5 -> showAstralStats(game)
                    6 -> { for (enemy in room.enemies) { enemy.showStats() } }
                    7 -> showAlliesStats(game)
                }
            }
        }
        Thread.sleep(5000)
        println("Вы понимаете, что призраки были были не реальны...")
        println("Астрал: Сохраняй Решимость!")
        Thread.sleep(2000)
        handleEmptyRoom(game)
    }
}