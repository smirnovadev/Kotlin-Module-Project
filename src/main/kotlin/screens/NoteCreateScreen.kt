package screens

import Application
import data.Note

class NoteCreateScreen(prevScreen: Screen?, application: Application) :
    Screen(prevScreen, application) {
    override fun onStartScreen() {
        println("Введите название заметки")

        val name = application.inputHandler.getUserText()
        println("Введите текст заметки")
        val content = application.inputHandler.getUserText()
        val note = Note(name, content)
        val archive = application.currentArchive
        archive?.addNote(note)
        println("Заметка '$name' была успешно добавлена в архив ${application.currentArchive?.name}")
        application.goBack()
    }
}