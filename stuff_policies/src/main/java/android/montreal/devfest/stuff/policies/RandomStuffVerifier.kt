package android.montreal.devfest.stuff.policies

import android.montreal.devfest.stuff.entities.RandomStuffEntity

interface RandomStuffVerifier {
    fun isValid(stuff: RandomStuffEntity): Boolean
}
