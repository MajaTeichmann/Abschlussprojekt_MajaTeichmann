//TODO:
// (1) variablen/konstanten in Klassen sortieren
// (2) FähigkeitsSchaden aller Fähigkeiten festlegen
/*
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
 */

//TODO: (3) funktionen, wenn drache verloren hat, erstellen
/*
    fun dragonLost() {
        println("Der Drache ${dragon.name} ist besiegt. Die Helden haben gewonnen!!!\n")

        println("${magier.name}:    ${magier.hp}")
        println("${ritter.name}:    ${ritter.hp}")
        println("${mönch.name}:     ${mönch.hp}")
        println("vs.")
        println("${dragon.name}: ${dragon.hp}")
    }
 */
//TODO: (4) funktionen, wenn die helden verloren haben, erstellen
/*
    fun heroesLost() {
        println("Alle Helden wurden besiegt. Der Drache ${dragon.name} haben gewonnen!!!\n")

        println("${magier.name}:    ${magier.hp}")
        println("${ritter.name}:    ${ritter.hp}")
        println("${mönch.name}:     ${mönch.hp}")
        println("vs.")
        println("${dragon.name}: ${dragon.hp}")
    }
 */

//TODO: (5) funktion, wenn maxRunden gespielt sind, erstellen
/*
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
 */

//TODO: (6) funktionen, wenn 1 Held <=0 HP hat, erstellen
// (7) funktionen, wenn 2 Helden <=0 HP haben, erstellen
/*

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

    val dragonAngriff = dragon.faehigkeiten.random()

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
 */
//-------------------------------------------------------------------