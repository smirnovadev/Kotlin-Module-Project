package screens

import Application

class NoteViewScreen(prevScreen: Screen?, application: Application) :
    Screen(prevScreen, application) {
    override fun onStartScreen() {
        val note = application.currentNote
        if (note != null) {
            println("---------")
            println("Название заметки: ${note.name}")
            println("Текст заметки: ${note.content}")
            println("---------")
        }
        application.goBack()
    }
}