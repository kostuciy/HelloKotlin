package homework_2_3

data class Like(
    val count: Int = 0, // default values set for easier tests
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)
