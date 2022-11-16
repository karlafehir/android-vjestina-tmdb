package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.model.Movie
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


data class MovieCardViewState(
    val imageUrl: String?,
    val isFavorite: Boolean
)

@Composable
fun MovieCard(
    movieCardViewState: MovieCardViewState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .width(122.dp)
        .height(179.dp),
) {
    Card(
        modifier = modifier,
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box {
            AsyncImage(
                model = movieCardViewState.imageUrl,
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
            )
            FavoriteButton(
                isFavorite = movieCardViewState.isFavorite,
                onClick = onClick,
                modifier = Modifier
                    .size(32.dp))
        }
    }
}

@Preview
@Composable
private fun MovieCardPreview() {
    val movie: Movie = MoviesMock.getMoviesList()[1]
    val movieCardViewState = MovieCardViewState(
        imageUrl = movie.imageUrl,
        isFavorite = movie.isFavorite,
    )
    MovieCard(
        movieCardViewState = movieCardViewState,
        onClick = {  }
    )
}
