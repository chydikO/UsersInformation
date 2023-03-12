package org.chudnovskiy0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        while (start() != 7) ;
    }

    private static int start() {
        final Menu[] menu = Menu.values();
        int option = 1;
        do {
            for (Menu value : menu) {
                System.out.println(value.label);
            }
            try {
                option = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (option) {
                    case 1 -> addUser();
                    case 2 -> deleteUser();
                    case 3 -> isUserPresent();
                    case 4 -> editLogin();
                    case 5 -> editPassword();
                    case 6 -> printUsers();
                    case 7 -> exit();
                }
            } catch (Exception ex) {
                System.out.println("Пожалуйста сделайте свой выбор от 1 до " + menu.length);
                scanner.next();
            }
        } while (option > menu.length || option < 1);
        return option;
    }

    private static void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void exit() {
        System.out.println("-= Выход =-");
    }

    private static void editPassword() {
        System.out.println("-= редактирование пароля пользователя =-");
        String userLogin = getLogin();
        int index;
        if ((index = findUserReturnIndex(userLogin)) >= 0) {
            users.get(index).setPassword(getPassword());
        } else {
            System.out.println("Нет такого пользователя.");
        }
    }

    private static void editLogin() {
        System.out.println("-= редактирование пользователя =-");
        String userLogin = getLogin();
        int index;
        if ((index = findUserReturnIndex(userLogin)) >= 0) {
            users.get(index).setLogin(getLogin());
        } else {
            System.out.println("Нет такого пользователя.");
        }
    }

    private static User findUser(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    private static int findUserReturnIndex(String login) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                return i;
            }
        }
        return -1;
    }

    private static void deleteUser() {
        System.out.println("-= Удаление существующего пользователя =-");
        String userLogin = getLogin();
        int index;
        if ((index = findUserReturnIndex(userLogin)) >= 0) {
            users.remove(index);
        } else {
            System.out.println("Нет такого пользователя.");
        }
    }

    private static void addUser() {
        String login = getLogin();
        String password = getPassword();
        if (!login.isBlank() && password != null) {
            User user = new User(login, password);
            users.add(user);
        } else {
            System.out.println("Пароль не совпадает, повторите ввод нового пользователя...");
        }
    }

    private static String getLogin() {
        System.out.print("Введите логин пользователя:\t");
        return scanner.nextLine();
    }

    private static String getPassword() {
        System.out.println("Введите пароль:\t");
        String password = scanner.nextLine();

        System.out.println("Введите пароль еще раз:\t");
        String password2 = scanner.nextLine();

        if (!password.equals(password2)) {
            return null;
        }
        return password;
    }

    private static void isUserPresent() {
        System.out.println("-= Проверка существующего пользователя =-");
        String login = getLogin();
        if (findUser(login) != null) {
            System.out.println("Пользователь существует");
        } else {
            System.out.println("Пользователь НЕ существует");
        }
    }
}