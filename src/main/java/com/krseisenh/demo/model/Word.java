package com.krseisenh.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Word {
    @Id
    public ObjectId _id;
    @NotBlank
    public String word;
    public String quote;
    public String description;
    public String user_id;
    public Date createdAt;
    public Date updatedAt;

    public Word(ObjectId _id, String word, String quote, String description, String user_id, Date createdAt,
            Date updatedAt) {
        this._id = _id;
        this.word = word;
        this.quote = quote;
        this.description = description;
        this.user_id = user_id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getUserId() {
        return user_id;
    }
}
