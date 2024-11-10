// SessionManager.java
package com.example.freshly;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREF_NAME = "FreshlyPrefs";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_TYPE = "user_type";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void saveUserSession(int userId, String userType) {
        editor.putInt(KEY_USER_ID, userId);
        editor.putString(KEY_USER_TYPE, userType);
        editor.apply();
    }

    public int getUserId() {
        return prefs.getInt(KEY_USER_ID, -1);
    }

    public String getUserType() {
        return prefs.getString(KEY_USER_TYPE, null);
    }

    public void clearSession() {
        editor.clear();
        editor.apply();
    }
}
