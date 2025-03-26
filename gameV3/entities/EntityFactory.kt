package gameV3.entities

import gameV3.entities.antHell.*
import gameV3.entities.crimsonChimes.*
import gameV3.main.Game
import kotlin.random.Random

class EntityFactory {

    fun beetleGenerator(game: Game) : Entity {
        val beetles = listOf(
            Beetle(level = game.player.level + Random.nextInt(-2, 2)),
            FireBeetle(level = game.player.level + Random.nextInt(-2, 2)),
            PoisonousBeetle(level = game.player.level + Random.nextInt(-2, 2)),
            GiantBeetle(level = game.player.level + Random.nextInt(-2, 2)),
            CrimsonBeetle(level = game.player.level + Random.nextInt(-2, 2)),
        )

        return beetles[Random.nextInt(0, beetles.size)]
    }

    fun crimsonFieldOneGenerator(game: Game) : Entity {
        val enemies = listOf(
            PoisonousButterfly(level = game.player.level + Random.nextInt(-2, 2)),
            CrimsonChimesMoth(level = game.player.level + Random.nextInt(-2, 2)),
            NimbleSparrow(level = game.player.level + Random.nextInt(-2, 2)),
        )

        return enemies[Random.nextInt(0, enemies.size)]
    }

    fun crimsonFieldTwoGenerator(game: Game) : Entity {
        val enemies = listOf(
            WailingWisps(level = game.player.level + Random.nextInt(-2, 2)),
            NimbleSparrow(level = game.player.level + Random.nextInt(-2, 2)),
            CrimsonSpirit(level = game.player.level + Random.nextInt(-2, 2)),
            EvilGnome(level = game.player.level + Random.nextInt(-2, 2)),
            CrimsonTroll(level = game.player.level + Random.nextInt(-2, 2)),
        )

        return enemies[Random.nextInt(0, enemies.size)]
    }

    fun crimsonFieldThreeGenerator(game: Game) : Entity {
        val enemies = listOf(
            CrimsonGuardian(level = game.player.level + Random.nextInt(-2, 2)),
            CrimsonSkeleton(level = game.player.level + Random.nextInt(-2, 2)),
            NimbleSparrow(level = game.player.level + Random.nextInt(-2, 2))
        )

        return enemies[Random.nextInt(0, enemies.size)]
    }

    fun antGenerator(game: Game) : Entity {
        val enemies = listOf(
            BabyAnt(level = game.player.level + Random.nextInt(-2, 2)),
            DemolitionAnt(level = game.player.level + Random.nextInt(-2, 2)),
            ColossalAnt(level = game.player.level + Random.nextInt(-2, 2)),
            InvisibleAnt(level = game.player.level + Random.nextInt(-2, 2)),
            NinjaAnt(level = game.player.level + Random.nextInt(-2, 2)),
            RescueAnt(level = game.player.level + Random.nextInt(-2, 2)),
            SkeletonAnt(level = game.player.level + Random.nextInt(-2, 2)),
            SoldierAnt(level = game.player.level + Random.nextInt(-2, 2)),
            SpiritCrusherAnt(level = game.player.level + Random.nextInt(-2, 2)),
            ToxicAnt(level = game.player.level + Random.nextInt(-2, 2)),
            WizardAnt(level = game.player.level + Random.nextInt(-2, 2)),
            WorkerAnt(level = game.player.level + Random.nextInt(-2, 2)),
            QueenAnt(level = game.player.level + Random.nextInt(-2, 2))
        )

        return enemies[Random.nextInt(0, enemies.size)]
    }





}