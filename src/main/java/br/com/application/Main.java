package br.com.application;

import br.com.application.dto.UserDTO;
import br.com.application.service.UserService;

import java.util.Scanner;

public class Main {
    static void main() {

        UserService userService = new UserService();

        try (Scanner scanner = new Scanner(System.in)) {
            IO.print(""" 
                    Welcome!
                    input your name:
                    """);
            String name = scanner.nextLine();

            IO.println("Now your age:");
            String age = scanner.nextLine();

            UserDTO user = userService.createNewUser(name, age);

            IO.println(String.format("New user created: %s", user));
        }
    }
}
