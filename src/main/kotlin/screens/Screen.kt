package screens

import Application
import data.Command

abstract class Screen(val prevScreen: Screen?, val application: Application) {
    protected val commandList = mutableListOf<Command>()

    fun startScreen() {
        onStartScreen()
        commandList.forEachIndexed { index, command ->
            println("[$index] - ${command.name}")
        }
    }

    abstract fun onStartScreen()

    fun getLastCommandIndex(): Int {
        return commandList.lastIndex
    }

    fun executeCommand(index: Int) {
        val command = commandList[index]
        command.action.invoke()
    }
}