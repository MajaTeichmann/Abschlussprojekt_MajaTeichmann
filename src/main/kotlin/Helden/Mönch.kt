package Helden

class Mönch : Helden(){

    var hp = heldenHP.random().toDouble()
    val startHP = hp
    var fuenfProzent = (startHP * 0.05)
    var betaeubt = false
    val name = Helden().heldenNamen.random()
    val schaden = Helden().faehigkeitsSchaden.random()
    override var heldenArt = "Mönch"


    override var faehigkeiten = mutableListOf<String>(
        "Schweben (immun gegen Bodenattacken, 1x alle 4 Runden nutzbar)",     // weicht Bodenattacken aus (1x alle 4 Runden möglich)
        "Meditation (heilt um 5% Gesamt-HP, 1x möglich)",   // Selbstheilung durch Meditation um 5% -> 1x möglich
        "Schockwelle (normaler Angriff)"   // Schockwelle entsenden
    )

    var schwebenAktiv = false
    var schweben = false
    var schwebenAbklingdauer = 0
    var selbstHeilungNutzbarkeit = true

}