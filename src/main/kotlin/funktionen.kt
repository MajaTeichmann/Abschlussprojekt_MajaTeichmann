import Gegner.Dragon
import Gegner.DragonKlon
import Helden.Helden
import Helden.Magier
import Helden.Mönch
import Helden.Ritter

class funktionen {
    ////////// ALLGEMEINES //////////
    var aktuelleRunde = 1
    val maximaleRunden = 7
    var magierFaehigkeitInput: String = ""
    var inputSchwierigkeitsstufeGegener = "1"
    val randomHeld = Helden().heldenListe.random()
    var verursachterSchaden: Double = 0.0
    var heldenGesamtHP: Double = 0.0


    ////////// HELDEN //////////
    var magier = Magier()
    var ritter = Ritter()
    var moench = Mönch()


    ////////// GEGNER //////////
    var drache1 = Dragon()
    var drache2 = Dragon()
    var drache3 = Dragon()
    var klon1 = DragonKlon()
    var klon2 = DragonKlon()
    var klon3 = DragonKlon()


    //////////////////// DRAGON ////////////////////
    //Schwierigkeitsstufe [1]
    var dragonHP1 = drache1.dragonHP1
    val dragonSchaden1 = drache1.faehigkeitsSchaden1.random()

    //Schwierigkeitsstufe [2]
    var dragonHP2 = drache2.dragonHP2
    val dragonSchaden2 = drache2.faehigkeitsSchaden2.random()

    //Schwierigkeitsstufe [3]
    var dragonHP3 = drache3.dragonHP3
    val dragonSchaden3 = drache3.faehigkeitsSchaden3.random()


    //////////////////// KLON ////////////////////
    //Schwierigkeitsstufe [1]
    var dragonKlonHP1 = dragonHP1 + (dragonHP1 * 0.2)
    val dragonKlonSchaden1: Double = dragonSchaden1 + (dragonSchaden1 * 0.1)

    //Schwierigkeitsstufe [2]
    var dragonKlonHP2 = dragonHP2 + (dragonHP2 * 0.25)
    val dragonKlonSchaden2: Double = dragonSchaden2 + (dragonSchaden2 * 0.15)

    //Schwierigkeitsstufe [3]
    val dragonKlonHP3 = dragonHP3 + (dragonHP3 * 0.3)
    val dragonKlonSchaden3: Double = dragonSchaden3 + (dragonSchaden3 * 0.2)

    //----------------------------------------------------------------------------------------------------------------------
    fun start() {
        begruessung()
    }

    fun begruessung() {
        println("Hallo und herzlich Willkommen zu meinem Videospiel!")
        Thread.sleep(1500)
        println("Im folgenden Spielverlauf wirst du deine drei Helden und deinen Gegner, einen mächtigen Drachen, kennenlernen.")
        Thread.sleep(1500)
        println("Fangen wir an...\n")
        Thread.sleep(1000)
        println()
        pausenmenue()
    }

    fun pausenmenue() {
        println("PAUSENMENÜ\n")
        println("Was möchtest du tun?")
        println(
            """
            [1] Helden ansehen 🧾
            [2] Spiel starten ⚔️ """.trimIndent()
        )
        val inputPausenmenue = readln()
        when (inputPausenmenue) {
            "1" -> {
                magierVorstellung()
                Thread.sleep(2500)
                ritterVorstellung()
                Thread.sleep(2500)
                moenchVorstellung()
                Thread.sleep(2500)
            }

            "2" -> {
                dracheVoreinstellungen()
                spielStarten()
            }
        }
        Thread.sleep(1000)
        pausenmenue()
    }

    // Pausenmenü-Eingabe [1]
    fun magierVorstellung() {
        println("\nHallo, ich bin ${magier.name} und ich bin ein ${magier.heldenArt} 🧙🏼‍🪄 .")
        Thread.sleep(1000)
        println("\nName:                   ${magier.name}")
        Thread.sleep(1000)
        println("Helden-Art:             ${magier.heldenArt}")
        Thread.sleep(1000)
        println("HP:                     ${magier.hp}")
        Thread.sleep(1000)
        println("Fähigkeiten:            ${magier.faehigkeiten[0]}")
        Thread.sleep(1000)
        println("                        ${magier.faehigkeiten[1]}")
        Thread.sleep(1000)
        println("                        ${magier.faehigkeiten[2]}\n\n")
    }

    fun ritterVorstellung() {
        println("\nHallo, ich bin ${ritter.name} und ich bin ein ${ritter.heldenArt} 🤺.")
        Thread.sleep(1000)
        println("\nName:                   ${ritter.name}")
        Thread.sleep(1000)
        println("Helden-Art:             ${ritter.heldenArt}")
        Thread.sleep(1000)
        println("HP:                     ${ritter.hp}")
        Thread.sleep(1000)
        println("Gegenstände:            Schwert")
        Thread.sleep(1000)
        println("Fähigkeiten:            ${ritter.faehigkeiten[0]}")
        Thread.sleep(1000)
        println("                        ${ritter.faehigkeiten[1]}")
        Thread.sleep(1000)
        println("                        ${ritter.faehigkeiten[2]}\n\n")
    }

    fun moenchVorstellung() {
        println("\nHallo, ich bin ${moench.name} und ich bin ein ${moench.heldenArt} 👳🏽.")
        Thread.sleep(1000)
        println("\nName:                   ${moench.name}")
        Thread.sleep(1000)
        println("Helden-Art:             ${moench.heldenArt}")
        Thread.sleep(1000)
        println("HP:                     ${moench.hp}")
        Thread.sleep(1000)
        println("Fähigkeiten:            ${moench.faehigkeiten[0]}")
        Thread.sleep(1000)
        println("                        ${moench.faehigkeiten[1]}")
        Thread.sleep(1000)
        println("                        ${moench.faehigkeiten[2]}\n\n")
    }

    // Pausenmenü-Eingabe [2]
    fun dracheVoreinstellungen() {
        println("\n\nBevor wir mit dem Spiel starten können, möchte ich wissen, wie stark der Drache 🐉 sein soll.")
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
        println("Gegner wurde generiert!\n\n")
        Thread.sleep(1000)

        when (inputSchwierigkeitsstufeGegener) {
            "1" -> {
                println("Name:                   ${drache1.name}")
                Thread.sleep(1000)
                println("HP:                     $dragonHP1")
                Thread.sleep(1000)
                println("Fähigkeiten:            ${drache1.faehigkeiten[0]} -> Klon erhält $dragonKlonHP1 HP und macht $dragonKlonSchaden1 Schaden, lebt 1 Runde")
                Thread.sleep(1000)
                println("                        ${drache1.faehigkeiten[1]}")
                Thread.sleep(1000)
                println("                        ${drache1.faehigkeiten[2]}")
                Thread.sleep(1000)
                println("                        ${drache1.faehigkeiten[3]}")
                Thread.sleep(1000)
                println("                        ${drache1.faehigkeiten[4]}")
                Thread.sleep(1000)
                println("                        ${drache1.faehigkeiten[5]}\n\n")
                Thread.sleep(2500)
            }

            "2" -> {
                Thread.sleep(1000)
                println("Name:                   ${drache2.name}")
                Thread.sleep(1000)
                println("HP:                     $dragonHP2")
                Thread.sleep(1000)
                println("Fähigkeiten:            ${drache2.faehigkeiten[0]} -> Klon erhält $dragonKlonHP2 HP und macht $dragonKlonSchaden2 Schaden, lebt 1 Runde")
                Thread.sleep(1000)
                println("                        ${drache2.faehigkeiten[1]}")
                Thread.sleep(1000)
                println("                        ${drache2.faehigkeiten[2]}")
                Thread.sleep(1000)
                println("                        ${drache2.faehigkeiten[3]}")
                Thread.sleep(1000)
                println("                        ${drache2.faehigkeiten[4]}")
                Thread.sleep(1000)
                println("                        ${drache2.faehigkeiten[5]}\n\n")
                Thread.sleep(2500)
            }

            "3" -> {
                Thread.sleep(1000)
                println("Name:                   ${drache3.name}")
                Thread.sleep(1000)
                println("HP:                     $dragonHP3")
                Thread.sleep(1000)
                println("Fähigkeiten:            ${drache3.faehigkeiten[0]} -> Klon erhält $dragonKlonHP3 HP und macht $dragonKlonSchaden3 Schaden, lebt 1 Runde")
                Thread.sleep(1000)
                println("                        ${drache3.faehigkeiten[1]}")
                Thread.sleep(1000)
                println("                        ${drache3.faehigkeiten[2]}")
                Thread.sleep(1000)
                println("                        ${drache3.faehigkeiten[3]}")
                Thread.sleep(1000)
                println("                        ${drache3.faehigkeiten[4]}")
                Thread.sleep(1000)
                println("                        ${drache3.faehigkeiten[5]}\n\n")
                Thread.sleep(2500)
            }
        }
    }

    fun spielStarten() {
        einleitung()
    }

