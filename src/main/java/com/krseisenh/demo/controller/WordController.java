package com.krseisenh.demo.controller;

import com.krseisenh.demo.model.User;
import com.krseisenh.demo.model.Word;
import com.krseisenh.demo.repository.UserRepository;
import com.krseisenh.demo.repository.WordRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;

@RequestMapping("api/v1/words/")
@RestController
public class WordController {
    @Autowired
    private WordRepository repository;
    private UserRepository userRepository;

    public WordController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public HashMap<String, Object> getAllWords(HttpServletRequest request) {
        String currentUserId = findUserFromRequest(request);
        HashMap<String, Object> response = generateResponse(repository.findAllByUserId(currentUserId));
        return response;
    }

    @GetMapping(path = "{id}")
    public HashMap<String, Object> getWordById(HttpServletRequest request, @PathVariable("id") ObjectId id) {
        String currentUserId = findUserFromRequest(request);
        try {
            Word lookingWord = repository.findBy_idAndUserId(id, currentUserId);
            HashMap<String, Object> response = generateResponse(lookingWord);
            return response;
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping
    public HashMap<String, Object> createWord(HttpServletRequest request, @Valid @NotNull @RequestBody Word word) {
        String currentUserId = findUserFromRequest(request);
        word.set_id(ObjectId.get());
        word.setCreatedAt(new Date());
        word.setUserId(currentUserId);
        repository.save(word);
        HashMap<String, Object> response = generateResponse(word);
        return response;
    }

    @PutMapping(path = "{id}")
    public void updateWordById(HttpServletRequest request, @PathVariable("id") ObjectId id,
            @Valid @NotNull @RequestBody Word word) {
        String currentUserId = findUserFromRequest(request);
        try {
            Word updateWord = repository.findBy_idAndUserId(id, currentUserId);
            if (updateWord != null) {
                updateWord.set_id(id);
                updateWord.setWord(word.word);
                updateWord.setDescription(word.description);
                updateWord.setQuote(word.quote);
                updateWord.setUpdatedAt(new Date());
                repository.save(updateWord);
            } else {
                return;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteWord(HttpServletRequest request, @PathVariable ObjectId id) {
        String currentUserId = findUserFromRequest(request);
        try {
            repository.delete(repository.findBy_idAndUserId(id, currentUserId));
        } catch (Exception e) {
            throw e;
        }
    }

    private HashMap<String, Object> generateResponse(Object data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", data);
        map.put("message", "OK");
        return map;
    }

    private String findUserFromRequest(HttpServletRequest request) {
        String userFromToken = request.getUserPrincipal().getName();
        try {
            User currentUser = userRepository.findByUsername(userFromToken);
            return currentUser.get_id();
        } catch (NullPointerException e) {
            throw e;
        }
    }
}