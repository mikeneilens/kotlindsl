@DslMarker
annotation class ConfigMarker

fun build(block: Config.() -> Unit) =
    println(Config().apply(block))

@ConfigMarker
class Config {
    var version = ""
    var src = ""
    var test = ""
    var tasks = ""
    private val dependencies = mutableListOf<String>()

    fun dependency(library: String) = 
        dependencies.add(library)

    fun task(type: String, commands: CommandContext.()->Unit) {
        val commandContext = CommandContext().apply(commands)
        tasks = "$tasks---$type configured with ${commandContext}"
    }

    override fun toString() = """Config:
    Version: $version
    Source path: $src
    Test path: $test
    Dependencies: ${dependencies.joinToString()}
    Tasks: $tasks
    """.trimMargin()

}

@ConfigMarker
class CommandContext {
        var jvmArgs = ""

        override fun toString() = "jvmArgs: $jvmArgs"
    }
