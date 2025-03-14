package gameV3.item

import kotlin.jvm.internal.Ref.LongRef

class Weapon(name: String, description: String) : Item(name, description) {

    val attackPower: Long = 0

    val critChance: Long = 0

    val critMultiplier: Long = 1

}