package gameV3.room

import gameV3.entities.Entity
import gameV3.item.Factories
import gameV3.main.Game
import gameV3.room.crimsonChimes.CrimsonChimesChestRoom
import kotlin.random.Random

abstract class Room(val name: String, val description: String) {
    var enemies: MutableList<Entity> = mutableListOf();
    var previousRoom: Room? = null
    var nextRoom: Room? = null

    private val itemFactory: Factories = Factories()

    abstract fun playerTurn(game: Game, room: Room)

    fun hasEnemies(): Boolean {
        return enemies.isNotEmpty()
    }

    fun clearEnemies() {
        enemies.clear()
    }

    private var tsce = 0

    fun handleCombat(game: Game, room: Room) {
                while (game.player.isAlive() && game.player.astral.isAlive() && room.hasEnemies()) {
                    game.player.updateEffects(game)
                    game.player.astral.updateEffects(game)

                    // Special Events

                    if (game.gameStage == 3) {
                        game.player.mana += 10
                        tsce++
                        if (tsce == 2) {
                            thirdStageSpecialEvent(game)
                            tsce = 0
                        }
                    }

                    if (!game.player.isAlive() || !game.player.astral.isAlive()) {
                        handlePlayerDeath(game)
                    }

                    // Обновляем эффекты союзников
                    if (game.player.allies.isNotEmpty()) {
                        for (ally in game.player.allies) {
                            ally.updateEffects(game)
                        }
                    }

                    var playerActionCompleted = false
                    while (!playerActionCompleted) {
                        playerActionCompleted = game.player.playerAction(game, room)
                    }

                    for (ally in game.player.allies) {
                        if (!ally.isAlive()) {
                            game.player.removeAlly(ally)
                        }
                    }

                    // Игрок выполняет свои действия
                    game.player.astral.performAction(game, room)


                    // Действия союзников
                    if (game.player.allies.isNotEmpty()) {
                        for (ally in game.player.allies) {
                            ally.performAction(game, room)
                        }
                    }

                    println("Ход игрока окончен.")
                    waitForEnter()
                    println("Ход противников:")

                    // Обновляем эффекты врагов
                    for (enemy in room.enemies) {
                        if (enemy.isAlive()) {
                            enemy.updateEffects(game)
                        }
                    }

                    // Действия врагов
                    for (enemy in room.enemies) {
                        if (enemy.isAlive()) {
                            enemy.performAction(game, room)

                            // Проверяем, жив ли враг после действия
                            if (!enemy.isAlive()) {
                                enemy.die(game, room) // Вызываем метод die() если враг мёртв
                                this.enemies.remove(enemy)
                                println("${enemy.name} был повержен!")

                            }
                        }
                    }

                    waitForEnter()
                }
    }

    private fun thirdStageSpecialEvent(game: Game) {
        val targets = getTargets(game)
        val target = targets[Random.nextInt(targets.size)]
        target.health -= target.level * 8
        println("${target.name} получает урон от падающих капельников!")
    }

    fun getTargets(game: Game): List<Entity> {
        val targets = mutableListOf<Entity>()
        for (ally in game.player.allies) {
            if (ally.isAlive()) {
                targets.add(ally)
            }
        }
        targets.add(game.player)
        targets.add(game.player.astral)
        return targets
    }

    fun openChest(game: Game, room: Room) {
        when (room) {
            is CrimsonChimesChestRoom -> {
                val drop = itemFactory.crimsonChimesChestItemGenerator()
                println("Вы открыли сундук и нашли: ${drop.name}.")
                game.player.inventory.addItem(drop)
            }
        }
    }

    private fun useInventory(game: Game) {
        println("Вы в меню инвентаря.")
        println("1. Экипировать / снять оружие")
        println("2. Использовать предмет из инвентаря")
        if (game.player.inventory.findAmulets()) {
            println("3. Экипировать / снять амулет")
        }
        val input = readlnOrNull()?.toInt()
        when (input) {
            1 -> {

            }
        }
    }

    fun handlePlayerDeath(game: Game) {
        TODO("Not yet implemented")
    }

    private fun showPlayerStats(game: Game) {
        val player = game.player
        println("Имя: ${player.name}")
        println("Здоровье: ${player.health}")
        println("Уровень: ${player.level})")

    }

