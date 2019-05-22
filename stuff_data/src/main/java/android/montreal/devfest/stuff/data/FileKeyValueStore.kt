package android.montreal.devfest.stuff.data

import android.content.Context
import android.montreal.devfest.stuff.data.gateway.StuffStorage
import java.io.*
import java.util.*

internal class FileKeyValueStore(context: Context) : StuffStorage {
    private val storageDirectory: File = context.filesDir

    override fun setString(key: String, value: String?) {
        val path = getFilePathForKey(key)
        try {
            BufferedWriter(FileWriter(path)).use { writer -> writer.write(value) }
        } catch (e: IOException) {
            throw RuntimeException("I am too lazy to deal with this...", e)
        }

    }

    override fun getString(key: String): String? {
        val path = getFilePathForKey(key)
        try {
            BufferedReader(FileReader(path)).use { reader -> return reader.readLine() }
        } catch (e: IOException) {
            return null
        }
    }

    override fun setInt(key: String, value: Int) {
        setString(key, String.format(Locale.getDefault(), "%d", value))
    }

    override fun getInt(key: String): Int {
        val str = getString(key)
        return if (str != null) Integer.parseInt(str) else 0
    }

    private fun getFilePathForKey(key: String): String {
        val file = File(storageDirectory, key)
        if (!file.exists()) {
            try {
                file.createNewFile()
            } catch (e: IOException) {
                throw RuntimeException("I am too lazy to deal with this...", e)
            }

        }
        return file.absolutePath
    }
}
