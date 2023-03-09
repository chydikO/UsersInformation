package org.chudnovskiy0;

public enum Menu {
    ADD("1. Добавить нового пользователя."),
    DEL("2. Удалить существующего пользователя."),
    IS_USER_PRESENT("3. Проверить существует ли пользователь."),
    EDIT_LOGIN("4. Изменить логин существующего пользователя."),
    EDIT_PASS("5. Изменить пароль существующего пользователя."),
    PRINT_USERS("6. Печать пользователей."),
    EXIT("7. Выход.");

    public final String label;

    Menu(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
