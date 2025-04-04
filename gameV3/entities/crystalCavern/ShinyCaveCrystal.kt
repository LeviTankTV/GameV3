package gameV3.entities.crystalCavern

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class ShinyCaveCrystal(name: String = "Сияющее Кристальное Хранилище", description: String = "Кристаль", health: Long = 2750, attackPower: Long = 0, defensePower: Long = 0, level: Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        // ничего не делаем
    }

    private fun generateDeathSummon(game: Game) : Entity {
        val list = listOf(
            ShinyBug(level = game.player.level + Random.nextInt(-2, 2)),
            ShinyGolem(level = game.player.level + Random.nextInt(-2, 2)),
            ShinyCrystalElement(level = game.player.level + Random.nextInt(-2, 2)),
            GlowCrystalWorm(level = game.player.level + Random.nextInt(-2, 2)),
            GlowingCrystalLizard(level = game.player.level + Random.nextInt(-2, 2)),
            GlowingCrystalSpirit(level = game.player.level + Random.nextInt(-2, 2)),
        )
        val summon = list[Random.nextInt(0, list.size)]
        return summon
    }
    override fun die(game: Game, room: Room) {
        repeat(Random.nextInt(1, 3)) {
            room.enemies.add(generateDeathSummon(game))
        }
        super.die(game, room)
    }
}