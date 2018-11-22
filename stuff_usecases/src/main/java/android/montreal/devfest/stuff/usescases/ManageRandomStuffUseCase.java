package android.montreal.devfest.stuff.usescases;


public interface ManageRandomStuffUseCase {
    RandomStuffData getRandomStuff() throws GetRandomStuffException;

    void setRandomStuff(RandomStuffData randomStuff) throws SetRandomStuffException;

}
