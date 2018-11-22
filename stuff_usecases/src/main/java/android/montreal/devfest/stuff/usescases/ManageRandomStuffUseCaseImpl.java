package android.montreal.devfest.stuff.usescases;

import android.montreal.devfest.policies.RandomStuffVerifier;

class ManageRandomStuffUseCaseImpl implements ManageRandomStuffUseCase {
    private final RandomStuffGetter getter;
    private final RandomStuffSetter setter;
    private final RandomStuffVerifier verifier;

    public ManageRandomStuffUseCaseImpl(RandomStuffVerifier verifier, RandomStuffSetter setter, RandomStuffGetter getter) {
        this.verifier = verifier;
        this.getter = getter;
        this.setter = setter;
    }

    @Override
    public RandomStuffData getRandomStuff() throws GetRandomStuffException {
        final RandomStuffData randomStuff = this.getter.getRandomStuff();

        if (!this.verifier.isValid(DataToEntityMapper.map(randomStuff))) {
            throw new GetRandomStuffException("No random stuff here!");
        }

        return randomStuff;
    }

    @Override
    public void setRandomStuff(RandomStuffData randomStuff) throws SetRandomStuffException {
        if (!this.verifier.isValid(DataToEntityMapper.map(randomStuff))) {
            throw new SetRandomStuffException("Can't use this random stuff!");
        }

        this.setter.setRandomStuff(randomStuff);
    }
}
