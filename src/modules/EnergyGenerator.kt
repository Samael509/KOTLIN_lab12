package modules

import resources.OutpostResource
import resources.ResourceManager

class EnergyGenerator : OutpostModule("генератор энергии") {
    override fun performAction(manager: ResourceManager) : ModuleResult {
        println("генератор работает... производит 20 энергии")
        val energy = manager.get("energy")

        return if(energy != null){
            energy.amount += 20
            ModuleResult.ResourceProduced("energy", 20)
        } else {
            manager.add(OutpostResource(99, "energy", 20))
            ModuleResult.Success("энергия создана впервые")
        }
    }
}