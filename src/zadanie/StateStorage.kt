package zadanie

import java.io.File

object StateStorage {
    private const val FILE_NAME = "outpost_state.txt1"

    fun save(resources: List<ObservableResource>) {
        val file = File(FILE_NAME)
        file.writeText(
            resources.joinToString("\n") {
                "${it.name}|${it.amount}"
            }
        )
        println("состояние базы сохранено")
    }

    fun load(): List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) return emptyList()
        println("загрузка состояния базы")
        return file.readLines().map {
            val parts = it.split("|")
            val name = parts[0]
            val amount = parts[1].toInt()
            ObservableResource(name, amount)
        }
    }
}