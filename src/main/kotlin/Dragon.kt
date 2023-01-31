class Dragon(name: String, hp: Int, schaden: Int) : Gegner(name, hp, schaden) {

    val hpKlon = hp / 100 * 20
    val schadenKlon = schaden / 100 * 15
    fun klon() {
        println("${name} hat seinen Klon (zukünftig ${name}(Klon) genannt) heraufbeschworen")
        println("${name}(Klon) hat eine HP von ${hpKlon} und macht ${schadenKlon} Schaden")
    }

    val flaechenSchadenRange = 150..300
    val flaechenSchaden = flaechenSchadenRange.random()
    fun flaechenSchaden() {
    // macht bodenschaden
    }

    val feuerAtemSchadenRange = 75..100
    val feuerAtemSchaden = feuerAtemSchadenRange.random()
    fun feueratem() {
    // spuckt feuer
    }

    fun hpKlau() {
        println("${name} hat seine Fähigkeit 'HP-Klau' aktiviert.")
        println("(NAME VON HELD) überträgt 5% seiner Gesamt-HP an ${name}")
        println("Neue HP-Statistik: (HELD1): HP, (HELD2): HP, (HELD3): HP, ${name}: ${hp}")
    }

    fun stampfAttacke(){
    // wie flächenschaden + betäubt getroffene Helden
    }

    var feuerRegenSchadenRange = 25..40
    var feuerRegenSchaden = feuerRegenSchadenRange.random()
    fun feuerRegen(){
        // lässt 5 Feuerbälle vom Himmelregnen -> zufallsgenerator welche(r) Held(en) getroffen wird/werden
    }
}