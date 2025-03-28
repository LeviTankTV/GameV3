package gameV3.entities.crimsonChimes

import gameV3.entities.Entity
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import kotlin.random.Random

open class CrimsonChimesMob(name: String, description: String, health: Long, attackPower: Long, defensePower: Long, level: Int): Entity(name, description, health, attackPower, defensePower, level) {
    override fun receiveDamage(weapon: Weapon?, damage: Long) {
        // Проверяем, является ли тип оружия "Crimson"
        val actualDamage = if (weapon?.type == "Crimson") {
            (damage * 1.5 - defensePower).toLong() // Увеличиваем урон на 1.5 раза
        } else {
            damage
        } - defensePower

        // Вычитаем здоровье, если фактический урон больше 0
        health -= if (actualDamage > 0) actualDamage else 0
    }

    override fun dropLoot(game: Game) {
        game.player.gold += Random.nextInt(50)
    }
}