package android.montreal.devfest.stuff.data.gateway;

import android.montreal.devfest.stuff.usecases.RandomStuffData;
import android.montreal.devfest.stuff.usecases.RandomStuffGetter;
import android.montreal.devfest.stuff.usecases.RandomStuffSetter;

class StuffDataGateway implements RandomStuffSetter, RandomStuffGetter {
    private static final String KEY_STUFF_STR = "rnd.str";
    private static final String KEY_STUFF_INT = "rnd.int";

    private final StuffStorage storage;

    StuffDataGateway(StuffStorage storage) {
        this.storage = storage;
    }

    @Override
    public RandomStuffData getRandomStuff() {
        return new RandomStuffData(
                storage.getString(KEY_STUFF_STR),
                storage.getInt(KEY_STUFF_INT)
        );
    }

    @Override
    public void setRandomStuff(RandomStuffData stuff) {
        storage.setString(KEY_STUFF_STR, stuff.text);
        storage.setInt(KEY_STUFF_INT, stuff.number);
    }
}
