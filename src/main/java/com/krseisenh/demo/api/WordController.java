package com.krseisenh.demo.api;

import com.krseisenh.demo.model.Word;
import com.krseisenh.demo.repositories.WordRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

@RequestMapping("api/v1/words")
@RestController
public class WordController {
    @Autowired
    private WordRepository repository;

    @GetMapping
    public HashMap<String, Object> getAllWord() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", repository.findAll());
        map.put("message", "OK");
        return map;
    }

    @GetMapping(path = "{id}")
    public HashMap<String, Object> getWordById(@PathVariable("id") ObjectId id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", repository.findBy_id(id));
        map.put("message", "OK");
        return map;
    }

    @PutMapping(path = "{id}")
    public void updateWordById(@PathVariable("id") ObjectId id, @Valid @NotNull @RequestBody Word word) {
        word.set_id(id);
        repository.save(word);
    }

    @PostMapping
    public Word createWord(@Valid @RequestBody Word word) {
        word.set_id(ObjectId.get());
        repository.save(word);
        return word;
    }

    @DeleteMapping(path = "{id}")
    public void deleteWord(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}