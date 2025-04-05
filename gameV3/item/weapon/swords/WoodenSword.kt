package gameV3.item.weapon.swords

import gameV3.entities.Entity
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

// Подкласс WoodenSword, наследующий от Weapon
class WoodenSword : Weapon(
    name = "Деревянный меч",
    description = "Простой меч, сделанный из дерева. Подходит для начинающих."
) {
    // Переопределяем характеристики для WoodenSword
    override var critChance: Long = 10   // Шанс критического удара в процентах
    override var critMultiplier: Double = 2.0 // Множитель урона при критическом ударе
    override var damage: Long = 3          // Базовый урон

    override fun applySpecialEffect(target: Entity) {
        val additionalDamage = Random.nextInt(20)
        damage += additionalDamage
    }
}