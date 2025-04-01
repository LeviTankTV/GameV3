package gameV3.entities.crystalCavern

import gameV3.entities.Entity
import gameV3.item.consumable.Crystal
import gameV3.item.other.Diamond
import gameV3.item.other.Emerald
import gameV3.item.other.GoldBar
import gameV3.item.other.IronBar
import gameV3.item.throwable.CrystalDagger
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import kotlin.random.Random

open class CrystalMob(name: String, description: String, health: Long, attackPower: Long, defensePower: Long, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun receiveDamage(weapon: Weapon?, damage: Long) {
        // Проверяем, является ли тип оружия "Crystal"
        val actualDamage = if (weapon?.type == "Crystal") {
            (damage * 4 - defensePower).toLong() // Увеличиваем урон на 1.5 раза
        } else {
            damage
        } - defensePower

        // Вычитаем здоровье, если фактический урон больше 0
        health -= if (actualDamage > 0) actualDamage else 0
    }

    override fun dropLoot(game: Game) {
        game.player.gold += Random.nextInt(150)
        if (Random.nextInt(20) == 0) {
            game.player.inventory.addItem(Crystal())
        }
        if (Random.nextInt(25) == 0) {
            game.player.inventory.addItem(CrystalDagger())
        }

        if (Random.nextInt(100) == 0) {
            game.player.inventory.addItem(Emerald())
        }

        if (Random.nextInt(100) == 0) {
            game.player.inventory.addItem(GoldBar())
        }

        if (Random.nextInt(100) == 0) {
            game.player.inventory.addItem(IronBar())
        }

        if (Random.nextInt(100) == 0) {
            game.player.inventory.addItem(Diamond())
        }
    }
}