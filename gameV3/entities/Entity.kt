package gameV3.entities

open class Entity(
    var name: String,           // Имя сущности
    var description: String,    // Описание сущности
    var health: Int,           // Здоровье сущности
    var attackPower: Int,      // Сила атаки
    var defensePower: Int,     // Сила защиты
    var level: Int,          // Уровень сущности
    var species: String = "",    // Вид сущности
    var habitat: String = ""    // Среда обитания сущнос
) {

    fun isAlive(): Boolean {
        if (health > 0) {
            return true
        }
        return false
    }


    fun receiveDamage(damage: Int) {
        val actualDamage = damage - defensePower
        health -= if (actualDamage > 0) actualDamage else 0
        if (health <= 0) {
            die()
        }
    }

    fun die() {
        println("$name растворился во тьме.")
    }
}