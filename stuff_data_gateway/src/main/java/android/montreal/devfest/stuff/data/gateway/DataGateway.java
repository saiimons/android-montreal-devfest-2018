package android.montreal.devfest.stuff.data.gateway;

import android.montreal.devfest.stuff.usescases.RandomStuffData;
import android.montreal.devfest.stuff.usescases.RandomStuffGetter;
import android.montreal.devfest.stuff.usescases.RandomStuffSetter;

class DataGateway implements RandomStuffSetter, RandomStuffGetter {
    public static final String KEY_STUFF_STR = "rnd.str";
    public static final String KEY_STUFF_INT = "rnd.int";

    private final StuffStorage storage;

    public DataGateway(StuffStorage storage) {
        this.storage = storage;
    }

    @Override
    public RandomStuffData getRandomStuff() {
        return new RandomStuffData(storage.getString(KEY_STUFF_STR), storage.getInt(KEY_STUFF_INT));
    }

    @Override
    public void setRandomStuff(RandomStuffData stuff) {
        storage.setString(KEY_STUFF_STR, stuff.text);
        storage.setInt(KEY_STUFF_INT, stuff.number);
    }
}
