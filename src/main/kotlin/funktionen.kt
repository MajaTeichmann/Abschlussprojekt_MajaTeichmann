import Gegner.Dragon
import Gegner.DragonKlon
import Helden.Helden
import Helden.Magier
import Helden.Mönch
import Helden.Ritter

class funktionen(var magier: Magier, var ritter: Ritter, var moench: Mönch) {

    init {
        ////////// HELDEN //////////
        magier = Magier()
        ritter = Ritter()
        moench = Mönch()
    }

    var aktuelleRunde = 1
    val maximaleRunden = 5
    var magierFaehigkeitInput: String = ""
    var inputSchwierigkeitsstufeGegener = "1"
    val randomHeld = Helden().heldenListe.random()
    val randomHeldFeuerBaelleSpucken = Dragon().feuerBaelleSpuckenRandomHeld.random()
    var verursachterSchaden: Double = 0.0
    val randomDrachenAngriff = Dragon().faehigkeiten.random()
    var heldenGesamtHP: Double = 0.0


    ////////// DRAGON //////////
    //Schwierigkeitsstufe [1]
    var dragonHP1 = Dragon().dragonHP1
    val dragonSchaden1 = Dragon().faehigkeitsSchaden1.random()
    val drache1 = Dragon()

    //Schwierigkeitsstufe [2]
    var dragonHP2 = Dragon().dragonHP2
    val dragonSchaden2 = Dragon().faehigkeitsSchaden2.random()
    val drache2 = Dragon()

    //Schwierigkeitsstufe [3]
    var dragonHP3 = Dragon().dragonHP3
    val dragonSchaden3 = Dragon().faehigkeitsSchaden3.random()
    val drache3 = Dragon()

    ////////// KLON //////////
    //Schwierigkeitsstufe [1]
    val dragonKlonHP1 = dragonHP1 + (dragonHP1 * 0.2)
    val dragonKlonSchaden1: Double = dragonSchaden1 + (dragonSchaden1 * 0.1)
    var klon1 = DragonKlon()

    //Schwierigkeitsstufe [2]
    val dragonKlonHP2 = dragonHP2 + (dragonHP2 * 0.25)
    val dragonKlonSchaden2: Double = dragonSchaden2 + (dragonSchaden2 * 0.15)
    var klon2 = DragonKlon()

    //Schwierigkeitsstufe [3]
    val dragonKlonHP3 = dragonHP3 + (dragonHP3 * 0.3)
    val dragonKlonSchaden3: Double = dragonSchaden3 + (dragonSchaden3 * 0.2)
    var klon3 = DragonKlon()

