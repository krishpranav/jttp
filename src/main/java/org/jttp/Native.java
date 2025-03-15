package org.jttp;

import java.lang.ref.Cleaner;
import java.lang.ref.Cleaner.Cleanable;

public final class Native {
    public final static String LIBRARY_NAME = "jttp";

    static {
        try {
            System.loadLibrary(LIBRARY_NAME);
        } catch (java.lang.UnsatisfiedLinkError e) {
            NativeUtils.loadEmbeddedLibrary(LIBRARY_NAME);
        }
    }

    protected final static Cleaner CLEANER = Cleaner.create();

    public final static Cleanable registerCleaner(Object obj, Runnable action) {
        return CLEANER.register(obj, action);
    }

    private final static native void quicke_init_logger();
}
