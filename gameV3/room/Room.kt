package gameV3.room

import gameV3.entities.Entity
import gameV3.main.Game

abstract class Room(val name: String, val description: String) {
    var enemies: MutableList<Entity> = mutableListOf();
    var previousRoom: Room? = null
    var nextRoom: Room? = null

    abstract fun playerTurn(game: Game, room: Room)

    fun hasEnemies(): Boolean {
        return enemies.isNotEmpty()
    }

    fun clearEnemies() {
        enemies.clear()
    }

    fun handleCombat(game: Game, room: Room) {
        when (game.gameStage) {
            1 -> {
                while (game.player.isAlive() && game.player.astral.isAlive()) {
                    game.player.updateEffects(game)
                    game.player.astral.updateEffects(game)

                    // Обновляем эффекты союзников
                    if (game.player.allies.isNotEmpty()) {
                        for (ally in game.player.allies) {
                            ally.updateEffects(game)
                        }
                    }

                    // Игрок выполняет свои действия
                    game.player.astral.performAction(game, room)
                    game.player.performAction(game, room)

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
                                enemy.die(game) // Вызываем метод die() если враг мёртв
                                println("${enemy.name} был повержен!")
                            }
                        }
                    }

                    waitForEnter()
                }
            }
        }
    }

    fun openChestDarkForest() {
        // TODO
    }

    fun openInventory(game: Game) {
        val inventory = game.player.inventory
        println("Ваш инвентарь:")

        inventory.listItems()

        if (game.gameStage == 1) {
            println("Вы слишком круты, чтобы взаимодействовать с инвентарем.")
        } else {
            println("Выберите действие:")
            // Здесь вы можете добавить логику для выбора действия
            // Например, вывести список действий и обработать выбор игрока
        }

        waitForEnter()
    }

    fun showPlayerStats(game: Game) {
        val player = game.player
        println("Имя: ${player.name}")
        println("Здоровье: ${player.health}")
        println("Уровень: ${player.level})")

    }

    fun handleEmptyRoom(game: Game) {
        if (game.gameStage == 1) {
            println("Вы находитесь в тёмном лесу. Выберите действие:")
            println("1. Идти глубже в лес")
            println("2. Вернуться по своим следам")
            println("3. Показать статистику игрока")
            println("4. Просмотреть свой инвентарь")
            println("5. Попросить совет у Астрала")

            val input = readlnOrNull()
            when (input) {
                "1" ->  {
                    game.darkForestRoomStepsCounter++
                    game.moveForward()
                }
                "2" -> {
                    game.darkForestRoomStepsCounter--
                    game.moveBackward()
                }
                "3" -> showPlayerStats(game)
                "4" -> openInventory(game)
                "5" -> if (!game.usedAstralAdvice) {
                    astralAdvice(game)
                    game.usedAstralAdvice = true
                }
                else -> println("Непонятная команда. Попробуйте снова.")
            }
        } else {
            // Логика для других стадий игры
            println("Эта комната пуста, но вы можете продолжать исследовать.")
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
    fun waitForEnter() {
        println("Нажмите Enter, чтобы продолжить...")
        readlnOrNull()
    }

}