    //----------------------------------------------------------------------------------------------------------------------
    fun start() {
        begruessung()
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

    fun pausenmenue() {
        println("PAUSENMENÜ\n")
        println("Was möchtest du tun?\n")
        println(
            """
            [1] Helden ansehen
            [2] Spiel starten
        """.trimIndent()
        )

        var inputPausenmenue = readln()

        when (inputPausenmenue) {
            "1" -> {
                magierVorstellung()
                Thread.sleep(5000)
                ritterVorstellung()
                Thread.sleep(5000)
                moenchVorstellung()
            }

            "2" -> {
                dracheVoreinstellungen()
                spielStarten()
            }
        }
        Thread.sleep(1000)
        pausenmenue()
    }

    fun spielStarten() {
        einleitung()
    }

    fun einleitung() {
        println("Unseren drei tapferen Helden ${magier.name}, ${ritter.name} und ${moench.name}")
        println("wandern gerade durch den nahe gelegenen Märchenwald, als sie auf einen Drachen treffen.")
        Thread.sleep(3000)
        println("Ohne mit der Wimper zu zucken, zieht unser ${ritter.heldenArt} ${ritter.name}")
        println("sein Schwert und nähert sich dem Drachen für einen Überraschungsangriff.")
        Thread.sleep(3000)
        println("Wie erwartet, ging ${ritter.name} nicht leise genug vor und alarmierte somit den Drachen.")
        Thread.sleep(3000)
        println("Erst jetzt konnten unsere drei Helden die Größe ihres Gegners in vollem Umfang erfassen und stellten fest,")
        println("dass es sich um ${drache1.name} handelt, den mächtigsten und stärksten Drachen im ganzen Land...")
        Thread.sleep(5000)
        println("Der Kampf beginnt in")
        Thread.sleep(1000)
        println("3")
        Thread.sleep(1000)
        println("2")
        Thread.sleep(1000)
        println("1")
        Thread.sleep(1000)
        println("GO!\n")

        kampfBeginnt()
    }

    fun kampfBeginnt() {
        do {
            println("\nRunde ${aktuelleRunde}:\n")
            if (inputSchwierigkeitsstufeGegener == "1") {
                if (dragonHP1 > 0 || magier.hp > 0 || ritter.hp > 0 || moench.hp > 0) {
                    if (!magier.betaeubt) {
                        if (dragonHP1 > 0 && magier.hp > 0) {
                            funktionen().magierAngriffStufe1()
                            println()
                        } else {
                            magier.hp = 0.0
                            println("${magier.name} ist tot (${magier.hp} HP)")
                        }
                    } else {
                        println("${magier.name} ist aktuell betäubt und kann nicht angreifen")
                        magier.betaeubt = false
                    }
                    if (!ritter.betaeubt) {
                        if (dragonHP1 > 0 && ritter.hp > 0) {
                            funktionen().ritterAngriffStufe1()
                            println()
                        } else {
                            ritter.hp = 0.0
                            println("${ritter.name} ist tot (${ritter.hp} HP)")
                        }
                    } else {
                        println("${ritter.name} ist aktuell betäubt und kann nicht angreifen")
                        ritter.betaeubt = false
                    }
                    if (!moench.betaeubt) {
                        if (dragonHP1 > 0 && moench.hp > 0) {
                            funktionen().moenchAngriffStufe1()
                            println()
                        } else {
                            moench.hp = 0.0
                            println("${moench.name} ist tot (${moench.hp} HP)")
                        }
                    } else {
                        println("${moench.name} ist aktuell betäubt und kann nicht angreifen")
                        moench.betaeubt = false
                    }
                    if (dragonHP1 > 0) {
                        funktionen().drachenAngriffStufe1()
                        println()
                    } else {
                        dragonHP1 = 0.0
                        println("Drache: $dragonHP1 HP")
                        funktionen().dragonLost()
                    }
                } else {
                    println("Spiel vorbei!")
                }
            } else if (inputSchwierigkeitsstufeGegener == "2") {
                if (dragonHP2 > 0 || magier.hp > 0 || ritter.hp > 0 || moench.hp > 0) {
                    if (dragonHP2 > 0 && magier.hp > 0) {
                        funktionen().magierAngriffStufe2()
                        println()
                    } else {
                        magier.hp = 0.0
                        println("Helden.Magier: ${magier.hp} HP")
                    }
                    if (dragonHP2 > 0 && ritter.hp > 0) {
                        funktionen().ritterAngriffStufe2()
                        println()
                    } else {
                        ritter.hp = 0.0
                        println("Helden.Ritter: ${ritter.hp} HP")
                    }
                    if (dragonHP2 > 0 && moench.hp > 0) {
                        funktionen().moenchAngriffStufe2()
                        println()
                    } else {
                        moench.hp = 0.0
                        println("Helden.Mönch: ${moench.hp} HP")
                    }
                    if (dragonHP2 > 0) {
                        funktionen().drachenAngriffStufe2()
                        println()
                    } else {
                        dragonHP2 = 0.0
                        println("Drache: $dragonHP2 HP")
                        funktionen().dragonLost()
                    }
                } else {
                    println("Spiel vorbei!")
                }

            } else {
                if (dragonHP3 > 0 || magier.hp > 0 || ritter.hp > 0 || moench.hp > 0) {
                    if (dragonHP3 > 0 && magier.hp > 0) {
                        magierAngriffStufe3()
                        println()
                    } else {
                        magier.hp = 0.0
                        println("Helden.Magier: ${magier.hp} HP")
                    }
                    if (dragonHP3 > 0 && ritter.hp > 0) {
                        ritterAngriffStufe3()
                        println()
                    } else {
                        ritter.hp = 0.0
                        println("Helden.Ritter: ${ritter.hp} HP")
                    }
                    if (dragonHP3 > 0 && moench.hp > 0) {
                        moenchAngriffStufe3()
                        println()
                    } else {
                        moench.hp = 0.0
                        println("Helden.Mönch: ${moench.hp} HP")
                    }
                    if (dragonHP2 > 0) {
                        drachenAngriffStufe3()
                        println()
                    } else {
                        dragonHP3 = 0.0
                        println("Drache: $dragonHP3 HP")
                        dragonLost()
                    }
                } else {
                    println("Spiel vorbei!")
                }
            }
            aktuelleRunde++
        } while (aktuelleRunde <= maximaleRunden)
        if (aktuelleRunde >= maximaleRunden) {
            if (dragonHP1 > magier.hp && dragonHP1 > ritter.hp && dragonHP1 > moench.hp) {
                heroesLost()
            } else if (dragonHP1 < magier.hp && dragonHP1 < ritter.hp && dragonHP1 < moench.hp) {
                dragonLost()
            } else {
                heldenGesamtHP = magier.hp + ritter.hp + moench.hp
                if (heldenGesamtHP > dragonHP1) {
                    dragonLost()
                }
                if (heldenGesamtHP < dragonHP1) {
                    heroesLost()
                }
                if (heldenGesamtHP == dragonHP1) {
                    println("Unentschieden!")
                }
            }
        }
    }

    // Pausenmenü-Eingabe [1]
    fun magierVorstellung() {
        println("\nHallo, ich bin ${magier.name} und ich bin ein ${magier.heldenArt}.\n")
        Thread.sleep(1000)
        println("\nName:                   ${magier.name}")
        Thread.sleep(1000)
        println("Helden-Art:             ${magier.heldenArt}")
        Thread.sleep(1000)
        println("HP:                     ${magier.hp}")
        Thread.sleep(1000)
        println("Gegenstände:            ${magier.beutel.size} Gegenstände im Beutel (Beutelinhalt: ${magier.beutel})")
        Thread.sleep(1000)
        println("Fähigkeiten:            ${magier.faehigkeiten}")
        println()
        println()
    }

    fun ritterVorstellung() {
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

    fun moenchVorstellung() {
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
    fun dracheVoreinstellungen() {
        println("\nBevor wir mit dem Spiel starten können, möchte ich wissen, wie stark der Drache sein soll.")
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

        inputSchwierigkeitsstufeGegener = readln()

        println("Gegner wird generiert")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(1000)
        println("\nGegner wurde generiert!")


        when (inputSchwierigkeitsstufeGegener) {
            "1" -> {
                Thread.sleep(1000)
                println("Name:                   ${drache1.name}")
                Thread.sleep(1000)
                println("HP:                     $dragonHP1")
                Thread.sleep(1000)
                println("Fähigkeiten:")
                Thread.sleep(1000)
                println()
                println("${drache1.faehigkeiten[0]} -> Klon: $dragonKlonHP1 HP, $dragonKlonSchaden1 Schaden")
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

            "2" -> {
                Thread.sleep(1000)
                println("Name:                   ${drache2.name}")
                Thread.sleep(1000)
                println("HP:                     $dragonHP2")
                Thread.sleep(1000)
                println("Fähigkeiten:")
                Thread.sleep(1000)
                println()
                println("${drache2.faehigkeiten[0]} -> Klon: $dragonKlonHP2 HP, $dragonKlonSchaden2 Schaden")
                Thread.sleep(1000)
                println(drache2.faehigkeiten[1])
                Thread.sleep(1000)
                println(drache2.faehigkeiten[2])
                Thread.sleep(1000)
                println(drache2.faehigkeiten[3])
                Thread.sleep(1000)
                println(drache2.faehigkeiten[4])
                Thread.sleep(1000)
                println(drache2.faehigkeiten[5])
                Thread.sleep(1000)
                println()
            }

            "3" -> {
                Thread.sleep(1000)
                println("Name:                   ${drache3.name}")
                Thread.sleep(1000)
                println("HP:                     $dragonHP3")
                Thread.sleep(1000)
                println("Fähigkeiten:")
                Thread.sleep(1000)
                println()
                println("${drache3.faehigkeiten[0]} -> Klon: $dragonKlonHP3 HP, $dragonKlonSchaden3 Schaden")
                Thread.sleep(1000)
                println(drache3.faehigkeiten[1])
                Thread.sleep(1000)
                println(drache3.faehigkeiten[2])
                Thread.sleep(1000)
                println(drache3.faehigkeiten[3])
                Thread.sleep(1000)
                println(drache3.faehigkeiten[4])
                Thread.sleep(1000)
                println(drache3.faehigkeiten[5])
                Thread.sleep(1000)
                println()
            }
        }
    }

    // GegnerSchwierigkeitsStufe 1
    fun magierAngriffStufe1() {
        println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}\n")
        println("Wähle eine Magier-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${magier.faehigkeiten[0]}")
        println("[2] ${magier.faehigkeiten[1]}")
        println("[3] ${magier.faehigkeiten[2]}")
        magierFaehigkeitInput = readln()
        if (magierFaehigkeitInput == "1" || magierFaehigkeitInput == "2" || magierFaehigkeitInput == "3") {
            when (magierFaehigkeitInput) {
                "1" -> {
                    if (magier.abklingzeitSchutzSchild == 0) {
                        magier.schutzschildGezogen = true
                        println("${magier.name} hat sein Schutzschild gezogen. Er ist nun 1 Runde unverwundbar!")
                        if (magier.schutzschildGezogen) {
                            magier.schutzschildNutzbarkeit = false
                            magier.schutzSchildMöglich = false
                            magier.unverwundbar = true
                            magier.abklingzeitSchutzSchild = 3
                        }
                    } else {
                        println("${magier.name} wollte sein Schutzschild einsetzen. Dieser hat aber noch ${magier.abklingzeitSchutzSchild} Runde Abklingzeit.")
                        println("Deshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache1.name} ${magier.schaden} Schaden.")
                        dragonHP1 = dragonHP1 - magier.schaden
                    }
                    magier.abklingzeitSchutzSchild--
                }

                "2" -> {
                    if (magier.abklingzeitDoppelterSchaden == 0) {
                        magier.doppelterSchadenNutzbarkeit = false
                        println("${magier.name} setzt seinen Schadenverdopplungszauber ein und schickt verursachten Schaden durch ${drache1.name} zurück und verdoppelt diesen.")
                        if (!magier.doppelterSchadenNutzbarkeit) {
                            magier.doppelterSchadenEingesetzt = true
                            magier.abklingzeitDoppelterSchaden = 3
                        }
                    } else {
                        println("${magier.name} wollte seinen Schadenverdopplungszauber einsetzen. Dieser hat aber noch ${magier.abklingzeitDoppelterSchaden} Runde Abklingzeit.")
                        println("Deshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache1.name} ${magier.schaden} Schaden.")
                        dragonHP1 = dragonHP1 - magier.schaden
                    }
                }

                "3" -> {
                    println("${magier.name} setzt seinen normalen Angriff ein und macht ${drache1.name} ${magier.schaden} Schaden.")
                    dragonHP1 = dragonHP1 - magier.schaden
                }
            }
            println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
        } else {
            println("Falsche Eingabe")
            return magierAngriffStufe1()
        }
    }

    fun ritterAngriffStufe1() {
        println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}")
        println("Wähle eine Helden.Ritter-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${ritter.faehigkeiten[0]}")
        println("[2] ${ritter.faehigkeiten[1]}")
        println("[3] ${ritter.faehigkeiten[2]}")
        var ritterFaehigkeitInput = readln()
        if (ritterFaehigkeitInput == "1" || ritterFaehigkeitInput == "2" || ritterFaehigkeitInput == "3") {
            when (ritterFaehigkeitInput) {
                "1" -> {
                    if (ritter.zustandSchutzSchild > 0) {
                        ritter.schutzSchildNutzbarkeit = true
                        if (!ritter.schutzschildGezogen) {
                            ritter.schutzschildGezogen = true
                            ritter.unverwundbar = true
                            ritter.schutzSchildAbklingdauer = 1
                            println("${ritter.name} hat sein Schutzschild gezogen und ist nun 1 Runde unverwundbar.")
                            println("Abklingdauer ${ritter.schutzSchildAbklingdauer} Runde(n), Zustand ${ritter.zustandSchutzSchild}/5!")
                        } else {
                            println("${ritter.name} hat bereits sein Schutzschild gezogen. Abklingdauer ${ritter.schutzSchildAbklingdauer} Runde(n), Zustand ${ritter.zustandSchutzSchild}/5!")
                            println("Deshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache1.name} ${ritter.schaden} Schaden.")
                            dragonHP1 = dragonHP1 - ritter.schaden
                            ritter.schutzSchildAbklingdauer--
                        }
                    } else {
                        ritter.schutzSchildNutzbarkeit = false
                        println("${ritter.name}'s Schutzschild ist zerbrochen und kann nicht mehr genutzt werden!")
                        println("Deshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache1.name} ${ritter.schaden} Schaden.")
                        dragonHP1 = dragonHP1 - ritter.schaden
                    }
                }

                "2" -> {
                    if (ritter.abklingzeitHarterSchlag == 0 && ritter.harterSchlagVerfügbar) {
                        ritter.abklingzeitHarterSchlag = 5
                        ritter.harterSchlagVerfügbar = false
                        println("${ritter.name} setzt seinen harten Schlag ein und macht ${drache1.name} ${ritter.schaden * 3} Schaden.")
                        dragonHP1 = dragonHP1 - (ritter.schaden * 3)
                    } else {
                        println("${ritter.name} wollte seinen harten Schlag einsetzen. Dieser hat aber noch ${ritter.abklingzeitHarterSchlag} Runde Abklingzeit.")
                        println("Deshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache1.name} ${ritter.schaden} Schaden.")
                        dragonHP1 = dragonHP1 - ritter.schaden
                    }
                }

                "3" -> {
                    println("${ritter.name} setzt seinen normalen Angriff ein und macht ${drache1.name} ${ritter.schaden} Schaden.")
                    dragonHP1 = dragonHP1 - ritter.schaden
                }
            }
            println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}")
        } else {
            println("Falsche Eingabe")
            return ritterAngriffStufe1()
        }
    }

    fun moenchAngriffStufe1() {
        println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
        println("Wähle eine Helden.Mönch-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${moench.faehigkeiten[0]}")
        println("[2] ${moench.faehigkeiten[1]}")
        println("[3] ${moench.faehigkeiten[2]}")
        var moenchFaehigkeitInput = readln()
        if (moenchFaehigkeitInput == "1" || moenchFaehigkeitInput == "2" || moenchFaehigkeitInput == "3") {
            when (moenchFaehigkeitInput) {
                "1" -> {
                    if (moench.schwebenAbklingdauer == 0) {
                        moench.schwebenAktiv = true
                        moench.schwebenAbklingdauer = 4
                        println("${moench.name} hat 'Schweben' aktiviert. Er ist nun 1 Runde vor Bodenattacken geschützt!")
                        if (moench.schweben == false) {
                            moench.schweben = true
                            if (moench.schwebenAktiv && moench.schwebenAbklingdauer == 0) {
                                moench.schwebenAbklingdauer = 4
                            }
                        }
                    } else {
                        println("${moench.name} hat seine Fähigkeit bereits vor ${4 - moench.schwebenAbklingdauer} Runden aktiviert und kann aktuell nicht erneut genutzt werden!")
                        println("Deshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache1.name} ${moench.schaden} Schaden.")
                        dragonHP1 = dragonHP1 - moench.schaden
                    }
                    moench.schwebenAbklingdauer--
                }

                "2" -> {
                    if (moench.selbstHeilungNutzbarkeit) {
                        moench.selbstHeilungNutzbarkeit = false
                        var selbstHeilung: Double = (moench.hp * 0.05) + moench.hp
                        println("${moench.name} setzt seine Selbstheilungskräfte ein und erhält +${selbstHeilung} HP.")
                        moench.hp = moench.hp + selbstHeilung
                    } else {
                        println("${moench.name} wollte sich selbst heilen. Diese Fähigkeit wurde aber bereits verwendet.")
                        println("Deshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache1.name} ${moench.schaden} Schaden.")
                        dragonHP1 = dragonHP1 - moench.schaden
                    }
                }

                "3" -> {
                    println("${moench.name} setzt seine Schockwelle ein und macht ${drache1.name} ${moench.schaden} Schaden.")
                    dragonHP1 = dragonHP1 - moench.schaden
                }
            }
            println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
        } else {
            println("Falsche Eingabe")
            return moenchAngriffStufe1()
        }
    }

    fun drachenAngriffStufe1() {
        println("Drache ${drache1.name} wählt Angriff:")
        Thread.sleep(1000)
        if (randomDrachenAngriff == Dragon().faehigkeiten[0]) {
            if (!DragonKlon().einsetzbar) {
                println("${drache1.name} wollte seinen Klon heraufbeschwören, dieser war aber schon im Einsatz.")
                return drachenAngriffStufe1()
            } else {
                println("${drache1.name}'s Klon erscheint...")
                DragonKlon().einsetzbar = false
                if (magier.hp > 0) {
                    println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden1} an.")
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden1} an.")
                    if (magier.schutzschildGezogen) {
                        println("Die Angriffe vom Drachen und seinem Klon sind an ${magier.name}'s Schutzschild abgeprallt")
                        magier.schutzschildGezogen = false
                        magier.unverwundbar = false
                        magier.abklingzeitSchutzSchild--
                        if (magier.abklingzeitSchutzSchild == 0) {
                            magier.schutzSchildMöglich = true
                            magier.schutzschildNutzbarkeit = true
                        } else {
                            magier.schutzSchildMöglich = false
                            magier.schutzschildNutzbarkeit = false
                        }
                        println("\nHelden.Magier HP: ${magier.hp} (-0) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    } else if (magier.doppelterSchadenEingesetzt) {
                        magier.doppelterSchadenNutzbarkeit = false
                        println("Weil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, erhält der Drache seinen eingesetzten Schaden verdoppelt zurück.")
                        dragonHP1 = (dragonHP1 - dragonSchaden1)
                        println("\nMagier HP: ${magier.hp} (- 0) vs. Drachen HP: ${dragonHP1} (-${dragonSchaden1}) & Klon HP: ${dragonKlonHP1}")

                    } else {
                        verursachterSchaden = dragonSchaden1 + dragonKlonSchaden1
                        magier.hp = (magier.hp - verursachterSchaden)
                        Thread.sleep(1000)
                        println("\nHelden.Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")

                    }
                }
                if (ritter.hp > 0) {
                    println("Helden.Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden1} an.")
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden1} an.")
                    if (ritter.schutzschildGezogen) {
                        println("Die Angriffe vom Drachen und seinem Klon sind an ${ritter.name}'s Schutzschild abgeprallt")
                        ritter.schutzschildGezogen = true
                        ritter.unverwundbar = true
                        ritter.zustandSchutzSchild--
                        if (ritter.zustandSchutzSchild == 0) {
                            ritter.schutzSchildNutzbarkeit = false
                            ritter.schutzschildGezogen = false
                            ritter.unverwundbar = false
                        }
                        println("\nHelden.Ritter HP: ${ritter.hp} (-0) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    } else {
                        verursachterSchaden = dragonSchaden1 + dragonKlonSchaden1
                        ritter.hp = (ritter.hp - verursachterSchaden)
                        Thread.sleep(1000)
                        println("\nHelden.Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    }
                }
                if (moench.hp > 0) {
                    println("Helden.Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden1} an.")
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden1} an.")
                    if (moench.schwebenAktiv) {
                        moench.schwebenAbklingdauer--
                    }
                    verursachterSchaden = dragonSchaden1 + dragonKlonSchaden1
                    Thread.sleep(1000)
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\nHelden.Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                }
                if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                    heroesLost()
                }
            }
        }
        if (randomDrachenAngriff == Dragon().faehigkeiten[1]) {
            println("${drache1.name} setzt 'Flächenschaden' ein...")
            println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
            if (magier.hp > 0) {
                println("Helden.Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
                if (magier.schutzschildGezogen) {
                    println("Obwohl ${magier.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("Helden.Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenNutzbarkeit = false
                    println("Weil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten.")
                    println("Dieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache1.name} macht deshalb ${magier.name} ${drache1.flaechenSchaden} Schaden.")
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("Helden.Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")

                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("Helden.Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")
                }
            }
            if (ritter.hp > 0) {
                println("\nHelden.Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}")
                if (ritter.schutzschildGezogen) {
                    println("Obwohl ${ritter.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\nHelden.Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")
                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("Helden.Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")
                }
            }
            if (moench.hp > 0) {
                println("\nHelden.Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
                if (moench.schwebenAktiv) {
                    println("Dank ${moench.name}'s eingesetzter Schwebefähigkeit, konnte ${drache1.name} keinen Schaden erwirken.")
                    println("Helden.Mönch HP: ${moench.hp} (-0) vs. Drachen HP: ${dragonHP1}\n")
                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    Thread.sleep(1000)
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("Helden.Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")
                }
            }
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLost()
            }
        }
        if (randomDrachenAngriff == Dragon().faehigkeiten[2]) {
            println("${drache1.name} setzt 'Feueratem' ein...")
            if (magier.hp > 0) {
                println("Helden.Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")

                Thread.sleep(1000)

                println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                if (magier.schutzschildGezogen) {
                    println("\nDer Angriff vom Drachen ist an ${magier.name}'s Schutzschild abgeprallt")
                    magier.schutzschildGezogen = false
                    magier.unverwundbar = false
                    magier.abklingzeitSchutzSchild--
                    if (magier.abklingzeitSchutzSchild == 0) {
                        magier.schutzSchildMöglich = true
                        magier.schutzschildNutzbarkeit = true
                    } else {
                        magier.schutzSchildMöglich = false
                        magier.schutzschildNutzbarkeit = false
                    }
                    println("\nHelden.Magier HP: ${magier.hp} (-0) vs. Drachen HP: ${dragonHP1}")
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenNutzbarkeit = false
                    println("Weil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten.")
                    println("Dieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache1.name} macht deshalb ${magier.name} ${drache1.feuerAtemSchaden} Schaden.")
                    verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                    println("Helden.Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")

                } else {
                    verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\nHelden.Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")

                }
            }
            if (ritter.hp > 0) {
                println("Helden.Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}")
                println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                if (ritter.schutzschildGezogen) {
                    println("Der Angriff vom Drachen ist an ${ritter.name}'s Schutzschild abgeprallt")
                    ritter.schutzschildGezogen = true
                    ritter.unverwundbar = true
                    ritter.zustandSchutzSchild--
                    println("\nHelden.Ritter HP: ${ritter.hp} (-0) vs. Drachen HP: ${dragonHP1}")
                } else {
                    verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\nHelden.Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                }
            }
            if (moench.hp > 0) {
                println("${drache1.name} setzt 'Flächenschaden' ein...")
                if (moench.hp > 0) {
                    println("Helden.Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                    if (moench.schwebenAktiv) {
                        println("Obwohl ${moench.name} aktuell 'Schweben' aktiviert hat, konnte dieser der Attacke nicht ausweichen.")
                        println("\nHelden.Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
                        println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                        verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                        Thread.sleep(1000)
                        moench.hp = (moench.hp - verursachterSchaden)
                        println("\nHelden.Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                    } else {
                        println("Helden.Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
                        println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                        verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                        Thread.sleep(1000)
                        moench.hp = (moench.hp - verursachterSchaden)
                        println("\nHelden.Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                    }
                }
            }
        }
        if (randomDrachenAngriff == Dragon().faehigkeiten[3]) {
            println("${drache1.name} hat seine HP-Klau Fähigkeit aktiviert und stielt einem zufälligen Helden.Helden 5% Gesamt-HP")
            Thread.sleep(1000)
            println("Drache wählt Held aus...")
            Thread.sleep(5000)
            if (randomHeld == "Helden.Magier") {
                magier.hp = magier.hp - magier.fuenfProzent
                dragonHP1 = dragonHP1 + magier.fuenfProzent
                println("Es wurden ${magier.name} 5% HP abgezogen und ${drache1.name} hinzugefügt.")
                println("Helden.Magier HP: ${magier.hp} (-${magier.fuenfProzent} HP) vs. Drachen HP: ${dragonHP1} (+${magier.fuenfProzent} HP)")
            } else if (randomHeld == "Helden.Ritter") {
                ritter.hp = ritter.hp - ritter.fuenfProzent
                dragonHP1 = dragonHP1 + ritter.fuenfProzent
                println("Es wurden ${ritter.name} 5% HP abgezogen und ${drache1.name} hinzugefügt.")
                println("Helden.Ritter HP: ${ritter.hp} (-${ritter.fuenfProzent} HP) vs. Drachen HP: ${dragonHP1} (+${ritter.fuenfProzent} HP)")
            } else {
                moench.hp = moench.hp - moench.fuenfProzent
                dragonHP1 = dragonHP1 + moench.fuenfProzent
                println("Es wurden ${moench.name} 5% HP abgezogen und ${drache1.name} hinzugefügt.")
                println("Helden.Mönch HP: ${magier.hp} (-${moench.fuenfProzent} HP) vs. Drachen HP: ${dragonHP1} (+${moench.fuenfProzent} HP)")
            }
        }
        if (randomDrachenAngriff == Dragon().faehigkeiten[4]) {
            println("${drache1.name} setzt 'Stampfattacke' ein...")
            println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
            println("Zusätzlich betäubt er alle getroffenen Einheiten")
            if (magier.hp > 0) {
                println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
                if (magier.schutzschildGezogen) {
                    println("Obwohl ${magier.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("Zusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    Thread.sleep(1000)
                    println("Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenNutzbarkeit = false
                    println("Weil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten.")
                    println("Dieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache1.name} macht deshalb ${magier.name} ${drache1.flaechenSchaden} Schaden.")
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("Zusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    Thread.sleep(1000)
                    println("Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")

                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("Zusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    Thread.sleep(1000)
                    println("Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")
                }
            }
            if (ritter.hp > 0) {
                println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}")
                if (ritter.schutzschildGezogen) {
                    println("Obwohl ${ritter.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("Zusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${ritter.name} nun 1 Runde betäubt.")
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    ritter.betaeubt = true
                    Thread.sleep(1000)
                    println("Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")
                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("Zusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${ritter.name} nun 1 Runde betäubt.")
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    ritter.betaeubt = true
                    Thread.sleep(1000)
                    println("Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")
                }
            }
            if (moench.hp > 0) {
                println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
                if (moench.schwebenAktiv) {
                    println("Dank ${moench.name}'s eingesetzter Schwebefähigkeit, konnte ${drache1.name} keinen Schaden erwirken.")
                    println("Mönch HP: ${moench.hp} (-0) vs. Drachen HP: ${dragonHP1}\n")
                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("Zusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${moench.name} nun 1 Runde betäubt.")
                    moench.hp = (moench.hp - verursachterSchaden)
                    moench.betaeubt = true
                    Thread.sleep(1000)
                    println("Mönch HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n")
                }
            }
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLost()
            }
        }
        if (randomDrachenAngriff == Dragon().faehigkeiten[5]) {
            Dragon().gespuckteFeuerbaelle = 0
            println("${drache1.name} hat Feuerregen aktiviert und spuckt 5 Feuerbälle in die Luft.")
            println("Wer wohl getroffen wird...")
            Thread.sleep(1000)
            println("Drache spuckt Feuerbälle...")
            Thread.sleep(5000)
            do {
                Dragon().gespuckteFeuerbaelle++
                println("Feuerball Nr. ${Dragon().gespuckteFeuerbaelle} fliegt durch die Luft und trifft:")
                Thread.sleep(3000)
                println(randomHeldFeuerBaelleSpucken)
                when (randomHeldFeuerBaelleSpucken) {
                    "Helden.Magier" -> {
                        verursachterSchaden = drache1.feuerRegenSchaden.toDouble()
                        magier.hp = magier.hp - verursachterSchaden
                        println("Helden.Magier HP: ${magier.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP1}")
                    }

                    "Helden.Ritter" -> {
                        verursachterSchaden = drache1.feuerRegenSchaden.toDouble()
                        ritter.hp = ritter.hp - verursachterSchaden
                        println("Helden.Ritter HP: ${magier.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP1}")
                    }

                    "Helden.Mönch" -> {
                        verursachterSchaden = drache1.feuerRegenSchaden.toDouble()
                        moench.hp = magier.hp - verursachterSchaden
                        println("Helden.Mönch HP: ${magier.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP1}")
                    }

                    "daneben" -> {
                        println("Dieser Feuerball ging daneben!")
                    }
                }

            } while (Dragon().gespuckteFeuerbaelle <= Dragon().feuerbaelle)
        }
    }

    // GegnerSchwierigkeitsStufe 2
    fun magierAngriffStufe2() {
        println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP2}")
        println("Wähle eine Helden.Magier-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${magier.faehigkeiten[0]}")
        println("[2] ${magier.faehigkeiten[1]}")
        println("[3] ${magier.faehigkeiten[2]}")
        var magierFaehigkeitInput = readln()
        if (magierFaehigkeitInput == "1" || magierFaehigkeitInput == "2" || magierFaehigkeitInput == "3") {
            when (magierFaehigkeitInput) {
                "1" -> {
                    if (magier.abklingzeitSchutzSchild == 0) {
                        magier.schutzschildGezogen = true
                        println("${magier.name} hat sein Schutzschild gezogen. Er ist nun 1 Runde unverwundbar!")
                        if (magier.schutzschildGezogen) {
                            magier.schutzschildNutzbarkeit = false
                            magier.schutzSchildMöglich = false
                            magier.unverwundbar = true
                            magier.abklingzeitSchutzSchild = 3
                        }
                    } else {
                        println("${magier.name} wollte sein Schutzschild einsetzen. Dieser hat aber noch ${magier.abklingzeitSchutzSchild} Runde Abklingzeit.")
                        println("Deshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache2.name} ${magier.schaden} Schaden.")
                        dragonHP2 = dragonHP2 - magier.schaden
                    }
                    magier.abklingzeitSchutzSchild--
                }

                "2" -> {
                    if (magier.abklingzeitDoppelterSchaden == 0) {
                        magier.doppelterSchadenNutzbarkeit = false
                        println("${magier.name} setzt seinen Schadenverdopplungszauber ein und schickt verursachten Schaden durch ${drache2.name} zurück und verdoppelt diesen.")
                        if (!magier.doppelterSchadenNutzbarkeit) {
                            magier.doppelterSchadenEingesetzt = true
                            magier.abklingzeitDoppelterSchaden = 3
                        }
                    } else {
                        println("${magier.name} wollte seinen Schadenverdopplungszauber einsetzen. Dieser hat aber noch ${magier.abklingzeitDoppelterSchaden} Runde Abklingzeit.")
                        println("Deshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache2.name} ${magier.schaden} Schaden.")
                        dragonHP2 = dragonHP2 - magier.schaden
                    }
                }

                "3" -> {
                    println("${magier.name} setzt seinen normalen Angriff ein und macht ${drache2.name} ${magier.schaden} Schaden.")
                    dragonHP2 = dragonHP2 - magier.schaden
                }
            }
            println("Helden.Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP2}")
        } else {
            println("Falsche Eingabe")
            return magierAngriffStufe2()
        }
    }

    fun ritterAngriffStufe2() {
        println("Helden.Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP2}")
        println("Wähle eine Helden.Ritter-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${ritter.faehigkeiten[0]}")
        println("[2] ${ritter.faehigkeiten[1]}")
        println("[3] ${ritter.faehigkeiten[2]}")
        var ritterFaehigkeitInput = readln()
        if (ritterFaehigkeitInput == "1" || ritterFaehigkeitInput == "2" || ritterFaehigkeitInput == "3") {
            when (ritterFaehigkeitInput) {
                "1" -> {
                    ritter.schutzschildGezogen = true
                    println("${ritter.name} hat sein Schutzschild gezogen. Er ist nun 1 Runde unverwundbar!")
                    if (ritter.zustandSchutzSchild > 0) {
                        if (ritter.schutzschildGezogen && ritter.schutzSchildNutzbarkeit) {
                            ritter.unverwundbar = true
                        }
                    } else {
                        println("${ritter.name}'s Schutzschild ist zerbrochen und kann nicht mehr genutzt werden!")
                        println("Deshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache2.name} ${ritter.schaden} Schaden.")
                        dragonHP2 = dragonHP2 - ritter.schaden
                    }
                }

                "2" -> {
                    if (ritter.abklingzeitHarterSchlag == 0 && ritter.harterSchlagVerfügbar) {
                        ritter.abklingzeitHarterSchlag = 5
                        ritter.harterSchlagVerfügbar = false
                        println("${ritter.name} setzt seinen harten Schlag ein und macht ${drache2.name} ${ritter.schaden * 3} Schaden.")
                        dragonHP2 = dragonHP2 - (ritter.schaden * 3)
                    } else {
                        println("${ritter.name} wollte seinen harten Schlag einsetzen. Dieser hat aber noch ${ritter.abklingzeitHarterSchlag} Runde Abklingzeit.")
                        println("Deshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache2.name} ${ritter.schaden} Schaden.")
                        dragonHP2 = dragonHP2 - ritter.schaden
                    }
                }

                "3" -> {
                    println("${ritter.name} setzt seinen normalen Angriff ein und macht ${drache2.name} ${ritter.schaden} Schaden.")
                    dragonHP2 = dragonHP2 - ritter.schaden
                }
            }
            println("Helden.Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP2}")
        } else {
            println("Falsche Eingabe")
            return ritterAngriffStufe2()
        }
    }

    fun moenchAngriffStufe2() {
        println("Helden.Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP2}")
        println("Wähle eine Helden.Mönch-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${moench.faehigkeiten[0]}")
        println("[2] ${moench.faehigkeiten[1]}")
        println("[3] ${moench.faehigkeiten[2]}")
        var moenchFaehigkeitInput = readln()
        if (moenchFaehigkeitInput == "1" || moenchFaehigkeitInput == "2" || moenchFaehigkeitInput == "3") {
            when (moenchFaehigkeitInput) {
                "1" -> {
                    if (moench.schwebenAbklingdauer == 0) {
                        moench.schwebenAktiv = true
                        println("${moench.name} hat 'Schweben' aktiviert. Er ist nun 1 Runde vor Bodenattacken geschützt!")
                        if (moench.schweben == false) {
                            moench.schweben = true
                            if (moench.schwebenAktiv && moench.schwebenAbklingdauer == 0) {
                                moench.schwebenAbklingdauer = 4
                            }
                        } else {
                            println("${moench.name} hat seine Fähigkeit bereits vor ${4 - moench.schwebenAbklingdauer} Runden aktiviert und kann aktuell nicht erneut genutzt werden!")
                            println("Deshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache2.name} ${moench.schaden} Schaden.")
                            dragonHP2 = dragonHP2 - moench.schaden
                        }
                        moench.schwebenAbklingdauer--
                    }
                }

                "2" -> {
                    if (moench.selbstHeilungNutzbarkeit) {
                        moench.selbstHeilungNutzbarkeit = false
                        var selbstHeilung = (moench.hp * 0.05) + moench.hp
                        println("${moench.name} setzt seine Selbstheilungskräfte ein und erhält +${selbstHeilung} HP.")
                        moench.hp = moench.hp + selbstHeilung
                    } else {
                        println("${moench.name} wollte sich selbst heilen. Diese Fähigkeit wurde aber bereits verwendet.")
                        println("Deshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache2.name} ${moench.schaden} Schaden.")
                        dragonHP2 = dragonHP2 - moench.schaden
                    }
                }

                "3" -> {
                    println("${moench.name} setzt seine Schockwelle ein und macht ${drache2.name} ${moench.schaden} Schaden.")
                    dragonHP2 = dragonHP2 - moench.schaden
                }
            }
            println("Helden.Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP2}")
        } else {
            println("Falsche Eingabe")
            return moenchAngriffStufe2()
        }
    }

    ///////////////////// NOCH FÜLLEN /////////////////////
    fun drachenAngriffStufe2() {
        println("Noch nicht implementiert. Schwierigkeitsstufe wurde auf leicht (1) gesetzt.")
        inputSchwierigkeitsstufeGegener = "1"
    }
    ///////////////////////////////////////////////////////

    // GegnerSchwierigkeitsStufe 3
    fun magierAngriffStufe3() {
        println("Helden.Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP3}")
        println("Wähle eine Helden.Magier-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${magier.faehigkeiten[0]}")
        println("[2] ${magier.faehigkeiten[1]}")
        println("[3] ${magier.faehigkeiten[2]}")
        var magierFaehigkeitInput = readln()
        if (magierFaehigkeitInput == "1" || magierFaehigkeitInput == "2" || magierFaehigkeitInput == "3") {
            when (magierFaehigkeitInput) {
                "1" -> {
                    if (magier.abklingzeitSchutzSchild == 0) {
                        magier.schutzschildGezogen = true
                        println("${magier.name} hat sein Schutzschild gezogen. Er ist nun 1 Runde unverwundbar!")
                        if (magier.schutzschildGezogen) {
                            magier.schutzschildNutzbarkeit = false
                            magier.schutzSchildMöglich = false
                            magier.unverwundbar = true
                            magier.abklingzeitSchutzSchild = 3
                        }
                    } else {
                        println("${magier.name} wollte sein Schutzschild einsetzen. Dieser hat aber noch ${magier.abklingzeitSchutzSchild} Runde Abklingzeit.")
                        println("Deshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache3.name} ${magier.schaden} Schaden.")
                        dragonHP3 = dragonHP3 - magier.schaden
                    }
                    magier.abklingzeitSchutzSchild--
                }

                "2" -> {
                    if (magier.abklingzeitDoppelterSchaden == 0) {
                        magier.doppelterSchadenNutzbarkeit = false
                        println("${magier.name} setzt seinen Schadenverdopplungszauber ein und schickt verursachten Schaden durch ${drache3.name} zurück und verdoppelt diesen.")
                        if (!magier.doppelterSchadenNutzbarkeit) {
                            magier.doppelterSchadenEingesetzt = true
                            magier.abklingzeitDoppelterSchaden = 3
                        }
                    } else {
                        println("${magier.name} wollte seinen Schadenverdopplungszauber einsetzen. Dieser hat aber noch ${magier.abklingzeitDoppelterSchaden} Runde Abklingzeit.")
                        println("Deshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache3.name} ${magier.schaden} Schaden.")
                        dragonHP3 = dragonHP3 - magier.schaden
                    }
                }

                "3" -> {
                    println("${magier.name} setzt seinen normalen Angriff ein und macht ${drache3.name} ${magier.schaden} Schaden.")
                    dragonHP3 = dragonHP3 - magier.schaden
                }
            }
            println("Helden.Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP3}")
        } else {
            println("Falsche Eingabe")
            return magierAngriffStufe3()
        }
    }

    fun ritterAngriffStufe3() {
        println("Helden.Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP3}")
        println("Wähle eine Helden.Ritter-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${ritter.faehigkeiten[0]}")
        println("[2] ${ritter.faehigkeiten[1]}")
        println("[3] ${ritter.faehigkeiten[2]}")
        var ritterFaehigkeitInput = readln()
        if (ritterFaehigkeitInput == "1" || ritterFaehigkeitInput == "2" || ritterFaehigkeitInput == "3") {
            when (ritterFaehigkeitInput) {
                "1" -> {
                    ritter.schutzschildGezogen = true
                    println("${ritter.name} hat sein Schutzschild gezogen. Er ist nun 1 Runde unverwundbar!")
                    if (ritter.zustandSchutzSchild > 0) {
                        if (ritter.schutzschildGezogen && ritter.schutzSchildNutzbarkeit) {
                            ritter.unverwundbar = true
                        }
                    } else {
                        println("${ritter.name}'s Schutzschild ist zerbrochen und kann nicht mehr genutzt werden!")
                        println("Deshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache3.name} ${ritter.schaden} Schaden.")
                        dragonHP3 = dragonHP3 - ritter.schaden
                    }
                }

                "2" -> {
                    if (ritter.abklingzeitHarterSchlag == 0 && ritter.harterSchlagVerfügbar) {
                        ritter.abklingzeitHarterSchlag = 5
                        ritter.harterSchlagVerfügbar = false
                        println("${ritter.name} setzt seinen harten Schlag ein und macht ${drache3.name} ${ritter.schaden * 3} Schaden.")
                        dragonHP3 = dragonHP3 - (ritter.schaden * 3)
                    } else {
                        println("${ritter.name} wollte seinen harten Schlag einsetzen. Dieser hat aber noch ${ritter.abklingzeitHarterSchlag} Runde Abklingzeit.")
                        println("Deshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache3.name} ${ritter.schaden} Schaden.")
                        dragonHP3 = dragonHP3 - ritter.schaden
                    }
                }

                "3" -> {
                    println("${ritter.name} setzt seinen normalen Angriff ein und macht ${drache3.name} ${ritter.schaden} Schaden.")
                    dragonHP3 = dragonHP3 - ritter.schaden
                }
            }
            println("Helden.Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP3}")
        } else {
            println("Falsche Eingabe")
            return ritterAngriffStufe3()
        }
    }

    fun moenchAngriffStufe3() {
        println("Helden.Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP3}")
        println("Wähle eine Helden.Mönch-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${moench.faehigkeiten[0]}")
        println("[2] ${moench.faehigkeiten[1]}")
        println("[3] ${moench.faehigkeiten[2]}")
        var moenchFaehigkeitInput = readln()
        if (moenchFaehigkeitInput == "1" || moenchFaehigkeitInput == "2" || moenchFaehigkeitInput == "3") {
            when (moenchFaehigkeitInput) {
                "1" -> {
                    if (moench.schwebenAbklingdauer == 0) {
                        moench.schwebenAktiv = true
                        println("${moench.name} hat 'Schweben' aktiviert. Er ist nun 1 Runde vor Bodenattacken geschützt!")
                        if (moench.schweben == false) {
                            moench.schweben = true
                            if (moench.schwebenAktiv && moench.schwebenAbklingdauer == 0) {
                                moench.schwebenAbklingdauer = 4
                            }
                        } else {
                            println("${moench.name} hat seine Fähigkeit bereits vor ${4 - moench.schwebenAbklingdauer} Runden aktiviert und kann aktuell nicht erneut genutzt werden!")
                            println("Deshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache3.name} ${moench.schaden} Schaden.")
                            dragonHP3 = dragonHP3 - moench.schaden
                        }
                        moench.schwebenAbklingdauer--
                    }
                }

                "2" -> {
                    if (moench.selbstHeilungNutzbarkeit) {
                        moench.selbstHeilungNutzbarkeit = false
                        var selbstHeilung = (moench.hp * 0.05) + moench.hp
                        println("${moench.name} setzt seine Selbstheilungskräfte ein und erhält +${selbstHeilung} HP.")
                        moench.hp = moench.hp + selbstHeilung
                    } else {
                        println("${moench.name} wollte sich selbst heilen. Diese Fähigkeit wurde aber bereits verwendet.")
                        println("Deshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache3.name} ${moench.schaden} Schaden.")
                        dragonHP3 = dragonHP3 - moench.schaden
                    }
                }

                "3" -> {
                    println("${moench.name} setzt seine Schockwelle ein und macht ${drache2.name} ${moench.schaden} Schaden.")
                    dragonHP3 = dragonHP3 - moench.schaden
                }
            }
            println("Helden.Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP3}")
        } else {
            println("Falsche Eingabe")
            return moenchAngriffStufe3()
        }
    }

    ///////////////////// NOCH FÜLLEN /////////////////////
    fun drachenAngriffStufe3() {
        println("Noch nicht implementiert. Schwierigkeitsstufe wurde auf leicht (1) gesetzt.")
        inputSchwierigkeitsstufeGegener = "1"
    }
    ///////////////////////////////////////////////////////

    fun dragonLost() {
        println("Der Drache ist tot und die Helden.Helden haben gewonnen!")
        println()
        println("\nDas Spiel ist vorbei!")
    }

    fun heroesLost() {
        println("Alle Helden.Helden sind tot und der Drache hat gewonnen!")
        println()
        println("\nDas Spiel ist vorbei!")
    }

}