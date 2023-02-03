class Ritter(heldenArt: String, name: String, hp: Double, item: String) :
    Helden(heldenArt, name, hp) {

    var heldenHP: IntRange = 300..500


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