    fun einleitung() {
        println("Unseren drei tapferen Helden ${magier.name} (${magier.heldenArt}), ${ritter.name} (${ritter.heldenArt}) und ${moench.name} (${moench.heldenArt})")
        Thread.sleep(1000)
        println("wandern gerade durch den nahe gelegenen Märchenwald, als sie auf einen Drachen treffen.")
        Thread.sleep(2500)
        println("Ohne mit der Wimper zu zucken, zieht unser ${ritter.heldenArt} ${ritter.name}")
        Thread.sleep(1000)
        println("sein Schwert und nähert sich dem Drachen für einen Überraschungsangriff.")
        Thread.sleep(2500)
        println("Wie erwartet, ging ${ritter.name} nicht leise genug vor und alarmierte somit den Drachen.")
        Thread.sleep(2500)
        println("Erst jetzt konnten unsere drei Helden die Größe ihres Gegners in vollem Umfang erfassen und stellten fest,")
        Thread.sleep(1000)
        println("dass es sich um den mächtigsten und stärksten Drachen im ganzen Land handelt...")
        Thread.sleep(3500)
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
        while (aktuelleRunde <= maximaleRunden && dragonHP1 > 0 && (magier.hp > 0 || ritter.hp > 0 || moench.hp > 0)) {
            println("\nRunde ${aktuelleRunde}:\n")
            if (inputSchwierigkeitsstufeGegener == "1") {
                if (dragonHP1 > 0 || magier.hp > 0 || ritter.hp > 0 || moench.hp > 0) {
                    if (!magier.betaeubt) {
                        if (dragonHP1 > 0 && magier.hp > 0) {
                            magierAngriffStufe1()
                            println()
                        } else {
                            if (magier.hp <= 0) {
                                magier.hp = 0.0
                                println("${magier.name} ist tot (${magier.hp} HP)")
                            }
                            if (dragonHP1 <= 0) {
                                dragonHP1 = 0.0
                                dragonLostStufe1()
                            }
                        }
                    } else {
                        println("${magier.name} ist aktuell betäubt und kann nicht angreifen")
                    }
                    if (!ritter.betaeubt) {
                        if (dragonHP1 > 0 && ritter.hp > 0) {
                            ritterAngriffStufe1()
                            println()
                        } else {
                            if (ritter.hp <= 0) {
                                ritter.hp = 0.0
                                println("${ritter.name} ist tot (${ritter.hp} HP)")
                            }
                            if (dragonHP1 <= 0) {
                                dragonHP1 = 0.0
                                dragonLostStufe1()
                            }
                        }
                    } else {
                        println("${ritter.name} ist aktuell betäubt und kann nicht angreifen")
                    }
                    if (!moench.betaeubt) {
                        if (dragonHP1 > 0 && moench.hp > 0) {
                            moenchAngriffStufe1()
                            println()
                        } else {
                            if (moench.hp <= 0) {
                                moench.hp = 0.0
                                println("${moench.name} ist tot (${moench.hp} HP)")
                            }
                            if (dragonHP1 <= 0) {
                                dragonHP1 = 0.0
                                dragonLostStufe1()
                            }
                        }
                    } else {
                        println("${moench.name} ist aktuell betäubt und kann nicht angreifen")
                    }
                    if (dragonHP1 > 0) {
                        drachenAngriffStufe1()
                        println()
                    }
                } else {
                    println("Spiel vorbei!")
                }
            } else if (inputSchwierigkeitsstufeGegener == "2") {
                if (dragonHP2 > 0 || magier.hp > 0 || ritter.hp > 0 || moench.hp > 0) {
                    if (!magier.betaeubt) {
                        if (dragonHP2 > 0 && magier.hp > 0) {
                            magierAngriffStufe2()
                            println()
                        } else {
                            if (magier.hp <= 0) {
                                magier.hp = 0.0
                                println("${magier.name} ist tot (${magier.hp} HP)")
                            }
                            if (dragonHP2 <= 0) {
                                dragonHP2 = 0.0
                                println("${drache2.name} ist tot (${dragonHP2} HP)")
                                dragonLostStufe2()
                            }
                        }
                    } else {
                        println("${magier.name} ist aktuell betäubt und kann nicht angreifen")
                    }
                    if (!ritter.betaeubt) {
                        if (dragonHP2 > 0 && ritter.hp > 0) {
                            ritterAngriffStufe2()
                            println()
                        } else {
                            if (ritter.hp <= 0) {
                                ritter.hp = 0.0
                                println("${ritter.name} ist tot (${ritter.hp} HP)")
                            }
                            if (dragonHP2 <= 0) {
                                dragonHP2 = 0.0
                                println("${drache1.name} ist tot (${dragonHP2} HP)")
                                dragonLostStufe2()
                            }
                        }
                    } else {
                        println("${ritter.name} ist aktuell betäubt und kann nicht angreifen")
                    }
                    if (!moench.betaeubt) {
                        if (dragonHP2 > 0 && moench.hp > 0) {
                            moenchAngriffStufe2()
                            println()
                        } else {
                            if (moench.hp <= 0) {
                                moench.hp = 0.0
                                println("${moench.name} ist tot (${moench.hp} HP)")
                            }
                            if (dragonHP2 <= 0) {
                                dragonHP2 = 0.0
                                println("${drache1.name} ist tot (${dragonHP2} HP)")
                                dragonLostStufe2()
                            }
                        }
                    } else {
                        println("${moench.name} ist aktuell betäubt und kann nicht angreifen")
                    }
                    if (dragonHP2 > 0) {
                        drachenAngriffStufe2()
                        println()
                    } else {
                        dragonHP2 = 0.0
                        println("Drache: $dragonHP2 HP")
                        dragonLostStufe2()
                    }
                } else {
                    println("Spiel vorbei!")
                }

            } else if (inputSchwierigkeitsstufeGegener == "3") {
                if (dragonHP3 > 0 || magier.hp > 0 || ritter.hp > 0 || moench.hp > 0) {
                    if (!magier.betaeubt) {
                        if (dragonHP3 > 0 && magier.hp > 0) {
                            magierAngriffStufe3()
                            println()
                        } else {
                            if (magier.hp <= 0) {
                                magier.hp = 0.0
                                println("${magier.name} ist tot (${magier.hp} HP)")
                            }
                            if (dragonHP3 <= 0) {
                                dragonHP3 = 0.0
                                println("${drache3.name} ist tot (${dragonHP3} HP)")
                                dragonLostStufe3()
                            }
                        }
                    } else {
                        println("${magier.name} ist aktuell betäubt und kann nicht angreifen")
                    }
                    if (!ritter.betaeubt) {
                        if (dragonHP3 > 0 && ritter.hp > 0) {
                            ritterAngriffStufe3()
                            println()
                        } else {
                            if (ritter.hp <= 0) {
                                ritter.hp = 0.0
                                println("${ritter.name} ist tot (${ritter.hp} HP)")
                            }
                            if (dragonHP3 <= 0) {
                                dragonHP3 = 0.0
                                println("${drache3.name} ist tot (${dragonHP3} HP)")
                                dragonLostStufe3()
                            }
                        }
                    } else {
                        println("${ritter.name} ist aktuell betäubt und kann nicht angreifen")
                    }
                    if (!moench.betaeubt) {
                        if (dragonHP3 > 0 && moench.hp > 0) {
                            moenchAngriffStufe3()
                            println()
                        } else {
                            if (moench.hp <= 0) {
                                moench.hp = 0.0
                                println("${moench.name} ist tot (${moench.hp} HP)")
                            }
                            if (dragonHP3 <= 0) {
                                dragonHP3 = 0.0
                                println("${drache3.name} ist tot (${dragonHP3} HP)")
                                dragonLostStufe3()
                            }
                        }
                    } else {
                        println("${moench.name} ist aktuell betäubt und kann nicht angreifen")
                    }
                    if (dragonHP3 > 0) {
                        drachenAngriffStufe3()
                        println()
                    } else {
                        dragonHP3 = 0.0
                        println("Drache: $dragonHP3 HP")
                        dragonLostStufe3()
                    }
                } else {
                    println("Spiel vorbei!")
                }
            }
            aktuelleRunde++
        }
        println("\n Maximale Rundenanzahl erreicht!")
        println("${magier.hp + ritter.hp + moench.hp} vs. ${dragonHP1}\n")
    }

