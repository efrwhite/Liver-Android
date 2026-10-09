package com.example.liver.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.liver.ui.theme.LiverCream
import com.example.liver.ui.theme.LiverDark
import com.example.liver.ui.theme.LiverGray
import com.example.liver.ui.theme.LiverGreen
import com.example.liver.ui.theme.LiverLightGreen
import com.example.liver.ui.theme.LiverOrange
import com.example.liver.ui.theme.LiverTheme

@Composable
fun HomeScreen(
    userName: String = "Anush",
    onLearnAboutProcessClick: () -> Unit = {},
    onCheckEligibilityClick: () -> Unit = {}
) {
    Surface(modifier = Modifier.fillMaxSize(), color = LiverCream) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = WindowInsets.navigationBars.asPaddingValues()
        ) {
            item { DonationHero(userName) }
            item {
                Column(
                    modifier = Modifier.padding(start = 19.dp, top = 19.dp, end = 19.dp, bottom = 62.dp)
                ) {
                    Text(
                        text = "Why donate?",
                        color = LiverDark,
                        fontSize = 34.sp,
                        lineHeight = 38.sp,
                        letterSpacing = (-0.9).sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(9.dp))
                    Text(
                        text = "A living donor's liver grows back to full function within weeks donating can save a life with minimal long-term impact on your own health.",
                        color = LiverDark,
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(33.dp))
                    EvaluationNotice()
                    Spacer(modifier = Modifier.height(13.dp))
                    RoboticSurgeryBenefit()
                    Spacer(modifier = Modifier.height(23.dp))
                    DonationActions(onLearnAboutProcessClick, onCheckEligibilityClick)
                }
            }
        }
    }
}

@Composable
private fun DonationHero(userName: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(232.dp)
            .background(LiverGreen)
            .statusBarsPadding()
            .padding(start = 31.dp, top = 48.dp, end = 31.dp, bottom = 15.dp)
    ) {
        Text(
            text = "Welcome !",
            color = LiverLightGreen,
            fontSize = 30.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(11.dp))
        Text(
            text = userName,
            color = LiverCream,
            fontSize = 44.sp,
            lineHeight = 44.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun EvaluationNotice() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 153.dp),
        shape = RoundedCornerShape(16.5.dp),
        color = LiverCream,
        border = BorderStroke(1.dp, LiverGray)
    ) {
        Text(
            text = "Every donor completes a full evaluation before surgery, so we only move forward when it's safe for you and gives the recipient a strong chance of success.",
            modifier = Modifier.padding(start = 54.dp, top = 15.dp, end = 41.dp, bottom = 30.dp),
            color = LiverDark,
            fontSize = 18.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun RoboticSurgeryBenefit() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 152.dp),
        shape = RoundedCornerShape(16.5.dp),
        color = LiverGray,
        border = BorderStroke(1.5.dp, LiverLightGreen)
    ) {
        Row(
            modifier = Modifier.padding(start = 6.dp, top = 22.dp, end = 16.5.dp, bottom = 18.dp),
            verticalAlignment = Alignment.Top
        ) {
            SurgeryRobotIcon()
            Spacer(modifier = Modifier.width(9.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Robotic surgery, when appropriate",
                    color = LiverGreen,
                    fontSize = 18.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Smaller incisions can mean less scarring and a smoother recovery for many donors.",
                    color = LiverDark,
                    fontSize = 18.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
private fun SurgeryRobotIcon() {
    Canvas(modifier = Modifier.size(width = 48.dp, height = 36.dp)) {
        val stroke = 3.dp.toPx()
        drawRoundRect(
            color = LiverGreen,
            topLeft = Offset(2.25.dp.toPx(), 2.25.dp.toPx()),
            size = Size(size.width - 4.5.dp.toPx(), size.height - 4.5.dp.toPx()),
            cornerRadius = CornerRadius(3.dp.toPx()),
            style = Stroke(width = stroke, cap = StrokeCap.Round)
        )
        drawCircle(LiverGreen, 4.5.dp.toPx(), Offset(13.5.dp.toPx(), 15.dp.toPx()))
        drawCircle(LiverGreen, 4.5.dp.toPx(), Offset(34.5.dp.toPx(), 15.dp.toPx()))
        val mouth = Path().apply {
            moveTo(17.25.dp.toPx(), 28.5.dp.toPx())
            cubicTo(
                18.75.dp.toPx(), 24.dp.toPx(),
                21.dp.toPx(), 21.75.dp.toPx(),
                24.dp.toPx(), 21.75.dp.toPx()
            )
            cubicTo(
                27.dp.toPx(), 21.75.dp.toPx(),
                29.25.dp.toPx(), 24.dp.toPx(),
                30.75.dp.toPx(), 28.5.dp.toPx()
            )
            moveTo(18.dp.toPx(), 28.5.dp.toPx())
            lineTo(30.dp.toPx(), 28.5.dp.toPx())
        }
        drawPath(
            path = mouth,
            color = LiverGreen,
            style = Stroke(width = stroke, cap = StrokeCap.Round)
        )
    }
}

@Composable
private fun DonationActions(
    onLearnAboutProcessClick: () -> Unit,
    onCheckEligibilityClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 22.5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(
            onClick = onLearnAboutProcessClick,
            modifier = Modifier.fillMaxWidth().height(57.dp),
            shape = RoundedCornerShape(23.dp),
            colors = ButtonDefaults.buttonColors(containerColor = LiverOrange, contentColor = LiverCream),
            border = BorderStroke(1.dp, LiverOrange)
        ) {
            Text("Learn about the process", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        OutlinedButton(
            onClick = onCheckEligibilityClick,
            modifier = Modifier.fillMaxWidth().height(57.dp),
            shape = RoundedCornerShape(23.dp),
            border = BorderStroke(1.dp, LiverGray),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = LiverDark)
        ) {
            Text("Check eligibility", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    LiverTheme { HomeScreen() }
}
