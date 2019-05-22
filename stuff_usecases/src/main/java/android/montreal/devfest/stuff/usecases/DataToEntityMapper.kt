package android.montreal.devfest.stuff.usecases

import android.montreal.devfest.stuff.entities.RandomStuffEntity

internal object DataToEntityMapper {
    fun map(data: RandomStuffData?): RandomStuffEntity? {
        return if (data == null) {
            null
        } else RandomStuffEntity(data.text, data.number)
    }
}
