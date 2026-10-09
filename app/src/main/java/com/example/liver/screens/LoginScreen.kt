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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
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
import com.example.liver.components.LiverOutlinedButton
import com.example.liver.components.LiverPrimaryButton
import com.example.liver.components.LiverTextField
import com.example.liver.ui.theme.LiverCream
import com.example.liver.ui.theme.LiverDark
import com.example.liver.ui.theme.LiverOrange
import com.example.liver.ui.theme.LiverTheme

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    var emailError by remember {
        mutableStateOf<String?>(null)
    }

    var passwordError by remember {
        mutableStateOf<String?>(null)
    }

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

            Spacer(
                modifier = Modifier.height(90.dp)
            )

            Text(
                text = "Welcome back",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                color = LiverDark
            )

            Text(
                text = "Sign in to the liver transplant program app",
                fontSize = 15.sp,
                color = LiverDark,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(22.dp)
            )

            Text(
                text = "Login",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = LiverDark
            )

            Spacer(
                modifier = Modifier.height(42.dp)
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Email",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = LiverDark
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                LiverTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailError = null
                    },
                    placeholder = "Enter your email",
                    isError = emailError != null,
                    errorText = emailError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = "Password",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = LiverDark
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                LiverTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        passwordError = null
                    },
                    placeholder = "Enter your password",
                    isError = passwordError != null,
                    errorText = passwordError,
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
                                    if (passwordVisible) {
                                        "Hide"
                                    } else {
                                        "Show"
                                    },
                                color = LiverDark
                            )
                        }
                    }
                )

                TextButton(
                    onClick = {
                        // Forgot password functionality can be added later.
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "Forgot Password?",
                        color = LiverOrange
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            LiverPrimaryButton(
                text = "Login",
                onClick = {

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

                    if (
                        emailError == null &&
                        passwordError == null
                    ) {
                        onLoginSuccess()
                    }
                }
            )

            Spacer(
                modifier = Modifier.height(48.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = LiverDark
                )

                Text(
                    text = "Or",
                    color = LiverDark
                )

                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = LiverDark
                )
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            LiverOutlinedButton(
                text = "Continue with Apple",
                onClick = {
                    onLoginSuccess()
                }
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            LiverOutlinedButton(
                text = "Continue with Google",
                onClick = {
                    onLoginSuccess()
                }
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            LiverOutlinedButton(
                text = "Continue with Facebook",
                onClick = {
                    onLoginSuccess()
                }
            )

            Spacer(
                modifier = Modifier.height(40.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LiverTheme {
        LoginScreen(
            onLoginSuccess = {}
        )
    }
}
