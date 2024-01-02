
import com.slack.circuit.foundation.Circuit
import ui.chat.ChatPresenter
import ui.chat.ChatScreenUiFactory
import ui.settings.SettingsPresenterFactory
import ui.settings.SettingsScreenUiFactory

val circuit = Circuit.Builder()
    .addPresenterFactory(ChatPresenter.Factory())
    .addUiFactory(ChatScreenUiFactory())
    .addPresenterFactory(SettingsPresenterFactory())
    .addUiFactory(SettingsScreenUiFactory())
    .build()