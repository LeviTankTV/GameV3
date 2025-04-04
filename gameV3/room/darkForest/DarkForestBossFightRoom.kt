package gameV3.room.darkForest

import gameV3.entities.bosses.HeartOfTheForest
import gameV3.main.Game
import gameV3.room.Room
import gameV3.room.crimsonChimes.CrimsonChimesEntranceRoom

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
        if (hasEnemies()) {
            handleCombat(game, room)
        } else {
            handleSecondGamePartTransition(game)
        }

    }

    private fun handleSecondGamePartTransition(game: Game) {
        println("Вы видите, как Астрал поднимает древесный ключ и указывает на дверь.")
        Thread.sleep(2000)

        println("Вы идёте за Астралом и открываете дверь...")
        Thread.sleep(2000)

        println("Перед вами обрыв! Вы останавливаетесь в ужасе.")
        Thread.sleep(2000)

        println("Вдруг вы замечаете человека в оранжевом, который подкрадывается сзади...")
        Thread.sleep(2000)

        println("Он толкает вас и Астрала в обрыв!")
        Thread.sleep(2000)

        // Логика потери уровней и денег
        val lostLevels = game.player.level // например, теряем все уровни
        val lostMoney = game.player.gold // теряем все деньги
        game.player.level = 1
        game.player.gold = 0

        println("Вы падаете в обрыв и теряете все свои уровни и деньги!")
        println("Вы потеряли: $lostLevels уровней и $lostMoney монет.")
        Thread.sleep(2000)

        println("Впереди вы видите рощу малиновых колокольчиков...")
        Thread.sleep(2000)
        waitForEnter()

        // Переход в следующую комнату
        game.gameTransition(2)

    }
}