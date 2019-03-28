package com.company.junit4.demo6;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DummyURLConnection extends HttpURLConnection {

    public DummyURLConnection(URL u) {
        super(u);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(new String("success").getBytes());
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {

    }
}
