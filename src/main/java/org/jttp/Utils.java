package org.jttp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Utils {

    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();

    public final static String asHex(byte[] bytes) {
        if (null == bytes)
            return "";

        char[] hex = new char[bytes.length * 2];

        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hex[j * 2] = HEX_ARRAY[v >>> 4];
            hex[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }

        return new String(hex);
    }

    public static final String copyFileFromJAR(String prefix, String filepath) throws IOException {
        try (final InputStream fileStream = Utils.class.getResourceAsStream(filepath)) {

            if (fileStream == null)
                return null;

            final File temp = File.createTempFile(prefix, "temp");
            temp.deleteOnExit();

            try (final OutputStream out = new FileOutputStream(temp)) {
                final byte[] buffer = new byte[1024];
                int len = fileStream.read(buffer);

                while (len != -1) {
                    out.write(buffer, 0, len);
                    len = fileStream.read(buffer);
                }
            }

            return temp.getAbsolutePath();
        }
    }

}