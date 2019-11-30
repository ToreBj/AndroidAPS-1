package info.nightscout.androidaps.plugins.pump.omnipod.exception;

import java.util.Locale;

public class CrcMismatchException extends OmnipodException {
    private final int expected;
    private final int actual;

    public CrcMismatchException(int expected, int actual) {
        super(String.format(Locale.getDefault(), "CRC mismatch: expected %d, got %d", expected, actual));
        this.expected = expected;
        this.actual = actual;
    }

    public int getExpected() {
        return expected;
    }

    public int getActual() {
        return actual;
    }

    @Override
    public boolean isCertainFailure() {
        return false;
    }
}