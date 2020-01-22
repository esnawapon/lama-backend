package com.krseisenh.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

public class Word {
    @Id
    public ObjectId _id;
    @NotBlank
    public String word;
    public String quote;
    public String description;

    public Word(ObjectId _id, String word, String quote, String description) {
        this._id = _id;
        this.word = word;
        this.quote = quote;
        this.description = description;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
