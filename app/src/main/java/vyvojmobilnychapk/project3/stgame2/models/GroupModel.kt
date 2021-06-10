package vyvojmobilnychapk.project3.stgame2.models

data class GroupModel(
    val id:Int,
    val name:String,
    var resources: Map<ResourceModel,Int>,
    var territories: Set<TerritoryModel>,
    val points:Int
)