package todo.user

class User {

    static constraints = {
        // In-built constraint to validate if email is correct and it should not be empty
        email(email: true, blank: false)
        // In built constraint to validate the password size shouldn't be more than 100 characters
        password(blank: false, maxSize: 100)
    }

    String email
    String password
}
