package account.domain.model.aggregate;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.toUnmodifiableMap;

public enum AccountRole {
    GENERAL_USER, ADMIN_USER;

    private static final Map<String, AccountRole> ROLE_MAP = Arrays.stream(values())
            .collect(toUnmodifiableMap(AccountRole::name, role -> role));

    public static AccountRole from(String role) {
        return Objects.requireNonNull(
                ROLE_MAP.get(role),
                () -> "해당하는 AccountRole 를 찾을 수 없습니다 [accountRole=" + role + "]"
        );
    }
}
