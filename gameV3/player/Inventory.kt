package gameV3.player

import gameV3.item.Item

class Inventory {
    private val items = mutableListOf<Item>()
    private var activeTalisman: Item? = null // Поле для хранения активного талисмана
    var weapon: Item? = null


    fun addItem(item: Item) {
        items.add(item)
        println("Вы добавили ${item.name} в инвентарь.")
    }

    fun eqiup

    fun removeItem(item: Item) {
        if (items.contains(item)) {
            items.remove(item) // Remove the item from the list
            println("Вы убрали ${item.name} из инвентаря.")

            // Если убираем активный талисман, снимаем его
            if (activeTalisman == item) {
                unequipTalisman()
            }
        } else {
            println("У вас нет ${item.name} в инвентаре.")
        }
    }


    fun getItems(): List<Item> {
        return items.toList() // Return a copy to prevent external modification
    }


    fun isEmpty(): Boolean {
        return items.isEmpty()
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

    fun equipWeapon(weapon: Item) {
        if (items.contains(weapon)) {
            println("Вы экипировали оружие: ${weapon.name}.")

        } else {
            println("У вас нет ${weapon.name} в инвентаре.")
        }
}