package com.company.junit4.demo6;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public class DummyURLStreamHandlerFactory implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        return new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(URL u) throws IOException {
                return new DummyURLConnection(u);
            }
        };
    }
}
