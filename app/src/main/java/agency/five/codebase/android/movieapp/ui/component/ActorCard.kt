package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.model.Actor
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class ActorCardViewState(
    val imageUrl: String?,
    val name: String,
    val character: String,
)

@Composable
fun ActorCard(
    actorCardViewState: ActorCardViewState,
    modifier: Modifier = Modifier
){
        Card(
            modifier = modifier,
            shape = RoundedCornerShape(10.dp),
            elevation = 10.dp
        ) {
            Column() {
                AsyncImage(
                    model = actorCardViewState.imageUrl,
                    contentDescription = "Image",
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.FillWidth
                )
                Text(text = actorCardViewState.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(text = actorCardViewState.character)
                Spacer(
                    modifier = modifier
                        .padding(4.dp)
                )
            }
        }
}

@Preview
@Composable
private fun ActorCardPreview() {
    val actor: Actor = MoviesMock.getActor()
    val actorCardViewState = ActorCardViewState(
        imageUrl = actor.imageUrl,
        name = actor.name,
        character = actor.character,
    )
    ActorCard(
        actorCardViewState = actorCardViewState,
        modifier = Modifier
            .size(width = 150.dp, height = 240.dp) //OVO
    )
}

