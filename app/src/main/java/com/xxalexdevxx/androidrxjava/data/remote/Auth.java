package com.xxalexdevxx.androidrxjava.data.remote;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


//*********** Podcast Index API Authentication, Authorization **************//

// The Podcast Index API requires a key, a secret, a current UTC unix epoch time,
// a User-Agent (system/product, example: Minke/1.0), and a
// SHA1 hash of the key + the secret + the UTC unix epoch time

public class Auth {

    private String baseUrl = RequestConstants.BASE_URL;
    private String apiKey = RequestConstants.API_KEY;
    private String apiSecret = RequestConstants.API_SECRET;
    private String userAgent = RequestConstants.USER_AGENT;
    private String authHash;
    private String headerTime = setApiHeaderTime();

    public Auth() {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.headerTime = headerTime;
        this.userAgent = userAgent;
        this.baseUrl = baseUrl;
        this.authHash = calculateApiHash(apiKey, apiSecret, headerTime);
    }

    private static String setApiHeaderTime() {
        Calendar calendar = new GregorianCalendar();
        Date todayDate = new Date();
        calendar.setTime(todayDate);
        long xAuthDate = calendar.getTimeInMillis() / 1000L;
        return String.valueOf(xAuthDate);
    }

    private static String calculateApiHash(String apiKey, String apiSecret, String apiHeaderTime) {

        String hashValues = apiKey + apiSecret + apiHeaderTime;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(hashValues.getBytes("UTF-8"));
            return byteArrayToString(messageDigest.digest());
        } catch (Exception ignored) {
            ignored.printStackTrace();
            return null;
        }
    }

    private static String byteArrayToString(byte[] bytes) {
        StringBuilder buffer = new StringBuilder();
        for (byte b : bytes) {
            buffer.append(String.format(Locale.getDefault(), "%02x", b));
        }
        return buffer.toString();
    }

    public static String getBaseUrl() {
        return RequestConstants.BASE_URL;
    }

    public static String getApiKey() {
        return RequestConstants.API_KEY;
    }

    public static String getUserAgent() {
        return RequestConstants.USER_AGENT;
    }

    public static String getHeaderTime(Auth auth) {
        return auth.headerTime;
    }

    public static String getAuthHash(Auth auth) {
        return auth.authHash;
    }
}