    // GegnerSchwierigkeitsStufe 1
    fun magierAngriffStufe1() {
        println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}]")
        println("\nWähle eine Magier-Fähigkeit")
        Thread.sleep(1000)
        println("[1] ${magier.faehigkeiten[0]}")
        println("[2] ${magier.faehigkeiten[1]}")
        println("[3] ${magier.faehigkeiten[2]}")
        magierFaehigkeitInput = readln()
        Thread.sleep(1000)
        if (magierFaehigkeitInput == "1" || magierFaehigkeitInput == "2" || magierFaehigkeitInput == "3") {
            when (magierFaehigkeitInput) {
                "1" -> {
                    if (magier.abklingzeitSchutzSchild == 0) {
                        magier.schutzschildGezogen = true
                        println("\n${magier.name} hat sein Schutzschild gezogen. Er ist nun 1 Runde unverwundbar.")
                        Thread.sleep(2500)
                        println("...außer gegen Bodenattacken! 😋\n")
                        if (magier.schutzschildGezogen) {
                            magier.schutzschildNutzbarkeit = false
                            magier.schutzSchildMöglich = false
                            magier.unverwundbar = true
                            magier.abklingzeitSchutzSchild = 3
                        }
                    } else {
                        println("\n${magier.name} wollte sein Schutzschild einsetzen. Dieser hat aber noch ${magier.abklingzeitSchutzSchild} Runde Abklingzeit.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache1.name} ${magier.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP1 = dragonHP1 - magier.schaden
                    }
                    magier.abklingzeitSchutzSchild--
                }

                "2" -> {
                    if (magier.abklingzeitDoppelterSchaden == 0) {
                        magier.doppelterSchadenNutzbarkeit = false
                        println("\n${magier.name} setzt seinen Schadenverdopplungszauber ein und schickt verursachten Schaden durch ${drache1.name} zurück und verdoppelt diesen.")
                        Thread.sleep(1000)
                        if (!magier.doppelterSchadenNutzbarkeit) {
                            magier.doppelterSchadenEingesetzt = true
                            magier.abklingzeitDoppelterSchaden = 3
                        }
                    } else {
                        println("\n${magier.name} wollte seinen Schadenverdopplungszauber einsetzen. Dieser hat aber noch ${magier.abklingzeitDoppelterSchaden} Runde Abklingzeit.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache1.name} ${magier.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP1 = dragonHP1 - magier.schaden
                    }
                    magier.abklingzeitDoppelterSchaden--
                }

                "3" -> {
                    println("\n${magier.name} setzt seinen normalen Angriff ein und macht ${drache1.name} ${magier.schaden} Schaden.")
                    Thread.sleep(1000)
                    dragonHP1 = dragonHP1 - magier.schaden
                }
            }
            println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}]\n\n")
            Thread.sleep(1000)
        } else {
            println("Falsche Eingabe\n\n")
            return magierAngriffStufe1()
        }
    }

    fun ritterAngriffStufe1() {
        println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}]")
        Thread.sleep(1000)
        println("\nWähle eine Ritter-Fähigkeit")
        Thread.sleep(1000)
        println("[1] ${ritter.faehigkeiten[0]}")
        println("[2] ${ritter.faehigkeiten[1]} (Haltbarkeit: ${ritter.zustandSchutzSchild}/5)")
        println("[3] ${ritter.faehigkeiten[2]}")
        var ritterFaehigkeitInput = readln()
        Thread.sleep(1000)
        if (ritterFaehigkeitInput == "1" || ritterFaehigkeitInput == "2" || ritterFaehigkeitInput == "3") {
            when (ritterFaehigkeitInput) {
                "1" -> {
                    if (ritter.zustandSchutzSchild > 0) {
                        ritter.schutzSchildNutzbarkeit = true
                        if (!ritter.schutzschildGezogen) {
                            ritter.schutzschildGezogen = true
                            ritter.unverwundbar = true
                            ritter.schutzSchildAbklingdauer = 1
                            println("\n${ritter.name} hat sein Schutzschild gezogen und ist nun 1 Runde unverwundbar.")
                            Thread.sleep(2000)
                            println("...außer gegen Bodenattacken! 😋")
                            Thread.sleep(1000)
                            println("Abklingdauer ${ritter.schutzSchildAbklingdauer} Runde(n), Zustand ${ritter.zustandSchutzSchild}/5!\n")
                        } else {
                            println("\n${ritter.name} hat bereits sein Schutzschild gezogen. Abklingdauer noch ${ritter.schutzSchildAbklingdauer} Runde(n), Zustand ${ritter.zustandSchutzSchild}/5!")
                            Thread.sleep(1000)
                            println("\nDeshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache1.name} ${ritter.schaden} Schaden.")
                            Thread.sleep(1000)
                            dragonHP1 = dragonHP1 - ritter.schaden
                            ritter.schutzSchildAbklingdauer--
                        }
                    } else {
                        ritter.schutzSchildNutzbarkeit = false
                        println("\n${ritter.name}'s Schutzschild ist zerbrochen und kann nicht mehr genutzt werden!")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache1.name} ${ritter.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP1 = dragonHP1 - ritter.schaden
                    }
                }

                "2" -> {
                    if (ritter.abklingzeitHarterSchlag == 0 && ritter.harterSchlagVerfügbar) {
                        ritter.abklingzeitHarterSchlag = 5
                        ritter.harterSchlagVerfügbar = false
                        println("\n${ritter.name} setzt seinen harten Schlag ein und macht ${drache1.name} ${ritter.schaden * 3} Schaden.")
                        Thread.sleep(1000)
                        dragonHP1 = dragonHP1 - (ritter.schaden * 3)
                    } else {
                        println("\n${ritter.name} wollte seinen harten Schlag einsetzen. Dieser hat aber noch ${ritter.abklingzeitHarterSchlag} Runde(n) Abklingzeit.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache1.name} ${ritter.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP1 = dragonHP1 - ritter.schaden
                    }
                    ritter.abklingzeitHarterSchlag--
                }

                "3" -> {
                    println("\n${ritter.name} setzt seinen normalen Angriff ein und macht ${drache1.name} ${ritter.schaden} Schaden.")
                    Thread.sleep(1000)
                    dragonHP1 = dragonHP1 - ritter.schaden
                }
            }
            println("[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}]\n\n")
            Thread.sleep(1000)
        } else {
            println("Falsche Eingabe\n\n")
            return ritterAngriffStufe1()
        }
    }

    fun moenchAngriffStufe1() {
        println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}]")
        Thread.sleep(1000)
        println("\nWähle eine Mönch-Fähigkeit")
        Thread.sleep(1000)
        println("[1] ${moench.faehigkeiten[0]}")
        println("[2] ${moench.faehigkeiten[1]}")
        println("[3] ${moench.faehigkeiten[2]}")
        var moenchFaehigkeitInput = readln()
        Thread.sleep(1000)
        if (moenchFaehigkeitInput == "1" || moenchFaehigkeitInput == "2" || moenchFaehigkeitInput == "3") {
            when (moenchFaehigkeitInput) {
                "1" -> {
                    if (moench.schwebenAbklingdauer == 0) {
                        moench.schwebenAktiv = true
                        moench.schwebenAbklingdauer = 4
                        println("\n${moench.name} hat 'Schweben' aktiviert. Er ist nun 1 Runde vor Bodenattacken geschützt!")
                        Thread.sleep(1000)
                        if (moench.schweben == false) {
                            moench.schweben = true
                            if (moench.schwebenAktiv && moench.schwebenAbklingdauer == 0) {
                                moench.schwebenAbklingdauer = 4
                            }
                        }
                    } else {
                        println("\n${moench.name} hat seine Fähigkeit bereits vor ${4 - moench.schwebenAbklingdauer} Runden aktiviert und kann aktuell nicht erneut genutzt werden!")
                        println("Abklingdauer noch ${moench.schwebenAbklingdauer} Runde(n)")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache1.name} ${moench.schaden} Schaden.\n\n")
                        dragonHP1 = dragonHP1 - moench.schaden
                    }
                    moench.schwebenAbklingdauer--
                }

                "2" -> {
                    if (moench.selbstHeilungNutzbarkeit) {
                        moench.selbstHeilungNutzbarkeit = false
                        var selbstHeilung: Double = moench.hp * 0.05
                        println("\n${moench.name} setzt seine Selbstheilungskräfte ein und erhält +${selbstHeilung} HP.")
                        Thread.sleep(1000)
                        moench.hp = moench.hp + selbstHeilung
                    } else {
                        println("\n${moench.name} wollte sich selbst heilen. Diese Fähigkeit wurde aber bereits verwendet.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache1.name} ${moench.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP1 = dragonHP1 - moench.schaden
                    }
                }

                "3" -> {
                    println("\n${moench.name} setzt seine Schockwelle ein und macht ${drache1.name} ${moench.schaden} Schaden.")
                    Thread.sleep(1000)
                    dragonHP1 = dragonHP1 - moench.schaden
                }
            }
            println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}]\n\n")
            Thread.sleep(1000)
        } else {
            println("Falsche Eingabe\n\n")
            return moenchAngriffStufe1()
        }
    }

    fun drachenAngriffStufe1() {
        println(
            """
            /|                                                               
        //^^^  ~~~~^^^^---___                   ^\            /|              
     /c~~`'     ____          ^^^^             /| \\        /_ _\             
     ~^^--; _\\\    ~~~---___     ~~~~        / '|  \\       | |              
         /_/                 --        ~~~__/ ,  |   \\       \ \             
                               -        |\--;' |  |    ;;      | |            
                               |          \   |    |    /     /  / 
                              |__ \  \     ~--|/~~\/~~|/     /  /             
                         /---_.     \  \         |    /      |  |             
                        ;-/   ~\-----   ;         |           |  |            
                         '--\_,--------'           |          |   |           
                           / ____    _^^^_..        |        -                
                          |       /^       ..       |       _    |            
                          | ---- |      .           |      _    |             
                           `     `.      |           |    -    -              
                            ` .--  `      |           -__-    -         
                             / ` -_.     /                   -          
                        _-__ ---^^     /          _---_____--        
      -------          ///  ///__ -__  / -____--~                 
        """.trimIndent()
        )
        Thread.sleep(3000)
        println("\nDrache ${drache1.name} wählt Angriff:")
        Thread.sleep(1000)
        var randomDrachenAngriff = drache1.faehigkeiten.random()
        println("...")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(2500)
        if (randomDrachenAngriff == drache1.faehigkeiten[0]) {
            if (!klon1.einsetzbar) {
                println("\n${drache1.name} wollte seinen Klon heraufbeschwören, dieser war aber schon im Einsatz.")
                return drachenAngriffStufe1()
            } else {
                println("${drache1.name}'s Klon erscheint...")
                klon1.einsetzbar = false
                if (magier.hp > 0) {
                    println("\nMagier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    Thread.sleep(1000)
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden1} an.")
                    Thread.sleep(1000)
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden1} an.")
                    Thread.sleep(1000)
                    if (magier.schutzschildGezogen) {
                        println("\nDie Angriffe vom Drachen und seinem Klon sind an ${magier.name}'s Schutzschild abgeprallt")
                        Thread.sleep(1000)
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
                        println("\nMagier HP: ${magier.hp} (-0) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    } else if (magier.doppelterSchadenEingesetzt) {
                        magier.doppelterSchadenEingesetzt = false
                        magier.doppelterSchadenNutzbarkeit = false
                        println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, erhält der Drache seinen eingesetzten Schaden verdoppelt zurück.")
                        Thread.sleep(1000)
                        println("Dabei stirbt sein Klon")
                        Thread.sleep(1000)
                        dragonHP1 = dragonHP1 - (dragonSchaden1 * 2)
                        dragonKlonHP1 = dragonKlonHP1 - dragonKlonHP1
                        println("\nMagier HP: ${magier.hp} (- 0) vs. Drachen HP: ${dragonHP1} (-${dragonSchaden1 * 2}) & Klon HP: ${dragonKlonHP1}\n\n")

                    } else {
                        verursachterSchaden = dragonSchaden1 + dragonKlonSchaden1
                        magier.hp = (magier.hp - verursachterSchaden)
                        Thread.sleep(1000)
                        println("\nMagier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}\n\n")

                    }
                }
                Thread.sleep(5000)
                if (ritter.hp > 0) {
                    println("\nRitter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    Thread.sleep(1000)
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden1} an.")
                    Thread.sleep(1000)
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden1} an.")
                    Thread.sleep(1000)
                    if (ritter.schutzschildGezogen) {
                        println("\nDie Angriffe vom Drachen und seinem Klon sind an ${ritter.name}'s Schutzschild abgeprallt")
                        Thread.sleep(1000)
                        ritter.schutzschildGezogen = false
                        ritter.unverwundbar = false
                        ritter.zustandSchutzSchild--
                        println("\nZustand Schutzschild ${ritter.zustandSchutzSchild}/5\n\n")
                        Thread.sleep(1000)
                        if (ritter.zustandSchutzSchild == 0) {
                            ritter.schutzSchildNutzbarkeit = false
                            ritter.schutzschildGezogen = false
                            ritter.unverwundbar = false
                        }
                        println("\nRitter HP: ${ritter.hp} (-0) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}\n\n")
                        Thread.sleep(1000)
                    } else {
                        verursachterSchaden = dragonSchaden1 + dragonKlonSchaden1
                        ritter.hp = (ritter.hp - verursachterSchaden)
                        println("\nRitter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}\n\n")
                        Thread.sleep(1000)
                    }
                }
                Thread.sleep(5000)
                if (moench.hp > 0) {
                    println("\nMönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    Thread.sleep(1000)
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden1} an.")
                    Thread.sleep(1000)
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden1} an.")
                    Thread.sleep(1000)
                    if (moench.schwebenAktiv) {
                        moench.schwebenAbklingdauer--
                    }
                    verursachterSchaden = dragonSchaden1 + dragonKlonSchaden1
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\nMönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}\n\n")
                    Thread.sleep(1000)
                }
                Thread.sleep(2500)
                if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                    heroesLostStufe1()
                }
            }
        }
        if (randomDrachenAngriff == drache1.faehigkeiten[1]) {
            println("\n${drache1.name} setzt 'Flächenschaden' ein...")
            Thread.sleep(1000)
            println("Der Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
            Thread.sleep(1000)
            if (magier.hp > 0) {
                println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}]")
                Thread.sleep(1000)
                if (magier.schutzschildGezogen) {
                    println("\nObwohl ${magier.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenEingesetzt = false
                    magier.doppelterSchadenNutzbarkeit = false
                    println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten.")
                    Thread.sleep(1000)
                    println("\nDieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache1.name} macht deshalb ${magier.name} ${drache1.flaechenSchaden} Schaden.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    magier.hp = magier.hp - verursachterSchaden
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\nMagier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (ritter.hp > 0) {
                println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}]")
                Thread.sleep(1000)
                if (ritter.schutzschildGezogen) {
                    ritter.schutzschildGezogen = false
                    println("\nObwohl ${ritter.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (moench.hp > 0) {
                println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}]")
                Thread.sleep(1000)
                if (moench.schwebenAktiv) {
                    println("\nDank ${moench.name}'s eingesetzter Schwebefähigkeit, konnte ${drache1.name} keinen Schaden erwirken.")
                    Thread.sleep(1000)
                    println("\n[Mönch HP: ${moench.hp} (-0) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                    moench.schwebenAktiv = false
                    moench.schwebenAbklingdauer--
                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(2500)
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe1()
            }
        }
        if (randomDrachenAngriff == drache1.faehigkeiten[2]) {
            println("\n${drache1.name} setzt 'Feueratem' ein...")
            Thread.sleep(1000)
            if (magier.hp > 0) {
                println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}]")
                Thread.sleep(1000)
                println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                Thread.sleep(1000)
                if (magier.schutzschildGezogen) {
                    println("\nDer Angriff vom Drachen ist an ${magier.name}'s Schutzschild abgeprallt")
                    Thread.sleep(1000)
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
                    println("\n[Magier HP: ${magier.hp} (-0) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenEingesetzt = false
                    magier.doppelterSchadenNutzbarkeit = false
                    println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten.")
                    Thread.sleep(1000)
                    println("\nDieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache1.name} macht deshalb ${magier.name} ${drache1.feuerAtemSchaden} Schaden.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (ritter.hp > 0) {
                println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}]")
                Thread.sleep(1000)
                println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                Thread.sleep(1000)
                if (ritter.schutzschildGezogen) {
                    println("\nDer Angriff vom Drachen ist an ${ritter.name}'s Schutzschild abgeprallt")
                    Thread.sleep(1000)
                    ritter.schutzschildGezogen = false
                    ritter.unverwundbar = false
                    ritter.zustandSchutzSchild--
                    println("\n[Ritter HP: ${ritter.hp} (-0) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (moench.hp > 0) {
                println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}]")
                Thread.sleep(1000)
                println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                Thread.sleep(1000)
                if (moench.schwebenAktiv) {
                    println("\nObwohl ${moench.name} aktuell 'Schweben' aktiviert hat, konnte dieser der Attacke nicht ausweichen.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                    Thread.sleep(1000)
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                }
                moench.schwebenAktiv = false
                moench.schwebenAbklingdauer--
            }
            Thread.sleep(2500)
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe1()
            }
        }
        if (randomDrachenAngriff == drache1.faehigkeiten[3]) {
            println("\n${drache1.name} hat seine HP-Klau Fähigkeit aktiviert und stielt einem zufälligen Helden 5% Gesamt-HP")
            Thread.sleep(1000)
            println("\nDrache wählt Held aus...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            if (randomHeld == "Magier") {
                magier.hp = magier.hp - magier.fuenfProzent
                dragonHP1 = dragonHP1 + magier.fuenfProzent
                println("\n[Magier HP:${magier.hp} HP vs. Drachen HP: ${dragonHP1} HP]")
                println("\nEs wurden ${magier.name} 5% HP abgezogen und ${drache1.name} hinzugefügt.")
                Thread.sleep(1000)
                println("\n[Magier HP: ${magier.hp} (-${magier.fuenfProzent} HP) vs. Drachen HP: ${dragonHP1} (+${magier.fuenfProzent} HP)]\n\n")
                Thread.sleep(1000)
            } else if (randomHeld == "Ritter") {
                ritter.hp = ritter.hp - ritter.fuenfProzent
                dragonHP1 = dragonHP1 + ritter.fuenfProzent
                println("\nEs wurden ${ritter.name} 5% HP abgezogen und ${drache1.name} hinzugefügt.")
                Thread.sleep(1000)
                println("\n[Ritter HP: ${ritter.hp} (-${ritter.fuenfProzent} HP) vs. Drachen HP: ${dragonHP1} (+${ritter.fuenfProzent} HP)]\n\n")
                Thread.sleep(1000)
            } else {
                moench.hp = moench.hp - moench.fuenfProzent
                dragonHP1 = dragonHP1 + moench.fuenfProzent
                println("\nEs wurden ${moench.name} 5% HP abgezogen und ${drache1.name} hinzugefügt.")
                Thread.sleep(1000)
                println("\n[Mönch HP: ${moench.hp} (-${moench.fuenfProzent} HP) vs. Drachen HP: ${dragonHP1} (+${moench.fuenfProzent} HP)]\n\n")
                Thread.sleep(1000)
            }
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe1()
            }
        }
        if (randomDrachenAngriff == drache1.faehigkeiten[4]) {
            println("\n${drache1.name} setzt 'Stampfattacke' ein...")
            Thread.sleep(1000)
            println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
            Thread.sleep(1000)
            println("\nZusätzlich betäubt er alle getroffenen Einheiten")
            Thread.sleep(1000)
            if (magier.hp > 0) {
                println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}]")
                Thread.sleep(1000)
                if (magier.schutzschildGezogen) {
                    magier.schutzschildGezogen = false
                    println("\nObwohl ${magier.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenEingesetzt = false
                    magier.doppelterSchadenNutzbarkeit = false
                    println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten...")
                    Thread.sleep(1000)
                    println("\nDieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache1.name} macht deshalb ${magier.name} ${drache1.flaechenSchaden} Schaden.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (ritter.hp > 0) {
                println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}]")
                Thread.sleep(1000)
                if (ritter.schutzschildGezogen) {
                    ritter.schutzschildGezogen = false
                    println("\nObwohl ${ritter.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${ritter.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    ritter.betaeubt = true
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${ritter.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    ritter.betaeubt = true
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (moench.hp > 0) {
                println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}]")
                Thread.sleep(1000)
                if (moench.schwebenAktiv) {
                    println("\nDank ${moench.name}'s eingesetzter Schwebefähigkeit, konnte ${drache1.name} keinen Schaden erwirken.")
                    Thread.sleep(1000)
                    println("\n[Mönch HP: ${moench.hp} (-0) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${moench.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    moench.hp = (moench.hp - verursachterSchaden)
                    moench.betaeubt = true
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}]\n\n")
                    Thread.sleep(1000)
                }
                moench.schwebenAktiv = false
                moench.schwebenAbklingdauer--
            }
            Thread.sleep(2500)
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe1()
            }
        }
        if (randomDrachenAngriff == drache1.faehigkeiten[5]) {
            drache1.gespuckteFeuerbaelle = 1
            println("\n${drache1.name} hat Feuerregen aktiviert und spuckt 5 Feuerbälle in die Luft.")
            Thread.sleep(1000)
            println("Wer wohl getroffen wird...")
            Thread.sleep(1000)
            println("Drache spuckt Feuerbälle...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            do {
                println("\nFeuerball Nr. ${drache1.gespuckteFeuerbaelle} fliegt durch die Luft und trifft:")
                Thread.sleep(1000)
                var randomHeldFeuerBaelle = drache1.feuerBaelleSpuckenRandomHeld.random()
                println(randomHeldFeuerBaelle)
                when (randomHeldFeuerBaelle) {
                    "Magier" -> {
                        verursachterSchaden = drache1.feuerRegenSchaden.toDouble()
                        magier.hp = magier.hp - verursachterSchaden
                        println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP1}]\n\n")
                        Thread.sleep(1000)
                    }

                    "Ritter" -> {
                        verursachterSchaden = drache1.feuerRegenSchaden.toDouble()
                        ritter.hp = ritter.hp - verursachterSchaden
                        println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP1}]\n\n")
                        Thread.sleep(1000)
                    }

                    "Mönch" -> {
                        verursachterSchaden = drache1.feuerRegenSchaden.toDouble()
                        moench.hp = moench.hp - verursachterSchaden
                        println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP1}]\n\n")
                        Thread.sleep(1000)
                    }

                    "daneben" -> {
                        println("\nDieser Feuerball ging daneben!")
                        Thread.sleep(1000)
                        println("Glück gehabt! 🎉\n\n")
                        Thread.sleep(1000)
                    }
                }
                drache1.gespuckteFeuerbaelle++
            } while (drache1.gespuckteFeuerbaelle <= drache1.feuerbaelle)
        }

        if (magier.betaeubt == true) {
            magier.betaeubt = false
        }
        if (ritter.betaeubt == true) {
            ritter.betaeubt = false
        }
        if (moench.betaeubt == true) {
            moench.betaeubt = false
        }
    }

    // GegnerSchwierigkeitsStufe 2
    fun magierAngriffStufe2() {
        println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP2}]")
        println("\nWähle eine Magier-Fähigkeit")
        Thread.sleep(1000)
        println("[1] ${magier.faehigkeiten[0]}")
        println("[2] ${magier.faehigkeiten[1]}")
        println("[3] ${magier.faehigkeiten[2]}")
        magierFaehigkeitInput = readln()
        Thread.sleep(1000)
        if (magierFaehigkeitInput == "1" || magierFaehigkeitInput == "2" || magierFaehigkeitInput == "3") {
            when (magierFaehigkeitInput) {
                "1" -> {
                    if (magier.abklingzeitSchutzSchild == 0) {
                        magier.schutzschildGezogen = true
                        println("\n${magier.name} hat sein Schutzschild gezogen. Er ist nun 1 Runde unverwundbar.")
                        Thread.sleep(2500)
                        println("...außer gegen Bodenattacken! 😋\n")
                        if (magier.schutzschildGezogen) {
                            magier.schutzschildNutzbarkeit = false
                            magier.schutzSchildMöglich = false
                            magier.unverwundbar = true
                            magier.abklingzeitSchutzSchild = 3
                        }
                    } else {
                        println("\n${magier.name} wollte sein Schutzschild einsetzen. Dieser hat aber noch ${magier.abklingzeitSchutzSchild} Runde Abklingzeit.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache2.name} ${magier.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP2 = dragonHP2 - magier.schaden
                    }
                    magier.abklingzeitSchutzSchild--
                }

                "2" -> {
                    if (magier.abklingzeitDoppelterSchaden == 0) {
                        magier.doppelterSchadenNutzbarkeit = false
                        println("\n${magier.name} setzt seinen Schadenverdopplungszauber ein und schickt verursachten Schaden durch ${drache2.name} zurück und verdoppelt diesen.")
                        Thread.sleep(1000)
                        if (!magier.doppelterSchadenNutzbarkeit) {
                            magier.doppelterSchadenEingesetzt = true
                            magier.abklingzeitDoppelterSchaden = 3
                        }
                    } else {
                        println("\n${magier.name} wollte seinen Schadenverdopplungszauber einsetzen. Dieser hat aber noch ${magier.abklingzeitDoppelterSchaden} Runde Abklingzeit.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache2.name} ${magier.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP2 = dragonHP2 - magier.schaden
                    }
                    magier.abklingzeitDoppelterSchaden--
                }

                "3" -> {
                    println("\n${magier.name} setzt seinen normalen Angriff ein und macht ${drache2.name} ${magier.schaden} Schaden.")
                    Thread.sleep(1000)
                    dragonHP2 = dragonHP2 - magier.schaden
                }
            }
            println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP2}]\n\n")
            Thread.sleep(1000)
        } else {
            println("Falsche Eingabe\n\n")
            return magierAngriffStufe2()
        }
    }

    fun ritterAngriffStufe2() {
        println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP2}]")
        Thread.sleep(1000)
        println("\nWähle eine Ritter-Fähigkeit")
        Thread.sleep(1000)
        println("[1] ${ritter.faehigkeiten[0]}")
        println("[2] ${ritter.faehigkeiten[1]} (Haltbarkeit: ${ritter.zustandSchutzSchild}/5)")
        println("[3] ${ritter.faehigkeiten[2]}")
        var ritterFaehigkeitInput = readln()
        Thread.sleep(1000)
        if (ritterFaehigkeitInput == "1" || ritterFaehigkeitInput == "2" || ritterFaehigkeitInput == "3") {
            when (ritterFaehigkeitInput) {
                "1" -> {
                    if (ritter.zustandSchutzSchild > 0) {
                        ritter.schutzSchildNutzbarkeit = true
                        if (!ritter.schutzschildGezogen) {
                            ritter.schutzschildGezogen = true
                            ritter.unverwundbar = true
                            ritter.schutzSchildAbklingdauer = 1
                            println("\n${ritter.name} hat sein Schutzschild gezogen und ist nun 1 Runde unverwundbar.")
                            Thread.sleep(2000)
                            println("...außer gegen Bodenattacken! 😋")
                            Thread.sleep(1000)
                            println("Abklingdauer ${ritter.schutzSchildAbklingdauer} Runde(n), Zustand ${ritter.zustandSchutzSchild}/5!\n")
                        } else {
                            println("\n${ritter.name} hat bereits sein Schutzschild gezogen. Abklingdauer noch ${ritter.schutzSchildAbklingdauer} Runde(n), Zustand ${ritter.zustandSchutzSchild}/5!")
                            Thread.sleep(1000)
                            println("\nDeshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache2.name} ${ritter.schaden} Schaden.")
                            Thread.sleep(1000)
                            dragonHP2 = dragonHP2 - ritter.schaden
                            ritter.schutzSchildAbklingdauer--
                        }
                    } else {
                        ritter.schutzSchildNutzbarkeit = false
                        println("\n${ritter.name}'s Schutzschild ist zerbrochen und kann nicht mehr genutzt werden!")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache2.name} ${ritter.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP2 = dragonHP2 - ritter.schaden
                    }
                }

                "2" -> {
                    if (ritter.abklingzeitHarterSchlag == 0 && ritter.harterSchlagVerfügbar) {
                        ritter.abklingzeitHarterSchlag = 5
                        ritter.harterSchlagVerfügbar = false
                        println("\n${ritter.name} setzt seinen harten Schlag ein und macht ${drache2.name} ${ritter.schaden * 3} Schaden.")
                        Thread.sleep(1000)
                        dragonHP2 = dragonHP2 - (ritter.schaden * 3)
                    } else {
                        println("\n${ritter.name} wollte seinen harten Schlag einsetzen. Dieser hat aber noch ${ritter.abklingzeitHarterSchlag} Runde(n) Abklingzeit.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache2.name} ${ritter.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP2 = dragonHP2 - ritter.schaden
                    }
                    ritter.abklingzeitHarterSchlag--
                }

                "3" -> {
                    println("\n${ritter.name} setzt seinen normalen Angriff ein und macht ${drache2.name} ${ritter.schaden} Schaden.")
                    Thread.sleep(1000)
                    dragonHP2 = dragonHP2 - ritter.schaden
                }
            }
            println("[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP2}]\n\n")
            Thread.sleep(1000)
        } else {
            println("Falsche Eingabe\n\n")
            return ritterAngriffStufe2()
        }
    }

    fun moenchAngriffStufe2() {
        println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP2}]")
        Thread.sleep(1000)
        println("\nWähle eine Mönch-Fähigkeit")
        Thread.sleep(1000)
        println("[1] ${moench.faehigkeiten[0]}")
        println("[2] ${moench.faehigkeiten[1]}")
        println("[3] ${moench.faehigkeiten[2]}")
        var moenchFaehigkeitInput = readln()
        Thread.sleep(1000)
        if (moenchFaehigkeitInput == "1" || moenchFaehigkeitInput == "2" || moenchFaehigkeitInput == "3") {
            when (moenchFaehigkeitInput) {
                "1" -> {
                    if (moench.schwebenAbklingdauer == 0) {
                        moench.schwebenAktiv = true
                        moench.schwebenAbklingdauer = 4
                        println("\n${moench.name} hat 'Schweben' aktiviert. Er ist nun 1 Runde vor Bodenattacken geschützt!")
                        Thread.sleep(1000)
                        if (moench.schweben == false) {
                            moench.schweben = true
                            if (moench.schwebenAktiv && moench.schwebenAbklingdauer == 0) {
                                moench.schwebenAbklingdauer = 4
                            }
                        }
                    } else {
                        println("\n${moench.name} hat seine Fähigkeit bereits vor ${4 - moench.schwebenAbklingdauer} Runden aktiviert und kann aktuell nicht erneut genutzt werden!")
                        println("Abklingdauer noch ${moench.schwebenAbklingdauer} Runde(n)")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache2.name} ${moench.schaden} Schaden.\n\n")
                        dragonHP2 = dragonHP2 - moench.schaden
                    }
                    moench.schwebenAbklingdauer--
                }

                "2" -> {
                    if (moench.selbstHeilungNutzbarkeit) {
                        moench.selbstHeilungNutzbarkeit = false
                        var selbstHeilung: Double = moench.hp * 0.05
                        println("\n${moench.name} setzt seine Selbstheilungskräfte ein und erhält +${selbstHeilung} HP.")
                        Thread.sleep(1000)
                        moench.hp = moench.hp + selbstHeilung
                    } else {
                        println("\n${moench.name} wollte sich selbst heilen. Diese Fähigkeit wurde aber bereits verwendet.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache2.name} ${moench.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP2 = dragonHP2 - moench.schaden
                    }
                }

                "3" -> {
                    println("\n${moench.name} setzt seine Schockwelle ein und macht ${drache2.name} ${moench.schaden} Schaden.")
                    Thread.sleep(1000)
                    dragonHP2 = dragonHP2 - moench.schaden
                }
            }
            println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP2}]\n\n")
            Thread.sleep(1000)
        } else {
            println("Falsche Eingabe\n\n")
            return moenchAngriffStufe2()
        }
    }

    fun drachenAngriffStufe2() {
        println(
            """
            /|                                                               
        //^^^  ~~~~^^^^---___                   ^\            /|              
     /c~~`'     ____          ^^^^             /| \\        /_ _\             
     ~^^--; _\\\    ~~~---___     ~~~~        / '|  \\       | |              
         /_/                 --        ~~~__/ ,  |   \\       \ \             
                               -        |\--;' |  |    ;;      | |            
                               |          \   |    |    /     /  / 
                              |__ \  \     ~--|/~~\/~~|/     /  /             
                         /---_.     \  \         |    /      |  |             
                        ;-/   ~\-----   ;         |           |  |            
                         '--\_,--------'           |          |   |           
                           / ____    _^^^_..        |        -                
                          |       /^       ..       |       _    |            
                          | ---- |      .           |      _    |             
                           `     `.      |           |    -    -              
                            ` .--  `      |           -__-    -         
                             / ` -_.     /                   -          
                        _-__ ---^^     /          _---_____--        
      -------          ///  ///__ -__  / -____--~                 
        """.trimIndent()
        )
        Thread.sleep(3000)
        println("\nDrache ${drache2.name} wählt Angriff:")
        Thread.sleep(1000)
        var randomDrachenAngriff = drache2.faehigkeiten.random()
        println("...")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(2500)
        if (randomDrachenAngriff == drache2.faehigkeiten[0]) {
            if (!klon2.einsetzbar) {
                println("\n${drache2.name} wollte seinen Klon heraufbeschwören, dieser war aber schon im Einsatz.")
                return drachenAngriffStufe2()
            } else {
                println("${drache2.name}'s Klon erscheint...")
                klon2.einsetzbar = false
                if (magier.hp > 0) {
                    println("\nMagier HP: ${magier.hp} vs. Drachen HP: ${dragonHP2} & Klon HP: ${dragonKlonHP2}")
                    Thread.sleep(1000)
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden2} an.")
                    Thread.sleep(1000)
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden2} an.")
                    Thread.sleep(1000)
                    if (magier.schutzschildGezogen) {
                        println("\nDie Angriffe vom Drachen und seinem Klon sind an ${magier.name}'s Schutzschild abgeprallt")
                        Thread.sleep(1000)
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
                        println("\nMagier HP: ${magier.hp} (-0) vs. Drachen HP: ${dragonHP2} & Klon HP: ${dragonKlonHP2}")
                    } else if (magier.doppelterSchadenEingesetzt) {
                        magier.doppelterSchadenNutzbarkeit = false
                        println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, erhält der Drache seinen eingesetzten Schaden verdoppelt zurück.")
                        Thread.sleep(1000)
                        println("Dabei stirbt sein Klon")
                        Thread.sleep(1000)
                        dragonHP2 = dragonHP2 - (dragonSchaden2 * 2)
                        dragonKlonHP2 = dragonKlonHP2 - dragonKlonHP2
                        println("\nMagier HP: ${magier.hp} (- 0) vs. Drachen HP: ${dragonHP2} (-${dragonSchaden2 * 2}) & Klon HP: ${dragonKlonHP2}\n\n")

                    } else {
                        verursachterSchaden = dragonSchaden2 + dragonKlonSchaden2
                        magier.hp = (magier.hp - verursachterSchaden)
                        Thread.sleep(1000)
                        println("\nMagier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2} & Klon HP: ${dragonKlonHP2}\n\n")

                    }
                }
                Thread.sleep(5000)
                if (ritter.hp > 0) {
                    println("\nRitter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP2} & Klon HP: ${dragonKlonHP2}")
                    Thread.sleep(1000)
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden2} an.")
                    Thread.sleep(2000)
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden2} an.")
                    Thread.sleep(1000)
                    if (ritter.schutzschildGezogen) {
                        println("\nDie Angriffe vom Drachen und seinem Klon sind an ${ritter.name}'s Schutzschild abgeprallt")
                        Thread.sleep(1000)
                        ritter.schutzschildGezogen = true
                        ritter.unverwundbar = true
                        ritter.zustandSchutzSchild--
                        println("\nZustand Schutzschild ${ritter.zustandSchutzSchild}/5\n\n")
                        Thread.sleep(1000)
                        if (ritter.zustandSchutzSchild == 0) {
                            ritter.schutzSchildNutzbarkeit = false
                            ritter.schutzschildGezogen = false
                            ritter.unverwundbar = false
                        }
                        println("\nRitter HP: ${ritter.hp} (-0) vs. Drachen HP: ${dragonHP2} & Klon HP: ${dragonKlonHP2}\n\n")
                        Thread.sleep(1000)
                    } else {
                        verursachterSchaden = dragonSchaden2 + dragonKlonSchaden2
                        ritter.hp = (ritter.hp - verursachterSchaden)
                        println("\nRitter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2} & Klon HP: ${dragonKlonHP2}\n\n")
                        Thread.sleep(1000)
                    }
                }
                Thread.sleep(5000)
                if (moench.hp > 0) {
                    println("\nMönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP2} & Klon HP: ${dragonKlonHP2}")
                    Thread.sleep(1000)
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden2} an.")
                    Thread.sleep(1000)
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden2} an.")
                    Thread.sleep(1000)
                    if (moench.schwebenAktiv) {
                        moench.schwebenAbklingdauer--
                    }
                    verursachterSchaden = dragonSchaden2 + dragonKlonSchaden2
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\nMönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2} & Klon HP: ${dragonKlonHP2}\n\n")
                    Thread.sleep(1000)
                }
                Thread.sleep(2500)
                if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                    heroesLostStufe2()
                }
            }
        }
        if (randomDrachenAngriff == drache2.faehigkeiten[2]) {
            println("\n${drache2.name} setzt 'Flächenschaden' ein...")
            Thread.sleep(1000)
            println("Der Drache greift mit einem Schaden von ${drache2.flaechenSchaden} an.")
            Thread.sleep(1000)
            if (magier.hp > 0) {
                println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP2}]")
                Thread.sleep(1000)
                if (magier.schutzschildGezogen) {
                    println("\nObwohl ${magier.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenNutzbarkeit = false
                    println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten.")
                    Thread.sleep(1000)
                    println("\nDieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache2.name} macht deshalb ${magier.name} ${drache2.flaechenSchaden} Schaden.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    magier.hp = magier.hp - verursachterSchaden
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\nMagier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (ritter.hp > 0) {
                println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP2}]")
                Thread.sleep(1000)
                if (ritter.schutzschildGezogen) {
                    println("\nObwohl ${ritter.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (moench.hp > 0) {
                println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP2}]")
                Thread.sleep(1000)
                if (moench.schwebenAktiv) {
                    println("\nDank ${moench.name}'s eingesetzter Schwebefähigkeit, konnte ${drache2.name} keinen Schaden erwirken.")
                    Thread.sleep(1000)
                    println("\n[Mönch HP: ${moench.hp} (-0) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                    moench.schwebenAktiv = false
                } else {
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(2500)
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe2()
            }
        }
        if (randomDrachenAngriff == drache2.faehigkeiten[2]) {
            println("\n${drache2.name} setzt 'Feueratem' ein...")
            Thread.sleep(1000)
            if (magier.hp > 0) {
                println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP2}]")
                Thread.sleep(1000)
                println("\nDer Drache greift mit einem Schaden von ${drache2.feuerAtemSchaden} an.")
                Thread.sleep(1000)
                if (magier.schutzschildGezogen) {
                    println("\nDer Angriff vom Drachen ist an ${magier.name}'s Schutzschild abgeprallt")
                    Thread.sleep(1000)
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
                    println("\n[Magier HP: ${magier.hp} (-0) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenNutzbarkeit = false
                    println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten.")
                    Thread.sleep(1000)
                    println("\nDieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache2.name} macht deshalb ${magier.name} ${drache2.feuerAtemSchaden} Schaden.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache2.feuerAtemSchaden.toDouble()
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache2.feuerAtemSchaden.toDouble()
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (ritter.hp > 0) {
                println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP2}]")
                Thread.sleep(1000)
                println("\nDer Drache greift mit einem Schaden von ${drache2.feuerAtemSchaden} an.")
                Thread.sleep(1000)
                if (ritter.schutzschildGezogen) {
                    println("\nDer Angriff vom Drachen ist an ${ritter.name}'s Schutzschild abgeprallt")
                    Thread.sleep(1000)
                    ritter.schutzschildGezogen = true
                    ritter.unverwundbar = true
                    ritter.zustandSchutzSchild--
                    println("\n[Ritter HP: ${ritter.hp} (-0) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache2.feuerAtemSchaden.toDouble()
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (moench.hp > 0) {
                println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP2}]")
                Thread.sleep(1000)
                println("\nDer Drache greift mit einem Schaden von ${drache2.feuerAtemSchaden} an.")
                Thread.sleep(1000)
                if (moench.schwebenAktiv) {
                    println("\nObwohl ${moench.name} aktuell 'Schweben' aktiviert hat, konnte dieser der Attacke nicht ausweichen.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache2.feuerAtemSchaden.toDouble()
                    Thread.sleep(1000)
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache2.feuerAtemSchaden.toDouble()
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(2500)
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe2()
            }
        }
        if (randomDrachenAngriff == drache2.faehigkeiten[3]) {
            println("\n${drache2.name} hat seine HP-Klau Fähigkeit aktiviert und stielt einem zufälligen Helden 5% Gesamt-HP")
            Thread.sleep(1000)
            println("\nDrache wählt Held aus...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            if (randomHeld == "Magier") {
                magier.hp = magier.hp - magier.fuenfProzent
                dragonHP2 = dragonHP2 + magier.fuenfProzent
                println("\n[Magier HP:${magier.hp} HP vs. Drachen HP: ${dragonHP2} HP]")
                println("\nEs wurden ${magier.name} 5% HP abgezogen und ${drache2.name} hinzugefügt.")
                Thread.sleep(1000)
                println("\n[Magier HP: ${magier.hp} (-${magier.fuenfProzent} HP) vs. Drachen HP: ${dragonHP2} (+${magier.fuenfProzent} HP)]\n\n")
                Thread.sleep(1000)
            } else if (randomHeld == "Ritter") {
                ritter.hp = ritter.hp - ritter.fuenfProzent
                dragonHP2 = dragonHP2 + ritter.fuenfProzent
                println("\nEs wurden ${ritter.name} 5% HP abgezogen und ${drache2.name} hinzugefügt.")
                Thread.sleep(1000)
                println("\n[Ritter HP: ${ritter.hp} (-${ritter.fuenfProzent} HP) vs. Drachen HP: ${dragonHP2} (+${ritter.fuenfProzent} HP)]\n\n")
                Thread.sleep(1000)
            } else {
                moench.hp = moench.hp - moench.fuenfProzent
                dragonHP2 = dragonHP2 + moench.fuenfProzent
                println("\nEs wurden ${moench.name} 5% HP abgezogen und ${drache2.name} hinzugefügt.")
                Thread.sleep(1000)
                println("\n[Mönch HP: ${moench.hp} (-${moench.fuenfProzent} HP) vs. Drachen HP: ${dragonHP2} (+${moench.fuenfProzent} HP)]\n\n")
                Thread.sleep(1000)
            }
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe2()
            }
        }
        if (randomDrachenAngriff == drache2.faehigkeiten[4]) {
            println("\n${drache2.name} setzt 'Stampfattacke' ein...")
            Thread.sleep(1000)
            println("\nDer Drache greift mit einem Schaden von ${drache2.flaechenSchaden} an.")
            Thread.sleep(1000)
            println("\nZusätzlich betäubt er alle getroffenen Einheiten")
            Thread.sleep(1000)
            if (magier.hp > 0) {
                println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP2}]")
                Thread.sleep(1000)
                if (magier.schutzschildGezogen) {
                    println("\nObwohl ${magier.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenNutzbarkeit = false
                    println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten...")
                    Thread.sleep(1000)
                    println("\nDieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache2.name} macht deshalb ${magier.name} ${drache2.flaechenSchaden} Schaden.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (ritter.hp > 0) {
                println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP2}]")
                Thread.sleep(1000)
                if (ritter.schutzschildGezogen) {
                    println("\nObwohl ${ritter.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${ritter.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    ritter.betaeubt = true
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(2000)
                } else {
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${ritter.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    ritter.betaeubt = true
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (moench.hp > 0) {
                println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP2}]")
                Thread.sleep(1000)
                if (moench.schwebenAktiv) {
                    println("\nDank ${moench.name}'s eingesetzter Schwebefähigkeit, konnte ${drache2.name} keinen Schaden erwirken.")
                    Thread.sleep(1000)
                    println("\n[Mönch HP: ${moench.hp} (-0) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache2.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${moench.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    moench.hp = (moench.hp - verursachterSchaden)
                    moench.betaeubt = true
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP2}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(2500)
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe2()
            }
        }
        if (randomDrachenAngriff == drache2.faehigkeiten[5]) {
            drache2.gespuckteFeuerbaelle = 1
            println("\n${drache2.name} hat Feuerregen aktiviert und spuckt 5 Feuerbälle in die Luft.")
            Thread.sleep(1000)
            println("Wer wohl getroffen wird...")
            Thread.sleep(1000)
            println("Drache spuckt Feuerbälle...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            do {
                println("\nFeuerball Nr. ${drache2.gespuckteFeuerbaelle} fliegt durch die Luft und trifft:")
                Thread.sleep(1000)
                var randomHeldFeuerBaelle = drache2.feuerBaelleSpuckenRandomHeld.random()
                println(randomHeldFeuerBaelle)
                when (randomHeldFeuerBaelle) {
                    "Magier" -> {
                        verursachterSchaden = drache2.feuerRegenSchaden.toDouble()
                        magier.hp = magier.hp - verursachterSchaden
                        println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP2}]\n\n")
                        Thread.sleep(1000)
                    }

                    "Ritter" -> {
                        verursachterSchaden = drache2.feuerRegenSchaden.toDouble()
                        ritter.hp = ritter.hp - verursachterSchaden
                        println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP2}]\n\n")
                        Thread.sleep(1000)
                    }

                    "Mönch" -> {
                        verursachterSchaden = drache2.feuerRegenSchaden.toDouble()
                        moench.hp = moench.hp - verursachterSchaden
                        println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP2}]\n\n")
                        Thread.sleep(1000)
                    }

                    "daneben" -> {
                        println("\nDieser Feuerball ging daneben!")
                        Thread.sleep(1000)
                        println("Glück gehabt! 🎉\n\n")
                        Thread.sleep(1000)
                    }
                }
                drache2.gespuckteFeuerbaelle++
            } while (drache2.gespuckteFeuerbaelle <= drache2.feuerbaelle)
        }

        if (magier.betaeubt == true) {
            magier.betaeubt = false
        }
        if (ritter.betaeubt == true) {
            ritter.betaeubt = false
        }
        if (moench.betaeubt == true) {
            moench.betaeubt = false
        }
    }

    // GegnerSchwierigkeitsStufe 3
    fun magierAngriffStufe3() {
        println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP3}]")
        println("\nWähle eine Magier-Fähigkeit")
        Thread.sleep(1000)
        println("[1] ${magier.faehigkeiten[0]}")
        println("[2] ${magier.faehigkeiten[1]}")
        println("[3] ${magier.faehigkeiten[2]}")
        magierFaehigkeitInput = readln()
        Thread.sleep(1000)
        if (magierFaehigkeitInput == "1" || magierFaehigkeitInput == "2" || magierFaehigkeitInput == "3") {
            when (magierFaehigkeitInput) {
                "1" -> {
                    if (magier.abklingzeitSchutzSchild == 0) {
                        magier.schutzschildGezogen = true
                        println("\n${magier.name} hat sein Schutzschild gezogen. Er ist nun 1 Runde unverwundbar.")
                        Thread.sleep(2500)
                        println("...außer gegen Bodenattacken! 😋\n")
                        if (magier.schutzschildGezogen) {
                            magier.schutzschildNutzbarkeit = false
                            magier.schutzSchildMöglich = false
                            magier.unverwundbar = true
                            magier.abklingzeitSchutzSchild = 3
                        }
                    } else {
                        println("\n${magier.name} wollte sein Schutzschild einsetzen. Dieser hat aber noch ${magier.abklingzeitSchutzSchild} Runde Abklingzeit.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache3.name} ${magier.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP3 = dragonHP3 - magier.schaden
                    }
                    magier.abklingzeitSchutzSchild--
                }

                "2" -> {
                    if (magier.abklingzeitDoppelterSchaden == 0) {
                        magier.doppelterSchadenNutzbarkeit = false
                        println("\n${magier.name} setzt seinen Schadenverdopplungszauber ein und schickt verursachten Schaden durch ${drache3.name} zurück und verdoppelt diesen.")
                        Thread.sleep(1000)
                        if (!magier.doppelterSchadenNutzbarkeit) {
                            magier.doppelterSchadenEingesetzt = true
                            magier.abklingzeitDoppelterSchaden = 3
                        }
                    } else {
                        println("\n${magier.name} wollte seinen Schadenverdopplungszauber einsetzen. Dieser hat aber noch ${magier.abklingzeitDoppelterSchaden} Runde Abklingzeit.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache3.name} ${magier.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP3 = dragonHP3 - magier.schaden
                    }
                    magier.abklingzeitDoppelterSchaden--
                }

                "3" -> {
                    println("\n${magier.name} setzt seinen normalen Angriff ein und macht ${drache3.name} ${magier.schaden} Schaden.")
                    Thread.sleep(1000)
                    dragonHP3 = dragonHP3 - magier.schaden
                }
            }
            println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP3}]\n\n")
            Thread.sleep(1000)
        } else {
            println("Falsche Eingabe\n\n")
            return magierAngriffStufe3()
        }
    }

    fun ritterAngriffStufe3() {
        println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP3}]")
        Thread.sleep(1000)
        println("\nWähle eine Ritter-Fähigkeit")
        Thread.sleep(1000)
        println("[1] ${ritter.faehigkeiten[0]}")
        println("[2] ${ritter.faehigkeiten[1]} (Haltbarkeit: ${ritter.zustandSchutzSchild}/5)")
        println("[3] ${ritter.faehigkeiten[2]}")
        var ritterFaehigkeitInput = readln()
        Thread.sleep(1000)
        if (ritterFaehigkeitInput == "1" || ritterFaehigkeitInput == "2" || ritterFaehigkeitInput == "3") {
            when (ritterFaehigkeitInput) {
                "1" -> {
                    if (ritter.zustandSchutzSchild > 0) {
                        ritter.schutzSchildNutzbarkeit = true
                        if (!ritter.schutzschildGezogen) {
                            ritter.schutzschildGezogen = true
                            ritter.unverwundbar = true
                            ritter.schutzSchildAbklingdauer = 1
                            println("\n${ritter.name} hat sein Schutzschild gezogen und ist nun 1 Runde unverwundbar.")
                            Thread.sleep(2000)
                            println("...außer gegen Bodenattacken! 😋")
                            Thread.sleep(1000)
                            println("Abklingdauer ${ritter.schutzSchildAbklingdauer} Runde(n), Zustand ${ritter.zustandSchutzSchild}/5!\n")
                        } else {
                            println("\n${ritter.name} hat bereits sein Schutzschild gezogen. Abklingdauer noch ${ritter.schutzSchildAbklingdauer} Runde(n), Zustand ${ritter.zustandSchutzSchild}/5!")
                            Thread.sleep(1000)
                            println("\nDeshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache3.name} ${ritter.schaden} Schaden.")
                            Thread.sleep(1000)
                            dragonHP3 = dragonHP3 - ritter.schaden
                            ritter.schutzSchildAbklingdauer--
                        }
                    } else {
                        ritter.schutzSchildNutzbarkeit = false
                        println("\n${ritter.name}'s Schutzschild ist zerbrochen und kann nicht mehr genutzt werden!")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache3.name} ${ritter.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP3 = dragonHP3 - ritter.schaden
                    }
                }

                "2" -> {
                    if (ritter.abklingzeitHarterSchlag == 0 && ritter.harterSchlagVerfügbar) {
                        ritter.abklingzeitHarterSchlag = 5
                        ritter.harterSchlagVerfügbar = false
                        println("\n${ritter.name} setzt seinen harten Schlag ein und macht ${drache3.name} ${ritter.schaden * 3} Schaden.")
                        Thread.sleep(1000)
                        dragonHP3 = dragonHP3 - (ritter.schaden * 3)
                    } else {
                        println("\n${ritter.name} wollte seinen harten Schlag einsetzen. Dieser hat aber noch ${ritter.abklingzeitHarterSchlag} Runde(n) Abklingzeit.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${ritter.name} seinen normalen Angriff ein und macht ${drache3.name} ${ritter.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP3 = dragonHP3 - ritter.schaden
                    }
                    ritter.abklingzeitHarterSchlag--
                }

                "3" -> {
                    println("\n${ritter.name} setzt seinen normalen Angriff ein und macht ${drache3.name} ${ritter.schaden} Schaden.")
                    Thread.sleep(1000)
                    dragonHP3 = dragonHP3 - ritter.schaden
                }
            }
            println("[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP3}]\n\n")
            Thread.sleep(1000)
        } else {
            println("Falsche Eingabe\n\n")
            return ritterAngriffStufe3()
        }
    }

    fun moenchAngriffStufe3() {
        println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP3}]")
        Thread.sleep(1000)
        println("\nWähle eine Mönch-Fähigkeit")
        Thread.sleep(1000)
        println("[1] ${moench.faehigkeiten[0]}")
        println("[2] ${moench.faehigkeiten[1]}")
        println("[3] ${moench.faehigkeiten[2]}")
        var moenchFaehigkeitInput = readln()
        Thread.sleep(1000)
        if (moenchFaehigkeitInput == "1" || moenchFaehigkeitInput == "2" || moenchFaehigkeitInput == "3") {
            when (moenchFaehigkeitInput) {
                "1" -> {
                    if (moench.schwebenAbklingdauer == 0) {
                        moench.schwebenAktiv = true
                        moench.schwebenAbklingdauer = 4
                        println("\n${moench.name} hat 'Schweben' aktiviert. Er ist nun 1 Runde vor Bodenattacken geschützt!")
                        Thread.sleep(1000)
                        if (moench.schweben == false) {
                            moench.schweben = true
                            if (moench.schwebenAktiv && moench.schwebenAbklingdauer == 0) {
                                moench.schwebenAbklingdauer = 4
                            }
                        }
                    } else {
                        println("\n${moench.name} hat seine Fähigkeit bereits vor ${4 - moench.schwebenAbklingdauer} Runden aktiviert und kann aktuell nicht erneut genutzt werden!")
                        println("Abklingdauer noch ${moench.schwebenAbklingdauer} Runde(n)")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache3.name} ${moench.schaden} Schaden.\n\n")
                        dragonHP3 = dragonHP3 - moench.schaden
                    }
                    moench.schwebenAbklingdauer--
                }

                "2" -> {
                    if (moench.selbstHeilungNutzbarkeit) {
                        moench.selbstHeilungNutzbarkeit = false
                        var selbstHeilung: Double = moench.hp * 0.05
                        println("\n${moench.name} setzt seine Selbstheilungskräfte ein und erhält +${selbstHeilung} HP.")
                        Thread.sleep(1000)
                        moench.hp = moench.hp + selbstHeilung
                    } else {
                        println("\n${moench.name} wollte sich selbst heilen. Diese Fähigkeit wurde aber bereits verwendet.")
                        Thread.sleep(1000)
                        println("\nDeshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache3.name} ${moench.schaden} Schaden.")
                        Thread.sleep(1000)
                        dragonHP3 = dragonHP3 - moench.schaden
                    }
                }

                "3" -> {
                    println("\n${moench.name} setzt seine Schockwelle ein und macht ${drache3.name} ${moench.schaden} Schaden.")
                    Thread.sleep(1000)
                    dragonHP3 = dragonHP3 - moench.schaden
                }
            }
            println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP3}]\n\n")
            Thread.sleep(1000)
        } else {
            println("Falsche Eingabe\n\n")
            return moenchAngriffStufe3()
        }
    }

    fun drachenAngriffStufe3() {
        println(
            """
            /|                                                               
        //^^^  ~~~~^^^^---___                   ^\            /|              
     /c~~`'     ____          ^^^^             /| \\        /_ _\             
     ~^^--; _\\\    ~~~---___     ~~~~        / '|  \\       | |              
         /_/                 --        ~~~__/ ,  |   \\       \ \             
                               -        |\--;' |  |    ;;      | |            
                               |          \   |    |    /     /  / 
                              |__ \  \     ~--|/~~\/~~|/     /  /             
                         /---_.     \  \         |    /      |  |             
                        ;-/   ~\-----   ;         |           |  |            
                         '--\_,--------'           |          |   |           
                           / ____    _^^^_..        |        -                
                          |       /^       ..       |       _    |            
                          | ---- |      .           |      _    |             
                           `     `.      |           |    -    -              
                            ` .--  `      |           -__-    -         
                             / ` -_.     /                   -          
                        _-__ ---^^     /          _---_____--        
      -------          ///  ///__ -__  / -____--~                 
        """.trimIndent()
        )
        Thread.sleep(3000)
        println("\nDrache ${drache3.name} wählt Angriff:")
        Thread.sleep(1000)
        var randomDrachenAngriff = drache3.faehigkeiten.random()
        println("...")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(1000)
        println("...")
        Thread.sleep(2500)
        if (randomDrachenAngriff == drache3.faehigkeiten[0]) {
            if (!klon3.einsetzbar) {
                println("\n${drache3.name} wollte seinen Klon heraufbeschwören, dieser war aber schon im Einsatz.")
                return drachenAngriffStufe2()
            } else {
                println("${drache3.name}'s Klon erscheint...")
                klon3.einsetzbar = false
                if (magier.hp > 0) {
                    println("\nMagier HP: ${magier.hp} vs. Drachen HP: ${dragonHP3} & Klon HP: ${dragonKlonHP2}")
                    Thread.sleep(1000)
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden2} an.")
                    Thread.sleep(1000)
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden2} an.")
                    Thread.sleep(1000)
                    if (magier.schutzschildGezogen) {
                        println("\nDie Angriffe vom Drachen und seinem Klon sind an ${magier.name}'s Schutzschild abgeprallt")
                        Thread.sleep(1000)
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
                        println("\nMagier HP: ${magier.hp} (-0) vs. Drachen HP: ${dragonHP3} & Klon HP: ${dragonKlonHP2}")
                    } else if (magier.doppelterSchadenEingesetzt) {
                        magier.doppelterSchadenNutzbarkeit = false
                        println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, erhält der Drache seinen eingesetzten Schaden verdoppelt zurück.")
                        Thread.sleep(1000)
                        println("Dabei stirbt sein Klon")
                        Thread.sleep(1000)
                        dragonHP3 = dragonHP3 - (dragonSchaden2 * 2)
                        dragonKlonHP2 = dragonKlonHP2 - dragonKlonHP2
                        println("\nMagier HP: ${magier.hp} (- 0) vs. Drachen HP: ${dragonHP3} (-${dragonSchaden2 * 2}) & Klon HP: ${dragonKlonHP2}\n\n")

                    } else {
                        verursachterSchaden = dragonSchaden2 + dragonKlonSchaden2
                        magier.hp = (magier.hp - verursachterSchaden)
                        Thread.sleep(1000)
                        println("\nMagier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3} & Klon HP: ${dragonKlonHP2}\n\n")

                    }
                }
                Thread.sleep(5000)
                if (ritter.hp > 0) {
                    println("\nRitter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP3} & Klon HP: ${dragonKlonHP2}")
                    Thread.sleep(1000)
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden2} an.")
                    Thread.sleep(2000)
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden2} an.")
                    Thread.sleep(1000)
                    if (ritter.schutzschildGezogen) {
                        println("\nDie Angriffe vom Drachen und seinem Klon sind an ${ritter.name}'s Schutzschild abgeprallt")
                        Thread.sleep(1000)
                        ritter.schutzschildGezogen = true
                        ritter.unverwundbar = true
                        ritter.zustandSchutzSchild--
                        println("\nZustand Schutzschild ${ritter.zustandSchutzSchild}/5\n\n")
                        Thread.sleep(1000)
                        if (ritter.zustandSchutzSchild == 0) {
                            ritter.schutzSchildNutzbarkeit = false
                            ritter.schutzschildGezogen = false
                            ritter.unverwundbar = false
                        }
                        println("\nRitter HP: ${ritter.hp} (-0) vs. Drachen HP: ${dragonHP3} & Klon HP: ${dragonKlonHP2}\n\n")
                        Thread.sleep(1000)
                    } else {
                        verursachterSchaden = dragonSchaden2 + dragonKlonSchaden2
                        ritter.hp = (ritter.hp - verursachterSchaden)
                        println("\nRitter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3} & Klon HP: ${dragonKlonHP2}\n\n")
                        Thread.sleep(1000)
                    }
                }
                Thread.sleep(5000)
                if (moench.hp > 0) {
                    println("\nMönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP3} & Klon HP: ${dragonKlonHP2}")
                    Thread.sleep(1000)
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden2} an.")
                    Thread.sleep(1000)
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden2} an.")
                    Thread.sleep(1000)
                    if (moench.schwebenAktiv) {
                        moench.schwebenAbklingdauer--
                    }
                    verursachterSchaden = dragonSchaden2 + dragonKlonSchaden2
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\nMönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3} & Klon HP: ${dragonKlonHP2}\n\n")
                    Thread.sleep(1000)
                }
                Thread.sleep(2500)
                if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                    heroesLostStufe3()
                }
            }
        }
        if (randomDrachenAngriff == drache3.faehigkeiten[2]) {
            println("\n${drache3.name} setzt 'Flächenschaden' ein...")
            Thread.sleep(1000)
            println("Der Drache greift mit einem Schaden von ${drache3.flaechenSchaden} an.")
            Thread.sleep(1000)
            if (magier.hp > 0) {
                println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP3}]")
                Thread.sleep(1000)
                if (magier.schutzschildGezogen) {
                    println("\nObwohl ${magier.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenNutzbarkeit = false
                    println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten.")
                    Thread.sleep(1000)
                    println("\nDieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache3.name} macht deshalb ${magier.name} ${drache3.flaechenSchaden} Schaden.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    magier.hp = magier.hp - verursachterSchaden
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\nMagier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (ritter.hp > 0) {
                println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP3}]")
                Thread.sleep(1000)
                if (ritter.schutzschildGezogen) {
                    println("\nObwohl ${ritter.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (moench.hp > 0) {
                println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP3}]")
                Thread.sleep(1000)
                if (moench.schwebenAktiv) {
                    println("\nDank ${moench.name}'s eingesetzter Schwebefähigkeit, konnte ${drache3.name} keinen Schaden erwirken.")
                    Thread.sleep(1000)
                    println("\n[Mönch HP: ${moench.hp} (-0) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                    moench.schwebenAktiv = false
                } else {
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(2500)
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe3()
            }
        }
        if (randomDrachenAngriff == drache3.faehigkeiten[2]) {
            println("\n${drache3.name} setzt 'Feueratem' ein...")
            Thread.sleep(1000)
            if (magier.hp > 0) {
                println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP3}]")
                Thread.sleep(1000)
                println("\nDer Drache greift mit einem Schaden von ${drache3.feuerAtemSchaden} an.")
                Thread.sleep(1000)
                if (magier.schutzschildGezogen) {
                    println("\nDer Angriff vom Drachen ist an ${magier.name}'s Schutzschild abgeprallt")
                    Thread.sleep(1000)
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
                    println("\n[Magier HP: ${magier.hp} (-0) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenNutzbarkeit = false
                    println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten.")
                    Thread.sleep(1000)
                    println("\nDieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache3.name} macht deshalb ${magier.name} ${drache3.feuerAtemSchaden} Schaden.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache3.feuerAtemSchaden.toDouble()
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache3.feuerAtemSchaden.toDouble()
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (ritter.hp > 0) {
                println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP3}]")
                Thread.sleep(1000)
                println("\nDer Drache greift mit einem Schaden von ${drache3.feuerAtemSchaden} an.")
                Thread.sleep(1000)
                if (ritter.schutzschildGezogen) {
                    println("\nDer Angriff vom Drachen ist an ${ritter.name}'s Schutzschild abgeprallt")
                    Thread.sleep(1000)
                    ritter.schutzschildGezogen = true
                    ritter.unverwundbar = true
                    ritter.zustandSchutzSchild--
                    println("\n[Ritter HP: ${ritter.hp} (-0) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache3.feuerAtemSchaden.toDouble()
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (moench.hp > 0) {
                println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP3}]")
                Thread.sleep(1000)
                println("\nDer Drache greift mit einem Schaden von ${drache3.feuerAtemSchaden} an.")
                Thread.sleep(1000)
                if (moench.schwebenAktiv) {
                    println("\nObwohl ${moench.name} aktuell 'Schweben' aktiviert hat, konnte dieser der Attacke nicht ausweichen.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache3.feuerAtemSchaden.toDouble()
                    Thread.sleep(1000)
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache3.feuerAtemSchaden.toDouble()
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(2500)
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe3()
            }
        }
        if (randomDrachenAngriff == drache3.faehigkeiten[3]) {
            println("\n${drache3.name} hat seine HP-Klau Fähigkeit aktiviert und stielt einem zufälligen Helden 5% Gesamt-HP")
            Thread.sleep(1000)
            println("\nDrache wählt Held aus...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            if (randomHeld == "Magier") {
                magier.hp = magier.hp - magier.fuenfProzent
                dragonHP3 = dragonHP3 + magier.fuenfProzent
                println("\n[Magier HP:${magier.hp} HP vs. Drachen HP: ${dragonHP3} HP]")
                println("\nEs wurden ${magier.name} 5% HP abgezogen und ${drache3.name} hinzugefügt.")
                Thread.sleep(1000)
                println("\n[Magier HP: ${magier.hp} (-${magier.fuenfProzent} HP) vs. Drachen HP: ${dragonHP3} (+${magier.fuenfProzent} HP)]\n\n")
                Thread.sleep(1000)
            } else if (randomHeld == "Ritter") {
                ritter.hp = ritter.hp - ritter.fuenfProzent
                dragonHP3 = dragonHP3 + ritter.fuenfProzent
                println("\nEs wurden ${ritter.name} 5% HP abgezogen und ${drache3.name} hinzugefügt.")
                Thread.sleep(1000)
                println("\n[Ritter HP: ${ritter.hp} (-${ritter.fuenfProzent} HP) vs. Drachen HP: ${dragonHP3} (+${ritter.fuenfProzent} HP)]\n\n")
                Thread.sleep(1000)
            } else {
                moench.hp = moench.hp - moench.fuenfProzent
                dragonHP3 = dragonHP3 + moench.fuenfProzent
                println("\nEs wurden ${moench.name} 5% HP abgezogen und ${drache3.name} hinzugefügt.")
                Thread.sleep(1000)
                println("\n[Mönch HP: ${moench.hp} (-${moench.fuenfProzent} HP) vs. Drachen HP: ${dragonHP3} (+${moench.fuenfProzent} HP)]\n\n")
                Thread.sleep(1000)
            }
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe3()
            }
        }
        if (randomDrachenAngriff == drache3.faehigkeiten[4]) {
            println("\n${drache3.name} setzt 'Stampfattacke' ein...")
            Thread.sleep(1000)
            println("\nDer Drache greift mit einem Schaden von ${drache3.flaechenSchaden} an.")
            Thread.sleep(1000)
            println("\nZusätzlich betäubt er alle getroffenen Einheiten")
            Thread.sleep(1000)
            if (magier.hp > 0) {
                println("\n[Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP3}]")
                Thread.sleep(1000)
                if (magier.schutzschildGezogen) {
                    println("\nObwohl ${magier.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                } else if (magier.doppelterSchadenEingesetzt) {
                    magier.doppelterSchadenNutzbarkeit = false
                    println("\nWeil ${magier.name} seine 'doppelter Schaden' Fähigkeit eingesetzt hat, würde der Drache seinen eingesetzten Schaden verdoppelt zurück erhalten...")
                    Thread.sleep(1000)
                    println("\nDieser wirkt bei dieser Drachenfähigkeit aber nicht. ${drache3.name} macht deshalb ${magier.name} ${drache3.flaechenSchaden} Schaden.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${magier.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    magier.betaeubt = true
                    println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (ritter.hp > 0) {
                println("\n[Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP3}]")
                Thread.sleep(1000)
                if (ritter.schutzschildGezogen) {
                    println("\nObwohl ${ritter.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    Thread.sleep(1000)
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${ritter.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    ritter.betaeubt = true
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(2000)
                } else {
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${ritter.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    ritter.betaeubt = true
                    println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(5000)
            if (moench.hp > 0) {
                println("\n[Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP3}]")
                Thread.sleep(1000)
                if (moench.schwebenAktiv) {
                    println("\nDank ${moench.name}'s eingesetzter Schwebefähigkeit, konnte ${drache3.name} keinen Schaden erwirken.")
                    Thread.sleep(1000)
                    println("\n[Mönch HP: ${moench.hp} (-0) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                } else {
                    verursachterSchaden = drache3.flaechenSchaden.toDouble()
                    println("\nZusätzlich zum erhaltenen Schaden von ${verursachterSchaden}, ist ${moench.name} nun 1 Runde betäubt.")
                    Thread.sleep(1000)
                    moench.hp = (moench.hp - verursachterSchaden)
                    moench.betaeubt = true
                    println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP3}]\n\n")
                    Thread.sleep(1000)
                }
            }
            Thread.sleep(2500)
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLostStufe3()
            }
        }
        if (randomDrachenAngriff == drache3.faehigkeiten[5]) {
            drache3.gespuckteFeuerbaelle = 1
            println("\n${drache3.name} hat Feuerregen aktiviert und spuckt 5 Feuerbälle in die Luft.")
            Thread.sleep(1000)
            println("Wer wohl getroffen wird...")
            Thread.sleep(1000)
            println("Drache spuckt Feuerbälle...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            println("...")
            Thread.sleep(1000)
            do {
                println("\nFeuerball Nr. ${drache3.gespuckteFeuerbaelle} fliegt durch die Luft und trifft:")
                Thread.sleep(1000)
                var randomHeldFeuerBaelle = drache3.feuerBaelleSpuckenRandomHeld.random()
                println(randomHeldFeuerBaelle)
                when (randomHeldFeuerBaelle) {
                    "Magier" -> {
                        verursachterSchaden = drache3.feuerRegenSchaden.toDouble()
                        magier.hp = magier.hp - verursachterSchaden
                        println("\n[Magier HP: ${magier.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP3}]\n\n")
                        Thread.sleep(1000)
                    }

                    "Ritter" -> {
                        verursachterSchaden = drache3.feuerRegenSchaden.toDouble()
                        ritter.hp = ritter.hp - verursachterSchaden
                        println("\n[Ritter HP: ${ritter.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP3}]\n\n")
                        Thread.sleep(1000)
                    }

                    "Mönch" -> {
                        verursachterSchaden = drache3.feuerRegenSchaden.toDouble()
                        moench.hp = moench.hp - verursachterSchaden
                        println("\n[Mönch HP: ${moench.hp} (-${verursachterSchaden} HP) vs. Drache HP: ${dragonHP3}]\n\n")
                        Thread.sleep(1000)
                    }

                    "daneben" -> {
                        println("\nDieser Feuerball ging daneben!")
                        Thread.sleep(1000)
                        println("Glück gehabt! 🎉\n\n")
                        Thread.sleep(1000)
                    }
                }
                drache3.gespuckteFeuerbaelle++
            } while (drache3.gespuckteFeuerbaelle <= drache3.feuerbaelle)
        }

        if (magier.betaeubt == true) {
            magier.betaeubt = false
        }
        if (ritter.betaeubt == true) {
            ritter.betaeubt = false
        }
        if (moench.betaeubt == true) {
            moench.betaeubt = false
        }
    }

    fun dragonLostStufe1() {
        println("Die Helden haben gewonnen! 🎉")
        Thread.sleep(1000)
        println("${heldenGesamtHP} vs. ${dragonHP1} ✝️\n")
        Thread.sleep(1000)
        println("\nDas Spiel ist vorbei!")
        println(
            """\||/
                |  @___oo
      /\  /\   / (__,,,,|
     ) /^\) ^\/ _)
     )   /^\/   _)
     )   _ /  / _)
 /\  )/\/ ||  | )_)
<  >      |(,,) )__)
 ||      /    \)___)\
 | \____(      )___) )___
  \______(_______;;; __;;;"""
        )
    }

    fun dragonLostStufe2() {
        println("Die Helden haben gewonnen!")
        println("${heldenGesamtHP} vs. ${dragonHP2}")
        println()
        println("\nDas Spiel ist vorbei!")
        println(
            """\||/
                |  @___oo
      /\  /\   / (__,,,,|
     ) /^\) ^\/ _)
     )   /^\/   _)
     )   _ /  / _)
 /\  )/\/ ||  | )_)
<  >      |(,,) )__)
 ||      /    \)___)\
 | \____(      )___) )___
  \______(_______;;; __;;;"""
        )
    }

    fun dragonLostStufe3() {
        println("Die Helden haben gewonnen!")
        println("${heldenGesamtHP} vs. ${dragonHP3}")
        println()
        println("\nDas Spiel ist vorbei!")
        println(
            """\||/
                |  @___oo
      /\  /\   / (__,,,,|
     ) /^\) ^\/ _)
     )   /^\/   _)
     )   _ /  / _)
 /\  )/\/ ||  | )_)
<  >      |(,,) )__)
 ||      /    \)___)\
 | \____(      )___) )___
  \______(_______;;; __;;;"""
        )
    }

    fun heroesLostStufe1() {
        println("Der Drache hat gewonnen! 😭")
        if (magier.hp <= 0) {
            magier.hp = 0.0
            println("${magier.hp} ✝️ vs. ${dragonHP1}")
        } else {
            println("${magier.hp} vs. ${dragonHP1}")
        }
        if (ritter.hp <= 0) {
            ritter.hp = 0.0
            println("${ritter.hp} ✝️ vs. ${dragonHP1}")
        } else {
            println("${ritter.hp} vs. ${dragonHP1}")
        }
        if (moench.hp <= 0) {
            moench.hp = 0.0
            println("${moench.hp} ✝️ vs. ${dragonHP1}")
        } else {
            println("${moench.hp} vs. ${dragonHP1}")
        }
        Thread.sleep(1000)
        println("\n${heldenGesamtHP} vs. ${dragonHP1}\n")
        Thread.sleep(1000)
        println("\nDas Spiel ist vorbei!")
    }

    fun heroesLostStufe2() {
        println("Der Drache hat gewonnen!")
        println("${magier.hp} vs. ${dragonHP2}")
        println("${ritter.hp} vs. ${dragonHP2}")
        println("${moench.hp} vs. ${dragonHP2}")

        println("\n${heldenGesamtHP} vs. ${dragonHP2}")
        println()
        println("\nDas Spiel ist vorbei!")
    }

    fun heroesLostStufe3() {
        println("Der Drache hat gewonnen!")
        println("${magier.hp} vs. ${dragonHP3}")
        println("${ritter.hp} vs. ${dragonHP3}")
        println("${moench.hp} vs. ${dragonHP3}")

        println("\n${heldenGesamtHP} vs. ${dragonHP3}")
        println()
        println("\nDas Spiel ist vorbei!")
    }
}