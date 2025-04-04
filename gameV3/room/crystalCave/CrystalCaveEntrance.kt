package gameV3.room.crystalCave

import gameV3.main.Game
import gameV3.room.Room

class CrystalCaveEntrance() : Room(name = "Вход в Кристальную Пещеру", description = "Вы находитесь в входе в Кристальную Пещеру") {
    override fun playerTurn(game: Game, room: Room) {
        println("\nВы на входе в Кристальную Пещеру.")
        Thread.sleep(2000)
        println("Вы замечаете, что здесь можете снова использовать свою магию!")
        Thread.sleep(2000)
        println("Вы видите, что вход сзади вас завалило камнями. Вы не можете вернуться назад. Вы должны продолжить свой путь в пещере.")
        waitForEnter()
        handleEmptyRoom(game)
    }
}
