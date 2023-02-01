class Mönch(heldenArt: String, name: String, hp: Double) :
    Helden(heldenArt, name, hp) {

    override var faehigkeiten = mutableListOf<String>(
        "Schweben",     // weicht Bodenattacken aus (1x alle 4 Runden möglich)
        "Meditation",   // Selbstheilung durch Meditation um 5% -> 1x möglich
        "Schockwelle"   // Schockwelle entsenden
    )

    var selbstHeilungHutzbarkeit = true

    override fun showFaehigkeiten() {
        println("${name}'s Fähigkeiten:")
        println(faehigkeiten)
    }

}