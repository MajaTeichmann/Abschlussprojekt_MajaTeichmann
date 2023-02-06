fun main() {

    ///// BLEIBT IN MAIN /////
    var aktuelleRunde = 0
    val maximaleRunden = 5
    var inputSchwierigkeitsstufeGegener = "2"
    val randomHeld = Helden().heldenListe.random()
    var verursachterSchaden: Double
    val randomDrachenAngriff = Dragon().faehigkeiten.random()
    /////////////////////////

//////////////////// Objekte festlegen ////////////////////
    ////////// HELDEN //////////
    val magier = Magier()
    val ritter = Ritter()
    val moench = Mönch()

    ////////// GEGNER //////////
    ////////// DRAGON //////////
    //Schwierigkeitsstufe [1]
    var dragonHP1 = Dragon().hpDragon1.random().toDouble()
    val dragonSchaden1 = Dragon().faehigkeitsSchaden1.random()
    val drache1 = Dragon()
    //Schwierigkeitsstufe [2]
    var dragonHP2 = Dragon().hpDragon2.random().toDouble()
    val dragonSchaden2 = Dragon().faehigkeitsSchaden2.random()
    val drache2 = Dragon()
    //Schwierigkeitsstufe [3]
    var dragonHP3 = Dragon().hpDragon3.random().toDouble()
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

    /////////////////////////////
//----------------------------------------------------------------------------------------------------------------------
    fun dragonLost() {
        println("Der Drache ist tot und die Helden haben gewonnen!")
        println()
        println("\nDas Spiel ist vorbei!")
    }

    fun heroesLost() {
        println("Alle Helden sind tot und der Drache hat gewonnen!")
        println()
        println("\nDas Spiel ist vorbei!")
    }

    // GegnerSchwierigkeitsStufe 1
    fun magierAngriffStufe1() {
        println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
        println("Wähle eine Magier-Fähigkeit")
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
                        println("Deshalb setzt ${magier.name} seinen normalen Angriff ein und macht ${drache1.name} ${magier.schaden} Schaden.")
                        dragonHP1 = dragonHP1 - magier.schaden
                    }
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
        println("Wähle eine Ritter-Fähigkeit")
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
            println("Ritter HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
        } else {
            println("Falsche Eingabe")
            return ritterAngriffStufe1()
        }
    }

    fun moenchAngriffStufe1() {
        println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
        println("Wähle eine Mönch-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${moench.faehigkeiten[0]}")
        println("[2] ${moench.faehigkeiten[1]}")
        println("[3] ${moench.faehigkeiten[2]}")
        var moenchFaehigkeitInput = readln()
        if (moenchFaehigkeitInput == "1" || moenchFaehigkeitInput == "2" || moenchFaehigkeitInput == "3") {
            when (moenchFaehigkeitInput) {
                "1" -> {
                    moench.schwebenAktiv = true
                    println("${moench.name} hat 'Schweben' aktiviert. Er ist nun 1 Runde vor Bodenattacken geschützt!")
                    if (moench.schweben == false) {
                        moench.schweben = true
                        if (moench.schwebenAktiv && moench.schwebenAbklingdauer == 0) {
                            moench.schwebenAbklingdauer = 4
                        }
                    } else {
                        println("${moench.name} hat seine Fähigkeit bereits vor ${4 - moench.schwebenAbklingdauer} Runden aktiviert und kann aktuell nicht erneut genutzt werden!")
                        println("Deshalb setzt ${moench.name} seine Schockwelle ein und macht ${drache1.name} ${moench.schaden} Schaden.")
                        dragonHP1 = dragonHP1 - moench.schaden
                    }
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
            println("${drache1.name}'s Klon erscheint...")
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
                    println("\nMagier HP: ${magier.hp} (-0) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                } else {
                    println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden1} an.")
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden1} an.")
                    verursachterSchaden = dragonSchaden1 + dragonKlonSchaden1

                    Thread.sleep(1000)

                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\nMagier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")

                }
            }
            if (ritter.hp > 0) {
                println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
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
                    println("\nRitter HP: ${ritter.hp} (-0) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                } else {
                    println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${dragonSchaden1} an.")
                    println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden1} an.")
                    verursachterSchaden = dragonSchaden1 + dragonKlonSchaden1
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\nRitter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                }
            }
            if (moench.hp > 0) {
                println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                println("\nDer Drache greift mit einem Schaden von ${dragonSchaden1} an.")
                println("Sein Klon greift mit einem Schaden von ${dragonKlonSchaden1} an.")
                if (moench.schwebenAktiv) {
                    moench.schwebenAbklingdauer--
                }
                verursachterSchaden = dragonSchaden1 + dragonKlonSchaden1
                Thread.sleep(1000)
                moench.hp = (moench.hp - verursachterSchaden)
                println("\nMönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
            }
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLost()
            }
        }
        if (randomDrachenAngriff == Dragon().faehigkeiten[1]) {
            println("${drache1.name} setzt 'Flächenschaden' ein...")
            if (magier.hp > 0) {
                println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
                println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
                if (magier.schutzschildGezogen) {
                    println("Obwohl ${magier.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                    println("\nMagier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\nMagier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                } else {
                    println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\nMagier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                }
            }
            if (ritter.hp > 0) {
                println("${drache1.name} setzt 'Flächenschaden' ein...")
                if (ritter.hp > 0) {
                    println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
                    if (ritter.schutzschildGezogen) {
                        println("Obwohl ${ritter.name} aktiv ein Schutzschild ausgerüstet hat, konnte dieser die Bodenattacke nicht abwehren.")
                        println("\nRitter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}")
                        println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
                        verursachterSchaden = drache1.flaechenSchaden.toDouble()
                        Thread.sleep(1000)
                        ritter.hp = (ritter.hp - verursachterSchaden)
                        println("\nRitter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                    } else {
                        println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1} & Klon HP: ${dragonKlonHP1}")
                        println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
                        verursachterSchaden = drache1.flaechenSchaden.toDouble()
                        Thread.sleep(1000)
                        ritter.hp = (ritter.hp - verursachterSchaden)
                        println("\nRitter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                    }
                }
            }
            if (moench.hp > 0) {
                println("${drache1.name} setzt 'Flächenschaden' ein...")
                if (moench.hp > 0) {
                    println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
                    if (moench.schwebenAktiv) {
                        println("Dank ${moench.name}'s eingesetzter Schwebefähigkeit, konnte ${drache1.name} keinen Schaden erwirken.")
                        println("\nMönch HP: ${moench.hp} (-0) vs. Drachen HP: ${dragonHP1}")
                    } else {
                        println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
                        println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
                        verursachterSchaden = drache1.flaechenSchaden.toDouble()
                        Thread.sleep(1000)
                        moench.hp = (moench.hp - verursachterSchaden)
                        println("\nMönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                    }
                }
            }
            if (magier.hp <= 0 && ritter.hp <= 0 && moench.hp <= 0) {
                heroesLost()
            }
        }
        if (randomDrachenAngriff == Dragon().faehigkeiten[2]) {
            println("${drache1.name} setzt 'Feueratem' ein...")
            if (magier.hp > 0) {
                println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")

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
                    println("\nMagier HP: ${magier.hp} (-0) vs. Drachen HP: ${dragonHP1}")
                } else {
                    verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                    Thread.sleep(1000)
                    magier.hp = (magier.hp - verursachterSchaden)
                    println("\nMagier HP: ${magier.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")

                }
            }
            if (ritter.hp > 0) {
                println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}")
                println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
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
                    println("\nRitter HP: ${ritter.hp} (-0) vs. Drachen HP: ${dragonHP1}")
                } else {
                    verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                    Thread.sleep(1000)
                    ritter.hp = (ritter.hp - verursachterSchaden)
                    println("\nRitter HP: ${ritter.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                }
            }
            if (moench.hp > 0) {
                println("${drache1.name} setzt 'Flächenschaden' ein...")
                if (moench.hp > 0) {
                    println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                    if (moench.schwebenAktiv) {
                        println("Obwohl ${moench.name} aktuell 'Schweben' aktiviert hat, konnte dieser der Attacke nicht ausweichen.")
                        println("\nMönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
                        println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                        verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                        Thread.sleep(1000)
                        moench.hp = (moench.hp - verursachterSchaden)
                        println("\nMönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                    } else {
                        println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP1}")
                        println("\nDer Drache greift mit einem Schaden von ${drache1.feuerAtemSchaden} an.")
                        verursachterSchaden = drache1.feuerAtemSchaden.toDouble()
                        Thread.sleep(1000)
                        moench.hp = (moench.hp - verursachterSchaden)
                        println("\nMönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                    }
                }
            }
        }
        if (randomDrachenAngriff == Dragon().faehigkeiten[3]) {
            println("${drache1.name} hat seine HP-Klau Fähigkeit aktiviert und stielt einem zufälligen Helden 5% Gesamt-HP")
            Thread.sleep(1000)
            println("Drache wählt Held aus...")
            Thread.sleep(5000)
            if (randomHeld == "Magier") {
                magier.hp = magier.hp - (magier.startHP * 0.05)
                println("Es wurden ${magier.name} 5% HP abgezogen und ${drache1.name} hinzugefügt.")
                println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
            } else if (randomHeld == "Ritter") {
                ritter.hp = ritter.hp - (ritter.startHP * 0.05)
                println("Es wurden ${ritter.name} 5% HP abgezogen und ${drache1.name} hinzugefügt.")
                println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP1}")
            } else {
                moench.hp = moench.hp - (moench.startHP * 0.05)
                println("Es wurden ${moench.name} 5% HP abgezogen und ${drache1.name} hinzugefügt.")
                println("Mönch HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
            }
        }

///////////////////// NOCH FÜLLEN /////////////////////
        if (randomDrachenAngriff == Dragon().faehigkeiten[4]) {
        }
        if (randomDrachenAngriff == Dragon().faehigkeiten[5]) {
        }
///////////////////////////////////////////////////////////////
    }

    // GegnerSchwierigkeitsStufe 2
    fun magierAngriffStufe2() {
        println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP2}")
        println("Wähle eine Magier-Fähigkeit")
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
            println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP2}")
        } else {
            println("Falsche Eingabe")
            return magierAngriffStufe2()
        }
    }

    fun ritterAngriffStufe2() {
        println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP2}")
        println("Wähle eine Ritter-Fähigkeit")
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
            println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP2}")
        } else {
            println("Falsche Eingabe")
            return ritterAngriffStufe2()
        }
    }

    fun moenchAngriffStufe2() {
        println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP2}")
        println("Wähle eine Mönch-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${moench.faehigkeiten[0]}")
        println("[2] ${moench.faehigkeiten[1]}")
        println("[3] ${moench.faehigkeiten[2]}")
        var moenchFaehigkeitInput = readln()
        if (moenchFaehigkeitInput == "1" || moenchFaehigkeitInput == "2" || moenchFaehigkeitInput == "3") {
            when (moenchFaehigkeitInput) {
                "1" -> {
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
            println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP2}")
        } else {
            println("Falsche Eingabe")
            return moenchAngriffStufe2()
        }
    }


    // GegnerSchwierigkeitsStufe 3
    fun magierAngriffStufe3() {
        println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP3}")
        println("Wähle eine Magier-Fähigkeit")
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
            println("Magier HP: ${magier.hp} vs. Drachen HP: ${dragonHP3}")
        } else {
            println("Falsche Eingabe")
            return magierAngriffStufe3()
        }
    }

    fun ritterAngriffStufe3() {
        println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP3}")
        println("Wähle eine Ritter-Fähigkeit")
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
            println("Ritter HP: ${ritter.hp} vs. Drachen HP: ${dragonHP3}")
        } else {
            println("Falsche Eingabe")
            return ritterAngriffStufe3()
        }
    }

    fun moenchAngriffStufe3() {
        println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP3}")
        println("Wähle eine Mönch-Fähigkeit")
        Thread.sleep(800)
        println("[1] ${moench.faehigkeiten[0]}")
        println("[2] ${moench.faehigkeiten[1]}")
        println("[3] ${moench.faehigkeiten[2]}")
        var moenchFaehigkeitInput = readln()
        if (moenchFaehigkeitInput == "1" || moenchFaehigkeitInput == "2" || moenchFaehigkeitInput == "3") {
            when (moenchFaehigkeitInput) {
                "1" -> {
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
            println("Mönch HP: ${moench.hp} vs. Drachen HP: ${dragonHP3}")
        } else {
            println("Falsche Eingabe")
            return moenchAngriffStufe3()
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
        println("HP:                     ${ritter.hp}")
        Thread.sleep(1000)
        println("Gegenstände:            ${magier.beutel.size} im Beutel (Beutelinhalt: ${magier.beutel})")
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
    fun dracheVorstellung() {
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
        Thread.sleep(5000)
        println("Der Kampf beginnt in")
        Thread.sleep(1000)
        println("3")
        Thread.sleep(1000)
        println("2")
        Thread.sleep(1000)
        println("1")
        Thread.sleep(1000)
        println("GO!")

        do {
            if (inputSchwierigkeitsstufeGegener == "1") {
                if (dragonHP1 > 0) {
                    if (ritter.hp > 0) {
                        magierAngriffStufe1()
                        println()
                    } else {
                        println("${magier.name} ist tot (${ritter.hp} HP)")
                    }
                    if (ritter.hp > 0) {
                        ritterAngriffStufe1()
                        println()
                    } else {
                        println("${ritter.name} ist tot (${ritter.hp} HP)")
                    }
                    if (moench.hp > 0) {
                        moenchAngriffStufe1()
                        println()
                    } else {
                        println("${moench.name} ist tot (${moench.hp} HP)")
                    }
                    drachenAngriffStufe1()
                    println()
                } else {
                    println("Drache: $dragonHP1 HP")
                    dragonLost()
                }
            } else if (inputSchwierigkeitsstufeGegener == "2") {
                if (dragonHP2 > 0) {
                    if (magier.hp > 0) {
                        magierAngriffStufe2()
                        println()
                    } else {
                        println("Magier: ${magier.hp} HP")
                    }
                }
                if (dragonHP2 > 0) {
                    if (ritter.hp > 0) {
                        ritterAngriffStufe2()
                        println()
                    } else {
                        println("Ritter: ${ritter.hp} HP")
                    }
                }
                if (dragonHP2 > 0) {
                    if (moench.hp > 0) {
                        moenchAngriffStufe2()
                        println()
                    } else {
                        println("Mönch: ${moench.hp} HP")
                    }
                }
                ////////////////////DRACHE GREIFT AN//////////////
            } else {
                if (dragonHP3 > 0) {
                    if (magier.hp > 0) {
                        magierAngriffStufe3()
                        println()
                    } else {
                        println("Magier: ${magier.hp} HP")
                    }
                }
                if (dragonHP3 > 0) {
                    if (ritter.hp > 0) {
                        ritterAngriffStufe3()
                        println()
                    } else {
                        println("Ritter: ${ritter.hp} HP")
                    }
                }
                if (dragonHP3 > 0) {
                    if (moench.hp > 0) {
                        moenchAngriffStufe3()
                        println()
                    } else {
                        println("Mönch: ${moench.hp} HP")
                    }
                }
                ////////////////////DRACHE GREIFT AN//////////////
            }
            aktuelleRunde++
        } while (aktuelleRunde <= maximaleRunden)
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
                magierVorstellung()
                Thread.sleep(5000)
                ritterVorstellung()
                Thread.sleep(5000)
                moenchVorstellung()
            }

            "2" -> {
                dracheVorstellung()
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
//----------------------------------------------------------------------------------------------------------------------

    start()
}