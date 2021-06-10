package vyvojmobilnychapk.project3.stgame2.models

abstract class GameModel(
    val groups: Set<GroupModel>,
    val resourcesSet: Set<ResourceModel>,
    val buildingSet: Set<BuildingModel>,
    val territoriesSet: Set<TerritoryModel>
)