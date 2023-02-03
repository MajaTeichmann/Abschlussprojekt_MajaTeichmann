class Dragon(name: String, hp: Double, schaden: Double) : Gegner(name, hp, schaden) {

    val flaechenSchadenRange = 150..300
    val flaechenSchaden = flaechenSchadenRange.random()

    val feuerAtemSchadenRange = 75..100
    val feuerAtemSchaden = feuerAtemSchadenRange.random()



    var feuerRegenSchadenRange = 25..40
    var feuerRegenSchaden = feuerRegenSchadenRange.random()
}