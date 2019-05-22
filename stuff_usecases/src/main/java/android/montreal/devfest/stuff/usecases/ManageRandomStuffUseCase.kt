package android.montreal.devfest.stuff.usecases


interface ManageRandomStuffUseCase {
    @Throws(GetRandomStuffException::class)
    fun getRandomStuff(): RandomStuffData

    @Throws(SetRandomStuffException::class)
    fun setRandomStuff(stuffData: RandomStuffData)
}
