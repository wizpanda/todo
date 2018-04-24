package todo.user

class UserService {

    User create(Map params) {
        User user = new User([
                email: params.email,
                password: params.password
        ])

        user.save()

        return user
    }

}