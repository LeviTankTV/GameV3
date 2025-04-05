
package gameV3.room.crystalCave

import gameV3.main.Game
import gameV3.room.Room

class EchoFlowersRoom: Room(name = "Комната с Эхо - Цветами", description = "Вы находитесь в комнате с Эхо - Цветами") {
    override fun playerTurn(game: Game, room: Room) {
        when (game.echoCounter) {
            0 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- ...заключение... обязательно. Сила Бездонного Сердца не должна вырваться наружу.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            1 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- Но... риск... портал нестабилен. Если существо будет уничтожено...")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            2 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- ...уничтожение... не вариант. Заключение. Только заключение.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            3 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- Тогда кристальная пещера... Сердце будет подавлено кристаллами?")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            4 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- ...да. Резонанс... ограничит портал. Но наблюдение... необходимо.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            5 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- Но как мы сможем наблюдать? Если он пробудится, то...")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            6 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- ...не бойся. Я буду наблюдать через сны, а ты следи за стабильностью кристалов.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            7 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- Это приемлемо... Но... что будет если... кто-то... найдет его?")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            8 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- ...это маловероятно. Заблудшие души... редко доходят так глубоко.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            9 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- Но если... Они могут нарушить баланс")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            10 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- ...мы не можем предугадать каждый исход, но его сила слишком опасна что бы её игнорировать.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            11 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- Я буду там и смогу помешать им.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            12 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- ...хорошо. Следи за ним. Предупреди меня, если что-то изменится.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            13 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- А как мы будем его сдерживать если он всё-таки вырвется?")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            14 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- ...кристаллы... усилить резонанс. Но это рискованно... может разрушить всё вокруг.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            15 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- Уничтожить Голема нам не позволительно, ведь так?")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            16 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- ...Никогда. Только заточение.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            17 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- Что если мы поместим его в сон, пока он находится в кристалах?")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            18 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- ...Нельзя создавать сон во сне. Это может разрушить его разум... и портал.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            19 -> {
                println("Вы можете услышать часть разговора каких-то существ")
                println("- Тогда мы будем надеяться на лучшее.")
                game.echoCounter++
                handleEmptyRoom(game)
            }
            else -> handleEmptyRoom(game) // Или другая логика, если echoCounter > 19
        }
    }
}
