class DragonKlon(name: String, hp: Double, schaden: Double) : Gegner(name, hp, schaden){

    val hpKlon = hp / 100 * 20
    val schadenKlon = schaden / 100 * 15

    fun klon() {
        println("${name} hat seinen Klon heraufbeschworen")
        println("Er hat eine HP von ${hpKlon} und macht ${schadenKlon} Schaden")
    }
}