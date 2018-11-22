package android.montreal.devfest.stuff.usescases;

import android.montreal.devfest.entities.RandomStuffEntity;

class DataToEntityMapper {
    static RandomStuffEntity map(RandomStuffData data) {
        if (data == null) {
            return null;
        }
        return new RandomStuffEntity(data.text, data.number);
    }
}
