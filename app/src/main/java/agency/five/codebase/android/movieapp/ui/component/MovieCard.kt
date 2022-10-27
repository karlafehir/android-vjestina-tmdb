package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.model.Movie
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Moviecard(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(122.dp)
            .height(179.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box {
            AsyncImage(
                model = movie.imageUrl,
                contentDescription = movie.title
            )
            FavoriteButton() //add isFavorite
        }
    }
}

@Preview
@Composable
private fun MovieCardPreview() {
    Moviecard(movie = MoviesMock.getMoviesList()[1])
}