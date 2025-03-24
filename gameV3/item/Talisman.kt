package gameV3.item

import gameV3.main.Game

open class Talisman(name: String, description: String) : Item(name, description) {

    open fun equip(game: Game) {}
    open fun unequip(game: Game) {}

}