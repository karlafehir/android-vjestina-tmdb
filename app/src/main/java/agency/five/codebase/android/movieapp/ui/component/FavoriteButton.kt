package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.Blue
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteButton(modifier: Modifier = Modifier) {
    val isFavorite = remember { mutableStateOf(true) }

    Image(
        painter = painterResource(
            id = if(isFavorite.value)
                R.drawable.heart_full
            else
                R.drawable.heart_empty),
        contentDescription = "Favorite",
        modifier = Modifier
            .clickable { isFavorite.value = isFavorite.value.not() }
            .size(32.dp)
            .background(Blue, CircleShape)
            .padding(top = 9.dp, start = 7.dp, end = 7.dp, bottom = 7.dp)
    )
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    FavoriteButton()
}