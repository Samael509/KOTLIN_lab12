import resources.OutpostResource
import java.io.File

object FileStorage {
    private const val FILE_NAME = "outpost_state.txt"

    fun save(resource: List<OutpostResource>) {
        val file = File(FILE_NAME)
        file.writeText(
            resource.joinToString("\n") {
                "${it.id.toString().padEnd(3)} | ${it.name.padEnd(10)} | ${it.amount}"
            }
        )
        println("состояние базы сохранено")
    }

    fun load(): List<OutpostResource>{
        val file = File(FILE_NAME)
        if (!file.exists()) return emptyList()
        println("загрузка состояние базы")
        return file.readLines().map {
            val (id, name, amount) = it.split(";")
            OutpostResource(id.toInt(), name, amount.toInt())
        }
    }
}