class Ritter(heldenArt: String, name: String, hp: Int, item: String) :
    Helden(heldenArt, name, hp) {

    override var faehigkeiten = mutableListOf<String>(
        "ledo difficile (harter Schlag)",       // harter Schlag (macht x3 Schaden als üblich, alle 5 Runden einsetzbar)
        "Schutzschild (Blockt Angriff)",        // Blockt Angriff ab (zerbricht, wenn Zustand <=0)
        "normaler Angriff"
    )

    override fun showFaehigkeiten() {
        println("${name}'s Fähigkeiten:")
        println(faehigkeiten)
    }
}