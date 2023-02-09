package Helden

class Magier: Helden() {

    var hp = heldenHP.random().toDouble()
    val startHP = hp
    var fuenfProzent = (startHP * 0.05)
    var betaeubt = false
    var name = Helden().heldenNamen.random()
    val schaden = Helden().faehigkeitsSchaden.random()
    override var heldenArt = "Magier"

    var schutzschildNutzbarkeit = true
    var schutzschildGezogen = false
    var schutzSchildMöglich = true
    var unverwundbar = false
    var abklingzeitSchutzSchild = 0 // 3 Runden wenn verwendet


    var doppelterSchadenNutzbarkeit = true
    var doppelterSchadenEingesetzt = false
    var abklingzeitDoppelterSchaden = 0 // 3 Runden wenn verwendet


    override var faehigkeiten = mutableListOf<String>(
        "Schutzschild (blockt (nicht Boden-)Angriffe, 1 Runde Schutz, 1x alle 3 Runden nutzbar)",
        "doppelter Schaden (schickt verursachten Schaden durch Gegner x2 zurück, 1x alle 3 Runden nutzbar)",
        "normaler Angriff"
        )

}