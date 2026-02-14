package modules

import resources.ResourceManager

class ResearchLab : OutpostModule(
    "исследовательская лаборатория"
) {
    override fun performAction(manager: ResourceManager) : ModuleResult {
        val minerals = manager.get("minerals")

        if(minerals == null || minerals.amount < 30){
            return ModuleResult.NotEnoughResources(
                resouceName = "minerals",
                required = 30,
                available = minerals?.amount ?: 0
            )
        } else{
            minerals.amount -= 30
            return ModuleResult.Success("исследование завершено")
        }
    }
}