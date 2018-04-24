package todo.user

import grails.gorm.transactions.Transactional

@Transactional
class UserController {

    static responseFormats = ['json']

    static allowedMethods = [signup: "POST"]

    def signup(String email, String password) {
        User user = new User([
                email: email,
                password: password
        ])

        // or directly write
        //User user = new User(params)

        user.save()
        if (user.hasErrors()) {
            respond([success: false, error: user.errors])
            return
        }

        respond([success: true, id: user.id])
    }

    def list() {
        List<User> userList = User.createCriteria().list {
            eq("enabled", true)
            gt("created", new Date("2018/01/01"))
        }

        respond(userList)
    }
}
