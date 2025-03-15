package org.jttp;

import org.jttp.http3.Http3;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class Jttp {
    public static final int MAX_CONN_ID_LEN = 20;

    public static final String CONN_ID_SEED_ALGO = "HMACSHA256";

    public enum Shutdown {
        READ(0),
        WRITE(1);

        private final int value;

        Shutdown(int value) {
            this.value = value;
        }

        public final int value() {
            return this.value;
        }
    }

    public static final byte[] newConnectionId() {
        return newConnectionId(new Random());
    }

    public static final Connection connection(String serverName, byte[] connId, Config config) throws ConnectionFailurException {
        final long ptr = Native.jhttp_connect(serverName, connId, config.getPointer());

        if (ptr <= Http3.ErrorCode.SUCCESS) {
            throw new ConnectionFailureException(ptr);
        }

        return Connection.newInstance(ptr);
    }
}
