package com.saleh.javatools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by salehmao on 29/03/2017.
 */
public class MapUtil {

    private MapUtil() {
        // can't be instantiated
        throw new UnsupportedOperationException("can not be instantiated");
    }

    public static String mapToString(Map<String, String> map) {
        StringBuilder builder = new StringBuilder();

        for (String key : map.keySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            String value = map.get(key);
            try {
                builder.append(null != key ? URLEncoder.encode(key, "UTF-8") : "");
                builder.append("=");
                builder.append(null != value ? URLEncoder.encode(value, "UTF-8") : "");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("This method requires UTF-8 encoding support", e);
            }
        }
        return builder.toString();
    }
}
