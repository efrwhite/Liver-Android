package com.example.liver.screens

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.liver.ui.theme.LiverCream
import com.example.liver.ui.theme.LiverDark
import com.example.liver.ui.theme.LiverOrange
import com.example.liver.ui.theme.LiverTheme

@Composable
fun RegisterScreen() {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    var firstNameError by remember { mutableStateOf<String?>(null) }
    var lastNameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmPasswordError by remember { mutableStateOf<String?>(null) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = LiverCream
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(90.dp))

            Text(
                text = "Register",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = LiverDark
            )

            Spacer(modifier = Modifier.height(42.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "First Name",
                        color = LiverDark
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = firstName,
                        onValueChange = {
                            firstName = it
                            firstNameError = null
                        },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text("John")
                        },
                        singleLine = true,
                        isError = firstNameError != null,
                        supportingText = {
                            firstNameError?.let {
                                Text(it)
                            }
                        },
                        shape = RoundedCornerShape(10.dp)
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Last Name",
                        color = LiverDark
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = lastName,
                        onValueChange = {
                            lastName = it
                            lastNameError = null
                        },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text("Doe")
                        },
                        singleLine = true,
                        isError = lastNameError != null,
                        supportingText = {
                            lastNameError?.let {
                                Text(it)
                            }
                        },
                        shape = RoundedCornerShape(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Email",
                    color = LiverDark
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailError = null
                    },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text("Enter your email")
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    isError = emailError != null,
                    supportingText = {
                        emailError?.let {
                            Text(it)
                        }
                    },
                    shape = RoundedCornerShape(10.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Password",
                    color = LiverDark
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        passwordError = null
                        confirmPasswordError = null
                    },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text("********")
                    },
                    singleLine = true,
                    visualTransformation =
                        if (passwordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                    trailingIcon = {
                        TextButton(
                            onClick = {
                                passwordVisible = !passwordVisible
                            }
                        ) {
                            Text(
                                text =
                                    if (passwordVisible) "Hide" else "Show"
                            )
                        }
                    },
                    isError = passwordError != null,
                    supportingText = {
                        if (passwordError != null) {
                            Text(passwordError!!)
                        } else {
                            Text("Must contain at least 8 characters")
                        }
                    },
                    shape = RoundedCornerShape(10.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Confirm Password",
                    color = LiverDark
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = {
                        confirmPassword = it
                        confirmPasswordError = null
                    },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text("********")
                    },
                    singleLine = true,
                    visualTransformation =
                        if (confirmPasswordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                    trailingIcon = {
                        TextButton(
                            onClick = {
                                confirmPasswordVisible =
                                    !confirmPasswordVisible
                            }
                        ) {
                            Text(
                                text =
                                    if (confirmPasswordVisible) {
                                        "Hide"
                                    } else {
                                        "Show"
                                    }
                            )
                        }
                    },
                    isError = confirmPasswordError != null,
                    supportingText = {
                        confirmPasswordError?.let {
                            Text(it)
                        }
                    },
                    shape = RoundedCornerShape(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = {

                    firstNameError =
                        if (firstName.isBlank()) {
                            "Required"
                        } else {
                            null
                        }

                    lastNameError =
                        if (lastName.isBlank()) {
                            "Required"
                        } else {
                            null
                        }

                    emailError = when {
                        email.isBlank() -> {
                            "Email is required"
                        }

                        !Patterns.EMAIL_ADDRESS
                            .matcher(email.trim())
                            .matches() -> {
                            "Enter a valid email"
                        }

                        else -> null
                    }

                    passwordError = when {
                        password.isBlank() -> {
                            "Password is required"
                        }

                        password.length < 8 -> {
                            "Password must contain at least 8 characters"
                        }

                        else -> null
                    }

                    confirmPasswordError = when {
                        confirmPassword.isBlank() -> {
                            "Confirm your password"
                        }

                        confirmPassword != password -> {
                            "Passwords do not match"
                        }

                        else -> null
                    }

                    if (
                        firstNameError == null &&
                        lastNameError == null &&
                        emailError == null &&
                        passwordError == null &&
                        confirmPasswordError == null
                    ) {
                        // Real account creation will be added later.
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LiverOrange
                )
            ) {
                Text(
                    text = "Create Account",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "By continuing, you agree to our Terms of Service and Privacy Policy.",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = LiverDark,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    LiverTheme {
        RegisterScreen()
    }
}