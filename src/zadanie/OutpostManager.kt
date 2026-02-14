package zadanie

class OutpostManager {
    val resources: MutableList<ObservableResource> by lazy {
        println("создаём менеджер ресурсов...")
        mutableListOf<ObservableResource>()
    }
}