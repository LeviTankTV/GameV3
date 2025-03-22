package gameV3.entities

import gameV3.effects.Effect
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room

open class Entity(
    var name: String,           // Имя сущности
    var description: String,    // Описание сущности
    var health: Long,           // Здоровье сущности
    var attackPower: Long,      // Сила атаки
    var defensePower: Long,     // Сила защиты
    var level: Int,          // Уровень сущности
) {
    val maxHealth = health

    var effects = listOf<Effect>()
    var isDead: Boolean = false

    fun isAlive(): Boolean {
        if (health > 0) {
            return true
        }
        return false
    }


    fun receiveDamage(weapon: Weapon?, damage: Long) {
        val actualDamage = damage - defensePower
        health -= if (actualDamage > 0) actualDamage else 0
    }

    fun die(game: Game) {
        isDead = true
        game.player.addXP(level * 10)
        dropLoot(game)
    }

    fun attack(weapon: Weapon?, target: Entity) {

        if (weapon != null) {

            val weaponDamage = weapon.damage

            val totalDamage = attackPower + weaponDamage

            weapon.applySpecialEffect(target)
            target.receiveDamage(weapon, totalDamage)
        } else {

            target.receiveDamage(null, attackPower)
        }
    }

    fun updateEffects(game: Game) {
        for (effect in effects) {
            effect.update(this)
            if (effect.duration == 0) {
                effect.remove(this)
            }
        }
    }

    open fun performAction(game: Game, room: Room) {
        TODO("Implement this method in the subclass")
    }

    open fun dropLoot(game: Game) {
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