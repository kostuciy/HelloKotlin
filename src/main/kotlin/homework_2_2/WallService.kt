package homework_2_2

object WallService {
    private val postList = mutableListOf<Post>()

    fun getPosts(): List<Post> = postList

    fun add(post: Post): Post {
        giveId(post)
        postList += post

        return post
    }

    fun update(updatedPost: Post): Boolean {
        val post = postList.find { it.id == updatedPost.id }
        val postIndex = postList.indexOf(post)

        return if (post != null) {
            postList[postIndex] = updatedPost
            true
        } else false
    }

    fun clear() {
        postList.clear()
    }

    private fun giveId(post: Post) {
        var id: Int = post.hashCode()

        var isNotUnique = true
        while (isNotUnique) {
            if (postList.none { it.hashCode() == id }) {
                isNotUnique = false
            } else id += (1..10).random()
        }

        post.id = id
    }
}