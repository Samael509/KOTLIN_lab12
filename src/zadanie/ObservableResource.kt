package zadanie

import kotlin.properties.Delegates

class ObservableResource(val name: String, amount: Int) {
    var amount: Int by Delegates.observable(amount) { _, old, new ->
        println("ресурс $name изменён: $old → $new")
    }
}