package gameV3.entities.darkForestCreatures

import gameV3.entities.Creature

class ForestSprouts(
    name: String = "Лесные побеги",
    description: String = "Милые маленькие растения, которые растут в тени.",
    health: Int = 5,
    attackPower: Int = 1,
    defensePower: Int = 1,
    level: Int,
    species: String = "Растение",
    habitat: String = "Лес"
) : Creature(name, description, health, attackPower, defensePower, level, species, habitat) {

    override fun specialAttack() {
        println("$name использует свои питательные вещества, чтобы восстановить здоровье!")
    }
}