class Dragon : Gegner() {

    val flaechenSchadenRange = 150..300
    val flaechenSchaden = flaechenSchadenRange.random()

    val feuerAtemSchadenRange = 75..100
    val feuerAtemSchaden = feuerAtemSchadenRange.random()

    var feuerRegenSchadenRange = 25..40
    var feuerRegenSchaden = feuerRegenSchadenRange.random()

    override var faehigkeiten = mutableListOf<String>(
        "Klon heraufbeschwören",
        "Flächenschaden",
        "Feueratem",
        "HP-Klau",
        "Stampfattacke",
        "Feuerregen"
    )

    override var verursachterSchadenDragon: Double = 0.0

    val name = Gegner().dragonNamen.random()

    val hpDragon1: IntRange = 450..650
    val hpDragon2: IntRange = 660..850
    val hpDragon3: IntRange = 860..1100

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