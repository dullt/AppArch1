package com.itera.erlenste.apparch1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itera.erlenste.apparch1.ui.theme.AppArch1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppArch1Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { ApplicationTopAppBar("Navne-app") }) { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        viewModel = viewModel()
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier, viewModel: NameViewModel) {
    // TODO: Bruk viewmodel for å hente ut liste med navn

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        InputComponent(modifier = Modifier)
        Spacer(modifier = Modifier.size(8.dp))

        //TODO: vis liste med navn når de blir tilgjengelige i state
        ResultComponent(modifier = Modifier, names = listOf())
    }
}

@Composable
fun InputComponent(modifier: Modifier) {
    var input by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            value = input,
            onValueChange = {
                input = it
            },
            modifier = Modifier.weight(0.8f),
            label = { Text(text = "Skriv noe") }
        )
        Spacer(modifier = Modifier.size(8.dp))

        //TODO: Implementer onClick med extension-function
        Button(onClick = { }) { Text(text = "Legg til") }
    }
}

@Composable
fun ResultComponent(modifier: Modifier, names: List<String>) {
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(3), modifier = modifier) {
        items(names) { name ->
            Result(modifier, name)
        }
    }
}

@Composable
fun Result(modifier: Modifier, name: String) {
    Card(modifier = modifier.padding(8.dp)) {
        Text(modifier = modifier.padding(8.dp), text = name)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewInputComponent() {
    AppArch1Theme {
        InputComponent(
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewResultComponent() {
    val names = listOf(
        "Malesuada hendrerit gravida inceptos non senectus justo.s",
        "Sollicitudin malesuada nam.",
        "A scelerisque imperdiet posuere massa erat, nostra nam volutpat massa.",
        "Elit tortor porttitor in enim maecenas ultriciess massa proin venenatis.",
        "Habitant neque per mauris, ultricies in elementum etiam netus ante?",
        "Neque nisi interdum per donec facilisi duis convallis montes ullamcorper"
    )
    AppArch1Theme {
        ResultComponent(
            modifier = Modifier, names = names
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewResult() {
    val name = "Neque nisi interdum per donec facilisi duis convallis montes ullamcorper"
    AppArch1Theme {
        Result(
            modifier = Modifier, name = name
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationTopAppBar(title: String) {
    TopAppBar(
        title = {
            Text(text = title)
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}