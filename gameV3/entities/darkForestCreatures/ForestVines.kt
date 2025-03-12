package gameV3.entities.darkForestCreatures

import gameV3.entities.Creature

class ForestVines(
    name: String = "Лесные лианы",
    description: String = "Живые лианы, которые могут обвивать свои жертвы.",
    health: Int = 20,
    attackPower: Int = 3,
    defensePower: Int = 4,
    level: Int,
    species: String = "Лиана",
    habitat: String = "Лес"
) : Creature(name, description, health, attackPower, defensePower, level, species, habitat) {

    override fun specialAttack() {
        println("$name обвивает противника, чтобы замедлить его движение!")
    }
}