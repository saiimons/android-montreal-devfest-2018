package android.montreal.devfest.stuff.usecases

import android.montreal.devfest.stuff.policies.RandomStuffVerifier

internal class ManageRandomStuffUseCaseImpl(private val verifier: RandomStuffVerifier, private val setter: RandomStuffSetter, private val getter: RandomStuffGetter) : ManageRandomStuffUseCase {

    @Throws(GetRandomStuffException::class)
    override fun getRandomStuff(): RandomStuffData {
        val randomStuff = this.getter.getRandomStuff()

        if (!this.verifier.isValid(DataToEntityMapper.map(randomStuff)!!)) {
            throw GetRandomStuffException("No random stuff here!")
        }

        return randomStuff
    }

    @Throws(SetRandomStuffException::class)
    override fun setRandomStuff(stuffData: RandomStuffData) {
        if (!this.verifier.isValid(DataToEntityMapper.map(stuffData)!!)) {
            throw SetRandomStuffException("Can't use this random stuff!")
        }
        this.setter.setRandomStuff(stuffData)
    }
}
