package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room

class SpiritCrusherAnt(name: String = "Муравей - Разрушитель душ", description: String = "Просто ант", health: Long = 200, attackPower: Long = 200, defensePower: Long = 30, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val astral = game.player.astral
        this.attack(null, astral)
        println("Муравей - Разрушитель душ нанес ${this.attackPower} урона Астралу.")
    }
}