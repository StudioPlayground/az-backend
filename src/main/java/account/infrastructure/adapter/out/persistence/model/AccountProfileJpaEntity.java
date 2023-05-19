package account.infrastructure.adapter.out.persistence.model;

import account.domain.model.aggregate.AccountProfile;
import account.domain.model.aggregate.ProfileNickName;
import account.domain.model.aggregate.Url;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Embeddable
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class AccountProfileJpaEntity {

    private String nickName;
    private String profileImageUrl;

    public static AccountProfileJpaEntity from(AccountProfile accountProfile) {
        return new AccountProfileJpaEntity(accountProfile.profileNickName().nickName(),
                accountProfile.profileUrl().url());
    }

    public AccountProfile toDomainModel() {
        return new AccountProfile(
                ProfileNickName.from(nickName),
                Url.from(profileImageUrl));
    }

}
