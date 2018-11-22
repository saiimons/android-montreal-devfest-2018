package android.montreal.devfest.stuff.policies;

import android.montreal.devfest.stuff.entities.RandomStuffEntity;

class RandomStuffVerifierImpl implements RandomStuffVerifier {
    @Override
    public boolean isValid(RandomStuffEntity stuff) {
        return stuff != null && stuff.text != null && stuff.text.length() != 0;
    }
}
