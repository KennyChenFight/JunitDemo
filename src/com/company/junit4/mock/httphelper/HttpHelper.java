package com.company.junit4.mock.httphelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;

public class HttpHelper {

    public String getContent(URL url) throws IOException {
        InputStream input = createInputStream(url);
        StringWriter writer = new StringWriter();
        byte[] data = new byte[2048];
        int length = -1;
        while((length = input.read(data)) != -1) {
            writer.write(new String(data, 0, length));
        }
        input.close();
        writer.close();
        return writer.toString();
    }

    protected InputStream createInputStream(URL url) throws IOException {
        return url.openStream();
    }
}
