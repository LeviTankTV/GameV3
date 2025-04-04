package gameV3.entities.crystalCavern

import gameV3.entities.Entity
import gameV3.main.Game
import gameV3.room.Room
import kotlin.random.Random

class Ghost(name : String, description : String = "???", health : Long = 0, attackPower : Long = 0, defensePower : Long = 0, level : Int) : Entity(name, description, health, attackPower, defensePower, level) {
    override fun performAction(game: Game, room: Room) {
        println("Призрак атаковал вас и нанёс $attackPower урона!")
        changeStats()
    }

    private fun changeStats() {
        this.attackPower = Random.nextInt(100).toLong()
        this.health = Random.nextInt(100).toLong()
        this.defensePower = Random.nextInt(100).toLong()
        val names = listOf(
            "Александр", "Михаил", "Дмитрий", "Иван", "Сергей",
            "Андрей", "Алексей", "Артем", "Владимир", "Евгений",
            "Николай", "Павел", "Константин", "Максим", "Олег",
            "Роман", "Тимур", "Станислав", "Юрий", "Григорий",
            "Анна", "Мария", "Елена", "Ольга", "Наталья",
            "Ирина", "Татьяна", "Светлана", "Виктория", "Екатерина",
            "Анастасия", "Юлия", "Ксения", "Дарья", "Алина",
            "Полина", "Валерия", "София", "Александра", "Вероника"
        )

        this.name = names[Random.nextInt(names.size)]
    }
}