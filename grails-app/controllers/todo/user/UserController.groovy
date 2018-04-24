package todo.user

import grails.gorm.transactions.Transactional

@Transactional
class UserController {

    static responseFormats = ['json']

    static allowedMethods = [signup: "POST"]

    UserService userService

    def signup() {
        User user = userService.create(params)

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
