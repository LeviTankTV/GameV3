package gameV3.entities.crimsonChimes

import gameV3.entities.Entity
import gameV3.item.weapon.Weapon
import gameV3.item.weapon.bows.OldCrimsonBow
import gameV3.item.weapon.gloves.OldCrimsonGloves
import gameV3.item.weapon.staffs.OldCrimsonStaff
import gameV3.item.weapon.swords.OldCrimsonSword
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class CrimsonGuardian(name: String = "Малиновый Страж", description: String = "Грозный страж малинового леса", health: Long = 120, attackPower: Long = 20, defensePower: Long = 20, level: Int): CrimsonChimesMob(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        val targets = getTargets(game)
        val random = Random.nextInt(targets.size)
        val target = targets[random]
        this.attack(null, target)
    }

    override fun dropLoot(game: Game) {
        val random = Random.nextInt(10)
        super.dropLoot(game)
        when (random) {
            0 -> {
                val randomm = Random.nextInt(4)
                when (randomm) {
                    0 -> {
                        game.player.inventory.addItem(OldCrimsonBow())
                    }

                    1 -> {
                        game.player.inventory.addItem(OldCrimsonSword())
                    }

                    2 -> {
                        game.player.inventory.addItem(OldCrimsonGloves())
                    }

                    3 -> {
                        game.player.inventory.addItem(OldCrimsonStaff())
                    }
                }
            }
        }
    }
}