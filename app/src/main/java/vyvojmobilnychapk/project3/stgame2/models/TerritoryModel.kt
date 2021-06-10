package vyvojmobilnychapk.project3.stgame2.models

data class TerritoryModel(
    val id:Int,
    val isRadioactive: Boolean,
    val neighbours: Set<TerritoryModel>,
    val numberOfEstates: Int,
    val buildings: Map<BuildingModel,Int>,
    val points: Int

)