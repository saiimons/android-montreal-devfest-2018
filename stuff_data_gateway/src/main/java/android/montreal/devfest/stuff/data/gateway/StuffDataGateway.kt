package android.montreal.devfest.stuff.data.gateway

import android.montreal.devfest.stuff.usecases.RandomStuffData
import android.montreal.devfest.stuff.usecases.RandomStuffGetter
import android.montreal.devfest.stuff.usecases.RandomStuffSetter

internal class StuffDataGateway(private val storage: StuffStorage) : RandomStuffSetter, RandomStuffGetter {

    override fun getRandomStuff(): RandomStuffData {
        return RandomStuffData(
                storage.getString(KEY_STUFF_STR),
                storage.getInt(KEY_STUFF_INT)
        )
    }

    override fun setRandomStuff(stuff: RandomStuffData) {
        storage.setString(KEY_STUFF_STR, stuff.text)
        storage.setInt(KEY_STUFF_INT, stuff.number)
    }

    companion object {
        private const val KEY_STUFF_STR = "rnd.str"
        private const val KEY_STUFF_INT = "rnd.int"
    }
}
