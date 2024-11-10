// CustomerHomeActivity.java
package com.example.freshly;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomerHomeActivity extends AppCompatActivity {

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        sessionManager = new SessionManager(this);
        ImageView profileImageView = findViewById(R.id.profile_image);
        TextView welcomeText = findViewById(R.id.welcome_text);

        // Set welcome text or profile image from session
        welcomeText.setText("Welcome, Customer!");

        Button logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(v -> {
            sessionManager.clearSession();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
