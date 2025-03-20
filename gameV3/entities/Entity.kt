package gameV3.entities

import gameV3.effects.Effect
import gameV3.main.Game
import gameV3.room.Room

open class Entity(
    var name: String,           // Имя сущности
    var description: String,    // Описание сущности
    var health: Int,           // Здоровье сущности
    var attackPower: Int,      // Сила атаки
    var defensePower: Int,     // Сила защиты
    var level: Int,          // Уровень сущности
) {

    var effects = listOf<Effect>()

    fun isAlive(): Boolean {
        if (health > 0) {
            return true
        }
        return false
    }


    fun receiveDamage(damage: Int) {
        val actualDamage = damage - defensePower
        health -= if (actualDamage > 0) actualDamage else 0
        if (health <= 0) {
            die()
        }
    }

    fun die() {
        println("$name растворился во тьме.")
    }

    fun attack() {

    }

    open fun performAction(game: Game, room: Room) {
        TODO("Implement this method in the subclass")
    }

    fun showStats() {
        println("Имя: $name")
        println("Описание: $description")
        println("Здоровье: $health")
        println("Сила атаки: $attackPower")
        println("Сила защиты: $defensePower")
        println("Уровень: $level")
    }

    fun addEffect(effect: Effect) {
        effects += effect
    }

    fun removeEffect(effect: Effect) {
        effects -= effect
    }
}