package gameV3.entities.allies

import gameV3.entities.Entity

class Ally(name: String, description: String, health: Int, attackPower: Int, defensePower: Int, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    var allies = listOf<Ally>()

    fun addAlly(ally: Ally) {
        allies = allies + ally
    }

    fun removeAlly(ally: Ally) {
        allies = allies - ally
    }

    fun describe() {
        println("Существо: $name")
        println("Описание: $description")
        println("Вид: $species")
        println("Здоровье: $health")
        println("Сила атаки: $attackPower")
        println("Сила защиты: $defensePower")
        println("Уровень: $level")
    }
}