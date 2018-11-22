package android.montreal.devfest.data;

import android.content.Context;
import android.montreal.devfest.stuff.data.gateway.StuffStorage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class FileKeyValueStore implements StuffStorage {
    private final File storageDirectory;

    public FileKeyValueStore(Context context) {
        this.storageDirectory = context.getFilesDir();
    }

    @Override
    public void setString(String key, String value) {
        final String path = getFilePathForKey(key);
        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(value);
        } catch (IOException e) {
            throw new RuntimeException("I am too lazy to deal with this...", e);
        }

    }

    @Override
    public String getString(String key) {
        final String path = getFilePathForKey(key);
        try (final BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void setInt(String key, int value) {
        setString(key, String.format(Locale.getDefault(), "%d", value));
    }

    @Override
    public int getInt(String key) {
        final String str = getString(key);
        return str != null ? Integer.parseInt(str) : 0;
    }

    private String getFilePathForKey(String key) {
        final File file = new File(storageDirectory, key);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("I am too lazy to deal with this...", e);
            }
        }
        return file.getAbsolutePath();
    }
}
