class Dragon(name: String, hp: Int, schaden: Int) : Gegner(name, hp, schaden) {


    var hpKlon = hp / 100 * 20
    var schadenKlon = schaden / 100 * 15

    fun klon() {
        println("${name} hat seinen Klon (zukünftig ${name}(Klon) genannt) heraufbeschworen")
        println("${name}(Klon) hat eine HP von ${hpKlon} und macht ${schadenKlon} Schaden")
    }

    fun flaechenschaden() {
    // macht bodenschaden
    }

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

    fun feuerRegen(){
        // lässt 5 Feuerbälle vom Himmelregnen -> zufallsgenerator welche(r) Held(en) getroffen wird/werden
    }
}