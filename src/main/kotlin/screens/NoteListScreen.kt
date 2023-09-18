package screens

import Application
import data.Command

class NoteListScreen(prevScreen: Screen?, application: Application) :
    Screen(prevScreen, application) {
    override fun onStartScreen() {
        val notes = application.currentArchive?.notes
        if (notes.isNullOrEmpty()) {
            println("Вы еще не создали ни одну заметку в этом архиве")
            application.goBack()
        } else {
            commandList.clear()
            for (note in notes) {
                val readNote = Command("Прочитать заметку: ${note.name}") {
                    application.currentNote = note
                    application.currentScreen = NoteViewScreen(this, application)
                }
                commandList.add(readNote)
            }
            val closeArchive = Command("Назад в архив") {
                application.goBack()
            }
            commandList.add(closeArchive)
        }
    }
}