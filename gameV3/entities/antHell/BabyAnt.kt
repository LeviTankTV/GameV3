package gameV3.entities.antHell

import gameV3.entities.Entity
import gameV3.item.consumable.Corn
import gameV3.item.consumable.Leaf
import gameV3.item.consumable.Rice
import gameV3.item.other.BabyEgg
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class BabyAnt(name: String = "Бейби Ант", description: String = "Безобидный малыш", health: Long = 50, attackPower: Long = 0, defensePower: Long = 0, level: Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        println("Бейби Ант не хочет биться")
    }

    override fun dropLoot(game: Game) {
        super.dropLoot(game)
        val random = Random

        // Проверяем вероятность для каждого предмета
        if (random.nextInt(10) == 0) { // 10% вероятность
            game.player.inventory.addItem(Corn())
        }
        if (random.nextInt(10) == 0) { // 10% вероятность
            game.player.inventory.addItem(Leaf())
        }
        if (random.nextInt(10) == 0) { // 10% вероятность
            game.player.inventory.addItem(Rice())
        }
        if (random.nextInt(10) == 0) { // 10% вероятность
            game.player.inventory.addItem(BabyEgg())
        }
    }
}