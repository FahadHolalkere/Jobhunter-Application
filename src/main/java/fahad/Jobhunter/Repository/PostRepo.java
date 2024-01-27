package fahad.Jobhunter.Repository;

import fahad.Jobhunter.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post, String>
{

}
