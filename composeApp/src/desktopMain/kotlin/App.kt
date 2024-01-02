import androidx.compose.runtime.Composable
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import theme.GeminiChatTheme

@Composable
fun App() {
    val geminiChatAppState = rememberGeminiChatAppState()
    GeminiChatTheme(darkTheme = false) {
        CircuitCompositionLocals(circuit) {
            NavigableCircuitContent(geminiChatAppState.navigator, geminiChatAppState.backStack)
        }
    }
}