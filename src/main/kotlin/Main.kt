var round = 0
var maxRound = 15

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
var faehigkeitsSchaden: IntRange = 20..80

fun main() {

    ////////////HELDEN////////////
    // Magier
    var magier = Magier("Magier", heldenNamen.random(), heldenHP.random(), "Beutel")

    // Ritter
    var ritter = Ritter("Ritter", heldenNamen.random(), heldenHP.random(), "Schwert")

    // Mönch
    var mönch = Moench("Mönch", heldenNamen.random(), heldenHP.random())

    //Dragon
    var dragon = Gegner(dragonNamen.random(), dragonHP.random(), 0)

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
        dragon = Gegner(dragonNamen.random(), dragonHP.random(), schaden)
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

    if (round <= maxRound) {
        round++
        while (dragon.hp > 0) {
            println("Runde ${round} startet...\n")
            println("Unsere Helden fangen an!")
            if (magier.hp > 0) {
                println("""
                    Magier:                 vs.                 Drache:
                    HP: ${magier.hp}                            ${dragon.hp}
                    Fähigkeit1                                  Fähigkeit1
                    Fähigkeit2                                  Fähigkeit2
                    Fähigkeit3                                  Fähigkeit3
                                                                Fähigkeit4
                                                                Fähigkeit5
                                                                Fähigkeit6
                """.trimIndent()
                )
                var magierAngriff = magier.faehigkeiten.random()
                println("${magier.name} wählt ${magierAngriff}")
                println("")
            }

        }
        dragonLost()
    }
}