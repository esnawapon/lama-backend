package com.krseisenh.demo.repositories;

import com.krseisenh.demo.model.Word;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WordRepository extends MongoRepository<Word, String> {
    Word findBy_id(ObjectId _id);
}
