package gameV3.item

open class Item(val name: String, val description: String) {
    override fun toString(): String {
        return "$name: $description"
    }
}