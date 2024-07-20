package data

data class Command(val name: String, val action: () -> Unit)