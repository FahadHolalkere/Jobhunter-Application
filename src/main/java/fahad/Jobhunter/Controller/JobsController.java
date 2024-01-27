package fahad.Jobhunter.Controller;
import java.util.List;
import fahad.Jobhunter.Repository.PostRepo;
import fahad.Jobhunter.Repository.SearchRepositoryImp;
import fahad.Jobhunter.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobsController
{
    @Autowired
    PostRepo repo;
    @Autowired
    SearchRepositoryImp searchrepo;
    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getallPosts()
    {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> getPosts(@PathVariable String text)
    {
        return searchrepo.findByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post savePost(@RequestBody Post post)
    {
        return repo.save(post);
    }


}
