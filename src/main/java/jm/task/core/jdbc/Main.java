package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Donatello", "Ninja", (byte) 20);
        userService.saveUser("Rafael", "Turtle", (byte) 21);
        userService.saveUser("Michelangelo", "Turtle-Ninja", (byte) 19);
        userService.saveUser("Sub-Zero", "fromMortalCombat", (byte) 22);
//
//        userService.removeUserById(2);
//
//        userService.getAllUsers();
//
//        userService.dropUsersTable();
    }
}
