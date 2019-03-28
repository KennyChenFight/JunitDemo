package com.company.junit4.mock.httphelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TestForHttpHelper extends HttpHelper {

    @Override
    protected InputStream createInputStream(URL url) throws IOException {
        // 傳回的 InputStream 就是 Mock 物件的概念
        return new ByteArrayInputStream("success".getBytes());
    }
}
