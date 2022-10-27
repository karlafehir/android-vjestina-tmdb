

import agency.five.codebase.android.movieapp.mock.MoviesMock
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserScoreProgressBar(
    userScore: Float,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier){
        Canvas(modifier = modifier
            .size(90.dp)
            .padding(10.dp)){
            drawArc(
                color = Color.Green,
                alpha = 0.2f,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(
                    width = 24f,
                    cap = StrokeCap.Round
                )
            )
            drawArc(
                color = Color.Green,
                startAngle = 270f,
                sweepAngle = userScore*360f,
                useCenter = false,
                style = Stroke(
                    width = 24f,
                    cap = StrokeCap.Round
                )
            )
        }
        Text(
            text = (userScore*10).toString(),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            modifier = modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserScoreProgressBarPreview() {
    UserScoreProgressBar(userScore =  MoviesMock.getMovieDetails().voteAverage)
}