package com.irvingmichael.irv.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Aaron Anderson on 10/10/16.
 */
public class CustomHeaderHttpRequest extends HttpServletRequestWrapper {

    private TreeMap<String, String> customHeaders;

    public CustomHeaderHttpRequest(HttpServletRequest request) {
        super(request);
        customHeaders = new TreeMap<>();
    }

    @Override
    public String getHeader(String name) {
        String header = super.getHeader(name);
        header = (name == "Referer") ? header : super.getParameter(name); // Note: you can't use getParameterValues() here.
        return header;
    }

    @Override
    public Enumeration getHeaderNames() {
        List<String> names = Collections.list(super.getHeaderNames());
        names.addAll(Collections.list(super.getParameterNames()));
        return Collections.enumeration(names);
    }

    public void setCustomHeader(String key, String value) {
        customHeaders.put(key, value); }
}
