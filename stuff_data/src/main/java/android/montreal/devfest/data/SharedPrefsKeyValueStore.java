package android.montreal.devfest.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.montreal.devfest.stuff.data.gateway.StuffStorage;
import android.preference.PreferenceManager;

class SharedPrefsKeyValueStore implements StuffStorage {
    private final SharedPreferences sharedPreferences;

    public SharedPrefsKeyValueStore(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void setString(String key, String value) {
        this.sharedPreferences.edit().putString(key, value).apply();
    }

    @Override
    public String getString(String key) {
        return this.sharedPreferences.getString(key, null);
    }

    @Override
    public void setInt(String key, int value) {
        this.sharedPreferences.edit().putInt(key, value).apply();
    }

    @Override
    public int getInt(String key) {
        return this.sharedPreferences.getInt(key, 0);
    }
}
