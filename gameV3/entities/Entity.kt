package gameV3.entities

import gameV3.effects.Effect
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

open class Entity(
    var name: String,           // Имя сущности
    var description: String,    // Описание сущности
    var health: Long,           // Здоровье сущности
    var attackPower: Long,      // Сила атаки
    var defensePower: Long,     // Сила защиты
    var level: Int,          // Уровень сущности
) {
    var maxHealth = health

    var effects = listOf<Effect>()
    var isDead: Boolean = false
    var incomeDamageIncreasePercentage: Double = 0.0
    var isInvisible: Boolean = false
    var weapon: Weapon? = null

    fun isAlive(): Boolean {
        if (health > 0) {
            return true
        }
        return false
    }


    open fun receiveDamage(weapon: Weapon?, damage: Long) {
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

            val isCriticalHit = Random.nextInt(0, 101) <= weapon.critChance // Generates a number between 0 and 100

            // Calculate total damage considering critical hit
            val totalDamage = if (isCriticalHit) {
                ((attackPower + weaponDamage * weapon.critMultiplier) * (1 + incomeDamageIncreasePercentage)).toLong()
            } else {
                ((attackPower + weaponDamage) * (1 + incomeDamageIncreasePercentage)).toLong()
            }

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

    fun getTargets (game: Game): List<Entity> {
        val targets = mutableListOf<Entity>()
        for (ally in game.player.allies) {
            targets.add(ally)
        }
        if (!game.player.isInvisible) {
            targets.add(game.player)
        }
        targets.add(game.player.astral)
        return targets
    }

    open fun performAction(game: Game, room: Room) {
        TODO("Implement this method in the subclass")
    }

    open fun dropLoot(game: Game) {
        game.player.gold += Random.nextInt(50)
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
        effect.apply(this)
    }

    fun removeEffect(effect: Effect) {
        effects -= effect
    }
}