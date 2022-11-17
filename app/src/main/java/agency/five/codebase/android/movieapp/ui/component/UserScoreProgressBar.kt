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

private const val ZeroAngle = 0f
private const val FullAngle = 360f
private const val ReflexAngle = 270f
private const val BarStroke = 24f

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
                startAngle = ZeroAngle,
                sweepAngle = FullAngle,
                useCenter = false,
                style = Stroke(
                    width = BarStroke,
                    cap = StrokeCap.Round
                )
            )
            drawArc(
                color = Color.Green,
                startAngle = ReflexAngle,
                sweepAngle = userScore * FullAngle,
                useCenter = false,
                style = Stroke(
                    width = BarStroke,
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
