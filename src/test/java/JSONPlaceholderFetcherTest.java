import org.example.JSONPlaceholderFetcher;
import org.example.PostMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JSONPlaceholderFetcherTest {

    JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher();

    @Test
    void isGetSinglePostWithIndex1Equal() {

        Assertions.assertEquals("{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  }",jsonPlaceholderFetcher.getSinglePost(1));
    }

    @Test
    void isArrayEqualTo100() {
        Assertions.assertEquals(100, PostMapper.convertJsonToPostList(jsonPlaceholderFetcher.getAllPosts()).size());
    }
}
