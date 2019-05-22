package android.montreal.devfest.stuff.usecases

import android.montreal.devfest.stuff.policies.RandomStuffVerifier

import dagger.Module
import dagger.Provides

@Module
class StuffUseCaseModule {

    @Provides
    fun manageRandomStuffUseCase(getter: RandomStuffGetter, setter: RandomStuffSetter, verifier: RandomStuffVerifier): ManageRandomStuffUseCase {
        return ManageRandomStuffUseCaseImpl(verifier, setter, getter)
    }
}
