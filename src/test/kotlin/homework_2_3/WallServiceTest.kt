package homework_2_3

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val post = Post(comments = Comment(), copyright = Copyright(), likes = Like())
        WallService.add(post)

        assertEquals(mutableListOf(post.copy(id = post.hashCode())), WallService.getPosts())
        assertTrue(WallService.getPosts()[0].id != 0)
    }

    @Test
    fun updateSuccessful() {
        val post = Post(comments = Comment(), copyright = Copyright(), likes = Like())
        WallService.add(post)
        val updatedPost = post.copy(id = post.hashCode())

        assertTrue(WallService.update(updatedPost))
    }

    @Test
    fun updateFailure() {
        val post = Post(comments = Comment(), copyright = Copyright(), likes = Like())
        WallService.add(post)

        val nonexistentPost = post.copy(id = 333)

        assertFalse(WallService.update(nonexistentPost))
    }

    @Test
    fun createCommentSuccessful() {
        val post = Post(id = 12, comments = Comment(), copyright = Copyright(), likes = Like())
        WallService.add(post)
        val comment = Comment()

        WallService.createComment(post.hashCode(), comment)

        assertEquals(1, WallService.getComments().size)
    }

    @Test
    fun createCommentFailure() {
        val post = Post(comments = Comment(), copyright = Copyright(), likes = Like())
        WallService.add(post)
        val comment = Comment()

        assertThrows(PostNotFoundException::class.java) {
            WallService.createComment(0, comment)
        }
    }
}