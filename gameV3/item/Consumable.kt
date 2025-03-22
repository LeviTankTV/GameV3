package gameV3.item

import gameV3.main.Game

open class Consumable(name: String, description: String): Item(name, description) {
    open fun eat(game: Game) {}
}