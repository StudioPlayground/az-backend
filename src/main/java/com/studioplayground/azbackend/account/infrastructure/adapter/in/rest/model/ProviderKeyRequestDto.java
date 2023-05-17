package com.studioplayground.azbackend.account.infrastructure.adapter.in.rest.model;

import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.applcation.port.in.model.ProviderKeyCommand;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PROTECTED)
public class ProviderKeyRequestDto {

    @Pattern(regexp = "GOOGLE")
    private String type;

    @NotNull
    private String id;

    public ProviderKeyCommand toCommand() {
        return new ProviderKeyCommand(type, id);
    }
}
