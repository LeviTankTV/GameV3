package gameV3.entities.crystalCavern

import gameV3.entities.Entity
import gameV3.item.other.SlidingCrystalWormEgg
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CaveCrystal(name : String = "Кристальное Хранилище", description : String = "Кристаль", health : Long = 1500, attackPower : Long = 0, defensePower : Long = 0, level : Int) : CrystalMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        // ничего не делаем
    }

    private fun generateDeathSummon(game: Game) : Entity {
        val list = listOf(
            CaveCrystalGryphon(level = game.player.level + Random.nextInt(-2, 2)),
            CaveCrystalSpider(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalBigSlime(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalDragon(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalGuardian(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalManticore(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalMediumSlime(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalPredator(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalPriest(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalRhinocerosBeetle(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalSmallSlime(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalTroll(level = game.player.level + Random.nextInt(-2, 2)),
            CrystalVampire(level = game.player.level + Random.nextInt(-2, 2)),
            FireGuardian(level = game.player.level + Random.nextInt(-2, 2)),
            HeadyCristalSpirit(level = game.player.level + Random.nextInt(-2, 2)),
            IgneousCrystal(level = game.player.level + Random.nextInt(-2, 2)),
            LavaCrystal(level = game.player.level + Random.nextInt(-2, 2)),
            LavaSpirit(level = game.player.level + Random.nextInt(-2, 2)),
            RockCrystal(level = game.player.level + Random.nextInt(-2, 2)),
            ShadowCrystalSpirit(level = game.player.level + Random.nextInt(-2, 2)),
            ShadowCrystalWarrior(level = game.player.level + Random.nextInt(-2, 2)),
            SlidingCrystalWorm(level = game.player.level + Random.nextInt(-2, 2))
        )
        val summon = list[Random.nextInt(0, list.size)]
        return summon
    }

    override fun die(game: Game, room: Room) {
        TODO(" Not yet implemented")
    }
}