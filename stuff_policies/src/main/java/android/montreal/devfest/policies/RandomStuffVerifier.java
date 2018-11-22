package android.montreal.devfest.policies;

import android.montreal.devfest.entities.RandomStuffEntity;

public interface RandomStuffVerifier {
    boolean isValid(RandomStuffEntity stuff);
}
