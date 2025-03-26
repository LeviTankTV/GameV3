package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.entities.EntityFactory
import gameV3.main.Game
import gameV3.room.Room

class AntEgg(name : String = "Яицо Муравьёв", description : String = "Из него может возникнуть муравей", health : Long = 300, attackPower : Long = 10, defensePower : Long = 0, level : Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        turn++
        if (turn == maxTurns) {
            this.health = 0
            summon(game, room)
        }
    }

    private var turn = 0
    private var maxTurns = 3

    private val factory = EntityFactory()
    private fun summon(game: Game, room: Room) {
        room.enemies.add(factory.antGenerator(game))
    }
}