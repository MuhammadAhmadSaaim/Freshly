// SignupActivity.java
package com.example.freshly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText emailField, passwordField, usernameField, addressField, phoneField;
    private RadioGroup userTypeGroup;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);
        usernameField = findViewById(R.id.username_field);
        addressField = findViewById(R.id.address_field);
        phoneField = findViewById(R.id.phone_field);
        userTypeGroup = findViewById(R.id.user_type_group);
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "freshly_db").build();

        Button signupButton = findViewById(R.id.signup_button);
        signupButton.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        String username = usernameField.getText().toString();
        String address = addressField.getText().toString();
        String phone = phoneField.getText().toString();
        int selectedUserType = userTypeGroup.getCheckedRadioButtonId();

        if (selectedUserType == R.id.radio_customer) {
            // Register as a customer
            Customer customer = new Customer();
            customer.email = email;
            customer.password = password;
            customer.image = ""; // Placeholder for image
            customer.gender = ""; // Placeholder for gender (optional)

            new Thread(() -> {
                database.customerDao().insert(customer);
                runOnUiThread(() -> {
                    Toast.makeText(this, "Customer registered successfully", Toast.LENGTH_SHORT).show();
                    finish();
                });
            }).start();

        } else if (selectedUserType == R.id.radio_vendor) {
            // Register as a vendor
            Vendor vendor = new Vendor();
            vendor.username = username;
            vendor.password = password;
            vendor.image = ""; // Placeholder for image
            vendor.phone = phone;
            vendor.address = address;

            new Thread(() -> {
                database.vendorDao().insert(vendor);
                runOnUiThread(() -> {
                    Toast.makeText(this, "Vendor registered successfully", Toast.LENGTH_SHORT).show();
                    finish();
                });
            }).start();
        } else {
            Toast.makeText(this, "Please select a user type", Toast.LENGTH_SHORT).show();
        }
    }
}
