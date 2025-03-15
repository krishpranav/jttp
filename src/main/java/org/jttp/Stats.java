package org.jttp;

public final class Stats {
    private int recv;
    private int sent;
    private int lost;

    Stats() {}

    public final int recv() {
        return this.recv;
    }

    protected final void setRecv(int recv) {
        this.recv = recv;
    }

    public final int sent() {
        return this.sent;
    }

    protected final void setSent(int sent) {
        this.sent = sent;
    }

    public final int lost() {
        return this.lost;
    }
}
