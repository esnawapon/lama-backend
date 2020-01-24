package com.krseisenh.demo.repository;

import com.krseisenh.demo.model.Word;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WordRepository extends MongoRepository<Word, String> {
    Word findBy_id(ObjectId _id);

    List<Word> findAllByUserId(String user_id);
}
