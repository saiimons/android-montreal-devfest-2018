package android.montreal.devfest.stuff.usecases;

public class SetRandomStuffException extends Exception {
    public SetRandomStuffException(String s) {
        super(s);
    }

    public SetRandomStuffException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
