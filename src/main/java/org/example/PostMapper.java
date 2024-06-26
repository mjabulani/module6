package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;


public class PostMapper {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Post convertJSONtoPost(String postJson) {
        Post post = new Post();

        try {
            JsonNode node = MAPPER.readTree(postJson);
            post.setUserId(node.get("userId").longValue());
            post.setId(node.get("id").longValue());
            post.setTitle(node.get("title").textValue());
            post.setBody(node.get("body").textValue());

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return post;
    }

    public static List<Post> convertJsonToPostList (String postJson) {
        List<Post> postList = new ArrayList<>();
        try {
            JsonNode root = MAPPER.readTree(postJson);

            for (JsonNode singlePost : root) {
                Post post = new Post();
                post.setUserId(singlePost.get("userId").longValue());
                post.setId(singlePost.get("id").longValue());
                post.setTitle(singlePost.get("title").textValue());
                post.setBody(singlePost.get("body").textValue());
                postList.add(post);
            }
            return postList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String mapPostToJson(Post post) {

        try {
            return MAPPER.writeValueAsString(post);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
