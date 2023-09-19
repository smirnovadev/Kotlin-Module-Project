import data.Archive
import data.Note
import screens.MenuScreen
import screens.Screen

class Application {
    var currentScreen: Screen? = null
        set(value) {
            field = value
            currentScreen?.startScreen()
        }
    var listArchive = mutableListOf<Archive>()
    val inputHandler = InputHandler(this)
    var currentArchive: Archive? = null
    var currentNote: Note? = null

    fun start() {
        val menuScreen = MenuScreen(prevScreen = null, application = this)
        currentScreen = menuScreen
        inputHandler.getCommand()
    }

    fun goBack() {
        currentScreen = currentScreen?.prevScreen
    }

    fun isFinished(): Boolean {
        return currentScreen == null
    }

    fun finish() {
        println("Спасибо за ваши заметки. Данные будут удалены :) До свидания!")
    }
}