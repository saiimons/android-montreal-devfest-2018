package android.montreal.devfest.stuff.policies

import android.montreal.devfest.stuff.entities.RandomStuffEntity

internal class RandomStuffVerifierImpl : RandomStuffVerifier {
    override fun isValid(stuff: RandomStuffEntity): Boolean {
        return stuff.text?.length != 0
    }
}
