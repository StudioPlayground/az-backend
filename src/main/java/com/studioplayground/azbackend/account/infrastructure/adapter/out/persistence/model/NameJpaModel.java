package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.domain.model.Name;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
public class NameJpaModel {

    private String firstName;
    private String lastName;
    private String displayName;

    public static NameJpaModel from(Name name) {
        return new NameJpaModel(name.firstName(), name.lastName(), name.displayName());
    }

    public Name toDomainModel() {
        return new Name(firstName, lastName, displayName);
    }
}
