import com.hasancbngl.di.koinModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin) {
        //logger. configure for koin
        slf4jLogger()
        //implement koin module
        modules(koinModule)
    }
}