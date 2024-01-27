package fahad.Jobhunter.Repository;

import com.mongodb.client.MongoClient;
import fahad.Jobhunter.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

@Component
public class SearchRepositoryImp implements SearchRepo {

    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;
    @Override
    public List<Post> findByText(String text) {

        /*
         * Requires the MongoDB Java Driver.
         * https://mongodb.github.io/mongo-java-driver
         */


        MongoDatabase database = mongoClient.getDatabase("JobHunter");
        MongoCollection<Document> collection = database.getCollection("jobs");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "jobsearch").
                                append("text", new Document("query", text)
                                        .append("path", Arrays.asList("techs", "profile", "desc")))),
                        new Document("$sort",
                        new Document("exp", -1L)),
                        new Document("$limit", 5L)));

        List<Post> ans = new ArrayList<>();

         for (Document document : result) {
             ans.add(mongoConverter.read(Post.class,document));
         }
         return ans;
    }
}
