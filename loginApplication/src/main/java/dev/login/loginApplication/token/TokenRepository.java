package dev.login.loginApplication.token;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;
public interface TokenRepository extends MongoRepository<Token, ObjectId>{
    @Query("db.Token.find({\n" +
            "        $and: [\n" +
            "        {\"user.id\": ObjectId(\"user_id\")},\n" +
            "        {$or: [\n" +
            "        {expired: {$ne: true}},\n" +
            "        {revoked: {$ne: true}}\n" +
            "        ]}\n" +
            "        ]\n" +
            "        })")
        List<Token> findAllValidTokenByUser(ObjectId id);
        Optional<Token> findByToken(String token);

}
