package com.example.tr.instantcool2.Utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by TR on 2017/10/10.
 */

public class StreamUtil {

    public static String readStream(InputStream in) throws Exception {

        // 定义一个内存输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1;
        byte[] buffer = new byte[1024]; // 1kb
        while ((len = in.read(buffer)) != -1) {

            baos.write(buffer, 0, len);
        }
        in.close();
        String content = new String(baos.toByteArray());

        return content;

    }

}
