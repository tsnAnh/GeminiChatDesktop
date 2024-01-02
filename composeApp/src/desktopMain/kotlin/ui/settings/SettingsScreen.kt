package ui.settings

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.ui

data object SettingsScreen : Screen {
    data class SettingsState(val eventSink: (SettingsUiEvent) -> Unit) : CircuitUiState

    sealed interface SettingsUiEvent {
        data object NavigateUp : SettingsUiEvent
    }
}

fun settingsScreenUi() =
    ui<SettingsScreen.SettingsState> { state, modifier -> Settings(state, modifier) }

@Composable
fun Settings(state: SettingsScreen.SettingsState, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            SettingsTopBar(
                onNavigateUp = { state.eventSink(SettingsScreen.SettingsUiEvent.NavigateUp) }
            )
        },
        modifier = modifier,
    ) {
        SettingsContent()
    }
}

@Composable
fun SettingsTopBar(onNavigateUp: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = onNavigateUp
            ) {
                Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
            }
        },
        title = {
            Text(text = "Settings")
        }
    )
}

@Composable
fun SettingsContent() {
    Text(text = "Settings")
}
