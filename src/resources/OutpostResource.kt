package resources

data class OutpostResource(
    val id: Int,
    val name: String,
    var amount: Int
){
    override fun toString(): String {
        return "ваш ресурс: $id | имя: $name | кол-во: $amount"
    }
}

fun main(){
    val gas = OutpostResource(1, "gas", 100)
    val mineral = OutpostResource(2, "miniral", 140)
    println("добыто доп. ресурсы: ${mineral.amount + 60}!")
    val bonusMiniral = mineral.copy(id = 3, amount = mineral.amount + 60)
    println(gas.toString())
    println(mineral.toString())
    println(bonusMiniral.toString())
}