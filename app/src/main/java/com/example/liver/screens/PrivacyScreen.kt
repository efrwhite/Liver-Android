package com.example.liver.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.liver.ui.theme.*

@Composable
fun PrivacyScreen(onNextClick: () -> Unit = {}) {
    var acknowledged by rememberSaveable { mutableStateOf(false) }
    Surface(Modifier.fillMaxSize(), color = LiverCream) {
        LazyColumn(Modifier.fillMaxSize(), contentPadding = WindowInsets.navigationBars.asPaddingValues()) {
            item { PrivacyHeader() }
            item {
                Column(
                    Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 46.dp, bottom = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    PrivacyCard(PrivacyCardKind.Hidden, "The recipient will never see your medical results or test details.")
                    PrivacyCard(PrivacyCardKind.Withdraw, "You can step away at any time, for any reason the recipient will not be told why or that you withdrew.")
                    PrivacyCard(PrivacyCardKind.Share, "If you want the recipient to know something, that's always your choice to share, we simply won't disclose it on your behalf.")
                    Spacer(Modifier.height(123.dp))
                    Acknowledgement(acknowledged) { acknowledged = it }
                    Spacer(Modifier.height(29.dp))
                    Button(
                        onClick = onNextClick,
                        modifier = Modifier.padding(horizontal = 19.dp).fillMaxWidth().height(64.dp),
                        shape = RoundedCornerShape(32.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = LiverOrange, contentColor = Color.White)
                    ) { Text("Next: Your Surgery", fontSize = 20.sp, fontWeight = FontWeight.Normal) }
                }
            }
        }
    }
}

@Composable
private fun PrivacyHeader() {
    Box(
        Modifier.fillMaxWidth().height(150.dp).background(LiverGreen).statusBarsPadding(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(Modifier.offset(y = (-7).dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(Modifier.size(82.dp).background(LiverOrange, CircleShape), contentAlignment = Alignment.Center) { LockIcon() }
            Spacer(Modifier.height(17.dp))
            Text("Privacy, first and always", color = Color.White, fontSize = 25.sp, lineHeight = 30.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(3.dp))
            Text("Your entire Evaluation is 100% confidential", color = Color.White, fontSize = 16.sp, lineHeight = 20.sp)
        }
    }
}

private enum class PrivacyCardKind { Hidden, Withdraw, Share }

@Composable
private fun PrivacyCard(kind: PrivacyCardKind, text: String) {
    val borderColor = if (kind == PrivacyCardKind.Withdraw) LiverGreen else LiverRed
    Surface(
        modifier = Modifier.fillMaxWidth().height(122.dp),
        shape = RoundedCornerShape(25.dp),
        color = Color.White,
        border = BorderStroke(1.dp, borderColor)
    ) {
        Row(Modifier.padding(horizontal = 22.dp), verticalAlignment = Alignment.CenterVertically) {
            when (kind) {
                PrivacyCardKind.Hidden -> HiddenEyeIcon()
                PrivacyCardKind.Withdraw -> WithdrawIcon()
                PrivacyCardKind.Share -> ShareIcon()
            }
            Spacer(Modifier.width(14.dp))
            Text(
                text = text,
                modifier = Modifier.weight(1f),
                color = LiverDark,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun Acknowledgement(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth().height(42.dp).clickable { onCheckedChange(!checked) },
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        border = BorderStroke(1.dp, LiverGreen)
    ) {
        Row(Modifier.padding(start = 19.dp, end = 16.dp), verticalAlignment = Alignment.CenterVertically) {
            Canvas(Modifier.size(20.dp)) {
                drawRect(Color(0xFFD9D9D9), style = Stroke(1.dp.toPx()))
                if (checked) {
                    val path = Path().apply { moveTo(size.width * .18f, size.height * .52f); lineTo(size.width * .42f, size.height * .76f); lineTo(size.width * .84f, size.height * .22f) }
                    drawPath(path, LiverGreen, style = Stroke(2.dp.toPx()))
                }
            }
            Spacer(Modifier.width(28.dp))
            Text("I understand my evaluation is confidential.", color = LiverDark, fontSize = 16.sp, lineHeight = 20.sp)
        }
    }
}

@Composable
private fun LockIcon() {
    Canvas(Modifier.size(42.dp)) {
        val stroke = 4.dp.toPx()
        drawRoundRect(Color.White, Offset(5.dp.toPx(), 20.dp.toPx()), Size(size.width - 10.dp.toPx(), 17.dp.toPx()), CornerRadius(3.dp.toPx()), style = Stroke(stroke))
        drawArc(Color.White, 180f, 180f, false, Offset(12.dp.toPx(), 5.dp.toPx()), Size(18.dp.toPx(), 25.dp.toPx()), style = Stroke(stroke))
    }
}

@Composable
private fun HiddenEyeIcon() {
    Canvas(Modifier.size(36.dp)) {
        val stroke = 3.dp.toPx()
        val eye = Path().apply { moveTo(2.dp.toPx(), 18.dp.toPx()); cubicTo(9.dp.toPx(), 6.dp.toPx(), 24.dp.toPx(), 6.dp.toPx(), 34.dp.toPx(), 18.dp.toPx()); cubicTo(25.dp.toPx(), 30.dp.toPx(), 10.dp.toPx(), 30.dp.toPx(), 2.dp.toPx(), 18.dp.toPx()) }
        drawPath(eye, LiverGreen, style = Stroke(stroke)); drawCircle(LiverGreen, 4.dp.toPx(), Offset(18.dp.toPx(), 18.dp.toPx())); drawLine(LiverGreen, Offset(3.dp.toPx(), 3.dp.toPx()), Offset(33.dp.toPx(), 33.dp.toPx()), stroke)
    }
}

@Composable
private fun WithdrawIcon() {
    Canvas(Modifier.size(36.dp)) {
        val stroke = 4.dp.toPx(); drawCircle(LiverOrange, 16.dp.toPx(), Offset(18.dp.toPx(), 18.dp.toPx()), style = Stroke(stroke)); drawLine(LiverOrange, Offset(25.dp.toPx(), 18.dp.toPx()), Offset(11.dp.toPx(), 18.dp.toPx()), stroke); drawLine(LiverOrange, Offset(11.dp.toPx(), 18.dp.toPx()), Offset(17.dp.toPx(), 12.dp.toPx()), stroke); drawLine(LiverOrange, Offset(11.dp.toPx(), 18.dp.toPx()), Offset(17.dp.toPx(), 24.dp.toPx()), stroke)
    }
}

@Composable
private fun ShareIcon() {
    Canvas(Modifier.size(36.dp)) {
        val stroke = 3.dp.toPx(); val a = Offset(9.dp.toPx(), 19.dp.toPx()); val b = Offset(26.dp.toPx(), 9.dp.toPx()); val c = Offset(26.dp.toPx(), 28.dp.toPx())
        drawLine(LiverGreen, a, b, stroke); drawLine(LiverGreen, a, c, stroke)
        listOf(a, b, c).forEach { drawCircle(Color.White, 5.dp.toPx(), it); drawCircle(LiverGreen, 5.dp.toPx(), it, style = Stroke(stroke)) }
    }
}
