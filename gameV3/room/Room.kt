package gameV3.room

import gameV3.entities.Entity
import gameV3.main.Game

abstract class Room(val name: String, val description: String) {
    var enemies: List<Entity> = listOf();
    var previousRoom: Room? = null
    var nextRoom: Room? = null
    abstract fun playerTurn(game: Game, room: Room)
    fun hasEnemies(): Boolean {
        return enemies.isNotEmpty()
    }
    fun handleCombat() {
        // TODO do combat
    }

    fun openChestDarkForest() {
        // TODO
    }

    fun openInventory(game: Game) {
        val inventory = game.player.inventory
        println("Ваш инвентарь:")

        if (game.gameStage == 1) {
            // Если стадия игры 1, просто выводим инвентарь
            inventory.forEach { item ->
                println(item.name)
            }
            println("Вы слишком круты, чтобы взаимодействовать с инвентарем.")
        } else {
            // На других стадиях выводим инвентарь и предлагаем выбрать действие
            inventory.forEach { item ->
                println(item.name)
            }
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
                "1" -> game.moveForward()
                "2" -> game.moveBackward()
                "3" -> showPlayerStats(game)
                "4" -> openInventory(game)
                "5" -> astralAdvice(game)
                else -> println("Непонятная команда. Попробуйте снова.")
            }
        } else {
            // Логика для других стадий игры
            println("Эта комната пуста, но вы можете продолжать исследовать.")
        }
    }

    fun astralAdvice(game: Game) {
        val adviceList = when (game.gameStage) {
            1 -> listOf("Будьте осторожны, лес полон тайн.", "Ищите свет в темноте.")
            2 -> listOf("Не доверяйте тем, кто предлагает помощь.", "Каждое ваше действие имеет последствия.")
            3 -> listOf("Слушайте шорохи вокруг, они могут вас предупредить.", "Ваша сила - в ваших решениях.")
            4 -> listOf("Проверяйте каждый угол, скрытые вещи могут быть полезны.", "Не забывайте о своих союзниках.")
            5 -> listOf("Только смелые смогут пройти этот путь.", "Помните, что истинная сила внутри вас.")
            else -> listOf("Астрал молчит...") // На случай, если gameStage не соответствует ни одной стадии
        }

        // Выводим случайный совет из списка
        val randomAdvice = adviceList.random()
        println("Астрал говорит: \"$randomAdvice\"")
    }

    fun waitForEnter() {
        println("Нажмите Enter, чтобы продолжить...")
        readlnOrNull()
    }

}