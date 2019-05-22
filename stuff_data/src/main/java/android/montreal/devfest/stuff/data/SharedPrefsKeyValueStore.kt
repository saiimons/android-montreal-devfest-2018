package android.montreal.devfest.stuff.data

import android.content.Context
import android.content.SharedPreferences
import android.montreal.devfest.stuff.data.gateway.StuffStorage
import android.preference.PreferenceManager

internal class SharedPrefsKeyValueStore(context: Context) : StuffStorage {
    private val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    override fun setString(key: String, value: String?) {
        this.sharedPreferences.edit().putString(key, value).apply()
    }

    override fun getString(key: String): String? {
        return this.sharedPreferences.getString(key, null)
    }

    override fun setInt(key: String, value: Int) {
        this.sharedPreferences.edit().putInt(key, value).apply()
    }

    override fun getInt(key: String): Int {
        return this.sharedPreferences.getInt(key, 0)
    }
}
