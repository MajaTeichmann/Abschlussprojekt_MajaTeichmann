open class Helden(var heldenArt: String, var name: String, var hp: Int) {

    open var faehigkeiten = mutableListOf<String>()
    open fun showFaehigkeiten(){
        println(faehigkeiten)
    }
}