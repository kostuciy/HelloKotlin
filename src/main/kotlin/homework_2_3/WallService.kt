package homework_2_3

import java.lang.RuntimeException

object WallService {
    private val postList = mutableListOf<Post>()
    private var comments = mutableListOf<Comment>()

    fun getPosts(): List<Post> = postList

    fun getComments(): List<Comment> = comments

    private fun getPostIndex(id: Int): Int {
        val index = postList.withIndex().find {
            it.value.id == id
        }?.index
            ?: throw PostNotFoundException()

        return index
    }

    private fun getPost(id: Int): Post {
        val post = postList.find {
            it.id == id
        }
            ?: throw PostNotFoundException()

        return post
    }

    fun add(post: Post): Post {
        val id = getId(post)
        val newPost = post.copy(id = id)
        postList += newPost

        return newPost
    }

    fun update(updatedPost: Post): Boolean {
        val post = postList.find { it.id == updatedPost.id }
        val postIndex = postList.indexOf(post)

        return if (post != null) {
            postList[postIndex] = updatedPost
            true
        } else false
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        val postIndex = getPostIndex(postId)
        val post = postList[postIndex]

        postList[postIndex] = post.copy(comments = comment)
        comments += comment

        return comment
    }

    fun clear() {
        postList.clear()
    }

    private fun getId(post: Post): Int {
        var id: Int = post.hashCode()

        var isNotUnique = true
        while (isNotUnique) {
            if (postList.none { it.hashCode() == id }) {
                isNotUnique = false
            } else id += (1..10).random()
        }

        return id
    }
}

class PostNotFoundException(
    override val message: String = "No such post found."
) : RuntimeException(message)
