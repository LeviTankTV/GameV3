package gameV3.item.weapon.swords

import gameV3.item.weapon.Weapon

class CrystalSword() : Weapon(name = "Кристальный меч", description = "Он очень силен против Кристальных врагов") {
    override var type = "Crystal"

    override var damage: Long = 75
}