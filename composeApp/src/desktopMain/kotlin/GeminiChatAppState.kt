
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import com.slack.circuit.backstack.SaveableBackStack
import com.slack.circuit.backstack.isAtRoot
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.slack.circuit.runtime.Navigator
import ui.chat.ChatScreen

@Stable
class GeminiChatAppState(
    val backStack: SaveableBackStack,
    val navigator: Navigator
) {
    val isRootScreen get() = backStack.isAtRoot
}

@Composable
fun rememberGeminiChatAppState(
    backStack: SaveableBackStack = rememberSaveableBackStack { push(ChatScreen) },
    navigator: Navigator = rememberCircuitNavigator(backStack) {}
): GeminiChatAppState = remember(backStack, navigator) {
    GeminiChatAppState(backStack, navigator)
}
