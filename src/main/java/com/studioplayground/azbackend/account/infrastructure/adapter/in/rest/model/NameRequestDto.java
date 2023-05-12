package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;


import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.domain.model.Name;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PROTECTED)
public class NameRequestDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String displayName;

    public Name toName() {
        return new Name(firstName, lastName, displayName);
    }

}