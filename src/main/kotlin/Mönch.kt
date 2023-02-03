class Mönch(heldenArt: String, name: String, hp: Double) :
    Helden(heldenArt, name, hp) {

    var heldenHP: IntRange = 300..500
    var mönchAngriff: String = ""


    override var faehigkeiten = mutableListOf<String>(
        "Schweben",     // weicht Bodenattacken aus (1x alle 4 Runden möglich)
        "Meditation",   // Selbstheilung durch Meditation um 5% -> 1x möglich
        "Schockwelle"   // Schockwelle entsenden
    )

    var schwebenAktiv = false
    var schweben = false
    var schwebenAbklingdauer = 0
    var selbstHeilungNutzbarkeit = true

    override fun showFaehigkeiten() {
        println("${name}'s Fähigkeiten:")
        println(faehigkeiten)
    }

}