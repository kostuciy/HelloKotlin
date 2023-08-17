package homework_2_3

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0, // default values set for easier tests
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyOwnerId: Int = -1,
    val replyPostId: Int = -1,
    val friendsOnly: Boolean = false,
    var comments: Comment? = null,
    val copyright: Copyright? = null,
    val likes: Like? = null,
    val reposts: Reposts? = null,
    val views: Views? = null,
    val postType: String = "",
    val postSource: PostSource? = null,
//    val attachments: Attachment,
    val geo: Geo? = null,
    val signerId: Int = 0,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavourite: Boolean = false,
    val donut: Donut? = null,
    val postPonedId: Int = 0

)