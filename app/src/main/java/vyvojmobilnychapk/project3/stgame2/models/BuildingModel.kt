package vyvojmobilnychapk.project3.stgame2.models

data class BuildingModel(
    val name:String,
    val nameToDisplay:String,
    val cost:Map<ResourceModel,Int>,
    val profit: Map<ResourceModel,Int>,
    val profitInstant : Map<ResourceModel,Int>,
    val points: Int
)