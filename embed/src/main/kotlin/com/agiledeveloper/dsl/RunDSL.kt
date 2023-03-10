package com.agiledeveloper.dsl

import javax.script.ScriptEngineManager

fun main() {
  print("Please enter the filename for schedule:")
  
  val fileName = readLine()
  
  val dsl = java.io.File(fileName).readText()

  val scriptEngine =
    ScriptEngineManager().getEngineByExtension("kts")

  try {
    val result = scriptEngine.eval("""
    import com.agiledeveloper.dsl.schedule
    
    $dsl
    """)
    
    println("Result of evaluation of the DSL:")
    println(result)
  } catch(ex: Exception) {
    println("""OOPS, we ran into an error.
    ${ex.message}""")
  }
}
