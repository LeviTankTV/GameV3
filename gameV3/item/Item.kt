package gameV3.item

class Item(val name: String, val description: String) {
    override fun toString(): String {
        return "$name: $description"
    }
}