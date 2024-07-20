import java.util.Scanner

class InputHandler(val application: Application) {
    private val scanner: Scanner = Scanner(System.`in`)
    fun getUserText(): String {
        var input = scanner.nextLine()
        while (input.isBlank()) {
            println("Строка не должна оставаться пустой. Пожалуйста введите текст.")
            input = scanner.nextLine()
        }
        return input
    }

    fun getCommand() {
        while (true) {
            if (application.isFinished()) {
                application.finish()
                return
            }
            val input = scanner.nextLine()
            val limit = application.currentScreen?.getLastCommandIndex() ?: 0
            val commandIndex = validate(input, limit)
            if (commandIndex == INVALID_COMMAND_INDEX) {
                application.currentScreen?.startScreen()
                continue
            }
            application.currentScreen?.executeCommand(commandIndex)
        }
    }

    private fun validate(input: String, limit: Int): Int {
        if (input.isBlank()) {
            println("Строка не должна оставаться пустой. Пожалуйста введите номер команды")
            return INVALID_COMMAND_INDEX
        }
        val commandIndex = input.toIntOrNull()
        return when (commandIndex) {
            null -> {
                println("Пожалуйста введите номер команды цифрой")
                INVALID_COMMAND_INDEX
            }

            !in 0..limit -> {
                println("Комманды под номером $commandIndex не существует")
                INVALID_COMMAND_INDEX
            }

            else -> {
                commandIndex
            }
        }
    }

    companion object {
        const val INVALID_COMMAND_INDEX = -1
    }
}