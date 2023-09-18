package screens

import Application
import data.Command

class ArchiveListScreen(prevScreen: Screen?, application: Application) :
    Screen(prevScreen, application) {
    override fun onStartScreen() {
        if (application.listArchive.isEmpty()) {
            println("Вы еще не создали ни одного архива")
            application.goBack()
        } else {
            commandList.clear()
            for (archive in application.listArchive) {
                val openArhive = Command("Открыть архив: ${archive.name}") {
                    application.currentArchive = archive
                    application.currentScreen = ArchiveViewScreen(this, application)

                }
                commandList.add(openArhive)
            }
            val closeArchive = Command("Назад в меню") {
                application.goBack()
            }
            commandList.add(closeArchive)
        }
    }
}