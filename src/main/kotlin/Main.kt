import kotlin.random.Random

var currentround = 1
var maxRound = 15
var faehigkeitsSchaden: IntRange = 20..80

val heroes = listOf<String>("Magier", "Ritter", "Mönch")
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
var randomHero = heroes.random()

var faehigkeitsSchadenMagier = faehigkeitsSchaden.random()
var magierAngriff: String = ""
var schutzschildGezogen = false
var schutzSchildMöglich = 0
var faehigkeitsSchadenRitter = faehigkeitsSchaden.random()
var ritterAngriff: String = ""
var faehigkeitsSchadenMönch = faehigkeitsSchaden.random()
var mönchAngriff: String = ""

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
    var magier = Magier("Magier", heldenNamen.random(), heldenHP.random().toDouble(), "Beutel")

    // Ritter
    var ritter = Ritter("Ritter", heldenNamen.random(), heldenHP.random().toDouble(), "Schwert")

    // Mönch
    var mönch = Mönch("Mönch", heldenNamen.random(), heldenHP.random().toDouble())


    ///////////GEGNER//////////////
    //Dragon
    var dragon = Dragon(dragonNamen.random(), dragonHP.random().toDouble(), 0)

    //DragonKlon
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

    fun alleHeldenGreifenAn() {
        if (magier.hp > 0) {
            println(
                """
                                Magier:          Dragon:
                             ${magier.hp} vs. ${dragon.hp}""".trimIndent()
            )
            magierAngriff = magier.faehigkeiten.random()
            println("${magier.name} wählt ${magierAngriff}")
            when (magierAngriff) {
                magier.faehigkeiten[0] -> {
                    println("${magier.name} hat sein Schutzschild gezogen. Er bekomt diese Runde keinen Schaden!")
                    schutzschildGezogen = true
                    if (schutzschildGezogen) {
                        var schutzSchildMöglich = 3
                    } else {
                        schutzSchildMöglich = 0
                    }
                    println("${magier.hp} vs. ${dragon.hp}")
                }

                magier.faehigkeiten[1] -> {
                    println("${magier.name} aktiviert ${magier.faehigkeiten[1]}. Er macht ${faehigkeitsSchadenMagier * 2} Schaden")
                    dragon.hp = dragon.hp - (faehigkeitsSchadenMagier * 2)
                    println("${magier.hp} vs. ${dragon.hp} (-${faehigkeitsSchadenMagier * 2})")
                }

                magier.faehigkeiten[2] -> {
                    println("${magier.name} aktiviert ${magier.faehigkeiten[2]}. Er macht ${faehigkeitsSchadenMagier} Schaden")
                    dragon.hp = dragon.hp - (faehigkeitsSchadenMagier)
                    println("${magier.hp} vs. ${dragon.hp} (-${faehigkeitsSchadenMagier})")
                }
            }
        } else {
            println("${magier.name} hat keine HP mehr")
            magier.hp = 0.0
        }


        if (ritter.hp > 0) {
            println(
                """
                                Ritter:          Dragon:
                             ${ritter.hp} vs. ${dragon.hp}""".trimIndent()
            )
            var ritterAngriff = ritter.faehigkeiten.random()
            println("${ritter.name} wählt ${ritterAngriff}")
            when (ritterAngriff) {
                ritter.faehigkeiten[0] -> {
                    println("${ritter.name} aktiviert ${ritter.faehigkeiten[0]}. Er macht ${faehigkeitsSchadenRitter * 3} Schaden!")
                    dragon.hp = dragon.hp - (faehigkeitsSchadenMagier)
                    println("${ritter.hp} vs. ${dragon.hp} (-${faehigkeitsSchadenRitter * 3})")
                }

                ritter.faehigkeiten[1] -> {
                    println("${ritter.name} hat sein Schutzschild gezogen. Er bekomt diese Runde keinen Schaden!")
                    println("${ritter.hp} vs. ${dragon.hp}")
                }

                ritter.faehigkeiten[2] -> {
                    println("${ritter.name} aktiviert ${ritter.faehigkeiten[2]}. Er macht ${faehigkeitsSchadenRitter} Schaden!")
                    dragon.hp = dragon.hp - (faehigkeitsSchadenMagier)
                    println("${ritter.hp} vs. ${dragon.hp} (-${faehigkeitsSchadenRitter})")
                }
            }
        } else {
            println("${ritter.name} hat keine HP mehr")
            ritter.hp = 0.0
        }


        if (mönch.hp > 0) {
            println(
                """
                                Mönch:          Dragon:
                             ${ritter.hp} vs. ${dragon.hp}""".trimIndent()
            )
            var mönchAngriff = mönch.faehigkeiten.random()
            println("${mönch.name} wählt ${mönchAngriff}")
            when (mönchAngriff) {
                mönch.faehigkeiten[0] -> {
                    println("${mönch.name} aktiviert ${mönch.faehigkeiten[0]}. Er weicht für 1 Runde dem Flächenschaden des Drachen aus!") //schwebt 1 runde -> in 4 runden wieder möglich
                    println("${mönch.hp} vs. ${dragon.hp}")
                }

                mönch.faehigkeiten[1] -> {
                    println("${mönch.name} aktiviert ${mönch.faehigkeiten[1]}. Er erhöht seine HP um 5% (+${mönch.hp * 0.05})!")
                    mönch.hp = mönch.hp * 0.05
                    println("${mönch.hp} vs. ${dragon.hp}")
                }

                mönch.faehigkeiten[2] -> {
                    println("${mönch.name} aktiviert ${mönch.faehigkeiten[2]}. Die Schockwelle macht ${faehigkeitsSchadenMönch} Schaden!")
                    dragon.hp = dragon.hp - (faehigkeitsSchadenMönch)
                    println("${mönch.hp} vs. ${dragon.hp} (-${faehigkeitsSchadenMönch}")
                }
            }
        } else {
            println("${mönch.name} hat keine HP mehr")
            mönch.hp = 0.0
        }
    }

    var dragonAngriff = dragon.faehigkeiten.random()

    fun alleHeldenAngreifen() {
        if (dragonAngriff == dragon.faehigkeiten[0]) {
            dragon.klon()
            println(
                """
                    Magier: ${magier.hp}                Drache: ${dragon.hp}
                    Ritter: ${ritter.hp}        vs. 
                    Mönch: ${mönch.hp}                  Klon:   ${dragonKlon.hp}
                """.trimIndent()
            )
            println("Der Drache greift an!")
            if (magierAngriff == magier.faehigkeiten[0]) {
                if (magier.schutzschildNutzbarkeit == true) {
                    magier.schutzschildNutzbarkeit = false  //in 3 Runden wieder Nutzbar
                    println("${dragon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragon.feuerAtemSchaden} an.")
                    println("${dragonKlon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragonKlon.schadenKlon} an.")
                    println("${magier.name} hat die Angriffe mit ${magier.faehigkeiten[0]} geblockt und erhält keinen Schaden.")
                    println("Magier: ${magier.hp}       vs.       Drache: ${dragon.hp} & Klon:   ${dragonKlon.hp}")
                } else {
                    println("${magier.name} wollte seinen Schutzzauber einsetzen, aber dieser hat noch Abklingkeit.")
                    println("${magier.name}'s Zug ist beendet!")
                }
            } else {
                println("${dragon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragon.feuerAtemSchaden} an.")
                println("${dragonKlon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragonKlon.schadenKlon} an.")
                println("${magier.name} erhält einen Gesamtschaden von ${dragon.feuerAtemSchaden + dragonKlon.schadenKlon}.")
                magier.hp = magier.hp - (dragon.feuerAtemSchaden + dragonKlon.schadenKlon)
                println("Magier: ${magier.hp}       vs.       Drache: ${dragon.hp} & Klon:   ${dragonKlon.hp}")
            }

            if (ritterAngriff == ritter.faehigkeiten[1]) {
                if (ritter.zustandSchutzSchild > 0) {
                    if (ritter.schutzSchildNutzbarkeit == true) {
                        ritter.schutzSchildNutzbarkeit = false  //in 5 Runden wieder Nutzbar
                        ritter.zustandSchutzSchild--
                        println("${dragon.name} greift ${ritter.name} mit einem Angriffsschaden von ${dragon.feuerAtemSchaden} an.")
                        println("${dragonKlon.name} greift ${ritter.name} mit einem Angriffsschaden von ${dragonKlon.schadenKlon} an.")
                        println("${ritter.name} hat die Angriffe mit ${ritter.faehigkeiten[1]} geblockt und erhält keinen Schaden.")
                        println("Ritter: ${ritter.hp}       vs.       Drache: ${dragon.hp} & Klon:   ${dragonKlon.hp}")
                    } else {
                        println("${ritter.name} wollte sein Schutzschild einsetzen, aber es hat noch Abklingkeit.")
                    }
                } else {
                    println("${ritter.name} wollte sein Schutzschild einsetzen, aber es ist zerstört worden.")
                }
            } else {
                println("${dragon.name} greift ${ritter.name} mit einem Angriffsschaden von ${dragon.feuerAtemSchaden} an.")
                println("${dragonKlon.name} greift ${ritter.name} mit einem Angriffsschaden von ${dragonKlon.schadenKlon} an.")
                println("${ritter.name} erhält einen Gesamtschaden von ${dragon.feuerAtemSchaden + dragonKlon.schadenKlon}.")
                ritter.hp = ritter.hp - (dragon.feuerAtemSchaden + dragonKlon.schadenKlon)
                println("Ritter: ${ritter.hp}       vs.       Drache: ${dragon.hp} & Klon:   ${dragonKlon.hp}")
            }
            if (mönchAngriff == mönch.faehigkeiten[1]) {
                if (mönch.selbstHeilungHutzbarkeit == true) {
                    mönch.selbstHeilungHutzbarkeit = false
                    println("${dragon.name} greift ${mönch.name} mit einem Angriffsschaden von ${dragon.feuerAtemSchaden} an.")
                    println("${dragonKlon.name} greift ${mönch.name} mit einem Angriffsschaden von ${dragonKlon.schadenKlon} an.")
                    println("${mönch.name} hat die Angriffe mit ${mönch.faehigkeiten[1]} geblockt und erhält keinen Schaden.")
                    println("Ritter: ${mönch.hp}       vs.       Drache: ${dragon.hp} & Klon:   ${dragonKlon.hp}")
                } else {
                    println("${mönch.name} wollte seine Selbstheilungskräfte einsetzen, diese wurden aber schon verwendet.")
                }
            } else {
                println("${dragon.name} greift ${mönch.name} mit einem Angriffsschaden von ${dragon.feuerAtemSchaden} an.")
                println("${dragonKlon.name} greift ${mönch.name} mit einem Angriffsschaden von ${dragonKlon.schadenKlon} an.")
                println("${mönch.name} erhält einen Gesamtschaden von ${dragon.feuerAtemSchaden + dragonKlon.schadenKlon}.")
                mönch.hp = mönch.hp - (dragon.feuerAtemSchaden + dragonKlon.schadenKlon)
                println("Mönch: ${mönch.hp}       vs.       Drache: ${dragon.hp} & Klon:   ${dragonKlon.hp}")
            }
        } else {
            when (dragonAngriff) {
                dragon.faehigkeiten[1] -> {
                    dragon.flaechenSchaden()
                    println(
                        """
                    Magier: ${magier.hp}
                    Ritter: ${ritter.hp}        vs.     Drache: ${dragon.hp}
                    Mönch: ${mönch.hp}
                """.trimIndent()
                    )
                    println("Der Drache greift an!")
                    if (magierAngriff == magier.faehigkeiten[0]) {
                        println("${dragon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragon.flaechenSchaden} an.")
                        println("${magier.name} hat die Angriffe mit ${magier.faehigkeiten[0]} geblockt und erhält keinen Schaden.")
                        println("Magier: ${magier.hp}       vs.       Drache: ${dragon.hp}")
                    } else {
                        println("${dragon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragon.flaechenSchaden} an.")
                        magier.hp = magier.hp - (dragon.flaechenSchaden)
                        println("Magier: ${magier.hp}       vs.       Drache: ${dragon.hp}")
                    }
                }

                dragon.faehigkeiten[2] -> {
                    dragon.feueratem()
                    println(
                        """
                    Magier: ${magier.hp}
                    Ritter: ${ritter.hp}        vs.     Drache: ${dragon.hp}
                    Mönch: ${mönch.hp}
                """.trimIndent()
                    )
                    println("Der Drache greift an!")
                    if (magierAngriff == magier.faehigkeiten[0]) {
                        println("${dragon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragon.feuerAtemSchaden} an.")
                        println("${magier.name} hat die Angriffe mit ${magier.faehigkeiten[0]} geblockt und erhält keinen Schaden.")
                        println("Magier: ${magier.hp}       vs.       Drache: ${dragon.hp}")
                    } else {
                        println("${dragon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragon.feuerAtemSchaden} an.")
                        magier.hp = magier.hp - (dragon.feuerAtemSchaden)
                        println("Magier: ${magier.hp}       vs.       Drache: ${dragon.hp}")
                    }
                }

                dragon.faehigkeiten[3] -> {
                    dragon.hpKlau()
                    println("${randomHero} überträgt 5% seiner Gesamt-HP an ${dragon.name}")
                    if (randomHero == "Magier") {
                        magier.hp = magier.hp - (magier.hp * 0.05)
                    } else if (randomHero == "Ritter") {
                        ritter.hp = ritter.hp - (ritter.hp * 0.05)
                    } else {
                        mönch.hp = mönch.hp - (mönch.hp * 0.05)
                    }
                    println("Neue HP-Statistik:")

                    println(
                        """
                    Magier: ${magier.hp}
                    Ritter: ${ritter.hp}        vs.     Drache: ${dragon.hp}
                    Mönch: ${mönch.hp}
                """.trimIndent()
                    )
                    println("Der Drache greift an!")
                    if (magierAngriff == magier.faehigkeiten[0]) {
                        println("${dragon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragon.flaechenSchaden} an.")
                        println("${magier.name} hat die Angriffe mit ${magier.faehigkeiten[0]} geblockt und erhält keinen Schaden.")
                        println("Magier: ${magier.hp}       vs.       Drache: ${dragon.hp}")
                    } else {
                        println("${dragon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragon.flaechenSchaden} an.")
                        magier.hp = magier.hp - (dragon.flaechenSchaden)
                        println("Magier: ${magier.hp}       vs.       Drache: ${dragon.hp}")
                    }
                }

                dragon.faehigkeiten[4] -> {
                    dragon.stampfAttacke()
                    // Alle Helden (am boden) betäuben (nächste Runde können sie nicht angreifen)
                    // stampattacke abklingzeit einrichten (alle 5 runden möglich)
                    println(
                        """
                    Magier: ${magier.hp}
                    Ritter: ${ritter.hp}        vs.     Drache: ${dragon.hp}
                    Mönch: ${mönch.hp}
                """.trimIndent()
                    )
                    println("Der Drache greift an!")
                    if (magierAngriff == magier.faehigkeiten[0]) {
                        println("${dragon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragon.flaechenSchaden} an.")
                        println("${magier.name} konnte den Angriff nicht blocken und erhält trotz Schild ${dragon.flaechenSchaden} Schaden.")
                        magier.hp = magier.hp - (dragon.flaechenSchaden)
                        println("Magier: ${magier.hp}       vs.       Drache: ${dragon.hp}")
                    } else {
                        println("${dragon.name} greift ${magier.name} mit einem Angriffsschaden von ${dragon.flaechenSchaden} an.")
                        println("${magier.name} erhält ${dragon.flaechenSchaden} Schaden.")
                        magier.hp = magier.hp - (dragon.flaechenSchaden)
                        println("Magier: ${magier.hp}       vs.       Drache: ${dragon.hp}")
                    }
                }

                dragon.faehigkeiten[5] -> {
                    dragon.feuerRegen()
                    for (i in 1..5) {
                        println("${randomHero}: -${dragon.feuerRegenSchaden} HP")
                        if (randomHero == "Magier") {
                            magier.hp = magier.hp - dragon.feuerRegenSchaden
                        } else if (randomHero == "Ritter") {
                            ritter.hp = ritter.hp - dragon.feuerRegenSchaden
                        } else if (randomHero == "Mönch") {
                            mönch.hp = mönch.hp - dragon.feuerRegenSchaden
                        }
                    }
                    println(
                        """
                    Magier: ${magier.hp}
                    Ritter: ${ritter.hp}        vs.     Drache: ${dragon.hp}
                    Mönch: ${mönch.hp}
                """.trimIndent()
                    )
                }
            }
        }
    }

    fun magierAngreifen() {

    }

    fun ritterAngreifen() {

    }

    fun mönchAngreifen() {

    }

    //------------------------------------------------------------------------
    fun spielStarten() {
        begruessung()
        heldenVorstellung()
        gegnerVorstellung()


        //Nur so dahin geschrieben...
        println(
            """
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

        alleHeldenGreifenAn()

    }

    spielStarten()
    fun dracheGreiftAn() {
        if (dragonAngriff == dragon.faehigkeiten[0] || dragonAngriff == dragon.faehigkeiten[1] || dragonAngriff == dragon.faehigkeiten[2] || dragonAngriff == dragon.faehigkeiten[4]) {
            if (magier.hp > 0 && ritter.hp > 0 && mönch.hp > 0) {
                alleHeldenAngreifen()
            } else if (magier.hp > 0) {
                magierAngreifen()
            }
            if (ritter.hp > 0) {
                ritterAngreifen()
            }
            if (mönch.hp > 0) {
                mönchAngreifen()
            } else {
                println("Alle Helden sind tot.")
                heroesLost()
            }
        } else if (dragonAngriff == dragon.faehigkeiten[3]) {
            dragon.hpKlau()
        } else if (dragonAngriff == dragon.faehigkeiten[5]) {
            dragon.feuerRegen()
        }
    }

    do {
        if (dragon.hp > 0) {
            println("Runde ${currentround} startet...\n")
            println("Unsere Helden fangen an!")
            alleHeldenGreifenAn()

            println("Nun ist der Drache ${dragon.name} an der Reihe...")
            dracheGreiftAn()
            currentround++
        }
    } while (currentround <= maxRound)
}