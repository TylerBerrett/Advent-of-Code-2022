import java.io.File

object FileLoader {
    fun getFile(name: String): File = File(this::class.java.classLoader.getResource(name)?.file!!)
}