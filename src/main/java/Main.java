import controller.UserController;
import model.RoleEnum;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        // rejestracja User
//        userController.addUser("mk@mk.pl","mk", RoleEnum.ROLE_USER, true, LocalDate.now(), "XXX");
        // rejestracja User1
        userController.addUser1("mk@mk.pl", "mk");
    }
}
