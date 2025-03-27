package gameV3.room.antHell

import gameV3.entities.antHell.AlarmAnt
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CelebrationRoom() : Room(name = "Праздник", description = "Вы находитесь в праздничном зале") {
    override fun playerTurn(game: Game, room: Room) {
        repeat(Random.nextInt(3, 6)) {
            room.enemies.add(AlarmAnt(level = game.player.level + Random.nextInt(-2, 2)))
        }
        if (room.hasEnemies()) {
            handleCombat(game, this)
        } else {
            handleEmptyRoom(game)
        }
    }


}