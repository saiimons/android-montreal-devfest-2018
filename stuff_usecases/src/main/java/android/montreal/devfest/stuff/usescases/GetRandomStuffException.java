package android.montreal.devfest.stuff.usescases;

public class GetRandomStuffException extends Exception {
    public GetRandomStuffException(String s) {
        super(s);
    }

    public GetRandomStuffException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
