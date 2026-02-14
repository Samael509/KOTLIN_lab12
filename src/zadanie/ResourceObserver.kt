package zadanie
import kotlin.properties.Delegates

class ResourceObserver {
    fun onResourceChanged(resource: ObservableResource, oldAmount: Int, newAmount: Int) {
        println("наблюдатель: ресурс ${resource.name} изменён: $oldAmount → $newAmount")
    }
}