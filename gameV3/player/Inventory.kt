package gameV3.player

import gameV3.item.Item

class Inventory {
    private val items = mutableListOf<Item>()
    private var activeTalisman: Item? = null // Поле для хранения активного талисмана

    fun addItem(item: Item) {
        items.add(item)
        println("Вы добавили ${item.name} в инвентарь.")
    }

    fun removeItem(item: Item) {
        if (items.remove(item)) {
            println("Вы убрали ${item.name} из инвентаря.")
            // Если убираем активный талисман, снимаем его
            if (activeTalisman == item) {
                unequipTalisman()
            }
        } else {
            println("У вас нет ${item.name} в инвентаре.")
        }
    }

    fun listItems() {
        if (items.isEmpty()) {
            println("Ваш инвентарь пуст.")
        } else {
            println("Ваш инвентарь:")
            items.forEach { println(it) }
        }
        // Выводим информацию об активном талисмане
        if (activeTalisman != null) {
            println("Активный талисман: ${activeTalisman!!.name}")
        } else {
            println("У вас нет активного талисмана.")
        }
    }

    fun equipTalisman(talisman: Item) {
        if (items.contains(talisman)) {
            activeTalisman = talisman
            println("Вы экипировали талисман: ${talisman.name}.")
        } else {
            println("У вас нет ${talisman.name} в инвентаре.")
        }
    }

    fun unequipTalisman() {
        if (activeTalisman != null) {
            println("Вы сняли талисман: ${activeTalisman!!.name}.")
            activeTalisman = null
        } else {
            println("У вас нет активного талисмана для снятия.")
        }
    }
}