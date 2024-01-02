package ui.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.ui

data object ChatScreen : Screen {
    data class ChatUiState(
        val count: Int = 0,
        val eventSink: (ChatUiEvent) -> Unit
    ) : CircuitUiState

    sealed interface ChatUiEvent {
        data object Increment : ChatUiEvent
        data object Decrement : ChatUiEvent
        data object ToSettings : ChatUiEvent
    }
}

fun chatScreenUi() = ui<ChatScreen.ChatUiState> { state, modifier -> Chat(state, modifier) }

@Composable
fun Chat(state: ChatScreen.ChatUiState, modifier: Modifier = Modifier) {
    Scaffold(modifier) {
        ChatContent(
            count = state.count,
            onDecrement = { state.eventSink(ChatScreen.ChatUiEvent.Decrement) },
            onIncrement = { state.eventSink(ChatScreen.ChatUiEvent.Increment) },
            navigateToSettings = { state.eventSink(ChatScreen.ChatUiEvent.ToSettings) }
        )
    }
}

@Composable
private fun ChatContent(
    count: Int,
    onDecrement: () -> Unit,
    onIncrement: () -> Unit,
    navigateToSettings: () -> Unit
) {
    Column {
        Text(text = "$count")
        Spacer(modifier = Modifier.height(24.dp))
        ActionButtonGroup(onDecrement, onIncrement)
        Button(onClick = navigateToSettings) {
            Text(text = "Navigate to Settings")
        }
    }
}

@Composable
fun ActionButtonGroup(
    onDecrement: () -> Unit,
    onIncrement: () -> Unit,
) {
    Row {
        Button(onClick = onDecrement) {
            Text(text = "-")
        }
        Button(onClick = onIncrement) {
            Text(text = "+")
        }
    }
}
