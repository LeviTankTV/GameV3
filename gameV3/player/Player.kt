package gameV3.player

import gameV3.entities.Entity
import gameV3.entities.allies.Ally
import gameV3.item.*
import gameV3.item.Throwable
import gameV3.item.weapon.Weapon
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class Player(
    name: String,
    description: String = "Игрок",
    health: Long = 1000,
    attackPower: Long = 10,
    defensePower: Long = 5,
    level: Int = 100,
    var experience: Int = 0,
    var gold: Int = 0,
    var mana: Int = 0

//    var inventory: Inventory,
//    var allies: List<Ally>
) : Entity(name, description, health, attackPower, defensePower, level) {
    var inventory = Inventory()
    var allies = mutableListOf<Entity>()
    var astral = Astral()

    fun addMana(mana: Int) {
        this.mana += mana
    }

    fun removeMana(mana: Int) {
        this.mana -= mana
    }

    fun addAlly(ally: Entity) {
        allies = (allies + ally).toMutableList()
    }

    fun removeAlly(ally: Entity) {
        allies = (allies - ally).toMutableList()
    }
    fun addXP(xp: Int) {
        experience += xp
        if (experience >= level * 100) {
            levelUp();
            println("$name повышает свой уровень!")
        }
    }

    fun increaseStats() {
        attackPower += 2;
        defensePower += 1;
        health += 20;
    }

    fun levelUp() {
        level++
        experience -= level * 100
        increaseStats()
    }



    fun playerAction(game: Game, room: Room) : Boolean  {

        when (game.gameStage) {
            1 -> {
                val enemies = room.enemies

                // Переменные для отслеживания статуса корней
                var sideRoot1Broken = false
                var sideRoot2Broken = false
                var sideRoot3Broken = false
                var sideRoot4Broken = false
                var sideRoot5Broken = false

                while (enemies[0].health > 0) { // Пока враг (главный корень) жив
                    val phrases = mutableListOf(
                        "Сердце леса не ждёт.",
                        "Ваша судьба в ваших руках.",
                        "Время наступило.",
                        "Вы наполнены решимостью.",
                        "Атакуйте!",
                        "Вам не сбежать от судьбы."
                    )
                    val randomPhrase = phrases[Random.nextInt(phrases.size)]
                    println("$randomPhrase Выберете действие:")

                    // Формируем список доступных действий
                    val availableActions = mutableListOf<String>()
                    var actionCounter = 1

                    if (!sideRoot1Broken) {
                        availableActions.add("${actionCounter++}. Попытаться сломать побочный корень 1 (Шанс: 40%)")
                    }
                    if (!sideRoot2Broken) {
                        availableActions.add("${actionCounter++}. Попытаться сломать побочный корень 2 (Шанс: 25%)")
                    }
                    if (!sideRoot3Broken) {
                        availableActions.add("${actionCounter++}. Попытаться сломать побочный корень 3 (Шанс: 15%)")
                    }
                    if (!sideRoot4Broken) {
                        availableActions.add("${actionCounter++}. Попытаться сломать побочный корень 4 (Шанс: 10%)")
                    }
                    if (!sideRoot5Broken) {
                        availableActions.add("${actionCounter++}. Попытаться сломать побочный корень 5 (Шанс: 5%)")
                    }

                    availableActions.add("${actionCounter++}. Показать список врагов") // Добавляем опцию "Показать врагов"

                    // Выводим доступные действия
                    availableActions.forEach { println(it) }

                    var choice = readlnOrNull()?.toIntOrNull() ?: -1 // Обработка ввода пользователя

                    when (choice) {
                        1 -> {
                            if (!sideRoot1Broken) {
                                val chance = Random.nextInt(1, 101)
                                if (chance <= 40) {
                                    sideRoot1Broken = true
                                    println("Вы успешно сломали побочный корень 1!")
                                } else {
                                    println("Вы не смогли сломать побочный корень 1.")
                                }
                            } else {
                                println("Неверный выбор. Попробуйте снова.")
                            }
                        }
                        2 -> {
                            if (!sideRoot2Broken) {
                                val chance = Random.nextInt(1, 101)
                                if (chance <= 25) {
                                    sideRoot2Broken = true
                                    println("Вы успешно сломали побочный корень 2!")
                                } else {
                                    println("Вы не смогли сломать побочный корень 2.")
                                }
                            } else {
                                println("Неверный выбор. Попробуйте снова.")
                            }
                        }
                        3 -> {
                            if (!sideRoot3Broken) {
                                val chance = Random.nextInt(1, 101)
                                if (chance <= 15) {
                                    sideRoot3Broken = true
                                    println("Вы успешно сломали побочный корень 3!")
                                } else {
                                    println("Вы не смогли сломать побочный корень 3.")
                                }
                            } else {
                                println("Неверный выбор. Попробуйте снова.")
                            }
                        }
                        4 -> {
                            if (!sideRoot4Broken) {
                                val chance = Random.nextInt(1, 101)
                                if (chance <= 10) {
                                    sideRoot4Broken = true
                                    println("Вы успешно сломали побочный корень 4!")
                                } else {
                                    println("Вы не смогли сломать побочный корень 4.")
                                }
                            } else {
                                println("Неверный выбор. Попробуйте снова.")
                            }
                        }
                        5 -> {
                            if (!sideRoot5Broken) {
                                val chance = Random.nextInt(1, 101)
                                if (chance <= 5) {
                                    sideRoot5Broken = true
                                    println("Вы успешно сломали побочный корень 5!")
                                } else {
                                    println("Вы не смогли сломать побочный корень 5.")
                                }
                            } else {
                                println("Неверный выбор. Попробуйте снова.")
                            }
                        }

                        actionCounter -> {  // Действие "Показать список врагов"
                            println("Список врагов:")
                            for (i in enemies.indices) {
                                println("${i + 1}. ${enemies[i].name} (Здоровье: ${enemies[i].health})")
                                enemies[i].showStats() // Вызываем метод showStats для каждого врага
                            }
                        }

                        else -> {
                            println("Неверный выбор. Попробуйте снова.")
                        }
                    }

                    // Проверяем, все ли боковые корни сломаны
                    if (sideRoot1Broken && sideRoot2Broken && sideRoot3Broken && sideRoot4Broken && sideRoot5Broken) {
                        enemies[0].defensePower = 200
                        println("Все побочные корни сломаны! Главный корень становится уязвимым!")

                        // Добавляем возможность атаковать, когда корни уничтожены
                        availableActions.clear()
                        availableActions.add("1. Атаковать")
                        availableActions.add("2. Показать список врагов")

                        println("Выберите действие:")
                        availableActions.forEach { println(it) }

                        var choice2 = readlnOrNull()?.toIntOrNull() ?: -1

                        when (choice2) {
                            1 -> {
                                // Выбор врага для атаки
                                println("Выберите врага для атаки:")
                                for (i in enemies.indices) {
                                    println("${i + 1}. ${enemies[i].name} (Здоровье: ${enemies[i].health})")
                                }

                                val enemyChoice = readlnOrNull()?.toIntOrNull() ?: -1

                                if (enemyChoice > 0 && enemyChoice <= enemies.size) {
                                    val targetEnemy = enemies[enemyChoice - 1]

                                    if (enemyChoice - 1 == 0) { // Attacking the main boss (enemies[0])
                                        val damage = Random.nextInt(2, 6) // 2-5% урона
                                        val damageAmount = (targetEnemy.maxHealth * (damage.toDouble() / 100)).toInt()
                                        targetEnemy.health -= damageAmount
                                        println("Вы атакуете ${targetEnemy.name} и наносите $damageAmount урона! ( $damage % )")
                                        println("${targetEnemy.name}: ${targetEnemy.health}")

                                    } else { // Attacking other enemies (instant kill)
                                        println("Вы мгновенно убиваете ${targetEnemy.name}!")
                                        enemies.removeAt(enemyChoice - 1)

                                        if (enemies.isEmpty()) {
                                            println("Вы победили!")
                                            return true
                                        }
                                    }


                                    if (targetEnemy.health <= 0 && enemyChoice -1 == 0) {
                                        println("Вы убили ${targetEnemy.name}!")
                                        println("Вы победили!")
                                        return true
                                    }
                                } else {
                                    println("Неверный выбор врага. Попробуйте снова.")
                                }
                            }

                            2 -> {
                                println("Список врагов:")
                                for (i in enemies.indices) {
                                    println("${i + 1}. ${enemies[i].name}")
                                    enemies[i].showStats()
                                }
                            }

                            else -> {
                                println("Неверный выбор. Попробуйте снова.")
                            }
                        }
                    } else { // If main root isn't vulnerable we shouldn't show attack
                        availableActions.clear()
                        if (!sideRoot1Broken) {
                            availableActions.add("${1}. Попытаться сломать побочный корень 1 (Шанс: 40%)")
                        }
                        if (!sideRoot2Broken) {
                            availableActions.add("${1}. Попытаться сломать побочный корень 2 (Шанс: 25%)")
                        }
                        if (!sideRoot3Broken) {
                            availableActions.add("${1}. Попытаться сломать побочный корень 3 (Шанс: 15%)")
                        }
                        if (!sideRoot4Broken) {
                            availableActions.add("${1}. Попытаться сломать побочный корень 4 (Шанс: 10%)")
                        }
                        if (!sideRoot5Broken) {
                            availableActions.add("${1}. Попытаться сломать побочный корень 5 (Шанс: 5%)")
                        }
                        if(availableActions.isNotEmpty())
                        {
                            var choice3 = readlnOrNull()?.toIntOrNull() ?: -1 // Обработка ввода пользователя

                            when (choice3) {
                                1 -> {
                                    if (!sideRoot1Broken) {
                                        val chance = Random.nextInt(1, 101)
                                        if (chance <= 40) {
                                            sideRoot1Broken = true
                                            println("Вы успешно сломали побочный корень 1!")
                                        } else {
                                            println("Вы не смогли сломать побочный корень 1.")
                                        }
                                    } else {
                                        println("Неверный выбор. Попробуйте снова.")
                                    }
                                }
                                2 -> {
                                    if (!sideRoot2Broken) {
                                        val chance = Random.nextInt(1, 101)
                                        if (chance <= 25) {
                                            sideRoot2Broken = true
                                            println("Вы успешно сломали побочный корень 2!")
                                        } else {
                                            println("Вы не смогли сломать побочный корень 2.")
                                        }
                                    }else {
                                        println("Неверный выбор. Попробуйте снова.")
                                    }
                                }
                                3 -> {
                                    if(!sideRoot3Broken){
                                        val chance = Random.nextInt(1, 101)
                                        if (chance <= 15) {
                                            sideRoot3Broken = true
                                            println("Вы успешно сломали побочный корень 3!")
                                        } else {
                                            println("Вы не смогли сломать побочный корень 3.")
                                        }
                                    } else {
                                        println("Неверный выбор. Попробуйте снова.")
                                    }
                                }
                                4 -> {
                                    if(!sideRoot4Broken){
                                        val chance = Random.nextInt(1, 101)
                                        if (chance <= 10) {
                                            sideRoot4Broken = true
                                            println("Вы успешно сломали побочный корень 4!")
                                        } else {
                                            println("Вы не смогли сломать побочный корень 4.")
                                        }
                                    }else {
                                        println("Неверный выбор. Попробуйте снова.")
                                    }
                                }
                                5 -> {
                                    if(!sideRoot5Broken){
                                        val chance = Random.nextInt(1, 101)
                                        if (chance <= 5) {
                                            sideRoot5Broken = true
                                            println("Вы успешно сломали побочный корень 5!")
                                        } else {
                                            println("Вы не смогли сломать побочный корень 5.")
                                        }
                                    }else {
                                        println("Неверный выбор. Попробуйте снова.")
                                    }
                                }

                                else -> {
                                    println("Неверный выбор. Попробуйте снова.")
                                }
                            }
                        }
                        else {
                            println("Все корни сломаны, но не получилось победить врага")
                        }


                    }

                    // Проверяем, не победили ли мы врага
                    if (enemies[0].health <= 0) {
                        println("Вы победили Сердце Леса!")
                        room.clearEnemies()
                        return true
                    }
                }
            }

            2 -> {
                println("Бой в малиновом лесу продолжается. Выберите действие:")
                println("1. Атаковать")
                println("2. Использовать инвентарь")
                println("3. Посмотреть характеристику игрока")
                println("4. Посмотреть характеристику астрала")
                println("4. Посмотреть характеристику врагов")

                var choice = readlnOrNull()?.toIntOrNull() ?: -1 // Обработка ввода пользователя

                when (choice) {
                    1 -> {
                        println("Выберите врага:")
                        for (enemy in room.enemies) {
                            println("${room.enemies.indexOf(enemy) + 1}. ${enemy.name}")
                        }
                        val enemyChoice = readlnOrNull()?.toIntOrNull() ?: -1 // Обработка ввода пользователя
                        if (enemyChoice in 1..room.enemies.size) {
                            val enemy = room.enemies[enemyChoice - 1]
                            attack(weapon, enemy)
                            return true
                        } else {
                            println("Неверный выбор. Попробуйте снова.")
                        }
                    }
                    2 -> {
                        useInventory(game, room)
                    }
                    3 -> {
                        showPlayerStats(game)
                    }
                    4 -> {
                        showAstralStats(game)
                    }
                    5 -> {
                        showEnemiesStats(room)
                    }
                    else -> {
                        println("Неверный выбор. Попробуйте снова.")
                    }
                }

            }

            -1 -> {
                println("Бой в муравейнике продолжается. Выберите действие:")
                println("1. Атаковать")
                println("2. Использовать инвентарь")
                println("3. Посмотреть характеристику игрока")
                println("4. Посмотреть характеристику астрала")
                println("4. Посмотреть характеристику врагов")

                var choice = readlnOrNull()?.toIntOrNull() ?: -1 // Обработка ввода пользователя

                when (choice) {
                    1 -> {
                        println("Выберите врага:")
                        for (enemy in room.enemies) {
                            println("${room.enemies.indexOf(enemy) + 1}. ${enemy.name}")
                        }
                        val enemyChoice = readlnOrNull()?.toIntOrNull() ?: -1 // Обработка ввода пользователя
                        if (enemyChoice in 1..room.enemies.size) {
                            val enemy = room.enemies[enemyChoice - 1]
                            attack(weapon, enemy)
                            return true
                        } else {
                            println("Неверный выбор. Попробуйте снова.")
                        }
                    }
                    2 -> {
                        useInventory(game, room)
                    }
                    3 -> {
                        showPlayerStats(game)
                    }
                    4 -> {
                        showAstralStats(game)
                    }
                    5 -> {
                        showEnemiesStats(room)
                    }
                    else -> {
                        println("Неверный выбор. Попробуйте снова.")
                    }
                }
            }

            3 -> {

            }

            4 -> {

            }

            5 -> {

            }
        }
        return true
    }

    private fun showPlayerStats(game: Game) {
        println("Имя: ${game.player.name}")
        println("Здоровье: ${game.player.health}")
        println("Уровень: ${game.player.level}")
        println("Опыт: ${game.player.experience}")
        println("Оружие: ${game.player.weapon?.name}")
        println("Сила атаки: ${game.player.attackPower}")
        println("Защита: ${game.player.defensePower}")
    }

    private fun showAstralStats(game: Game) {
        println("Имя: ${game.player.astral.name}")
        println("Здоровье: ${game.player.astral.health}")
    }

    private fun showEnemiesStats(room: Room) {
        for (enemy in room.enemies) {
            println("Имя: ${enemy.name}")
            println("Здоровье: ${enemy.health}")
            println("Уровень: ${enemy.level}")
        }
    }

    private fun useInventory(game: Game, room: Room) {
        println("Вы в меню инвентаря. Выберите действие:")
        println("1. Экипировать / снять оружие")
        println("2. Использовать предмет из инвентаря")
        if (game.player.inventory.findAmulets()) {
            println("3. Экипировать / снять амулет")
        }
        val input = readlnOrNull()?.toInt()
        when (input) {
            1 -> {
                println("Ваше текущее оружие: ${game.player.weapon?.name}")
                println("Выберите действие:")
                println("1. Экипировать оружие")
                println("2. Снять оружие")
                val weaponChoice = readlnOrNull()?.toInt()
                when (weaponChoice) {
                    1 -> {
                        println("Выберите оружие из инвентаря:")
                        for (item in game.player.inventory.items) {
                            if (item is Weapon) {
                                println("${game.player.inventory.items.indexOf(item) + 1}. ${item.name}")
                            }
                        }
                        val itemChoice = readlnOrNull()?.toInt()
                        if (itemChoice != null) {
                            val item = game.player.inventory.items[itemChoice - 1]
                            if (item is Weapon) {
                                game.player.weapon = item
                                game.player.inventory.removeItem(item)
                            }
                        }
                    }
                    2 -> {
                        weapon?.let { game.player.inventory.addItem(it) }
                        game.player.weapon = null
                    }
                    else -> println("Неверный выбор. Попробуйте снова.")
                }
            }
            2 -> {
                println("Выберите предмет из инвентаря:")
                for (item in game.player.inventory.items) {
                    println("${game.player.inventory.items.indexOf(item) + 1}. ${item.name}")
                }
                val itemChoice = readlnOrNull()?.toInt()
                if (itemChoice != null) {
                    when (val item = game.player.inventory.items[itemChoice - 1]) {
                        is Consumable -> item.eat(game)
                        is Throwable -> {
                            println("Выберите врага:")
                            for (enemy in room.enemies) {
                                println("${room.enemies.indexOf(enemy) + 1}. ${enemy.name}")
                            }
                            val enemyChoice = readlnOrNull()?.toIntOrNull() ?: -1 // Обработка ввода пользователя
                            if (enemyChoice in 1..room.enemies.size) {
                                val enemy = room.enemies[enemyChoice - 1]
                                item.throwAt(enemy)
                                game.player.inventory.removeItem(item)
                            }
                        }
                        is Weapon -> {
                            println("Вы не можете использовать оружие в инвентаре.")
                        }
                        is MultiThrowable -> {
                            item.throwAt(room.enemies)
                            game.player.inventory.removeItem(item)
                        }
                        else -> {
                            item.use(game)
                            game.player.inventory.removeItem(item)
                        }
                    }
                }
            }
            3 -> {
                println("Текущий талисман: ${game.player.inventory.activeTalisman?.name}")
                println("Выберите действие:")
                println("1. Экипировать талисман")
                println("2. Снять талисман")
                val talismanChoice = readlnOrNull()?.toInt()
                when (talismanChoice) {
                    1 -> {
                        println("Выберите талисман из инвентаря:")
                        for (item in game.player.inventory.items) {
                            if (item is Talisman) {
                                println("${game.player.inventory.items.indexOf(item) + 1}. ${item.name}")
                            }
                        }
                        val itemChoice = readlnOrNull()?.toInt()
                        if (itemChoice != null) {
                            val item = game.player.inventory.items[itemChoice - 1]
                            if (item is Talisman) {
                                game.player.inventory.removeItem(item)
                                game.player.inventory.addItem(game.player.inventory.activeTalisman!!)
                                game.player.inventory.activeTalisman = item
                                item.equip(game)
                            }
                        }
                    }
                    2 -> {
                        if (game.player.inventory.activeTalisman != null) {
                            (game.player.inventory.activeTalisman as Talisman).unequip(game)
                            game.player.inventory.addItem(game.player.inventory.activeTalisman!!)
                            game.player.inventory.activeTalisman = null
                        }
                    }
                }
            }
            else -> println("Неверный выбор. Попробуйте снова.")
        }


    }


}