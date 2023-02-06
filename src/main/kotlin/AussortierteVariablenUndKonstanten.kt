/*
if (randomDrachenAngriff == Gegner().faehigkeiten[1]) {
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
                    println("Mönch HP: ${magier.hp} vs. Drachen HP: ${dragonHP1}")
                    println("\nDer Drache greift mit einem Schaden von ${drache1.flaechenSchaden} an.")
                    verursachterSchaden = drache1.flaechenSchaden.toDouble()
                    Thread.sleep(1000)
                    moench.hp = (moench.hp - verursachterSchaden)
                    println("\nMönch HP: ${moench.hp} (-${verursachterSchaden}) vs. Drachen HP: ${dragonHP1}")
                }
            }
        }
    }

 */