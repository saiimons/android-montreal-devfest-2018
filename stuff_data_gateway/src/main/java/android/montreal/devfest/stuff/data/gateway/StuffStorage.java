package android.montreal.devfest.stuff.data.gateway;

public interface StuffStorage {
    void setString(String key, String value);

    String getString(String key);

    void setInt(String key, int value);

    int getInt(String key);
}
