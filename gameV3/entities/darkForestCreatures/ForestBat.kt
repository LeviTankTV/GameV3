package gameV3.entities.darkForestCreatures

import gameV3.entities.Creature

class ForestBat(
    name: String = "Лесная летучая мышь",
    description: String = "Маленькая летучая мышь, обитающая в темных лесах.",
    health: Int = 30,
    attackPower: Int = 5,
    defensePower: Int = 2,
    level: Int,
    species: String = "Летучая мышь",
    habitat: String = "Темный лес"
) : Creature(name, description, health, attackPower, defensePower, level, species, habitat) {

    // Реализация метода особой атаки
    override fun specialAttack() {
        println("$name использует ультразвуковую волну, чтобы дезориентировать противника!")
        // Здесь можно добавить логику для дезориентации противника или уменьшения его здоровья
    }
}