import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

fun main(args: Array<String>) {
    println("Welcome, would you like to read, write or delete a file")
    println("1 - read \n2 - write \n3 - delete")
    println("Number: ")
    var input1 = readLine()

    when (input1) {
        "1" -> readFile()
        "2" -> writeFile()
        "3" -> deleteFile()
        else -> {
            println("Invalid input, shutting down")
        }
    }
}

fun writeFile() {
    println("Please enter the name of the file you want to create: ")
    val fileName = readLine()
    val file = File(fileName)
    file.createNewFile()
    println("File created.")
    println("Please enter the text you want saved to the file: ")
    val text = readLine()
    try {
        var writer = FileWriter(file)
        writer.write(text)
        writer.close()

    } catch (e: IOException) {
        e.printStackTrace()
    }
    println("Text successfully written to " + file.name)
}

fun readFile() {
    println("Please enter the name of the file you want to read: ")
    val fileName = readLine()
    val file = File(fileName)
    if (file.exists()) {
        try {
            val reader = FileReader(file)
            println("File: " + reader.readText())
            reader.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    } else {
        println("No such file exists")
    }
}

fun deleteFile() {
    println("Please enter the name of the file you want to delete: ")
    val fileName = readLine()
    val file = File(fileName)
    if (file.exists()) {
        file.delete()
    } else {
        println("No such file exists")
    }
}