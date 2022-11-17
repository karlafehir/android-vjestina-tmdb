package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val ZERO_ANGLE = 0f
private const val FULL_ANGLE = 360f
private const val REFLEX_ANGLE = 270f
private const val BAR_STROKE = 24f

@Composable
fun UserScoreProgressBar(
    userScore: Float,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Canvas(
            modifier = modifier
                .fillMaxSize()
        ) {
            drawArc(
                color = Color.Green,
                alpha = 0.2f,
                startAngle = ZERO_ANGLE,
                sweepAngle = FULL_ANGLE,
                useCenter = false,
                style = Stroke(
                    width = BAR_STROKE,
                    cap = StrokeCap.Round
                )
            )
            drawArc(
                color = Color.Green,
                startAngle = REFLEX_ANGLE,
                sweepAngle = userScore * FULL_ANGLE,
                useCenter = false,
                style = Stroke(
                    width = BAR_STROKE,
                    cap = StrokeCap.Round
                )
            )
        }
        Text(
            text = (userScore * 10).toString(),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserScoreProgressBarPreview() {
    val voteAverage = MoviesMock.getMovieDetails().voteAverage
    UserScoreProgressBar(
        userScore = voteAverage,
        modifier = Modifier
            .size(width = 70.dp, height = 70.dp)
    )
}
