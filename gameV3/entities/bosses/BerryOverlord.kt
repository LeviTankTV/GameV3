package gameV3.entities.bosses

import gameV3.entities.Entity
import gameV3.entities.crimsonChimes.CrimsonSpirit
import gameV3.entities.crimsonChimes.CrimsonWraith
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class BerryOverlord(name: String = "Ягодный Оверлорд", description: String = "Очень опасный босс", health: Long = 10000, attackPower: Long = 175, defensePower: Long = 10000, level: Int = 1) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        summonTurns++
        if (summonTurns == 7) {
            repeat(2) {
                room.enemies.add(CrimsonSpirit(level = game.player.level + Random.nextInt(-2, 2)))
            }
            summonTurns = 0
        }
        if (bossStage == 1) {
            val targets = getTargets(game)
            val target = targets[Random.nextInt(targets.size)]
            this.attack(null, target)
            if (!hasCrimsonWraiths(room)) {
                room.enemies.add(CrimsonWraith(level = game.player.level + Random.nextInt(-2, 2)))
                room.enemies.add(CrimsonWraith(level = game.player.level + Random.nextInt(-2, 2)))
                this.defensePower -= 3333
                bossStage++
            }
        } else if (bossStage == 2) {
            val targets = getTargets(game)
            for (target in targets) {
                this.attack(null, target)
            }
            if (!hasCrimsonWraiths(room)) {
                room.enemies.add(CrimsonWraith(level = game.player.level + Random.nextInt(-2, 2)))
                room.enemies.add(CrimsonWraith(level = game.player.level + Random.nextInt(-2, 2)))
                this.defensePower -= 3333
                bossStage++
            }
        } else if (bossStage == 3) {
            val targets = getTargets(game)
            for (target in targets) {
                this.attack(null, target)
            }
            if (!hasCrimsonWraiths(room)) {
                room.enemies.add(CrimsonWraith(level = game.player.level + Random.nextInt(-2, 2)))
                room.enemies.add(CrimsonWraith(level = game.player.level + Random.nextInt(-2, 2)))
                this.defensePower -= 3333
                bossStage++
            }
        } else if (bossStage == 4) {
            val targets = getTargets(game)
            for (target in targets) {
                this.attack(null, target)
            }
            consumeTurns++
            if (consumeTurns == 5) {
                consume(room)
                consumeTurns = 0
            }
        }
    }


    private var consumeTurns: Int = 0
    private var summonTurns : Int = 0
    private var bossStage : Int = 1

    private fun hasCrimsonWraiths(room: Room) : Boolean {
        for (enemy in room.enemies) {
            if (enemy is CrimsonWraith) {
                return true
            }
        }
        return false
    }

    private fun consume(room: Room) {
        for (enemy in room.enemies) {
            if (enemy is CrimsonSpirit) {
                println("Ягодный Оверлорд поглотил малиновый дух и восстановил ${enemy.health} здоровья .")
                this.health += enemy.health
                room.enemies.remove(enemy)

            }
        }
    }
}