package gameV3.room.darkForest

import gameV3.main.Game
import gameV3.room.Room

class IntroCutscene(name: String, description: String) : Room(name, description) {
    override fun playerTurn(game: Game, room: Room) {
        println("Вы выходите из разрушенного замка, обладая мощными артефактами и значительным количеством монет.")
        Thread.sleep(5000) // Задержка 5 секунд

        println("Внезапно перед вами появляется звезда, сверкающая ярким светом.")
        Thread.sleep(5000) // Задержка 5 секунд

        // Диалог со звездой
        println("Звезда: \"Я - Астрал. Одному в этих краях ходить опасно. Без меня ты не сможешь покинуть королевство.\"")
        Thread.sleep(5000) // Задержка 5 секунд

        println("Астрал: \"Вокруг королевства короля Артура есть барьер, который защищает его от кошмарных сил, но я могу помочь тебе.\"")
        Thread.sleep(5000) // Задержка 5 секунд

        println("Астрал: \"В обмен на защиту, я обеспечу тебя барьером. Я слышал что-то странное в лесу неподалеку от королевства. Нам стоит это проверить.\"")

        // Ожидание нажатия Enter после последних слов
        waitForEnter()

        // Устанавливаем новый gameStage
        game.gameStage = 1

        // Генерируем новые комнаты и переходим в следующую
        game.generateDungeon()
        game.moveForward()
    }

}