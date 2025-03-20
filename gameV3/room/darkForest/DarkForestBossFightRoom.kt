package gameV3.room.darkForest

import gameV3.entities.bosses.HeartOfTheForest
import gameV3.main.Game
import gameV3.room.Room

class DarkForestBossFightRoom(name: String, description: String) : Room(name, description) {

    private fun enterRoom() {
        val boss = HeartOfTheForest()
        enemies += boss
        // Выводим описание комнаты с задержкой
        println("Вы входите в комнату...")
        Thread.sleep(1000) // Задержка 1 секунда

        println("Вы видите огромное дерево тьмы посередине комнаты.")
        Thread.sleep(2000) // Задержка 2 секунды

        println("Дерево держится на пяти мощных корнях.")
        Thread.sleep(2000) // Задержка 2 секунды

        println("Астрал шепчет вам, что нужно сломать эти корни.")
        Thread.sleep(2000) // Задержка 2 секунды
        waitForEnter()
    }

    override fun playerTurn(game: Game, room: Room) {
        enterRoom()
        handleCombat(game, room)
    }
}