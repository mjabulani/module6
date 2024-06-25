package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher();

        // print single post
        Post post = PostMapper.convertJSONtoPost(jsonPlaceholderFetcher.getSinglePost(1));

        System.out.println(post);
        // print all posts
        System.out.println(jsonPlaceholderFetcher.getAllPosts());

        List<Post> posts = new ArrayList<>();


        jsonPlaceholderFetcher.getAllPosts();
        // add new post

    }
}