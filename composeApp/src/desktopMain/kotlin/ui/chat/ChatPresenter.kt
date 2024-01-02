package ui.chat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import ui.settings.SettingsScreen

class ChatPresenter(private val navigator: Navigator) : Presenter<ChatScreen.ChatUiState> {
    @Composable
    override fun present(): ChatScreen.ChatUiState {
        var count by rememberSaveable {
            mutableStateOf(0)
        }

        return ChatScreen.ChatUiState(count) { event ->
            when (event) {
                ChatScreen.ChatUiEvent.Decrement -> count--
                ChatScreen.ChatUiEvent.Increment -> count++
                ChatScreen.ChatUiEvent.ToSettings -> {
                    navigator.goTo(SettingsScreen)
                }
            }
        }
    }

    class Factory : Presenter.Factory {
        override fun create(
            screen: Screen,
            navigator: Navigator,
            context: CircuitContext
        ): Presenter<*>? {
            return when (screen) {
                is ChatScreen -> ChatPresenter(navigator)
                else -> null
            }
        }

    }
}

class ChatScreenUiFactory : Ui.Factory {
    override fun create(screen: Screen, context: CircuitContext): Ui<*>? {
        return when (screen) {
            is ChatScreen -> chatScreenUi()
            else -> null
        }
    }
}

