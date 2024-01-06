package com.example.composeexplorer.activities.functions.dialogs.picker

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateTimePicker() {
    ComposeExplorerTheme {
        Surface {

            //Date:
            val calendarState = rememberSheetState()
            CalendarDialog(
                state = calendarState,
                config = CalendarConfig(
                    monthSelection = true,
                    yearSelection = true,
                    style = CalendarStyle.MONTH,
                    disabledDates = listOf(LocalDate.now().plusDays(7))
                ),
                selection = CalendarSelection.Date { date ->
                    Log.d("SelectedDate", "$date")
                }
            )

            //Time:
            val clockState = rememberSheetState()
            ClockDialog(
                state = clockState,
                config = ClockConfig(
                    is24HourFormat = true
                ),
                selection = ClockSelection.HoursMinutes { hours, minutes ->
                    Log.d("SelectedDate", "$hours:$minutes")
                }
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { calendarState.show() }) {
                    Text(text = "Date Picker")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { clockState.show() }) {
                    Text(text = "Time Picker")
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DateTimePickerPreview() {
    DateTimePicker()
}