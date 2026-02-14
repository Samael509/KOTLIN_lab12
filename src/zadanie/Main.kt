package zadanie
import kotlin.properties.Delegates

fun main() {
    val manager = OutpostManager()
    val observer = ResourceObserver()

    val mineral = ObservableResource("Minerals", 100,)
    val gas = ObservableResource("Gas", 50,)

    manager.resources.add(mineral)
    manager.resources.add(gas)

    mineral.amount = 120
    gas.amount = 60

    StateStorage.save(manager.resources)

    val loadedResources = StateStorage.load()

    println("загруженные ресурсы:")
    loadedResources.forEach {
        println("${it.name}: ${it.amount}")
    }
}