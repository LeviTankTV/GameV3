package gameV3.item

import gameV3.main.Game

open class Item(val name: String, val description: String) {
    override fun toString(): String {
        return "$name: $description"
    }
    open fun use(game: Game) {}
}