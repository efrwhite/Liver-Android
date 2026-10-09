package com.example.liver.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.liver.components.LiverPrimaryButton
import com.example.liver.ui.theme.LiverCream
import com.example.liver.ui.theme.LiverGray
import com.example.liver.ui.theme.LiverGreen
import com.example.liver.ui.theme.LiverLightGreen
import com.example.liver.ui.theme.LiverOrange
import com.example.liver.ui.theme.LiverRed
import com.example.liver.ui.theme.LiverTheme

@Composable
fun EvaluationProcessScreen(
    onNextClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = LiverCream
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = WindowInsets.navigationBars.asPaddingValues()
        ) {

            item {
                // Top green information section
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp)
                        .statusBarsPadding(),
                    color = LiverGreen
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 28.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Every donor goes through the same five phases, so we're confident it's safe for you before anything moves forward.",
                            color = Color.White,
                            fontSize = 23.sp,
                            lineHeight = 30.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 22.dp,
                            vertical = 34.dp
                        )
                ) {

                EvaluationStep(
                    number = 1,
                    title = "Online screening questionnaire",
                    description = "A basic check of your health history",
                    dotColor = LiverLightGreen,
                    showLine = true
                )

                EvaluationStep(
                    number = 2,
                    title = "Meet your donor advocate",
                    description = "An Independent Living Donor Advocate (ILDA) supports only you, separate from the recipient's care team, to make sure your decision is fully your own.",
                    dotColor = LiverOrange,
                    showLine = true
                )

                EvaluationStep(
                    number = 3,
                    title = "Blood work & initial diagnostics",
                    description = "Blood type match, liver function, general health",
                    dotColor = LiverGray,
                    showLine = true
                )

                EvaluationStep(
                    number = 4,
                    title = "Imaging & specialized tests",
                    description = "CT/MRI scans map your liver's anatomy",
                    dotColor = LiverGray,
                    showLine = true
                )

                EvaluationStep(
                    number = 5,
                    title = "Multidisciplinary team meeting",
                    description = "Social worker, nutrition, nurse coordinator, hepatologist & surgeon",
                    dotColor = LiverGray,
                    showLine = false
                )

                Spacer(
                    modifier = Modifier.height(42.dp)
                )

                LiverPrimaryButton(
                    text = "Next: Your Surgery",
                    onClick = onNextClick
                )

                }
            }
        }
    }
}

@Composable
private fun EvaluationStep(
    number: Int,
    title: String,
    description: String,
    dotColor: Color,
    showLine: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {

        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(
                        color = dotColor,
                        shape = CircleShape
                    )
            )

            if (showLine) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .weight(1f)
                        .background(Color.DarkGray)
                )
            }
        }

        Spacer(
            modifier = Modifier.width(18.dp)
        )

        Surface(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(28.dp),
            color = Color.White,
            border = BorderStroke(
                width = 1.dp,
                color = LiverRed.copy(alpha = 0.45f)
            )
        ) {

            Column(
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 20.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "$number. $title",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = description,
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EvaluationProcessScreenPreview() {
    LiverTheme {
        EvaluationProcessScreen()
    }
}
