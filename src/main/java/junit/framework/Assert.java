package junit.framework;

/**
 * A set of assert methods.  Messages are only displayed when an assert fails.
 *
 * @deprecated Please use {@link org.junit.Assert} instead.
 */
@Deprecated
public class Assert  extends BaseAssert{
    
    @Override
    protected AssertionError createAssertionError() {
        return new AssertionFailedError();
    }

    @Override
    protected AssertionError createAssertionError(String message) {
        return new AssertionFailedError(message);
    }

    /**
     * Asserts that two objects are equal. If they are not
     * an AssertionFailedError is thrown with the given message.
     */
    public static void assertEquals(String message, Object expected, Object actual) {
        if (expected == null && actual == null || expected != null && expected.equals(actual)) {
            return;
        }
        failNotEquals(message, expected, actual);
    }

    /**
     * Asserts that two objects are equal. If they are not
     * an AssertionFailedError is thrown.
     */
    public static void assertEquals(Object expected, Object actual) {
        assertEquals(null, expected, actual);
    }

    /**
     * Asserts that two Strings are equal.
     */
    public static void assertEquals(String message, String expected, String actual) {
        assertEquals((Object) expected, (Object) actual);
    }

    /**
     * Asserts that two Strings are equal.
     */
    public static void assertEquals(String expected, String actual) {
        assertEquals(null, expected, actual);
    }

    /**
     * Asserts that two doubles are equal concerning a delta.  If they are not
     * an AssertionFailedError is thrown with the given message.  If the expected
     * value is infinity then the delta value is ignored.
     */
    public static void assertEquals(String message, double expected, double actual, double delta) {
        if (Double.compare(expected, actual) == 0 || Math.abs(expected - actual) <= delta) {
            return;
        }
        failNotEquals(message, expected, actual);
    }

    /**
     * Asserts that two doubles are equal concerning a delta. If the expected
     * value is infinity then the delta value is ignored.
     */
    public static void assertEquals(double expected, double actual, double delta) {
        assertEquals(null, expected, actual, delta);
    }

    /**
     * Asserts that two floats are equal concerning a positive delta. If they
     * are not an AssertionFailedError is thrown with the given message. If the
     * expected value is infinity then the delta value is ignored.
     */
    public static void assertEquals(String message, float expected, float actual, float delta) {
        if (Float.compare(expected, actual) == 0 || Math.abs(expected - actual) <= delta) {
            return;
        }
        failNotEquals(message, expected, actual);
    }

    /**
     * Asserts that two floats are equal concerning a delta. If the expected
     * value is infinity then the delta value is ignored.
     */
    public static void assertEquals(float expected, float actual, float delta) {
        assertEquals(null, expected, actual, delta);
    }

    // Add other assertion methods here...

    private static void failNotEquals(String message, Object expected, Object actual) {
        fail(format(message, expected, actual));
    }

    private static String format(String message, Object expected, Object actual) {
        String formatted = (message != null && message.length() > 0) ? message + " " : "";
        return formatted + "expected:<" + expected + "> but was:<" + actual + ">";
    }
}
