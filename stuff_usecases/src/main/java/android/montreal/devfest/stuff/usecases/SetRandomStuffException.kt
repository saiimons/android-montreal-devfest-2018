package android.montreal.devfest.stuff.usecases

class SetRandomStuffException : Exception {
    constructor(s: String) : super(s)

    constructor(s: String, throwable: Throwable) : super(s, throwable)
}
