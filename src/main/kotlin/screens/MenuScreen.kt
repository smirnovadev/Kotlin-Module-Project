package screens

import Application
import data.Command

class MenuScreen(prevScreen: Screen?, application: Application) : Screen(prevScreen, application) {
    init {
        val commandMake = Command("Создать архив") {
            application.currentScreen = CreateArchiveScreen(this, application)
        }
        val commandOpen = Command("Открыть архив") {
            application.currentScreen = ArchiveListScreen(this, application)
        }
        val commandExit = Command("Выйти из программы") {
            application.goBack()
        }
        commandList.addAll(listOf(commandMake, commandOpen, commandExit))
    }

    override fun onStartScreen() {
        println("Возможные действия: ")
    }
}