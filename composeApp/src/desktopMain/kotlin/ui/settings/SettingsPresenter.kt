package ui.settings

import androidx.compose.runtime.Composable
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui

class SettingsPresenter(private val navigator: Navigator) : Presenter<SettingsScreen.SettingsState> {
    @Composable
    override fun present(): SettingsScreen.SettingsState {
        return SettingsScreen.SettingsState { event ->
            when (event) {
                SettingsScreen.SettingsUiEvent.NavigateUp -> navigator.pop()
            }
        }
    }
}

class SettingsPresenterFactory : Presenter.Factory {
    override fun create(
        screen: Screen,
        navigator: Navigator,
        context: CircuitContext
    ): Presenter<*>? {
        return when (screen) {
            is SettingsScreen -> SettingsPresenter(navigator)
            else -> null
        }
    }
}

class SettingsScreenUiFactory : Ui.Factory {
    override fun create(screen: Screen, context: CircuitContext): Ui<*>? {
        return when (screen) {
            is SettingsScreen -> settingsScreenUi()
            else -> null
        }
    }
}
