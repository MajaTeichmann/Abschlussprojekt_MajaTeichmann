fun main() {
    // Generelle Einstellungen
    var aktuelleRunde = 0
    val maximaleRunden = 5

    val heldenListe = listOf<String>("Magier", "Ritter", "Mönch")
    val randomHeld = heldenListe.random()
    val heldenNamen = mutableListOf<String>(
        "Eltrocus",
        "Kid",
        "Bat",
        "Dazzler",
        "Crow",
        "Spitfire",
        "Watcher",
        "Whiz",
        "Oxman",
        "Mole",
        "Puma",
        "Wolfman",
        "Blitzfire",
        "Deadnite",
        "Whiz",
        "General",
        "Katana",
        "Colossus",
        "Shield",
        "Spider",
        "Prophet",
        "Girl",
        "Wolfman",
        "Nighthawk",
        "One",
        "Wildflame",
        "Hope",
        "Kid",
        "Wonder",
        "Trident",
        "Chronos",
        "Y",
        "Scout",
        "Razor",
        "Dagger",
        "Manta",
        "Griffin",
        "Flare",
        "Archer",
        "Slayer",
        "Soldier",
        "Illusionist",
        "Savior",
        "Spy",
        "Vindicator",
        "Amazon",
        "General",
        "Leopard",
        "Knuckles",
        "Protector",
        "Gamma",
        "Mercenary",
        "Karma",
        "Grasshopper",
        "Granite",
        "Phantasm",
        "Nightquake",
        "Magician",
        "Optimo",
        "Prophet",
        "Guardian",
        "Spectre",
        "Atomic",
        "Axeman",
        "Gargoyle",
        "Starlight",
        "Armadillo",
        "Shield",
        "Warrior",
        "Siren",
        "Saber",
        "Marksman",
        "Hammer",
        "Elemental",
        "Roach",
        "Venombite",
        "Commander",
        "Commander",
        "Katana",
        "Watcher",
        "Spitfire",
        "Wonderman",
        "Mole",
        "Knight",
        "Halo",
        "Manta",
        "Nightowl",
        "Dragonloom",
        "Beetle",
        "Sentinel",
        "Incognito",
        "Crusher",
        "Sage",
        "Rosethorn",
        "Oxman",
        "Remix",
        "Nighthawk",
        "Spitfire",
        "Gladiator",
        "Flame"
    )
    val faehigkeitsSchaden: IntRange = 20..80
    val heldenHP: IntRange = 300..500

    val dragonNamen = mutableListOf<String>(
        "Smaug",
        "Glaurung",
        "Ancalagon",
        "Drogon",
        "Viserion",
        "Rhaegal",
        "King Ghidorah",
        "Malefiz",
        "Jabberwocky",
        "Fuchur",
        "Mushu",
        "Elliot",
        "Grisu",
        "Tabaluga",
        "Ohnezahn",
        "Sturmpfeil",
        "Draco",
        "Saphira",
        "Glaedr",
        "Haku",
        "Shenlong",
        "Nepomuk"
    )
    val hpDragon1: IntRange = 450..650
    val hpDragon2: IntRange = 660..850
    val hpDragon3: IntRange = 860..1100
    val dragonFaehigkeitsSchaden: IntRange = 20..80
    val nameDrache = dragonNamen.random()
    val dragonHP1 = hpDragon1.random().toDouble()
    val dragonHP2 = hpDragon2.random().toDouble()
    val dragonHP3 = hpDragon3.random().toDouble()
    val dragonKlonHP1 = dragonHP1 + (dragonHP1* 0.2)
    val dragonKlonHP2 = dragonHP2 + (dragonHP2 * 0.25)
    val dragonKlonHP3 = dragonHP3 + (dragonHP3 * 0.3)
    val dragonSchaden1 = dragonFaehigkeitsSchaden.random()
    val dragonSchaden2 = dragonFaehigkeitsSchaden.random()
    val dragonSchaden3 = dragonFaehigkeitsSchaden.random()

    //Objekte festlegen
    //HELDEN
    val magier = Magier("Magier", heldenNamen.random(), heldenHP.random().toDouble(), "Beutel")
    val ritter = Ritter("Ritter", heldenNamen.random(), heldenHP.random().toDouble(), "Schwert")
    val moench = Mönch("Mönch", heldenNamen.random(), heldenHP.random().toDouble())

    // GEGNER
    //Schwierigkeitsstufe [1]
    val dragonKlonSchaden1: Double = dragonSchaden1 + (dragonSchaden1 * 0.1)
    val drache1 = Dragon(nameDrache, dragonHP1, dragonSchaden1.toDouble())
    var klon1 = DragonKlon(nameDrache, dragonKlonHP1, dragonKlonSchaden1)
    //Schwierigkeitsstufe [2]
    val dragonKlonSchaden2: Double = dragonSchaden2 + (dragonSchaden2 * 0.15)
    val drache2 = Dragon(nameDrache, dragonHP2, dragonSchaden2.toDouble())
    var klon2 = DragonKlon(nameDrache, dragonKlonHP2, dragonKlonSchaden2)
    //Schwierigkeitsstufe [3]
    val dragonKlonSchaden3: Double = dragonSchaden3 + (dragonSchaden3 * 0.2)
    val drache3 = Dragon(nameDrache, dragonHP3, dragonSchaden3.toDouble())
    var klon3 = DragonKlon(nameDrache, dragonKlonHP3, dragonKlonSchaden3)


    //----------------------------------
    // Pausenmenü-Eingabe [1]
    fun magier() {
        println("\nHallo, ich bin ${magier.name} und ich bin ein ${magier.heldenArt}.\n")
        Thread.sleep(1000)
        println("\nName:                   ${magier.name}")
        Thread.sleep(1000)
        println("Helden-Art:             ${magier.heldenArt}")
        Thread.sleep(1000)
        println("HP:                     ${magier.hp}")
        Thread.sleep(1000)
        println("Gegenstände:            ${magier.beutel.size} im Beutel (Beutelinhalt: ${magier.beutel})")
        Thread.sleep(1000)
        println("Fähigkeiten:            ${magier.faehigkeiten}")
        println()
        println()
    }

    fun ritter() {
        println("\nHallo, ich bin ${ritter.name} und ich bin ein ${ritter.heldenArt}.\n")
        Thread.sleep(1000)
        println("\nName:                   ${ritter.name}")
        Thread.sleep(1000)
        println("Helden-Art:             ${ritter.heldenArt}")
        Thread.sleep(1000)
        println("HP:                     ${ritter.hp}")
        Thread.sleep(1000)
        println("Gegenstände:            Schwert")
        Thread.sleep(1000)
        println("Fähigkeiten:            ${ritter.faehigkeiten}")
        println()
        println()
    }

    fun moench() {
        println("\nHallo, ich bin ${moench.name} und ich bin ein ${moench.heldenArt}.\n")
        Thread.sleep(1000)
        println("\nName:                   ${moench.name}")
        Thread.sleep(1000)
        println("Helden-Art:             ${moench.heldenArt}")
        Thread.sleep(1000)
        println("HP:                     ${moench.hp}")
        Thread.sleep(1000)
        println("Gegenstände:            KEINE")
        Thread.sleep(1000)
        println("Fähigkeiten:            ${moench.faehigkeiten}")
        println()
        println()
    }

    // Pausenmenü-Eingabe [2]
    fun drache() {
        println("\nBevor ich dir deinen Gegner vorstellen kann, möchte ich wissen, wie stark er sein soll.")
        Thread.sleep(1000)
        println("\nWir haben 3 Schwierigkeitsstufen")
        Thread.sleep(1000)
        println("[1] leicht")
        Thread.sleep(1000)
        println("[2] normal")
        Thread.sleep(1000)
        println("[3] schwer")
        Thread.sleep(1000)
        println("\nBitte tippe nun die Schwierigkeitsstufe deiner Wahl ein:")

        var inputSchwierigkeitsstufe = readln()

        println("Gegner wird generiert")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(1000)
        println("\nGegner wurde generiert!")

        when (inputSchwierigkeitsstufe) {
            "1" -> {
                Thread.sleep(1000)
                println("Name:                   ${drache1.name}")
                Thread.sleep(1000)
                println("HP:                     ${dragonHP1}")
                Thread.sleep(1000)
                println("Fähigkeiten:")
                Thread.sleep(1000)
                println()
                println("${drache1.faehigkeiten[0]} -> Klon: ${dragonKlonHP1} HP, ${dragonKlonSchaden1} Schaden")
                Thread.sleep(1000)
                println(drache1.faehigkeiten[1])
                Thread.sleep(1000)
                println(drache1.faehigkeiten[2])
                Thread.sleep(1000)
                println(drache1.faehigkeiten[3])
                Thread.sleep(1000)
                println(drache1.faehigkeiten[4])
                Thread.sleep(1000)
                println(drache1.faehigkeiten[5])
                Thread.sleep(1000)
                println()
            }
        }
    }

    fun einleitung() {
        println("Unseren drei tapferen Helden")
        Thread.sleep(1000)
        println(magier.name)
        Thread.sleep(1000)
        println(ritter.name)
        Thread.sleep(1000)
        println("und ${moench.name}")
        println("wandern gerade durch den nahe gelegenen Märchenwald, als sie auf einen Drachen treffen.")
        Thread.sleep(1000)
        println("Ohne mit der Wimper zu zucken, zieht unser Held ")
        Thread.sleep(1000)
        println("${ritter.heldenArt} ${ritter.name}")
        println("sein Schwert und nähert sich dem Drachen für einen Überraschungsangriff. ")
        Thread.sleep(1000)
        println("Wie erwartet, ging")
        Thread.sleep(1000)
        println(ritter.name)
        println("nicht leise genug vor und alarmierte somit den Drachen.")
        Thread.sleep(1000)
        println("Erst jetzt konnten unsere drei Helden die Größe ihres Gegners in vollem Umfang erfassen und stellten fest, dass es sich um ")
        Thread.sleep(500)
        println(drache1.name)
        Thread.sleep(500)
        println("handelt, den mächtigsten und stärksten Drachen im ganzen Land...")
    }

    fun spielStarten() {
        einleitung()
    }

    fun spielBeenden() {

    }

    fun pausenmenue() {
        println("PAUSENMENÜ\n")
        println("Was möchtest du tun?\n")
        println(
            """
            [1] Helden kennenlernen
            [2] Drache kennenlernen
            [3] Spiel starten
            [4] Spiel beenden
        """.trimIndent()
        )

        var inputPausenmenue = readln()

        when (inputPausenmenue) {
            "1" -> {
                magier()
                Thread.sleep(5000)
                ritter()
                Thread.sleep(5000)
                moench()
            }

            "2" -> {
                drache()
            }

            "3" -> {
                spielStarten()
            }

            "4" -> {
                spielBeenden()
            }
        }
        Thread.sleep(1000)
        pausenmenue()
    }

    fun begruessung() {
        println("Hallo und herzlich Willkommen zu meinem Videospiel!")
        Thread.sleep(1000)
        println("Im folgenden Spielverlauf wirst du deine drei Helden und deinen Gegner, einen mächtigen Drachen, kennenlernen.")
        Thread.sleep(1000)
        println("Fangen wir an...\n")
        Thread.sleep(1000)

        pausenmenue()
    }

    fun start() {
        begruessung()
    }

    start()
}