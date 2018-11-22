package android.montreal.devfest.stuff.usecases;


public interface ManageRandomStuffUseCase {
    RandomStuffData getRandomStuff() throws GetRandomStuffException;

    void setRandomStuff(RandomStuffData randomStuff) throws SetRandomStuffException;

}
