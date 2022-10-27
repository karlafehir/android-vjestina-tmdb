package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.model.Actor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


data class ActorCardViewState(
    val imageUrl: String,
    val name: String,
    val character: String,
)

@Composable
fun ActorCard(
    actorCardViewState: Actor,
    modifier: Modifier = Modifier
)
{
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(320.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 10.dp
        ) {
            Column() {
                AsyncImage(
                    model = actorCardViewState.imageUrl,
                    contentDescription = "Image",
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Column() {
                    Text(text = actorCardViewState.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                        )
                    Text(text = actorCardViewState.character)
                }
            }
        }
    }
}

@Preview
@Composable
private fun ActorCardPreview() {
  ActorCard(actorCardViewState = MoviesMock.getActor())
}

