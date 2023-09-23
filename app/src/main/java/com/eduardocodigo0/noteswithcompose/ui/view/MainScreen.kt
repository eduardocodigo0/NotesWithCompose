package com.eduardocodigo0.noteswithcompose.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eduardocodigo0.noteswithcompose.R
import kotlin.random.Random

@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val ctx = LocalContext.current
    var searchString by remember { mutableStateOf("") }
    val noteList by mutableStateOf(
        listOf(
            "Test note 1",
            "Test note 2",
            "Test note 3",
            "Test note 4",
            "Test note 5",
            "Test note 6",
            "Test note 7",
            "Test note 8",
            "Test note 9",
            "Test note 10",
            "Test note 11",
            "Test note 12",
            "Test note 13",

        )
    )

    val colorList = listOf(
        Color.Blue,
        Color.LightGray,
        Color.Green,
        Color.Magenta,
        Color.Yellow,
        Color.Cyan
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape =  RoundedCornerShape(
                    dimensionResource(
                        id = R.dimen.search_bar_corner_radius
                    )
                ),
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary

            ) { Icon(Icons.Filled.Add,"") }
        },

    ) {
        Column(
            modifier = Modifier.padding(
                dimensionResource(
                    id = R.dimen.main_screen_padding
                )
            )
        ) {
            TextField(
                value = searchString,
                onValueChange = { changedValue ->
                    searchString = changedValue
                },
                placeholder = { Text(ctx.getString(R.string.search_bar_label)) },
                shape = RoundedCornerShape(
                    dimensionResource(
                        id = R.dimen.search_bar_corner_radius
                    )
                ),
                leadingIcon = {
                    Icon(Icons.Filled.Search, "")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        dimensionResource(
                            id = R.dimen.search_bar_height
                        )
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                )
            )

            Spacer(
                modifier = Modifier.height(
                    dimensionResource(
                        id = R.dimen.search_bar_bottom_spacer
                    )
                )
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
            ) {
                items(noteList.size) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(
                            modifier = Modifier.height(
                                dimensionResource(
                                    id = R.dimen.search_bar_bottom_spacer
                                )
                            )
                        )
                        CardNote(title = "Teste", date = "10/05/2021", bgColor = colorList.getOrNull(Random.nextInt(0, colorList.size)) ?: Color.Gray)
                        Spacer(
                            modifier = Modifier.height(
                                dimensionResource(
                                    id = R.dimen.search_bar_bottom_spacer
                                )
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CardNote(title: String, date: String, bgColor: Color) {
    Card(
        shape = RoundedCornerShape(
            dimensionResource(
                id = R.dimen.card_corner_radius
            )
        ),
        colors = CardDefaults.cardColors(
            containerColor = bgColor,
        ),
        modifier = Modifier
            .width(
                dimensionResource(
                    id = R.dimen.card_width
                )
            )
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                dimensionResource(
                    id = R.dimen.card_margin
                )
            )
        ) {
            Spacer(
                modifier = Modifier.height(
                    dimensionResource(
                        id = R.dimen.card_title_top_margin
                    )
                )
            )
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(
                modifier = Modifier.height(
                    dimensionResource(
                        id = R.dimen.card_spacer
                    )
                )
            )

            Text(
                text = date,
                fontSize = 8.sp,
                textAlign = TextAlign.End,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = dimensionResource(
                            id = R.dimen.card_date_horizontal_margin
                        )
                    )
            )
        }

    }
}

@Composable
@Preview(showBackground = true)
fun CardNotePreview() {
    CardNote(
        title = "Titulo",
        date = "01/02/2003",
        Color.Blue
    )
}


@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    MainScreen()
}

