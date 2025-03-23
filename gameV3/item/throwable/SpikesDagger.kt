package gameV3.item.throwable

import gameV3.entities.Entity
import gameV3.item.Throwable
import gameV3.main.Game

class SpikesDagger: Throwable(name = "Колючий кинжал", description = "Кинжал из лоз малины") {

    override fun throwAt(target: Entity) {
        target.health -= 75
    }

}