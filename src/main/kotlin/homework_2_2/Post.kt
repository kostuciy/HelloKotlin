package homework_2_2

import java.util.*

data class Post(
    val ownerId: Int = 0, // default values set for easier tests
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyOwnerId: Int = -1,
    val replyPostId: Int = -1,
    val friendsOnly: Boolean = false,
    var comments: Comment,
    val copyright: Copyright,
    val likes: Like
) {
    var id = 0
}