package org.junit.internal;

import static java.lang.Thread.currentThread;

/**
 * Miscellaneous functions dealing with classes.
 */
public class Classes {

    /**
     * Do not instantiate.
     * 
     * @deprecated will be private soon.
     */
    @Deprecated

    // Ce constructeur est privé pour empêcher l'instanciation de la classe.
    private Classes() {
    }

    /**
     * Returns Class.forName for {@code className} using the current thread's
     * class loader. If the current thread does not have a class loader, falls
     * back to the class loader for {@link Classes}.
     *
     * @param className Name of the class.
     * @throws ClassNotFoundException if the class cannot be found.
     */
    public static Class<?> getClass(String className) throws ClassNotFoundException {
        return getClass(className, Classes.class);
    }

    /**
     * Returns Class.forName for {@code className} using the current thread's
     * class loader. If the current thread does not have a class loader, falls
     * back to the class loader for the passed-in class.
     *
     * @param className    Name of the class.
     * @param callingClass Class that is requesting the class.
     * @throws ClassNotFoundException if the class cannot be found.
     * @since 4.13
     */
    public static Class<?> getClass(String className, Class<?> callingClass) throws ClassNotFoundException {
        ClassLoader classLoader = currentThread().getContextClassLoader();
        return loadClass(className, callingClass, classLoader);
    }

    /**
     * Loads the class using the provided class loader. Falls back to the class
     * loader for the passed-in class if the current thread does not have a
     * class loader.
     *
     * @param className    Name of the class.
     * @param callingClass Class that is requesting the class.
     * @param classLoader  The class loader to use.
     * @throws ClassNotFoundException if the class cannot be found.
     */
    private static Class<?> loadClass(String className, Class<?> callingClass, ClassLoader classLoader)
            throws ClassNotFoundException {
        return Class.forName(className, true, classLoader == null ? callingClass.getClassLoader() : classLoader);
    }
}
