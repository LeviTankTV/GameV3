package gameV3.room.crimsonChimes

import gameV3.item.Item
import gameV3.item.consumable.CrimsonHealthPotion
import gameV3.item.consumable.CrimsonNestPotion
import gameV3.item.consumable.InvisibilityPotion
import gameV3.item.keys.AncientKey
import gameV3.item.other.CrimsonPandoraBox
import gameV3.item.talisman.CrimsonTalisman
import gameV3.item.throwable.SpikesDagger
import gameV3.item.weapon.bows.CrimsonBow
import gameV3.item.weapon.gloves.CrimsonGloves
import gameV3.item.weapon.gloves.OldCrimsonGloves
import gameV3.item.weapon.swords.CrimsonSword
import gameV3.item.weapon.swords.OldCrimsonSword
import gameV3.main.Game
import gameV3.room.Room
import gameV3.item.weapon.bows.OldCrimsonBow
import gameV3.item.weapon.staffs.CrimsonStaff
import gameV3.item.weapon.staffs.OldCrimsonStaff

class CrimsonMarketplace : Room(name = "Малиновый Рынок", description = "Место для покупки / продажи") {

    private val merchantInventory = mutableListOf<Item>()

    init {
        // Начальный ассортимент торговца (можно добавить другие предметы)
        merchantInventory.add(CrimsonNestPotion())
        merchantInventory.add(InvisibilityPotion())
        merchantInventory.add(CrimsonPandoraBox())
        merchantInventory.add(SpikesDagger())
        merchantInventory.add(CrimsonHealthPotion())
        merchantInventory.add(CrimsonGloves())
        merchantInventory.add(OldCrimsonGloves())
        merchantInventory.add(CrimsonSword())
        merchantInventory.add(OldCrimsonSword())
        merchantInventory.add(CrimsonBow())
        merchantInventory.add(OldCrimsonBow())
        merchantInventory.add(CrimsonStaff())
        merchantInventory.add(OldCrimsonStaff())
        merchantInventory.add(AncientKey())
        merchantInventory.add(CrimsonTalisman())
    }

    override fun playerTurn(game: Game, room: Room) {
        println("\nВы на Малиновом Рынке.")
        println(description)
        showOptions(game)
    }

    private fun showOptions(game: Game) {
        println("\nЧто вы хотите сделать?")
        println("1. Купить")
        println("2. Продать")
        println("3. Уйти с рынка")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> buy(game)
            2 -> sell(game)
            3 -> handleEmptyRoom(game)
            else -> {
                println("Неверный выбор.")
                showOptions(game)
            }
        }
    }

    private fun buy(game: Game) {
        println("\nЧто вы хотите купить?")
        if (merchantInventory.isEmpty()) {
            println("У торговца ничего нет на продажу.")
            showOptions(game)
            return
        }

        for ((index, item) in merchantInventory.withIndex()) {
            println("${index + 1}. ${item.name} - ${getItemPrice(item)} золота")
        }
        println("0. Назад")

        when (val choice = readlnOrNull()?.toIntOrNull()) {
            null, 0 -> showOptions(game)
            in 1..merchantInventory.size -> {
                val selectedItem = merchantInventory[choice - 1]
                val price = getItemPrice(selectedItem)

                if (game.player.gold >= price) {
                    game.player.gold -= price
                    game.player.inventory.addItem(selectedItem)
                    merchantInventory.removeAt(choice - 1)
                    println("Вы купили ${selectedItem.name} за $price золота.")
                    println("У вас осталось ${game.player.gold} золота.")
                } else {
                    println("Недостаточно золота.")
                }
                buy(game) // Вернуться к меню покупки
            }
            else -> {
                println("Неверный выбор.")
                buy(game)
            }
        }
    }

    private fun sell(game: Game) {
        println("\nЧто вы хотите продать?")
        if (game.player.inventory.isEmpty()) {
            println("У вас ничего нет на продажу.")
            showOptions(game)
            return
        }

        val playerInventoryList = game.player.inventory.items // Get the list of items

        for ((index, item) in playerInventoryList.withIndex()) {
            println("${index + 1}. ${item.name} - ${getItemPrice(item) / 2} золота") // Продажа вдвое дешевле покупки
        }
        println("0. Назад")

        when (val choice = readlnOrNull()?.toIntOrNull()) {
            null, 0 -> showOptions(game)
            in 1..playerInventoryList.size -> {  // Use the size of the inventory list
                val selectedItem = playerInventoryList[choice - 1]
                val price = getItemPrice(selectedItem) / 2 // Продажа вдвое дешевле
                game.player.gold += price
                game.player.inventory.removeItem(selectedItem)
                merchantInventory.add(selectedItem) // Добавляем предмет торговцу
                println("Вы продали ${selectedItem.name} за $price золота.")
                println("У вас теперь ${game.player.gold} золота.")
                sell(game) // Вернуться к меню продажи
            }
            else -> {
                println("Неверный выбор.")
                sell(game)
            }
        }
    }

    private fun getItemPrice(item: Item): Int {
        return when (item) {
            is AncientKey -> 2500
            is CrimsonTalisman -> 1500
            is CrimsonHealthPotion -> 200
            is CrimsonNestPotion -> 300
            is InvisibilityPotion -> 400
            is CrimsonPandoraBox -> 1000
            is SpikesDagger -> 800  // Увеличил цену, чтобы отразить его ценность
            is CrimsonGloves -> 600  // Обычные перчатки
            is OldCrimsonGloves -> 1200  // Старые перчатки лучше
            is CrimsonSword -> 1000
            is OldCrimsonSword -> 2000  // Старый меч значительно лучше
            is CrimsonBow -> 1200
            is OldCrimsonBow -> 2500  // Старый лук лучше
            is CrimsonStaff -> 1100
            is OldCrimsonStaff -> 2200  // Старый посох лучше
            else -> 100 // Базовая цена для других предметов
        }
    }

}