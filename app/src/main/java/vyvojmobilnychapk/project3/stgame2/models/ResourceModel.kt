package vyvojmobilnychapk.project3.stgame2.models

sealed class ResourceModel(
    val name: String,
    val nameToDisplay: String
){

    object Wood : ResourceModel("1_wood","Drevo")
    object Brick : ResourceModel("2_brick","Tehly")
    object Iron : ResourceModel("3_iron","Železo")
    object People : ResourceModel("4_people","Zamestnanci")
    object Money : ResourceModel("5_money","Peniaze")

}