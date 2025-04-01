package gameV3.entities.crystalCavern

import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CaveCrystal(name : String = "Кристальное Хранилище", description : String = "Кристаль", health : Long = 1500, attackPower : Long = 0, defensePower : Long = 0, level : Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        // ничего не делаем
    }

    override fun die(game: Game, room: Room) {
        TODO(" Not yet implemented")
    }
}