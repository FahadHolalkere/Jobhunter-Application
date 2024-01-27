package fahad.Jobhunter.Repository;

import fahad.Jobhunter.models.Post;

import java.util.List;

public interface SearchRepo {
    List<Post> findByText(String text);
}
