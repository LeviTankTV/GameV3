package gameV3.entities.allies.summonable

import gameV3.effects.BurningEffect
import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room

class DemolitionAntAlly(name : String = "Муравей - Разрушитель", description : String = "Муравей", health : Long = 125, attackPower : Long = 10, defensePower : Long = 0, level : Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = room.enemies
        for (target in targets) {
            this.attack(null, target)
            target.addEffect(BurningEffect(3, 20))
            println("Муравей атакует и поджигает ${target.name}!")
        }
    }
}