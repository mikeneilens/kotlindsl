# kotlindsl

This folder contains examples of DSL code taken from "Programming DSLs in Kotlin".

There are different ways to run DSL scripts.

1. Run the script stand alone using the koltin cli:

   __kotlinc-jvm -script scriptfile.kts__

All classes and functions required by scriptfile.kts need to be in the .kts file.

You may need to install kotlin to your laptop to run kotlinc-jvm (sdkman is an easy way to install kotlin).

2. Run the script using precompiled classes using the koltin cli.
   
   __kotlinc-jvm -d classes KotlinFile.kt__

   __kotlinc-jvm -classpath classes -script scriptfile.kts__

The classes created by KotlinFile.kt are compiled into the classes directory.
The script called scriptfile.kts then looks for classes in the classes directory.

3. Run the script using code compiled into a .jar file using the koltin cli.

   __kotlinc-jvm -d kotlinfile.jar kotlinfile.kt__

   __kotlinc-jvm -classpath kotlinfile.jar -script scriptfile.kts__

The classes created by KotlinFile.kt are compiled into kotlinfile.jar.
The script called scriptfile.kts then looks for classes in kotlinfile.jar.

4. Run the script dynamically using a kotlin program.

The script could be in a file or database and loaded into a string before executing.
Program Embed gives an example of how to do this using the __javax.script.ScriptEngineManager__.