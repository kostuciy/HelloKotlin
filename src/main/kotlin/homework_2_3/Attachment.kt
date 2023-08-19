package homework_2_3

sealed class Attachment {
    abstract val type: AttachmentType
    abstract val id: Int
}

enum class AttachmentType {
    PHOTO, AUDIO,
    VIDEO, FILE,
    GIFT
}

class PhotoAttachment(
    override val id: Int,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0,
    val text: String = "",
    val date: Int = 0,
    val sizes: Array<Size>? = null,
    val width: Int = 1920,
    val height: Int = 1080
    ) : Attachment() {
    override val type = AttachmentType.PHOTO
}

class AudioAttachment(
    override val id: Int,
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
) : Attachment() {
    override val type = AttachmentType.AUDIO
}

class VideoAttachment(
    override val id: Int,
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
) : Attachment() {
    override val type = AttachmentType.VIDEO
}

class FileAttachment(
    override val id: Int,
    val ownerId: Int = 0,
    val size: Int = 0,
    val ext: String = "",
    val title: String = "",
    val fileType: Int = 0,
) : Attachment() {
    override val type = AttachmentType.FILE
}

class GiftAttachment(
    override val id: Int,
    val thumb256: String = "",
    val thumb96: String = "",
    val thumb48: String = "",
) : Attachment() {
    override val type = AttachmentType.GIFT
}



