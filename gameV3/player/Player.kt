package gameV3.player

import gameV3.item.Item
import gameV3.entities.Entity
import gameV3.entities.allies.Ally

class Player(
    name: String,
    description: String = "Игрок",
    health: Int = 100,
    attackPower: Int = 10,
    defensePower: Int = 5,
    level: Int = 100,
    var experience: Int = 0,
//    var inventory: Inventory,
//    var allies: List<Ally>
) : Entity(name, description, health, attackPower, defensePower, level)
{
    var inventory = listOf<Item>()
    var allies = listOf<Ally>()

    fun addXP(xp: Int) {
        experience += xp
        if (experience >= level * 100) {
            levelUp();
            println("$name повышает свой уровень!")
        }
    }

    fun increaseStats() {
        attackPower += 2;
        defensePower += 1;
        health += 20;
    }

    fun levelUp() {
        level++
        experience -= level * 100
        increaseStats()
    }
    // Метод для атаки
    fun attack(target: Entity) {
        println("$name атакует ${target.name}!")
        target.receiveDamage(attackPower)
    }

    // Метод для использования предмета из инвентаря
    fun useItem(item: Item) {
        // Логика использования предмета
        println("$name использует ${item.name}.")
    }

    fun aboutPlayer() {
        println("Имя: $name")
        println("Описание: $description")
        println("Здоровье: $health")
        println("Сила атаки: $attackPower")
        println("Сила защиты: $defensePower")
        println("Опыт: $experience")
        println("Уровень: $level")
    }
}