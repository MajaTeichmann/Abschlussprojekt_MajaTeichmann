package Helden

class Ritter : Helden() {

    var hp = heldenHP.random().toDouble()
    val startHP = hp
    var fuenfProzent = (startHP * 0.05)
    var betaeubt = false
    val name = Helden().heldenNamen.random()
    val schaden = Helden().faehigkeitsSchaden.random()
    override var heldenArt = "Ritter"


    override var faehigkeiten = mutableListOf<String>(
        "Schutzschild (blockt Angriff, 1 Runde Schutz, 1x alle 2 Runden nutzbar, max. Haltbarkeit 5 Angriffe)",
        "harter Schlag (Schaden x3, 1x alle 5 Runden nutzbar)",
        "normaler Angriff"
    )

    var schutzschildGezogen = false
    var unverwundbar = false
    var schutzSchildNutzbarkeit = true
    var schutzSchildAbklingdauer = 0
    var zustandSchutzSchild = 5


    var harterSchlagVerfügbar = true
    var abklingzeitHarterSchlag = 0

    override fun showFaehigkeiten() {
        println("${name}'s Fähigkeiten:")
        println(faehigkeiten)
    }
}

