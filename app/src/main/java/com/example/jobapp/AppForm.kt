package com.example.jobapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jobapp.ui.theme.JobAppTheme

//import android.os.Bundle
//import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class AppForm : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegistrationForm(onApplyClicked = {
                        val thanksIntent = Intent(this, Thanks::class.java)
                        startActivity(thanksIntent)
                    })
                }
            }
        }
    }
}


@Preview
@Composable
fun RegistrationForm(onApplyClicked: () -> Unit = {}) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var Qualification by remember { mutableStateOf("") }
    var specifieddomain by remember { mutableStateOf("") }
    var graduationstart by remember { mutableStateOf("") }
    var graduationend by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Item 1") }
    val items = listOf(
        "Senior Developer",
        "Intern",
        "Junior Developer",
        "Project Manager",
        "Business Analyst",
        "Data Analyst",
        "Accountant",
        "Cloud Engineer",
        "Quality Assurance"
    )
    val context = LocalContext.current
    //val filePickerLauncher = rememberLauncherForFilePicker()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Application Form", fontWeight = FontWeight.ExtraBold, fontSize = 28.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            OutlinedTextField(
                value = Qualification,
                onValueChange = { Qualification = it },
                label = { Text("Qualification") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),

            )

            OutlinedTextField(
                value = specifieddomain,
                onValueChange = { specifieddomain = it },
                label = { Text("Specified Domain") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),

            )

            OutlinedTextField(
                value = graduationstart,
                onValueChange = { graduationstart = it },
                label = { Text("Graduation Start Year") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),

            )

            OutlinedTextField(
                value = graduationend,
                onValueChange = { graduationend = it },
                label = { Text("Graduation End Year") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = selectedItem,
                        onValueChange = { selectedItem = it },
                        label = { Text("Select a Role") },
                        singleLine = true,
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.weight(1f)
                    ) {
                        items.forEach { item ->
                            DropdownMenuItem(
                                text = {
                                    Text(text = item, modifier = Modifier.weight(1f))
                                },
                                onClick = {
                                    selectedItem = item
                                    expanded = false
                                }
                            )
                        }
                    }
                    IconButton(
                        onClick = { expanded = !expanded }) {
                        Icon(Icons.Filled.ArrowDropDown, contentDescription = "Toggle dropdown")
                    }
                }


            }


            Button(
                onClick = {
                    onApplyClicked()
                },
                modifier = Modifier.fillMaxWidth()

            ) {
                Text("Click To Apply")
            }
        }
    }
}



fun submitRegistration(name: String, email: String, password: String) {

}