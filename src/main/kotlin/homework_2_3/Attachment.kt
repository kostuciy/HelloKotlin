package homework_2_3

interface Attachment {
    val type: AttachmentType
    val id: Int
}

enum class AttachmentType {
    PHOTO, AUDIO,
    VIDEO, FILE,
    GIFT
}

class PhotoAttachment(
    override val id: Int,
    val photo: Photo
    ) : Attachment {
    override val type = AttachmentType.PHOTO
}

data class Photo(
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0,
    val text: String = "",
    val date: Int = 0,
    val sizes: Array<Size>? = null,
    val width: Int = 1920,
    val height: Int = 1080
)

class AudioAttachment(
    override val id: Int,
    val audio: Audio,
) : Attachment {
    override val type = AttachmentType.AUDIO
}

data class Audio(
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val genreId: Int = 0,
    val lyricsId: Int = 0,
    val artist: String = "",
    val title: String = "",
    val lyrics: String = "",
    val url: String = "",
    val date: Int = 0,
    val noSearch: Boolean = false,
    val isHq: Boolean = false
)

class VideoAttachment(
    override val id: Int,
    val video: Video
) : Attachment {
    override val type = AttachmentType.VIDEO
}

data class Video(
    val vid: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val description: String = "",
    val duration: Int = 0,
    val link: String = "",
    val image: String = "",
    val imageMedium: String = "",
    val date: Int = 0,
    val player: String = ""
)

class FileAttachment(
    override val id: Int,
    val file: File
) : Attachment {
    override val type = AttachmentType.FILE
}

data class File(
    val ownerId: Int = 0,
    val size: Int = 0,
    val ext: String = "",
    val title: String = "",
    val fileType: Int = 0,
)

class GiftAttachment(
    override val id: Int,
    val gift: Gift
) : Attachment {
    override val type = AttachmentType.GIFT
}

data class Gift(
    val thumb256: String = "",
    val thumb96: String = "",
    val thumb48: String = "",
)



