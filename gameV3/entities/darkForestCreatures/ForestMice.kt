package gameV3.entities.darkForestCreatures

import gameV3.entities.Creature

class ForestMice(
    name: String = "Лесная мышь",
    description: String = "Маленькая мышь, прячущаяся под листьями.",
    health: Int = 15,
    attackPower: Int = 2,
    defensePower: Int = 1,
    level: Int,
    species: String = "Мышь",
    habitat: String = "Лес"
) : Creature(name, description, health, attackPower, defensePower, level, species, habitat) {

    override fun specialAttack() {
        println("$name использует быстрый побег, чтобы избежать атаки!")
    }
}