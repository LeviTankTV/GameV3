package gameV3.item

import gameV3.item.consumable.*
import gameV3.item.other.CrimsonPandoraBox
import gameV3.item.talisman.CrimsonTalisman
import gameV3.item.throwable.SpikesDagger
import gameV3.item.weapon.bows.CrimsonBow
import gameV3.item.weapon.gloves.CrimsonGloves
import gameV3.item.weapon.staffs.CrimsonStaff
import gameV3.item.weapon.swords.CrimsonSword
import kotlin.random.Random

class Factories {

    fun darkForestMazeItemGenerator(): Item {
        val items = listOf(
            Strawberry(),
            Raspberry(),
            PorciniMushroom(),
            HoneyMushroom(),
            Chanterelles()
        )

        // Генерируем случайный индекс для выбора предмета
        val randomIndex = Random.nextInt(items.size)

        // Возвращаем случайный предмет
        return items[randomIndex]
    }

    fun crimsonChimesChestItemGenerator(): Item {
        val items = listOf(
            InvisibilityPotion(),
            CrimsonHealthPotion(),
            CrimsonNestPotion(),
            CrimsonPandoraBox(),
            CrimsonTalisman(),
            CrimsonSword(),
            CrimsonBow(),
            CrimsonStaff(),
            CrimsonGloves(),
            SpikesDagger()
        )

        // Генерируем случайный индекс для выбора предмета
        val randomIndex = Random.nextInt(items.size)

        // Возвращаем случайный предмет
        return items[randomIndex]
    }
}