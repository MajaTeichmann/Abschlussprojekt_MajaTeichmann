class Ritter() : Helden() {

    var hp = heldenHP.random().toDouble()
    val startHP = hp
    val name = Helden().heldenNamen.random()
    val schaden = Helden().faehigkeitsSchaden.random()
    override var heldenArt = "Ritter"


    override var faehigkeiten = mutableListOf<String>(
        "Schutzschild (Blockt Angriff ab, zerbricht nach 5 geblockten Angriffen)",
        "harter Schlag (macht x3 Schaden als üblich, alle 5 Runden einsetzbar)",
        "normaler Angriff"
    )

    var harterSchlagVerfügbar = true
    var abklingzeitHarterSchlag = 0



    var schutzschildGezogen = false
    var unverwundbar = false
    var schutzSchildNutzbarkeit = true
    var zustandSchutzSchild = 5

    override fun showFaehigkeiten() {
        println("${name}'s Fähigkeiten:")
        println(faehigkeiten)
    }
}