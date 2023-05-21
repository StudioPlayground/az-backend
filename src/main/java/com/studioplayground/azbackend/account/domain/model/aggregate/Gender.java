package com.studioplayground.azbackend.account.domain.model.aggregate;

import static java.util.stream.Collectors.toUnmodifiableMap;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public enum Gender {
    MALE,
    FEMALE,
    NON_BINARY;

    private static final Map<String, Gender> GENDER_MAP =
            Arrays.stream(values()).collect(toUnmodifiableMap(Gender::name, gender -> gender));

    public static Gender from(String gender) {
        return Objects.requireNonNull(
                GENDER_MAP.get(gender), () -> "해당하는 Gender 를 찾을 수 없습니다 [gender=" + gender + "]");
    }
}
