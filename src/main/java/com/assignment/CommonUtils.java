package com.assignment;

import java.util.Base64;

public class CommonUtils {

    public static String extractUsername(String base64EncodedString) {
        // Decode the Base64 encoded string
        byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedString);
        String decodedString = new String(decodedBytes);

        // Assuming the format is "username:password", split by ":" and get the username
        String[] parts = decodedString.split(":", 2);
        return parts.length > 0 ? parts[0] : null; // Return the username part
    }

}
