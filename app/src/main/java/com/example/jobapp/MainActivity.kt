package com.example.jobapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.jobapp.ui.theme.JobAppTheme
import com.example.jobapp.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(JobViewModel::class.java)
        setContent {
            JobAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Greeting("Android")
                    val jobsState = viewModel.jobs.collectAsState()
                    val jobs = jobsState.value
                    Screen(jobs, onAddClicked = {
                        val appFormIntent = Intent(this, AppForm::class.java)
                        startActivity(appFormIntent)
                    })
                }
            }
        }
    }
}

@Composable
fun JobItem(
    job: Job,
    onAddClicked: (String) -> Unit
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                onAddClicked(job.url)
            }
    ) {
        Card(
            modifier = Modifier
                .padding(1.5.dp)
        ) {


            if (job.logo != null) {
                AsyncImage(
                    model = job.logo, contentDescription = job.logo, modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .height(300.dp)
                        .width(300.dp)

                )

                Text(
                    text = job.company_name,
                    modifier = Modifier.padding(4.dp),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black
                )
            }
        }
    }
}

fun generateJobs(): List<Job> {
    return listOf(

        Job(
            "1",
            "Data Analyst",
            "Microsoft",

            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQgBLBewdpybJI-0Mra5pwtO3mXSgxpp80bQ&s",
            "abc.com"
        )
    )
}


@Preview
@Composable
fun Screen(jobs: List<Job> = emptyList(), onAddClicked: (String) -> Unit = {}) {

    var searchText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .background(color = Color.White)
    ) {
        val gradientColors = listOf(Blue, Blue)
        Card(

            modifier = Modifier
                .padding(1.5.dp)
        ) {

            Text(
                text = "Welcome to CareerCatalyst",
                style = TextStyle(brush = Brush.horizontalGradient(colors = gradientColors)),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)

            )
        }

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Search Jobs") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        val filteredJobs = if (searchText.isNotBlank()) {
            jobs.filter {
                it.company_name.contains(searchText, ignoreCase = true)
            }
        } else {
            jobs // Return all jobs if search text is blank
        }


        LazyVerticalGrid(columns = GridCells.Fixed(1)) {
            items(filteredJobs) { currentJob ->
                JobItem(currentJob, onAddClicked)
            }
        }
    }
}


