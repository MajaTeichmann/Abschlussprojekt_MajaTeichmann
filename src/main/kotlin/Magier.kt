class Magier(heldenArt: String, name: String, hp: Double, item: String) :
    Helden(heldenArt, name, hp) {

    var magierAngriff: String = ""


    var schutzschildNutzbarkeit = true
    var schutzschildGezogen = false
    var schutzSchildMöglich = true
    var unverwundbar = false
    var abklingzeitSchutzSchild = 0 // 3 Runden wenn verwendet


    var doppelterSchadenNutzbarkeit = true
    var doppelterSchadenEingesetzt = false
    var abklingzeitDoppelterSchaden = 0 // 3 Runden wenn verwendet


    override var faehigkeiten = mutableListOf<String>(
        "expecto scutum (Schutzschild)",        // erwarte Schutzschild (schützt Zauberer 1 Runde vor Schaden) 1x alle 3 Runden nutzbar
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