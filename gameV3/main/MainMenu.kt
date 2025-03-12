package gameV3.main

import gameV3.player.Player

class MainMenu {
    fun show() {
        while (true) {
            println("=== Главное меню ===")
            println("1. Начать игру")
            println("2. Информация об игре")
            println("3. Выход")
            print("Выберите опцию: ")

            when (readlnOrNull()) {
                "1" -> {
                    print("Введите ваше имя: ") // Запрашиваем имя игрока
                    val playerName = readlnOrNull() ?: "Игрок" // Если имя не введено, используем "Игрок"
                    val player = Player(playerName)
                    val game = Game(player) // Передаем имя в конструктор Game
                    game.start()
                }
                "2" -> {
                    showGameInfo()
                }
                "3" -> {
                    println("Вы еще вернётесь. Спасибо за игру! До свидания!")
                    return
                }
                else -> {
                    println("Неправильный ввод. Пожалуйста, выберите 1, 2 или 3.")
                }
            }
        }
    }

    private fun showGameInfo() {
        println("\n=== Информация об игре ===")
        println("Название: Supreme Dungeon III")
        println("Разработчик: LeviTank_TV")
        println("Описание: Это финальная часть захватывающего приключения!")
        println("===========================")
    }
}

fun main() {
    val menu = MainMenu()
    menu.show() // Запуск меню
}