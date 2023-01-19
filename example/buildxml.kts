val languageAndAuthors = mapOf("Java" to "Gosling", "Lisp" to "McCarthy", "Ruby" to "Matz")

val xml = elem("langauges") {
    languageAndAuthors.forEach{ (title, author) ->
        elem("language", "title" to title) {
            elem("author") {
                text(author)
            }
        }
    }
}
println(xml)

fun elem(name: String, vararg attributes: Pair<String, String>, block: XmlNode.() -> Unit = {} ): XmlNode =
XmlNode(name, *attributes).apply{block()}

class XmlNode(val elementName: String, vararg attributes:Pair<String,String>) {
    var textValue = ""
    val children = mutableListOf<XmlNode>()
    val attributes = attributes
    
    fun elem(name: String, vararg attributes: Pair<String, String>, block: XmlNode.() -> Unit = {} ) =
     children.add(XmlNode(name, *attributes).apply{block()})

     fun text(value: String) {
        textValue = value
     }

     override fun toString() = xmlAsString()

     fun xmlAsString(indentation: String = ""): String = 
        listOf(
            renderOpeningTag(indentation),
            renderTextNode(indentation),
            renderChildren(indentation),
            renderClosingTag(indentation))
            .filter(String::isNotEmpty)
            .joinToString("\n")

    fun renderOpeningTag(indentation: String):String {
        val attributeValues = attributes.map {(title,author)->
            "$title='$author'"
        }.joinToString(" ", prefix = " ")
        return "$indentation<${(elementName + attributeValues).trim()}>"
    }

    fun renderTextNode(indentation: String) = 
        if (textValue.isEmpty()) "" else "$indentation$textValue"

    fun renderChildren(indentation: String) = 
        children.map{xmlNode -> 
        "${xmlNode.xmlAsString("$indentation ")}"}
        .joinToString("\n")
    
    fun renderClosingTag(indentation: String) = "$indentation</$elementName>"
}

