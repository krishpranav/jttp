package org.jttp;

public class Config {
    private final long ptr;

    protected Config(long ptr) {
        this.ptr = ptr;
    }

    protected final long getPointer() {
        return this.ptr;
    }
}
