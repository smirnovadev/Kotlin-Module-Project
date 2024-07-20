package screens

import Application
import data.Command

class ArchiveViewScreen(prevScreen: Screen?, application: Application) :
    Screen(prevScreen, application) {
    init {
        val createNote = Command("Создать заметку") {
            val noteCreate = NoteCreateScreen(this, application)
            application.currentScreen = noteCreate
        }
        commandList.add(createNote)
        val viewNote = Command("Открыть заметку") {
            application.currentScreen = NoteListScreen(this, application)
        }
        commandList.add(viewNote)
        val closeNote = Command("Назад к выбору архива") {
            application.goBack()
        }
        commandList.add(closeNote)
    }

    override fun onStartScreen() {
        println("Выберите действие над архивом ${application.currentArchive?.name}: ")
    }
}