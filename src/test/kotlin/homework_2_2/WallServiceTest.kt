package homework_2_2

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

        assertEquals(mutableListOf(post), WallService.getPosts())
        assertTrue(post.id != 0)
    }

    @Test
    fun updateSuccessful() {
        val post = Post(comments = Comment(), copyright = Copyright(), likes = Like())
        WallService.add(post)

        assertTrue(WallService.update(post))
    }

    @Test
    fun updateFailure() {
        val post = Post(comments = Comment(), copyright = Copyright(), likes = Like())
        WallService.add(post)

        val nonexistentPost = Post(comments = Comment(), copyright = Copyright(), likes = Like())
        nonexistentPost.id = 333

        assertFalse(WallService.update(nonexistentPost))
    }
}