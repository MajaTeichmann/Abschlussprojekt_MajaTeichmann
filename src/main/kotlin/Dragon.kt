class Dragon(name: String, hp: Double, schaden: Double) : Gegner(name, hp, schaden) {


    val flaechenSchadenRange = 150..300
    val flaechenSchaden = flaechenSchadenRange.random()
    fun flaechenSchaden() {
        println("${name} hat seine Attacke 'Flächenschaden' aktivert.")
        println("Alle lebenden Helden erhalten Schaden.")
    }

    val feuerAtemSchadenRange = 75..100
    val feuerAtemSchaden = feuerAtemSchadenRange.random()
    fun feueratem() {
        println("${name} spuckt Feuer und fügt allen lebenden Helden Schaden zu")
    }

    fun hpKlau() {
        println("${name} hat seine Fähigkeit 'HP-Klau' aktiviert.")
    }

    fun stampfAttacke() {
        println("${name} hat seine Attacke 'Stampfattacke' aktivert.")
        println("Alle lebenden Helden erhalten Schaden und werden für 1 Runde betäubt.")
    }

    var feuerRegenSchadenRange = 25..40
    var feuerRegenSchaden = feuerRegenSchadenRange.random()
    fun feuerRegen() {
        println("${name} hat seine Attacke 'Feuerregen' aktiviert und spuckt 5 Feuerbälle in den Himmel.")
        println("Getroffen wurden folgende Helden:")
        // lässt 5 Feuerbälle vom Himmelregnen -> zufallsgenerator welche(r) Held(en) getroffen wird/werden
    }
}