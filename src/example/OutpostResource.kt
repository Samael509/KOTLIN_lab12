package example
import kotlin.math.min
import kotlin.properties.Delegates

data class OutpostResource(
    val id: Int,
    val name: String,
    val amountInit: Int
) {
    var amount: Int by Delegates.observable(amountInit) { _, old, new ->
        println("ресурс [$name] изменился: $old -> $new")
    }
}

fun main(){
    val gas = OutpostResource(1, "Gas", 100)
    val mineral = OutpostResource(2, "Minerals", 250)
    println("успех. вы добыли доп. минералы: ${mineral.amount + 50}")
    val bonusMineral = mineral.copy(id = 3, name = "Mineral Bonus", amountInit = mineral.amount + 50)
    println(gas.toString())
    println(mineral.toString())
    println(bonusMineral.toString())
}