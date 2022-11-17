package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.model.Crewman
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


data class CrewItemViewState(
    val name: String,
    val job: String,
)

@Composable
fun CrewItem(
    crewItemViewState: CrewItemViewState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = crewItemViewState.name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(text = crewItemViewState.job)
    }
}

@Preview
@Composable
private fun CrewItemPreview() {
    val crew: Crewman = MoviesMock.getCrewman()
    val crewItemViewState = CrewItemViewState(
        name = crew.name,
        job = crew.job,
    )
    CrewItem(
        crewItemViewState = crewItemViewState,
        modifier = Modifier
    )
}

