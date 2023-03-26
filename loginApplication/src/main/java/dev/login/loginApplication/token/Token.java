package dev.login.loginApplication.token;

import dev.login.loginApplication.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {

        @Id
        public ObjectId id;

        public String token;

        public TokenType tokenType = TokenType.BEARER;

        public boolean revoked;

        public boolean expired;

        public User user;
}
