package com.studioplayground.azbackend.account.domain.model.aggregate;

public record AccountId(
        Long id
) {
    public static AccountId EMPTY = new AccountId(null);
    public static AccountId of(Long id) {
        return new AccountId(id);
    }
    public boolean isNull() {
      return id == null;
  }
}
