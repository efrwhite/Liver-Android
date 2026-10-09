package com.example.liver.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.liver.ui.theme.LiverCream
import com.example.liver.ui.theme.LiverDark
import com.example.liver.ui.theme.LiverGreen
import com.example.liver.ui.theme.LiverOrange
import com.example.liver.ui.theme.LiverRed
import com.example.liver.ui.theme.LiverTheme

@Composable
fun DonationOptionsScreen(
    onHomeClick: () -> Unit,
    onEvaluationProcessClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = LiverCream
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                color = LiverGreen
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = 24.dp,
                            vertical = 42.dp
                        ),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = "Two ways to donate",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "There's more than one path to becoming a donor. Tap each to learn more.",
                        color = Color.White,
                        fontSize = 21.sp,
                        lineHeight = 28.sp
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(
                    modifier = Modifier.height(42.dp)
                )

                DonationOptionCard(
                    title = "Directed donation",
                    description =
                        "You donate to a specific person you know, a family member, friend, or acquaintance who needs a transplant.",
                    borderColor = LiverRed,
                    directed = true
                )

                Spacer(
                    modifier = Modifier.height(22.dp)
                )

                DonationOptionCard(
                    title = "Non-directed donation",
                    description =
                        "You donate anonymously to whoever is highest on the wait list and the best match. You may never meet them.",
                    borderColor = LiverGreen,
                    directed = false
                )

                Spacer(
                    modifier = Modifier.height(34.dp)
                )

                Text(
                    text = "Not sure which fits you? You can decide later in the process.",
                    color = LiverDark,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(38.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    OutlinedButton(
                        onClick = onHomeClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(58.dp),
                        shape = RoundedCornerShape(30.dp),
                        border = BorderStroke(
                            width = 1.dp,
                            color = LiverOrange
                        )
                    ) {
                        HomeIcon()

                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )

                        Text(
                            text = "Home",
                            color = LiverOrange,
                            fontSize = 17.sp
                        )
                    }

                    Button(
                        onClick = onEvaluationProcessClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(58.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LiverOrange,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "The Evaluation\nProcess",
                            fontSize = 17.sp,
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(36.dp)
                )
            }
        }
    }
}

@Composable
private fun DonationOptionCard(
    title: String,
    description: String,
    borderColor: Color,
    directed: Boolean
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 220.dp),
        shape = RoundedCornerShape(26.dp),
        color = Color.White,
        border = BorderStroke(
            width = 1.dp,
            color = borderColor
        )
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 28.dp,
                vertical = 24.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (directed) {
                DirectedDonationIcon()
            } else {
                NonDirectedDonationIcon()
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = title,
                color = LiverDark,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = description,
                color = LiverDark,
                fontSize = 18.sp,
                lineHeight = 23.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun DirectedDonationIcon() {
    Canvas(
        modifier = Modifier.size(42.dp)
    ) {
        val heart = Path().apply {
            moveTo(size.width / 2f, size.height * .86f)

            cubicTo(
                size.width * .36f,
                size.height * .72f,
                size.width * .08f,
                size.height * .55f,
                size.width * .08f,
                size.height * .30f
            )

            cubicTo(
                size.width * .08f,
                size.height * .05f,
                size.width * .38f,
                size.height * .03f,
                size.width / 2f,
                size.height * .23f
            )

            cubicTo(
                size.width * .62f,
                size.height * .03f,
                size.width * .92f,
                size.height * .05f,
                size.width * .92f,
                size.height * .30f
            )

            cubicTo(
                size.width * .92f,
                size.height * .55f,
                size.width * .64f,
                size.height * .72f,
                size.width / 2f,
                size.height * .86f
            )
        }

        drawPath(
            path = heart,
            color = LiverGreen,
            style = Stroke(
                width = 3.5.dp.toPx(),
                cap = StrokeCap.Round
            )
        )
    }
}

@Composable
private fun NonDirectedDonationIcon() {
    Canvas(
        modifier = Modifier.size(48.dp)
    ) {
        val path = Path().apply {
            moveTo(2.dp.toPx(), 25.dp.toPx())
            lineTo(14.dp.toPx(), 25.dp.toPx())
            lineTo(25.dp.toPx(), 8.dp.toPx())
            lineTo(25.dp.toPx(), 36.dp.toPx())
            lineTo(37.dp.toPx(), 22.dp.toPx())
            lineTo(47.dp.toPx(), 22.dp.toPx())
        }

        drawPath(
            path = path,
            color = LiverRed,
            style = Stroke(
                width = 3.5.dp.toPx(),
                cap = StrokeCap.Round
            )
        )
    }
}

@Composable
private fun HomeIcon() {
    Canvas(
        modifier = Modifier.size(30.dp)
    ) {
        val house = Path().apply {
            moveTo(4.dp.toPx(), 14.dp.toPx())
            lineTo(15.dp.toPx(), 5.dp.toPx())
            lineTo(26.dp.toPx(), 14.dp.toPx())
            lineTo(26.dp.toPx(), 25.dp.toPx())
            lineTo(4.dp.toPx(), 25.dp.toPx())
            close()
        }

        val stroke = 2.5.dp.toPx()

        drawPath(
            path = house,
            color = LiverOrange,
            style = Stroke(
                width = stroke,
                cap = StrokeCap.Round
            )
        )

        drawLine(
            color = LiverOrange,
            start = androidx.compose.ui.geometry.Offset(
                9.dp.toPx(),
                21.dp.toPx()
            ),
            end = androidx.compose.ui.geometry.Offset(
                21.dp.toPx(),
                21.dp.toPx()
            ),
            strokeWidth = stroke,
            cap = StrokeCap.Round
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DonationOptionsScreenPreview() {
    LiverTheme {
        DonationOptionsScreen(
            onHomeClick = {},
            onEvaluationProcessClick = {}
        )
    }
}