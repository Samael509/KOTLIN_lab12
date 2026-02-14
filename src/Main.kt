import example.Messenger
import modules.EnergyGenerator
import modules.ModuleResult
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager

object SystemLogger{
    init{
        println("SystemLogger инициализирован")
    }
    fun log(message: String){
        println("[LOG] $message")
    }
}
val logger by lazy {
    SystemLogger
}

fun main() {
    //    val manager = resources.ResourceManager()
//    val gas = OutpostResource(1, "Gas", 2)
//    val mineral = OutpostResource(2, "mineral", 129)
//    manager.add(gas)
//    manager.add(mineral)
//    manager.printAll()
//    val bonusMiniral = mineral.copy(id = 3, amount = mineral.amount + 60)
//    println("бонусные минералы: $bonusMiniral")
    fun handModuleResult(result: ModuleResult) {
        when (result) {
            is ModuleResult.Success ->
                println("успех: ${result.message}")

            is ModuleResult.ResourceProduced ->
                println("произведено: ${result.resourceName} +${result.amount}")

            is ModuleResult.NotEnoughResources ->
                println(
                    "недостаточно ресурса ${result.resouceName}" + "нужно: ${result.required}, есть: ${result.available}"
                )

            is ModuleResult.Error ->
                println("ошибка: ${result.reason}")
        }
    }

    val manager = ResourceManager()
    manager.add(OutpostResource(1, "minerals", 120))
    manager.add(OutpostResource(2, "gas", 50))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handModuleResult(generatorResult)
    handModuleResult(labResult)
    println()
    manager.printAll()

    logger.log("запуск базы")
    val loadedResources = FileStorage.load()
    loadedResources.forEach { manager.add(it) }
    if (loadedResources.isEmpty()){
        manager.add(OutpostResource(1, "Minerals", 300))
        manager.add(OutpostResource(2, "gas", 100))
        FileStorage.save(manager.getAll())

    }
}