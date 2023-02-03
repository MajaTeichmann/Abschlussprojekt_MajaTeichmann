open class Helden(var heldenArt: String, var name: String, var hp: Double) {

    open var faehigkeiten = mutableListOf<String>()
    open fun showFaehigkeiten(){
        println(faehigkeiten)
    }

}