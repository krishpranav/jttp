package org.jttp.http3;

public final class Http3 {

    public static final byte[] APPLICATION_PROTOCOL = "\u0005h3-29\u0005h3-28\u0005h3-27".getBytes();

    public static final class ErrorCode {

        public static final short DONE = -1;

        public static final short BUFFER_TO_SHORT = -2;

        public static final short INTERNAL_ERROR = -3;

        public static final short EXCESSIVE_LOAD = -4;

        public static final short ID_ERROR = -5;

        public static final short STREAM_CREATION_ERROR = -6;

        public static final short CLOSED_CRITICAL_STREAM = -7;

        public static final short MISSING_SETTINGS = -8;

        public static final short FRAME_UNEXPECTED = -9;

        public static final short FRAME_ERROR = -10;

        public static final short QPACK_DECOMPRESSION_FAILED = -11;

        public static final short TRANSPORT_ERROR = -12;

        public static final short STREAM_BLOCKED = -13;
    }

}