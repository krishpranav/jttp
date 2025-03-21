package org.jttp;

import java.lang.ref.Cleaner;
import java.lang.ref.Cleaner.Cleanable;

public final class Native {

    public final static String LIBRARY_NAME = "jhttp";

    static {
        try {
            System.loadLibrary(LIBRARY_NAME);
        } catch (java.lang.UnsatisfiedLinkError e) {
            NativeUtils.loadEmbeddedLibrary(LIBRARY_NAME);
        }

        jhttp_init_logger();
    }

    protected final static Cleaner CLEANER = Cleaner.create();

    public final static Cleanable registerCleaner(Object obj, Runnable action) {
        return CLEANER.register(obj, action);
    }

    private final static native void jhttp_init_logger();


    public final static native long jhttp_config_new(int version);

    public final static native void jhttp_config_load_cert_chain_from_pem_file(long config_prt, String path);

    public final static native void jhttp_config_load_priv_key_from_pem_file(long config_ptr, String path);

    public final static native void jhttp_config_verify_peer(long config_ptr, boolean v);

    public final static native void jhttp_config_grease(long config_ptr, boolean v);

    public final static native void jhttp_config_log_keys(long config_ptr);

    public final static native void jhttp_config_enable_early_data(long config_ptr);

    public final static native int jhttp_config_set_application_protos(long config_ptr, byte[] protos);

    public final static native void jhttp_config_set_max_idle_timeout(long config_ptr, long v);

    public final static native void jhttp_config_set_max_udp_payload_size(long config_ptr, long v);

    public final static native void jhttp_config_set_initial_max_data(long config_ptr, long v);

    public final static native void jhttp_config_set_initial_max_stream_data_bidi_local(long config_ptr, long v);

    public final static native void jhttp_config_set_initial_max_stream_data_bidi_remote(long config_ptr, long v);

    public final static native void jhttp_config_set_initial_max_stream_data_uni(long config_ptr, long v);

    public final static native void jhttp_config_set_initial_max_streams_bidi(long config_ptr, long v);

    public final static native void jhttp_config_set_initial_max_streams_uni(long config_ptr, long v);

    public final static native void jhttp_config_set_ack_delay_exponent(long config_ptr, long v);

    public final static native void jhttp_config_set_max_ack_delay(long config_ptr, long v);

    public final static native void jhttp_config_set_disable_active_migration(long config_ptr, boolean v);

    public final static native int jhttp_config_set_cc_algorithm_name(long config_ptr, String name);

    public final static native void jhttp_config_enable_hystart(long config_ptr, boolean v);

    public final static native long jhttp_config_free(long config_ptr);

    public final static native long jhttp_accept(byte[] scid, byte[] odcid, long config_ptr);

    public final static native long jhttp_connect(String server_name, byte[] scid, long config_ptr);

    public final static native int jhttp_negotiate_version(byte[] scid, byte[] dcid, byte[] buf);

    public final static native boolean jhttp_version_is_supported(int version);

    public final static native int jhttp_retry(
            byte[] sourceConnId, byte[] destinationConnId, byte[] newSourceConnId,
            byte[] token, int version, byte[] buf);

    public final static native int jhttp_conn_recv(long conn_ptr, byte[] buf);

    public final static native int jhttp_conn_send(long conn_ptr, byte[] buf);

    public final static native int jhttp_conn_close(long conn_ptr, boolean app, long err, byte[] reason);

    public final static native long jhttp_conn_timeout_as_nanos(long conn_ptr);

    public final static native long jhttp_conn_timeout_as_millis(long conn_ptr);

    public final static native void jhttp_conn_on_timeout(long conn_ptr);

    public final static native boolean jhttp_conn_is_established(long conn_ptr);

    public final static native boolean jhttp_conn_is_in_early_data(long conn_ptr);

    public final static native boolean jhttp_conn_is_closed(long conn_ptr);

    public final static native void jhttp_conn_stats(long conn_ptr, Stats holder);

    public final static native void jhttp_conn_free(long conn_ptr);

    public final static native int jhttp_conn_stream_recv(long conn_ptr, long stream_id, byte[] buf);

    public final static native int jhttp_conn_stream_send(long conn_ptr, long stream_id, byte[] buf, boolean fin);

    public final static native void jhttp_conn_stream_shutdown(long conn_ptr, long stream_id, int direction, long err);

    public final static native int jhttp_conn_stream_capacity(long conn_ptr, long stream_id);

    public final static native boolean jhttp_conn_stream_finished(long conn_ptr, long stream_id);

    public final static native long jhttp_conn_readable(long conn_ptr);

    public final static native long jhttp_conn_writable(long conn_ptr);

    public final static native long jhttp_stream_iter_next(long stream_iter_ptr);

    public final static native void jhttp_stream_iter_free(long stream_iter_ptr);

    public final static native void jhttp_header_from_slice(byte[] buf, int dcid_len, PacketHeader holder);
}