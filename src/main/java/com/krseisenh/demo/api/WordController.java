package com.krseisenh.demo.api;

import com.krseisenh.demo.model.Word;
import com.krseisenh.demo.repositories.WordRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;

@RequestMapping("api/v1/words")
@RestController
public class WordController {
    @Autowired
    private WordRepository repository;

    @GetMapping
    public HashMap<String, Object> getAllWords() {
        HashMap<String, Object> ressponse = generateResponse(repository.findAll());
        return ressponse;
    }

    @GetMapping(path = "{id}")
    public HashMap<String, Object> getWordById(@PathVariable("id") ObjectId id) {
        HashMap<String, Object> ressponse = generateResponse(repository.findBy_id(id));
        return ressponse;
    }

    @PutMapping(path = "{id}")
    public void updateWordById(@PathVariable("id") ObjectId id, @Valid @NotNull @RequestBody Word word) {
        Word updateWord = repository.findBy_id(id);
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
    }

    @PostMapping
    public Word createWord(@Valid @RequestBody Word word) {
        word.set_id(ObjectId.get());
        word.setCreatedAt(new Date());
        repository.save(word);
        return word;
    }

    @DeleteMapping(path = "{id}")
    public void deleteWord(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

    public HashMap<String, Object> generateResponse(Object data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", data);
        map.put("message", "OK");
        return map;
    }
}