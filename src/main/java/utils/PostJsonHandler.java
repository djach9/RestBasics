package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PostJsonHandler {
    public Post getPostFromFile() {
        Post post;
        try {
            post = new ObjectMapper().readValue(new File("src/main/resources/posts.json"), Post.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return post;
    }
}