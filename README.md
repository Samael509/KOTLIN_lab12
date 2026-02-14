# Изученные темы и примеры в Kotlin

## Делегирование свойств
Делегирование свойств позволяет делегировать логику хранения и обработки значения другому объекту. В Kotlin это реализуется с помощью ключевого слова `by`. Такой подход помогает уменьшить дублирование кода, сделать его более чистым и централизовать логику проверки и обработки данных.

**Пример:** Ограничение диапазона значения энергии (используйте Delegates.observable для отслеживания изменений):

```k
import kotlin.properties.Delegates

var energy: Int by Delegates.observable(100) { _, old, new ->
    println("Энергия изменилась: $old → $new")
}
```
## Lazy (ленивая инициализация)
lazy позволяет инициализировать объект только при первом обращении к нему. Это полезно, если объект создаётся не всегда, его создание ресурсоёмкое или нужно отложить инициализацию.

Пример: Создание менеджера ресурсов, который инициализируется только при первом использовании:
```kotlin
val resourceManager by lazy {
    ResourceManager()
}
```
Объект ResourceManager будет создан только при первом вызове resourceManager.

## Обсервер-паттерн (наблюдатель)
Обсервер-паттерн позволяет объектам реагировать на изменения состояния другого объекта. В Kotlin его можно реализовать с помощью делегатов Delegates.observable. В проекте Galaxy Outpost Manager наблюдатели могут реагировать на изменение ресурсов, логировать события или уведомлять пользователя.

Пример идеи: Менеджер ресурсов изменяет ресурсы, а наблюдатель выводит сообщение при изменении:
```
import kotlin.properties.Delegates

var energy: Int by Delegates.observable(100) { _, old, new ->
    println("Энергия изменилась: $old → $new")
}
```
## Сохранение состояния
Пример:
```k
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
```