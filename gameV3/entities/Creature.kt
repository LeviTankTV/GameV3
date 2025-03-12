package gameV3.entities

abstract class Creature(
    name: String,
    description: String,
    health: Int,
    attackPower: Int,
    defensePower: Int,
    level: Int,
    species: String,        // Вид существа
    habitat: String         // Среда обитания
) : Entity(name, description, health, attackPower, defensePower, level, species, habitat) {

    // Метод для особой атаки
    abstract fun specialAttack();

    // Метод для описания существа
    fun describe() {
        println("Существо: $name")
        println("Описание: $description")

        println("Вид: $species")
        println("Среда обитания: $habitat")
        println("Здоровье: $health")
        println("Сила атаки: $attackPower")
        println("Сила защиты: $defensePower")
        println("Уровень: $level")
    }
}