package com.ciamb.vcode.book.sequence;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class BookSequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public long generateSequence(String seqName) {
        var counter = mongoOperations.findAndModify(
            Query.query(Criteria.where("_id").is(seqName)),
            new Update().inc("sequences", 1),
            FindAndModifyOptions.options().returnNew(true).upsert(true),
            BookSequence.class);

            mongoOperations.findAndModify(
                Query.query(Criteria.where("_id").is(seqName)), 
                Update.update("last_entrance", LocalDateTime.now(ZoneOffset.systemDefault())),
                BookSequence.class);

            return !Objects.isNull(counter) 
            ? counter.sequences() 
            : 1;
    }

}
