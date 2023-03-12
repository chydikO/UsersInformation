package org.chudnovskiy0;

import lombok.*;

@RequiredArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class User {
    private final String login;
    private final String password;
}
