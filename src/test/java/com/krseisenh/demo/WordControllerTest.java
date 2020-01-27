package com.krseisenh.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.krseisenh.demo.model.Word;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class WordControllerTest {
    // @InjectMocks
    // WordController wordController;

    // @Mock
    // WordRepository repository;

    @Test
    public void testFindUserWords() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        // // given
        Word word1 = new Word(new ObjectId(), "Test", "Gupta", "howtodoinjava@gmail.com", "1", new Date(), null);
        List<Word> words = new ArrayList<Word>();
        words.add(word1);

        // HashMap<String, Object> map = new HashMap<>();
        // map.put("result", words);
        // map.put("message", "OK");

        // // when
        // when(wordController.getAllWords(request)).thenReturn(map);

        // HashMap<String, Object> result = wordController.getAllWords(request);

        // then
        // assertThat(result.values()[].size()).isEqualTo(2);
        //
        // assertThat(result.getEmployeeList().get(0).getFirstName())
        // .isEqualTo(employee1.getFirstName());
        //
        // assertThat(result.getEmployeeList().get(1).getFirstName())
        // .isEqualTo(employee2.getFirstName());

    }
}