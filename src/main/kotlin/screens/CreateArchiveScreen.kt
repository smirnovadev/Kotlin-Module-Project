package screens

import Application
import data.Archive

class CreateArchiveScreen(prevScreen: Screen?, application: Application) :
    Screen(prevScreen, application) {
    override fun onStartScreen() {
        println("Введите название архива")
        val name = application.inputHandler.getUserText()
        val archive = Archive(name)
        application.listArchive.add(archive)
        application.goBack()
    }
}