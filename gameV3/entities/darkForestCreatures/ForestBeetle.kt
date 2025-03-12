package gameV3.entities.darkForestCreatures

import gameV3.entities.Creature

class ForestBeetle(
    name: String = "Лесной жук",
    description: String = "Маленький жук с блестящей оболочкой.",
    health: Int = 10,
    attackPower: Int = 1,
    defensePower: Int = 2,
    level: Int,
    species: String = "Жук",
    habitat: String = "Лес"
) : Creature(name, description, health, attackPower, defensePower, level, species, habitat) {

    override fun specialAttack() {
        println("$name использует защитный панцирь, чтобы уменьшить урон!")
    }
}