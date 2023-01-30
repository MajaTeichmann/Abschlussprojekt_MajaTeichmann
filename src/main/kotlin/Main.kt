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
    var held1 = Magier("Magier", heldenNamen.random(), heldenHP.random(), "Beutel")

    // Ritter
    var held2 = Ritter("Ritter", heldenNamen.random(), heldenHP.random(), "Schwert")

    // Mönch
    var held3 = Moench("Mönch", heldenNamen.random(), heldenHP.random())

    fun begruessung(){
        println("Hallo und herzlich Willkommen zu meinem Videospiel!")
        println("Im folgenden Spielverlauf wirst du deine drei Helden und deinen Gegner, einen mächtigen Drachen, kennenlernen.")
        println("Fangen wir an...")
    }
    fun heldenVorstellung(){
        println("Hallo, ich bin ${held1.name} und ich bin ein ${held1.heldenArt}.\n")
        println("""
            Name:                   ${held1.name}
            Helden-Art:             ${held1.heldenArt}
            HP:                     ${held1.hp}
            Gegenstände:            ${held1.beutel}
            Fähigkeiten:            ${held1.faehigkeiten}""")

        println("\nHallo, ich bin ${held2.name} und ich bin ein ${held2.heldenArt}.")
        println("""
            Name:                   ${held2.name}
            Helden-Art:             ${held2.heldenArt}
            HP:                     ${held2.hp}
            Gegenstände:            
            Fähigkeiten:            ${held2.faehigkeiten}""")

        println("\nHallo, ich bin ${held3.name} und ich bin ein ${held3.heldenArt}.")
        println("""
            Name:                   ${held3.name}
            Helden-Art:             ${held3.heldenArt}
            HP:                     ${held3.hp}
            Gegenstände:            
            Fähigkeiten:            ${held3.faehigkeiten}""")
    }
    fun gegnerVorstellung(){
        println("\nWie stark soll dein Gegner sein?")
        println("Nenne mir hierfür bitte die entsprechende Zahl")
        println("""
            |[1] für schwach
            |[2] für normal
            |[3] für stark
        """.trimMargin())
        var input = readln().toInt()
        var schaden = 0
        when(input){
            1 -> schaden = 25
            2 -> schaden = 35
            3 -> schaden = 60
        }
        var gegner = Gegner(dragonNamen.random(), dragonHP.random(), schaden)
        println("""
            Name:                   ${gegner.name}
            HP:                     ${gegner.hp}
            **********Fähigkeiten:**********
            ${gegner.faehigkeiten[0]} macht ${schaden*1.5} Schaden, lebt 1 Runde
            ${gegner.faehigkeiten[1]} ${faehigkeitsSchaden.random()}
            ${gegner.faehigkeiten[2]} ${schaden}
            ${gegner.faehigkeiten[3]} zieht zufälligem Helden 5% HP ab (Held -5%, Drache +5% (vom HeldenHP)
            ${gegner.faehigkeiten[4]} ${faehigkeitsSchaden.random()}
            ${gegner.faehigkeiten[5]} ${faehigkeitsSchaden.random()}""")
    }

    fun spielStarten(){
        begruessung()
        heldenVorstellung()
        gegnerVorstellung()
    }

    spielStarten()

}