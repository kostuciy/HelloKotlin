package homework_2_8

import homework_2_3.Attachment
import homework_2_3.Comment
import java.lang.IllegalArgumentException

data class Note(
    val id: Int = 0,
    val text: String = "",
    private val attachments: MutableList<Attachment> = mutableListOf(),
    private val comments: MutableList<Comment> = mutableListOf()
) {
    private val archivedComments: MutableList<Comment> = mutableListOf()
    private var commentIdCount = 0

    fun getComments(): List<Comment> = comments

    fun getCommentById(commentId: Int): Comment {
        val comment = comments.find { it.id == commentId }
            ?: throw CommentNotFoundException(commentId)

        return comment
    }

    fun addComment(comment: Comment) {
        comments += comment.copy(id = commentIdCount++)
    }

    fun removeComment(comment: Comment) {
        if (!comments.remove(comment))
            throw CommentNotFoundException(comment.id)

        archivedComments += comment
    }

    fun restoreComment(commentId: Int) {
        val comment = archivedComments.find {
            it.id == commentId
        } ?: throw CommentNotFoundException(commentId)

        archivedComments.remove(comment)
        comments += comment
    }

    fun clearArchivedComments() {
        archivedComments.clear()
    }

    fun editComment(commentId: Int, newText: String) {
        val comment = getCommentById(commentId)
        removeComment(comment)

        comments += comment.copy(text = newText)
    }
}

class CommentNotFoundException(
    commentId: Int
) : IllegalArgumentException("No comment with id $commentId found")