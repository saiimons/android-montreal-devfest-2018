package android.montreal.devfest.stuff.data.gateway

interface StuffStorage {
    fun setString(key: String, value: String?)

    fun getString(key: String): String?

    fun setInt(key: String, value: Int)

    fun getInt(key: String): Int
}
