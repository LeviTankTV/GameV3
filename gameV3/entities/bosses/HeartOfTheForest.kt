package gameV3.entities.bosses

import gameV3.entities.Entity
import gameV3.entities.darkForest.Druid
import gameV3.entities.darkForest.WoodenGuardian
import gameV3.item.Item
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class HeartOfTheForest(name : String = "Сердце леса", description : String = "Хранитель многих тайн", health : Long = 55555, attackPower : Long = 80, defensePower : Long = 100000, level : Int = 1): Entity(name, description, health, attackPower, defensePower, level) {

    override fun performAction(game: Game, room: Room) {
        val astral = game.player.astral
        val playerAllies = game.player.allies
        val targets = listOf(astral,game.player) + playerAllies

        val action = Random.nextInt(5)

        when (action) {
            0 -> this.attack(null, targets[Random.nextInt(targets.size)])
            1 -> this.summon(room, game, "guardian")
            2 -> this.evilLaugh()
            3 -> this.attackAstral(game)
            4 -> this.summon(room, game, "druid")
        }
    }

    fun summon(room: Room, game: Game, mob: String) {
        when (mob) {
            "guardian" -> room.enemies.add(WoodenGuardian(level = Random.nextInt(game.player.level) + Random.nextInt(-2,2)))
            "druid" -> room.enemies.add(Druid(level = Random.nextInt(game.player.level) + Random.nextInt(-2,2)))
        }
    }

    private fun attackAstral(game: Game) {
        game.player.astral.health -= this.attackPower
    }

    private fun evilLaugh() {
        println("ВУХАХАХАХХАХАХАХАХХАХАХАХХАХА")
    }

    override fun dropLoot(game: Game) {
        game.player.inventory.addItem(Item("Древесный Ключ", "Ключ выхода из тёмного леса"))
    }
}