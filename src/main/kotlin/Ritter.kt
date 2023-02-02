class Ritter(heldenArt: String, name: String, hp: Double, item: String) :
    Helden(heldenArt, name, hp) {

    var heldenHP: IntRange = 300..500
    var ritterAngriff: String = ""


    override var faehigkeiten = mutableListOf<String>(
        "ledo difficile (harter Schlag)",       // harter Schlag (macht x3 Schaden als üblich, alle 5 Runden einsetzbar)
        "Schutzschild (Blockt Angriff)",        // Blockt Angriff ab (zerbricht, wenn Zustand <=0)
        "normaler Angriff"
    )

    var harterSchlag = true
    var schutzSchildNutzbarkeit = true
    var zustandSchutzSchild = 5

    override fun showFaehigkeiten() {
        println("${name}'s Fähigkeiten:")
        println(faehigkeiten)
    }
}