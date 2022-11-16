package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.ui.theme.Gray600
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



data class MovieCategoryLabelViewState(
    val movie : String
)

@Composable
fun MovieCategoryLabel(
    modifier: Modifier = Modifier
)
{
//    Row() {
//        Column(
//            modifier = Modifier.width(54.dp),
//            verticalArrangement = Arrangement.spacedBy(4.dp)
//        ) {
//            Text(
//                text = "Movies",
//                fontWeight = FontWeight.Bold,
//                color = Color.Black,
//                fontSize = 16.sp
//            )
//            Box(){
//                Divider(color = Color.Black, thickness = 3.dp,)
//            }
//        }
//        Text(
//            text = "Movies",
//            fontWeight = FontWeight.Normal,
//            color = Gray600,
//            fontSize = 16.sp
//        )
//    }
}

//Will complete today

@Preview(showBackground = true)
@Composable
private fun MovieCategoryLabelPreview() {
    MovieCategoryLabel()
}