    fun handleEmptyRoom(game: Game) {
        when (game.gameStage) {
            1 -> {
                println("Вы находитесь в тёмном лесу. Выберите действие:")
                println("1. Идти глубже в лес")
                println("2. Вернуться по своим следам")
                println("3. Показать статистику игрока")
                println("4. Просмотреть свой инвентарь")
                println("5. Попросить совет у Астрала")

                val input = readlnOrNull()
                when (input) {
                    "1" -> {
                        game.darkForestRoomStepsCounter++
                        game.moveForward()
                    }
                    "2" -> {
                        game.darkForestRoomStepsCounter--
                        game.moveBackward()
                    }
                    "3" -> showPlayerStats(game)
                    "4" -> println("Вы слишком круты, чтобы взаимодействовать с инвентарем.")
                    "5" -> if (!game.usedAstralAdvice) {
                        astralAdvice(game)
                        game.usedAstralAdvice = true
                    } else {
                        println("Вы уже получили совет от Астрала.")
                    }
                    else -> println("Непонятная команда. Попробуйте снова.")
                }
            }
            // Добавьте дополнительные стадии игры здесь
            2 -> {
                println("Вы находитесь в пустой комнате. Выберите действие:")
                println("1. Идти дальше по малиновому лесу")
                println("2. Вернуться назад")
                println("3. Показать статистику игрока")
                println("4. Поделать что-то в инвентаре")
                println("5. Просмотреть статистику Астрала")
                println("6. Просмотреть статистику союзников")

                val input = readlnOrNull()
                when (input) {
                    "1" -> {
                        game.moveForward()
                    }
                    "2" -> {
                        game.moveBackward()
                    }
                    "3" -> showPlayerStats(game)
                    "4" -> useInventory(game)
                    "5" -> showAstralStats(game)
                    "6" -> showAlliesStats(game)
                    else -> println("Непонятная команда. Попробуйте снова.")
                }
            }
            3 -> {
                    println("Вы продолжаете идти по кристальной пещере. Выберите действие:")
                    println("1. Идти дальше по пещере")
                    println("2. Вернуться назад")
                    println("3. Показать статистику игрока")
                    println("4. Поделать что-то в инвентаре")
                    println("5. Просмотреть статистику Астрала")
                    println("6. Просмотреть статистику союзников")

                    val input = readlnOrNull()
                    when (input) {
                        "1" -> {
                            game.moveForward()
                        }
                        "2" -> {
                            game.moveBackward()
                        }
                        "3" -> showPlayerStats(game)
                        "4" -> useInventory(game)
                        "5" -> showAstralStats(game)
                        "6" -> showAlliesStats(game)
                        else -> println("Непонятная команда. Попробуйте снова.")
                    }

            }
            4 -> {
                // Логика для стадии 4
                println("Эта комната пуста, но вы можете продолжать исследовать.")
            }
            5 -> {
                // Логика для стадии 5
                println("Эта комната пуста, но вы можете продолжать исследовать.")
            }
            -1 -> {
                println("Вы бродите по туннелям муравейника. Что вы хотите сделать?")
                println("1. Бродить дальше по муравейнику")
                println("2. Пойти назад по своим следам")
                println("3. Поделать что-то в инвентаре")
                println("4. Просмотреть статистику игрока")
                println("5. Просмотреть статистику Астрала")
                println("6. Просмотреть статистику союзников")

                val input = readlnOrNull()?.toInt()
                when (input) {
                    1 -> game.moveForward()
                    2 -> game.moveBackward()
                    3 -> useInventory(game)
                    4 -> showPlayerStats(game)
                    5 -> showAstralStats(game)
                    6 -> showAlliesStats(game)
                }
            }
            else -> {
                println("Эта комната пуста, но вы можете продолжать исследовать.")
            }
        }
    }

    fun showAstralStats(game: Game) {
        val astral = game.player.astral
        println("Имя: ${astral.name}")
        println("Здоровье: ${astral.health}")
        println("Уровень: ${astral.level}")
    }

    fun showAlliesStats(game: Game) {
        val allies = game.player.allies
        for (ally in allies) {
            println("Имя: ${ally.name}")
            println("Здоровье: ${ally.health}")
            println("Уровень: ${ally.level}")
        }
    }

    fun astralAdvice(game: Game) {
        val adviceList = when (game.gameStage) {
            1 -> listOf(
                "А знаешь, этот лес кажется знакомым.",
                "Надеюсь мой свет помогает вам.",
                "Корона была всего лишь оружием, её владелец - Тьма.",
                "ERROR 404."
            )
            2 -> listOf(
                "Не доверяйте тем, кто предлагает помощь.",
                "Каждое ваше действие имеет последствия.",
                "Скрытые враги могут появиться в любой момент.",
                "Ищите союзников, но будьте осторожны с их намерениями.",
                "Ваши ошибки могут стать вашим самым большим учителем."
            )
            3 -> listOf(
                "Слушайте шорохи вокруг, они могут вас предупредить.",
                "Ваша сила - в ваших решениях.",
                "Каждый выбор имеет свою цену.",
                "Не бойтесь рисковать, но делайте это с умом.",
                "Иногда лучше отступить, чтобы потом атаковать."
            )
            4 -> listOf(
                "Проверяйте каждый угол, скрытые вещи могут быть полезны.",
                "Не забывайте о своих союзниках.",
                "Собирайте информацию, она может спасти жизнь.",
                "Внимание к деталям может раскрыть тайны.",
                "Ваши враги могут быть ближе, чем вы думаете."
            )
            5 -> listOf(
                "Только смелые смогут пройти этот путь.",
                "Помните, что истинная сила внутри вас.",
                "Используйте свои слабости как свою силу.",
                "Каждый конец - это новый старт.",
                "Слушайте свое сердце, оно знает путь."
            )
            else -> listOf(
                "Астрал молчит...",
                "Подождите, пока не наступит новый день.",
                "Иногда тишина - это тоже ответ."
            )
        }

        // Выводим случайный совет из списка
        val randomAdvice = adviceList.random()
        println("Совет: $randomAdvice")
    }

    fun showEnemies() {
        for (enemy in enemies) {
            enemy.showStats()
        }
    }

    fun waitForEnter() {
        println("Нажмите Enter, чтобы продолжить...")
        readlnOrNull()
    }

}