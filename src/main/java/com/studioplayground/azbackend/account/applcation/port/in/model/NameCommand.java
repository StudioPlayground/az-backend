package com.studioplayground.azbackend.account.applcation.port.in.model;

import com.studioplayground.azbackend.account.domain.model.Name;

public record NameCommand(
    String firstName,
    String lastName,
    String displayName
) {

    public Name toDomainModel() {
        return new Name(firstName, lastName, displayName);
    }
}
