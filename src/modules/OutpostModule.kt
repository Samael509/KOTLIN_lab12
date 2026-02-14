package modules

import resources.ResourceManager

abstract class OutpostModule(
    val name: String,
    var level: Int = 1
) {
    fun upgrade(){
        level++
        println("$name улучшен до $level")
    }
    abstract fun performAction(manager: ResourceManager) : ModuleResult
}