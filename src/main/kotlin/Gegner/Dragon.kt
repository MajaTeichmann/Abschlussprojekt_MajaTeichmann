package Gegner
class Dragon : Gegner() {
    val flaechenSchadenRange = 150..300
    val flaechenSchaden = flaechenSchadenRange.random()

    val feuerAtemSchadenRange = 75..100
    val feuerAtemSchaden = feuerAtemSchadenRange.random()

    var feuerRegenSchadenRange = 25..40
    var feuerRegenSchaden = feuerRegenSchadenRange.random()

    override var faehigkeiten = mutableListOf<String>(
        "Klon heraufbeschwören",    //0
        "Flächenschaden",           //1
        "Feueratem",                //2
        "HP-Klau",                  //3
        "Stampfattacke",            //4
        "Feuerregen"                //5
    )
    override var verursachterSchadenDragon: Double = 0.0
    val name = Gegner().dragonNamen.random()
    val hpDragon1: IntRange = 450..650
    var dragonHP1 = hpDragon1.random().toDouble()
    val hpDragon2: IntRange = 660..850
    var dragonHP2 = hpDragon2.random().toDouble()
    val hpDragon3: IntRange = 860..1100
    var dragonHP3 = hpDragon3.random().toDouble()

    val faehigkeitsSchaden1: IntRange = 15..30
    val faehigkeitsSchaden2: IntRange = 35..70
    val faehigkeitsSchaden3: IntRange = 75..100

    var feuerbaelle = 5
    var gespuckteFeuerbaelle = 0
    var feuerBaelleSpuckenRandomHeld = listOf<String>(
        "daneben",
        "Magier",
        "daneben",
        "Ritter",
        "daneben",
        "Mönch"
    )
}