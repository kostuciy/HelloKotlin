package homework_2_8

import homework_2_3.Comment
import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun add() {
        val user = User(1)
        val note = Note()

        user.noteService.add(note)

        assertTrue(user.noteService.get().size == 1)
    }

    @Test
    fun getByIdSuccessful() {
        val user = User(1)
        val note = Note()
        val noteId = note.hashCode()

        user.noteService.add(note)

        assertEquals(
            note.copy(id = noteId),
            user.noteService.getById(noteId)

        )
    }

    @Test
    fun getByIdFailure() {
        val user = User(1)
        val note = Note()

        user.noteService.add(note)

        assertThrows(NoteNotFoundException::class.java) {
            user.noteService.getById(0)
        }
    }

    @Test
    fun createComment() {
        val user = User(1)
        val note = Note()
        val comment = Comment()

        user.noteService.add(note)

        val noteId = user.noteService.get()[0].id
        user.noteService.createComment(noteId, comment)

        val noteWithComment = user.noteService.get()[0]

        assertTrue(noteWithComment.getComments().size == 1)
    }

    @Test
    fun deleteSuccessful() {
        val user = User(1)
        val note = Note()

        user.noteService.add(note)

        val noteId = user.noteService.get()[0].id
        user.noteService.delete(noteId)

        assertTrue(user.noteService.get().isEmpty())
    }

    @Test
    fun deleteFailure() {
        val user = User(1)
        val note = Note()

        user.noteService.add(note)

        assertThrows(NoteNotFoundException::class.java) {
            user.noteService.delete(0)
        }
    }

    @Test
    fun deleteCommentSuccessful() {
        val user = User(1)
        val note = Note()
        val comment = Comment()

        user.noteService.add(note)

        val noteId = user.noteService.get()[0].id
        user.noteService.createComment(noteId, comment)
        val commentId = 0
        user.noteService.deleteComment(noteId, commentId)

        assertTrue(note.getComments().isEmpty())
    }

    @Test
    fun deleteCommentFailure() {
        val user = User(1)
        val note = Note()
        val comment = Comment()

        user.noteService.add(note)

        val noteId = user.noteService.get()[0].id
        user.noteService.createComment(noteId, comment)

        assertThrows(CommentNotFoundException::class.java) {
            user.noteService.deleteComment(noteId, 111)
        }
    }

    @Test
    fun editSuccessful() {
        val user = User(1)
        val note = Note()

        user.noteService.add(note)
        val noteId = user.noteService.get()[0].id

        user.noteService.edit(noteId, "New text")
        val editedNote = user.noteService.getById(noteId)

        assertEquals("New text", editedNote.text)
    }

    @Test
    fun editFailure() {
        val user = User(1)
        val note = Note()

        user.noteService.add(note)

        assertThrows(NoteNotFoundException::class.java) {
            user.noteService.edit(0, "New text")
        }
    }

    @Test
    fun editCommentSuccessful() {
        val user = User(1)
        val note = Note()
        val comment = Comment()

        user.noteService.add(note)

        val noteId = user.noteService.get()[0].id
        user.noteService.createComment(noteId, comment)

        val commentId = 0
        val noteWithComment = user.noteService.getById(noteId)

        user.noteService.editComment(noteId, commentId, "New comment text")

        val editedComment = noteWithComment.getCommentById(commentId)

        assertEquals("New comment text", editedComment.text)
    }

    @Test
    fun editedCommentFailure() {
        val user = User(1)
        val note = Note()
        val comment = Comment()

        user.noteService.add(note)

        val noteId = user.noteService.get()[0].id
        user.noteService.createComment(noteId, comment)

        assertThrows(NoteNotFoundException::class.java) {
            user.noteService.editComment(0, 0, "New comment text")
        }
        assertThrows(CommentNotFoundException::class.java) {
            user.noteService.editComment(noteId, 1111, "New comment text")
        }

    }

    @Test
    fun restoreComment() {
        val user = User(1)
        val note = Note()
        val comment = Comment()

        user.noteService.add(note)

        val noteId = user.noteService.get()[0].id
        val noteWithComment = user.noteService.getById(noteId)

        user.noteService.createComment(noteId, comment)
        val commentId = 0

        user.noteService.deleteComment(noteId, commentId)
        assertTrue(noteWithComment.getComments().isEmpty())

        user.noteService.restoreComment(noteId, commentId)
        assertTrue(noteWithComment.getComments().size == 1)
    }
}