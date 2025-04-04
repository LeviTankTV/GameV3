package gameV3.room.crystalCave

import gameV3.entities.EntityFactory
import gameV3.entities.crystalCavern.CrystalMimic
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class LabyrinthOfEchoes: Room(name = "Зона Контроля №2", description = "Вы находитесь в лабиринте эха") {
    override fun playerTurn(game: Game, room: Room) {
        fillRoom(game)
        println("Вам надоели лабиринты и вы решаете просто идти вперёд.")
        println("Походу всё не так просто, и вы видите врагов...")
        Thread.sleep(1000)
        waitForEnter()

        handleCombat(game, room)

        println("Новая волна мобов наступает!")
        fillRoom(game)
        waitForEnter()
        handleCombat(game, room)
        println("Последняя волна мобов наступает!")
        fillRoom(game)
        waitForEnter()
        handleCombat(game, room)
        println("Вы победили всех мобов и выходите из лабиринта.")
        Thread.sleep(1000)
        handleEmptyRoom(game)
    }

    private fun fillRoom(game: Game) {
        this.enemies.add(CrystalMimic(health = game.player.health, attackPower = game.player.attackPower, defensePower = game.player.defensePower, level = game.player.level + Random.nextInt(-2, 2)))
        repeat(Random.nextInt(5,8)) {
            this.enemies.add(EntityFactory().caveCrystalGenerator(game))
        }
    }
}