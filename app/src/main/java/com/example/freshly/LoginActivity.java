// LoginActivity.java
package com.example.freshly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailField, passwordField;
    private AppDatabase database;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "freshly_db").build();
        sessionManager = new SessionManager(this);

        Button loginButton = findViewById(R.id.login_button);
        Button signupButton = findViewById(R.id.signup_button);

        loginButton.setOnClickListener(v -> loginUser());
        signupButton.setOnClickListener(v -> startActivity(new Intent(this, SignupActivity.class)));
    }

    private void loginUser() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        new Thread(() -> {
            // Check if user is a customer
            Customer customer = database.customerDao().login(email, password);
            if (customer != null) {
                sessionManager.saveUserSession(customer.id, "customer");
                runOnUiThread(() -> {
                    startActivity(new Intent(this, CustomerHomeActivity.class));
                    finish();
                });
                return;
            }

            // Check if user is a vendor
            Vendor vendor = database.vendorDao().login(email, password);
            if (vendor != null) {
                sessionManager.saveUserSession(vendor.id, "vendor");
                runOnUiThread(() -> {
                    startActivity(new Intent(this, VendorHomeActivity.class));
                    finish();
                });
                return;
            }

            // Show error message if login fails
            runOnUiThread(() -> Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show());
        }).start();
    }
}
