package com.home.content.test.helpers;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpContext {

    private Integer statusCode;
    private final Map<String, String> headers = new HashMap<>();

    public String getResponseBody() {
        return responseBody;
    }

    private String responseBody;

    public int getStatusCode() {
        return statusCode;
    }

    public boolean hasHeader(final String name) {
        return this.headers.containsKey(name);
    }

    public String getHeader(final String name) {
        return this.headers.get(name);
    }

    public void populateGetQuery(final GetMethod method) throws IOException {
        this.statusCode = method.getStatusCode();

        this.headers.clear();
        for (final Header header : method.getResponseHeaders()) {
            this.headers.put(header.getName(), header.getValue());
        }
        this.responseBody = method.getResponseBodyAsString();
    }

    public void populatePostQuery(final PostMethod method) throws IOException {
        this.statusCode = method.getStatusCode();

        this.headers.clear();
        for (final Header header : method.getResponseHeaders()) {
            this.headers.put(header.getName(), header.getValue());
        }
        this.responseBody = method.getResponseBodyAsString();
    }
}
