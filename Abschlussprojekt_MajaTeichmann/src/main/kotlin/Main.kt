var currentround = 1
var maxRound = 15
var faehigkeitsSchaden: IntRange = 20..80

var heldenNamen = mutableListOf<String>(
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
var heldenHP: IntRange = 300..500
var faehigkeitsSchadenMagier = faehigkeitsSchaden.random()
var faehigkeitsSchadenRitter = faehigkeitsSchaden.random()
var faehigkeitsSchadenMönch = faehigkeitsSchaden.random()

var dragonNamen = mutableListOf<String>(
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
var dragonHP: IntRange = 450..650

fun main() {

    ////////////HELDEN////////////
    // Magier
    var magier = Magier("Magier", heldenNamen.random(), heldenHP.random(), "Beutel")

    // Ritter
    var ritter = Ritter("Ritter", heldenNamen.random(), heldenHP.random(), "Schwert")

    // Mönch
    var mönch = Mönch("Mönch", heldenNamen.random(), heldenHP.random())

    //Dragon
    var dragon = Dragon(dragonNamen.random(), dragonHP.random(), 0)
    var dragonKlon = Dragon("Klon", dragon.hpKlon, dragon.schadenKlon)

    fun begruessung() {
        println("Hallo und herzlich Willkommen zu meinem Videospiel!")
        println("Im folgenden Spielverlauf wirst du deine drei Helden und deinen Gegner, einen mächtigen Drachen, kennenlernen.")
        println("Fangen wir an...")
    }

    fun heldenVorstellung() {
        println("Hallo, ich bin ${magier.name} und ich bin ein ${magier.heldenArt}.\n")
        println(
                """
            Name:                   ${magier.name}
            Helden-Art:             ${magier.heldenArt}
            HP:                     ${magier.hp}
            Gegenstände:            ${magier.beutel.size} (${magier.beutel})
            Fähigkeiten:            ${magier.faehigkeiten}"""
        )

        println("\nHallo, ich bin ${ritter.name} und ich bin ein ${ritter.heldenArt}.")
        println(
                """
            Name:                   ${ritter.name}
            Helden-Art:             ${ritter.heldenArt}
            HP:                     ${ritter.hp}
            Gegenstände:            
            Fähigkeiten:            ${ritter.faehigkeiten}"""
        )

        println("\nHallo, ich bin ${mönch.name} und ich bin ein ${mönch.heldenArt}.")
        println(
                """
            Name:                   ${mönch.name}
            Helden-Art:             ${mönch.heldenArt}
            HP:                     ${mönch.hp}
            Gegenstände:            
            Fähigkeiten:            ${mönch.faehigkeiten}"""
        )
    }

    fun gegnerVorstellung() {
        println("\nWie stark soll dein Gegner sein?")
        println("Nenne mir hierfür bitte die entsprechende Zahl")
        println(
                """
            |[1] für schwach
            |[2] für normal
            |[3] für stark
        """.trimMargin()
        )
        var input = readln().toInt()
        var schaden = 0
        when (input) {
            1 -> schaden = 25
            2 -> schaden = 35
            3 -> schaden = 60
        }
        dragon.schaden = schaden
        var dragonKlonFaehigkeit = schaden * 1.5
        var dragonFlaechenSchaden = faehigkeitsSchaden.random()
        var dragonStampfAttacke = faehigkeitsSchaden.random()
        var dragonFeuerRegen = faehigkeitsSchaden.random()
        println(
                """
            Name:                   ${dragon.name}
            HP:                     ${dragon.hp}
            **********Fähigkeiten:**********
            ${dragon.faehigkeiten[0]} macht x1.5 Schaden, lebt 1 Runde
            ${dragon.faehigkeiten[1]} macht Bodenschaden
            ${dragon.faehigkeiten[2]} Feueratem -> ${schaden}
            ${dragon.faehigkeiten[3]} zieht zufälligem Helden 5% HP ab (Held -5%, Drache +5% (vom HeldenHP)
            ${dragon.faehigkeiten[4]} wie Flächenschaden + betäubt getroffene Helden
            ${dragon.faehigkeiten[5]} lässt 5 Feuerbälle vom Himmelregnen -> zufallsgenerator welche(r) Held(en) getroffen wird/werden"""
        )
    }

    fun dragonLost() {
        println("Der Drache ${dragon.name} ist besiegt. Die Helden haben gewonnen!!!\n")

        println("${magier.name}:    ${magier.hp}")
        println("${ritter.name}:    ${ritter.hp}")
        println("${mönch.name}:     ${mönch.hp}")
        println("vs.")
        println("${dragon.name}: ${dragon.hp}")
    }

    fun heroesLost() {
        println("Alle Helden wurden besiegt. Der Drache ${dragon.name} haben gewonnen!!!\n")

        println("${magier.name}:    ${magier.hp}")
        println("${ritter.name}:    ${ritter.hp}")
        println("${mönch.name}:     ${mönch.hp}")
        println("vs.")
        println("${dragon.name}: ${dragon.hp}")
    }

    fun maxRoundsPlayed() {
        println("Die maximale Rundenanzahl wurde erreicht\n")

        println("${magier.name}:    ${magier.hp}")
        println("${ritter.name}:    ${ritter.hp}")
        println("${mönch.name}:     ${mönch.hp}")
        println("vs.")
        println("${dragon.name}: ${dragon.hp}")

        if (magier.hp > dragon.hp || ritter.hp > dragon.hp || mönch.hp > dragon.hp) {
            dragonLost()
        } else if (magier.hp < dragon.hp || ritter.hp < dragon.hp || mönch.hp < dragon.hp) {
            heroesLost()
        } else
            println("Unentschieden!!!")
    }

    fun spielStarten() {
        begruessung()
        heldenVorstellung()
        gegnerVorstellung()
    }

    spielStarten()


    //Nur so dahin geschrieben...
    println("""
                Unseren drei tapferen Helden ${magier.name}, ${ritter.name} und ${mönch.name} wandern gerade durch den 
                nahe gelegenen Märchenwald, als sie auf einen Drachen treffen.
                Ohne mit der Wimper zu zucken, zieht unser Held ${ritter.name} (${ritter.heldenArt}) sein Schwert und 
                nähert sich dem Drachen für einen Überraschungsangriff. 
                Wie erwartet, ging ${ritter.name} nicht leise genug vor und alarmierte somit den Drachen.
                Erst jetzt konnten unsere drei Helden die Größe ihres Gegners in vollem Umfang erfassen und stellten fest,
                dass es sich um ${dragon.name} handelt, den mächtigsten und stärksten Drachen im ganzen Land...
                """.trimIndent()
    )
    Thread.sleep(1000)
    println("3")
    Thread.sleep(1000)
    println("2")
    Thread.sleep(1000)
    println("1")
    Thread.sleep(1000)
    println("Kampf!\n")

    do {
        if(dragon.hp > 0){
            println("Runde ${currentround} startet...\n")
            println("Unsere Helden fangen an!")
            if (magier.hp > 0) {
                println("""
                    Kämpfer: Magier:                                                                        Drache:
                    HP:      ${magier.hp}                                           vs.                     ${dragon.hp}
                             ${magier.faehigkeiten[0]} (schützt vor Schaden)        vs.                     ${dragon.faehigkeiten[0]} (${dragonKlon.hp} HP, ${dragonKlon.schadenKlon})
                             ${magier.faehigkeiten[1]} (${faehigkeitsSchadenMagier}*2) vs.                  ${dragon.faehigkeiten[1]} (${dragon.flaechenSchaden})
                             ${magier.faehigkeiten[2]} (${faehigkeitsSchadenMagier}) vs.                    ${dragon.faehigkeiten[2]} (${dragon.feuerAtemSchaden})
                                                                                                            ${dragon.faehigkeiten[3]} (zieht zufälligem Held 5% HP ab)
                                                                                                            ${dragon.faehigkeiten[4]} (${dragon.flaechenSchaden} + Betäubung)
                                                                                                            ${dragon.faehigkeiten[5]} (${dragon.feuerRegenSchaden})""".trimIndent()
                )
                var magierAngriff = magier.faehigkeiten.random()
                println("${magier.name} wählt ${magierAngriff}")
                println("")
            }
            if (ritter.hp > 0) {
                println("""
                    Ritter:                                 vs.                                 Drache:
                    HP: ${ritter.hp}                                                            ${dragon.hp}
                    ${ritter.faehigkeiten[0]} (schützt vor Schaden)                             ${dragon.faehigkeiten[0]} (${dragonKlon.hp} HP, ${dragonKlon.schadenKlon})
                    ${ritter.faehigkeiten[1]} (${faehigkeitsSchadenMagier * 2})                 ${dragon.faehigkeiten[1]} (${dragon.flaechenSchaden})
                    ${ritter.faehigkeiten[2]} (${faehigkeitsSchadenMagier})                     ${dragon.faehigkeiten[2]} (${dragon.feuerAtemSchaden})
                                                                                                ${dragon.faehigkeiten[3]} (zieht zufälligem Held 5% HP ab)
                                                                                                ${dragon.faehigkeiten[4]} (${dragon.flaechenSchaden} + Betäubung)
                                                                                                ${dragon.faehigkeiten[5]} (${dragon.feuerRegenSchaden})""".trimIndent()
                )
                var ritterAngriff = ritter.faehigkeiten.random()
                println("${ritter.name} wählt ${ritterAngriff}")
                println("")
            }
            if (mönch.hp > 0) {
                println("""
                    Ritter:                                 vs.                                 Drache:
                    HP: ${mönch.hp}                                                            ${dragon.hp}
                    ${mönch.faehigkeiten[0]} (schützt vor Schaden)                             ${dragon.faehigkeiten[0]} (${dragonKlon.hp} HP, ${dragonKlon.schadenKlon})
                    ${mönch.faehigkeiten[1]} (${faehigkeitsSchadenMagier * 2})                 ${dragon.faehigkeiten[1]} (${dragon.flaechenSchaden})
                    ${mönch.faehigkeiten[2]} (${faehigkeitsSchadenMagier})                     ${dragon.faehigkeiten[2]} (${dragon.feuerAtemSchaden})
                                                                                               ${dragon.faehigkeiten[3]} (zieht zufälligem Held 5% HP ab)
                                                                                               ${dragon.faehigkeiten[4]} (${dragon.flaechenSchaden} + Betäubung)
                                                                                               ${dragon.faehigkeiten[5]} (${dragon.feuerRegenSchaden})""".trimIndent()
                )
                var mönchAngriff = mönch.faehigkeiten.random()
                println("${mönch.name} wählt ${mönchAngriff}")
                println("")
            }
            currentround++
        }
    }
    while(currentround <= maxRound)
}