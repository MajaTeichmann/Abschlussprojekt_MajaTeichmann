class Magier(heldenArt: String, name: String, hp: Int, item: String) :
    Helden(heldenArt, name, hp) {

    override var faehigkeiten = mutableListOf<String>(
        "expecto scutum (Schutzschild)",        // erwarte Schutzschild (schützt 1 Runde Zauberer und alle Mitstreiter)
        "duplex damnum (doppelter Schaden)",    // verdopple Schaden (schickt verursachten Schaden durch Gegner  zurück und verdoppelt diesen, 3 Runden Abklingzeit)
        "noceat (normaler Angriff)"             // werde schaden (normaler Angriff)
        )

    // Beutel mit Zaubertränken (eigene Anwendung und Fremdanwendung)
    var beutel = mutableListOf<String>(
        "Schutzzauber",
        "Schutzzauber", // (halbiert 1 Runde den erhaltenen Schaden auf Anwender)
        "Heilzauber", // heilt Anwender einmalig um 10% Gesamt-HP (mind. 5 HP)
        "Betaeubungszauber" // Betäubt Gegner 1 Runde und macht 2% Gesamtschaden)
    )

    override fun showFaehigkeiten() {
        println("${name}'s Fähigkeiten:")
        println(faehigkeiten)
    }

    fun showBeutel() {
        println("${name}'s Beutelitems:")
        println(beutel)
    }
}