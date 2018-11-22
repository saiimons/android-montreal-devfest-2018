package android.montreal.devfest.stuff.policies;

import android.montreal.devfest.stuff.entities.RandomStuffEntity;

public interface RandomStuffVerifier {
    boolean isValid(RandomStuffEntity stuff);
}
