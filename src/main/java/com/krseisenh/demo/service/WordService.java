package com.krseisenh.demo.service;

import java.util.List;

import com.krseisenh.demo.model.Word;
import com.krseisenh.demo.repository.WordRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    @Autowired
    private WordRepository wordRepository;

    public List<Word> getWords(String userId) {
        return wordRepository.findAllByUserId(userId);
    }

    public Word getWord(ObjectId _id, String userId) {
        return wordRepository.findBy_idAndUserId(_id, userId);
    }
}