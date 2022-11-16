package agency.five.codebase.android.movieapp.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: MovieCategoryLabelTextViewState
)

sealed class MovieCategoryLabelTextViewState{
    class Text(val text: String): MovieCategoryLabelTextViewState()
    class TextRes(@StringRes val textRes: Int): MovieCategoryLabelTextViewState()
}

@Composable
fun selectTextSource(movieCategoryLabelViewState: MovieCategoryLabelViewState): String{
    return when(val categoryText = movieCategoryLabelViewState.categoryText) {
        is MovieCategoryLabelTextViewState.Text -> categoryText.text
        is MovieCategoryLabelTextViewState.TextRes -> stringResource(id = categoryText.textRes)
    }
}

@Composable
fun MovieCategoryLabel(
    item: MovieCategoryLabelViewState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (item.isSelected) {
        Column(
            modifier = modifier
                .padding(5.dp)
                .width(intrinsicSize = IntrinsicSize.Max)
                .clickable(onClick = onClick)
        ) {
            Text(
                text = selectTextSource(movieCategoryLabelViewState = item),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier
                .size(2.dp)
            )
            Divider(color = Color.Black,
                thickness = 3.dp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
    else {
        Text(
            text = selectTextSource(movieCategoryLabelViewState = item),
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = modifier
                .padding(5.dp)
                .clickable(onClick = onClick)
        )
    }
}

@Preview
@Composable
fun MovieCategoryLabelPreview(){
    val inputText = MovieCategoryLabelTextViewState.Text("TV")
    val stringRes = MovieCategoryLabelTextViewState.Text("Movies")
    val categoryViewState1 = MovieCategoryLabelViewState(0, true, stringRes)
    val categoryViewState2 = MovieCategoryLabelViewState(1, false, inputText)
    Row{
        MovieCategoryLabel(item = categoryViewState1, { })
        MovieCategoryLabel(item = categoryViewState2, { })
    }
}

