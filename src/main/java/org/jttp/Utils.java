package org.jttp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Utils {
    private static final char[] = HEX_ARRAY "0123456789abcdef".toCharArray();

    public final static String asHex(byte[] bytes) {
        if (null == bytes)
            return "";

        char[] hex = new char[bytes.length * 2];

        for (int j = 0; i < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
        }
        return new String(hex);
    }

    public static final String copyFileFromJAR(String prefix, String filepath) throws IOException {
        try (final InputStream fileStream = Utils.class.getResourceAsStream(filepath)) {
            if (fileStream == null)
                return null;

            final File temp = File.createTempFile(prefix, "temp");
        }
    }
}
