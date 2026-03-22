package blogging.System.Service;

import blogging.System.Exception.ResourceNotFoundException;
import blogging.System.Model.BlogPost;
import blogging.System.Repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public BlogPost createPost(BlogPost post) {
       return postRepo.save(post);
    }
    public List<BlogPost> getAllPosts() {
        return postRepo.findAll();
    }
    public BlogPost getPostById(Long id){
        BlogPost post = postRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post With id " + id + " Not found"));
        return post;
    }

    public void updatePost(Long id, BlogPost updatedPost) {
        BlogPost post = getPostById(id);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setCategory(updatedPost.getCategory());
        post.setTags(updatedPost.getTags());
        postRepo.save(post);
    }
    public void deletePost(Long id) {
        BlogPost post = getPostById(id);
        postRepo.delete(post);
    }

}
