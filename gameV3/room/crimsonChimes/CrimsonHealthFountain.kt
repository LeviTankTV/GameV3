package gameV3.room.crimsonChimes

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrimsonHealthFountain() : Room(name = "Малиновый Фонтан Жизни", description = "Вы находитесь в малиновом фонтане жизни") {

    override fun playerTurn(game: Game, room: Room) {
        handleFountain(game)
        handleEmptyRoom(game)
    }

    private fun handleFountain(game: Game) {
        val fountainHealth = Random.nextInt(50, 300)
        game.player.health += fountainHealth
        println("Вы пополнили здоровье на $fountainHealth очков. Теперь у вас ${game.player.health} очков здоровья.")
    }

}