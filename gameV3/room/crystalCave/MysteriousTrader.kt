
package gameV3.room.crystalCave

import gameV3.item.Item
import gameV3.item.consumable.Crystal
import gameV3.item.other.*
import gameV3.item.throwable.CrystalDagger
import gameV3.item.throwable.Fire
import gameV3.item.throwable.LavaDagger
import gameV3.item.throwable.Rock
import gameV3.item.weapon.swords.CrystalSword
import gameV3.item.weapon.swords.LavaSword
import gameV3.main.Game
import gameV3.room.Room

class MysteriousTrader : Room(name = "Таинственный Торговец", description = "Вы находитесь возле таинственного торговца. Он смотрит на вас странным взглядом.") {

    private val merchantInventory = mutableListOf<Item>()

    init {
        // Начальный ассортимент торговца (можно добавить другие предметы)
        merchantInventory.add(Crystal())
        merchantInventory.add(GoldBar())
        merchantInventory.add(LavaDagger())
        merchantInventory.add(LavaSword())
        merchantInventory.add(Fire())
        merchantInventory.add(ShadowCrystalBook())
        merchantInventory.add(CrystalSmallSlimeEgg())
        merchantInventory.add(Rock())
        merchantInventory.add(CrystalSword())
        merchantInventory.add(HealSpellBook())
        merchantInventory.add(CrystalDagger())
        merchantInventory.add(SlidingCrystalWormEgg())
        merchantInventory.add(CaveCrystalGryphonEgg())
        merchantInventory.add(GlowingCrystalLizardEgg())
        merchantInventory.add(CrystalRhinocerosBeetleEgg())
        merchantInventory.add(CrystalManticoreEgg())
        merchantInventory.add(Diamond())
        merchantInventory.add(Emerald())
        merchantInventory.add(IronBar())
    }

    override fun playerTurn(game: Game, room: Room) {
        println("\nВы находитесь возле Таинственного Торговца.")
        println(description)
        showOptions(game)
    }

    private fun showOptions(game: Game) {
        println("\nЧто вы хотите сделать?")
        println("1. Купить")
        println("2. Продать")
        println("3. Уйти")

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
            println("${index + 1}. ${item.name} - ${getItemPrice(item) / 4} золота") // Продажа в 4 раза дешевле покупки
        }
        println("0. Назад")

        when (val choice = readlnOrNull()?.toIntOrNull()) {
            null, 0 -> showOptions(game)
            in 1..playerInventoryList.size -> {  // Use the size of the inventory list
                val selectedItem = playerInventoryList[choice - 1]
                val price = getItemPrice(selectedItem) / 4 // Продажа в 4 раза дешевле
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
            is Crystal -> 500
            is GoldBar -> 2000
            is LavaDagger -> 3000
            is LavaSword -> 5000
            is Fire -> 1000
            is ShadowCrystalBook -> 4000
            is CrystalSmallSlimeEgg -> 2500
            is Rock -> 10
            is CrystalSword -> 6000
            is HealSpellBook -> 3500
            is CrystalDagger -> 2800
            is SlidingCrystalWormEgg -> 3000
            is CaveCrystalGryphonEgg -> 5000
            is GlowingCrystalLizardEgg -> 1500
            is CrystalRhinocerosBeetleEgg -> 6000
            is CrystalManticoreEgg -> 10000
            is Diamond -> 8000
            is Emerald -> 6500
            is IronBar -> 1500
            else -> 10 // Базовая цена для других предметов
        }
    }
}
