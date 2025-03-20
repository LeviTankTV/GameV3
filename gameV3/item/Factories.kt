package gameV3.item

import gameV3.item.eatable.*
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

}