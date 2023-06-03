package com.example.proyectocm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getName();
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    EditText email, password;
    private FirebaseAuth mAuth;

    Button btnLogin1, SingUP;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        SingUP = findViewById(R.id.btnSingUp);

        btnLogin1 = findViewById(R.id.btnLogin1);

        SingUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent singUp = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(singUp);
            }
        });

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(LoginActivity.this, menu.class);
                startActivity(login);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if(currentUser != null) {
            Intent login = new Intent(this, MainActivity.class);
            login.putExtra("user", currentUser.getEmail());
            startActivity(login);
        } else {
            email.setText("");
            password.setText("");
        }
    }

    private boolean validateForm() {
        boolean valid = true;
        String emailCheck = email.getText().toString();
        if (TextUtils.isEmpty(emailCheck)) {
            email.setError("Required");
            valid = false;
        } else {
            email.setError(null);
        }

        String passCheck = password.getText().toString();
        if (TextUtils.isEmpty(passCheck)) {
            password.setError("Required");
            valid = false;
        } else {
            password.setError(null);
        }
        return valid;
    }

    private void signInUser(String email, String password) {
        if (validateForm()) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI
                        Log.d(TAG, "signInWithEmail: Success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);
                    } else {
                        // If Sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail: Failure", task.getException());
                        Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                }
            });
        }
    }

    public void login(View view) {
        String emailLogin = email.getText().toString();
        String passLogin = password.getText().toString();

        if (!isEmailValid(emailLogin)) {
            Toast.makeText(LoginActivity.this, "Email is not a valid format", Toast.LENGTH_SHORT).show();
            return;
        }

        signInUser(emailLogin, passLogin);
    }
    public static boolean isEmailValid(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public void forgotPassword(View view) {
        String Email = email.getText().toString();

        if (!isEmailValid(Email)) {
            Toast.makeText(LoginActivity.this, "Email is not a valid format", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.sendPasswordResetEmail(Email).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(LoginActivity.this, "Email instructions hace been sent, please check your email", Toast.LENGTH_SHORT).show();
            }
        });
    }

}