package com.baxance.songr;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import org.springframework.util.Assert;

@SpringBootTest
@AutoConfigureMockMvc
public class SongrTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads(){
    }

    @Test
    void testHomePage() throws Exception{
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(content().string(containsString("<h1>SPLASH PAGE</h1>")))
                .andExpect(content().string(containsString("<legend>Add an Album</legend>")))
                .andExpect(status().isOk());

    }

    @Test
    public void testSomething(){
        Album test = new Album("The Bees Made Honey in the Lions Skull",
                "Earth",
                7,
                3206,
                "https://southernlord" +
                        ".com/media/2018/03/Sunn90_Earth_Bees-666x666.jpg");
        String expected = "The Bees Made Honey in the Lions Skull";
        String actual = test.getTitle();
        Assert.isTrue(expected.equals(actual), "new album from constructor");
    }
}
