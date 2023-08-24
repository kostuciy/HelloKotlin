package homework_2_8

import homework_2_3.Comment
import java.lang.IllegalArgumentException

class NoteService(
    private val context: User
) {
    private val noteList = mutableListOf<Note>()

    fun get(): List<Note> = noteList

    fun add(note: Note) {
        noteList += getNoteWithId(note)
    }

    fun getById(noteId: Int): Note {
        val note = noteList.find { it.id == noteId }
            ?: throw NoteNotFoundException(noteId)

        return note
    }

    fun getIndexById(noteId: Int): Int {
        val index = noteList.withIndex().find {
            it.value.id == noteId
        }?.index ?: throw NoteNotFoundException(noteId)

        return index
    }

    fun createComment(noteId: Int, comment: Comment) {
        val note = getById(noteId)
        note.addComment(comment)
    }

    fun delete(noteId: Int) {
        val noteIndex = getIndexById(noteId)

        noteList.removeAt(noteIndex)
    }

    fun deleteComment(noteId: Int, commentId: Int) {
        val note = getById(noteId)
        val comment = note.getCommentById(commentId)

        note.removeComment(comment)
    }

    fun edit(noteId: Int, newText: String) {
        val editedNote = getById(noteId).copy(text = newText)
        delete(noteId)

        noteList += editedNote
    }


    fun editComment(noteId: Int, commentId: Int, newText: String) {
        val note = getById(noteId)
        note.editComment(commentId, newText)
    }




    fun getComments(noteId: Int): List<Comment> {
        val note = getById(noteId)

        return note.getComments()
    }

    fun getFriendsNotes(friendId: Int): List<Note> {
        val friend = context.getFriendById(friendId)

        return friend.noteService.get()
    }

    fun restoreComment(noteId: Int, deletedCommentId: Int) {
        val note = getById(noteId)

        note.restoreComment(deletedCommentId)
    }

    private fun getNoteWithId(note: Note): Note {
        var id: Int = note.hashCode()

        var isNotUnique = true
        while (isNotUnique) {
            if (noteList.none { it.hashCode() == id }) {
                isNotUnique = false
            } else id += (1..10).random()
        }

        return note.copy(id = id)
    }
}

class NoteNotFoundException(
    id: Int,
) : IllegalArgumentException("Note with id $id not found.")