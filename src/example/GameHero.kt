package example
import kotlin.properties.Delegates

class GameHero(startName: String){
    var name: String by Delegates.observable(startName){
            _, old, new ->
        println("[$old] получил новое имя: $new")
    }
    var mana: Int by Delegates.observable(100){
            _, old, new ->
        println("мана: $old -> $new")
    }
    val ultimate: String by lazy {
        println("загружаем анимацию способности...")
        "метеоритный дождь"
    }
}

fun main(){
    println("создаём героя...")
    val hero = GameHero("воин тьмы")

    println("\nтекущая мана: ${hero.mana}")

    println("\nгерой пытается использовать способность:")
    println("способность: ${hero.ultimate}")

    println("\nменяем имя:")
    hero.name = "тёмный паладин"

    println("\nгерой вовсстанавливает ману")
    hero.mana = 200
}