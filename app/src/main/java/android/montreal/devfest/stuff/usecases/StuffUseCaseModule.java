package android.montreal.devfest.stuff.usecases;

import android.montreal.devfest.stuff.policies.RandomStuffVerifier;

import dagger.Module;
import dagger.Provides;

@Module
public class StuffUseCaseModule {

    @Provides
    public ManageRandomStuffUseCase manageRandomStuffUseCase(RandomStuffGetter getter, RandomStuffSetter setter, RandomStuffVerifier verifier) {
        return new ManageRandomStuffUseCaseImpl(verifier, setter, getter);
    }
}
