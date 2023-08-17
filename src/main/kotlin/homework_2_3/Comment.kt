package homework_2_3

data class Comment(
    val count: Int = 0, // default values set for easier tests
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = false,
    val canOpen: Boolean = false,
)
