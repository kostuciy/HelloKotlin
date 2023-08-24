package homework_2_8

import java.lang.IllegalArgumentException

class User(val id: Int) {
    val noteService = NoteService(this)
    private val friendList = mutableListOf<User>()

    fun getFriendList(): List<User> = friendList

    fun getFriendById(id: Int): User {
        val friend = friendList.find {
            it.id == id
        } ?: throw UserNotFoundException(id)

        return friend
    }

    fun addFriend(user: User) {
        friendList += user
    }
}

class UserNotFoundException(
    userId: Int
) : IllegalArgumentException("No user with id $userId was found")