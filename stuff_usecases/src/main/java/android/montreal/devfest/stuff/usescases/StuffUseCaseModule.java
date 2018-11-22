package android.montreal.devfest.stuff.usescases;

import android.montreal.devfest.policies.RandomStuffVerifier;

import dagger.Module;
import dagger.Provides;

@Module
public class StuffUseCaseModule {

    @Provides
    public ManageRandomStuffUseCase manageRandomStuffUseCase(RandomStuffGetter getter, RandomStuffSetter setter, RandomStuffVerifier verifier) {
        return new ManageRandomStuffUseCaseImpl(verifier, setter, getter);
    }
}
