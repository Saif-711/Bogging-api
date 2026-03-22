package blogging.System.Controller;


import blogging.System.Model.BlogPost;
import blogging.System.Repo.PostRepo;
import blogging.System.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepo postRepo;
    @GetMapping
    public ResponseEntity<List<BlogPost>> getPosts() {
        return new ResponseEntity<>(
                postService.getAllPosts(), HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getPost(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost post) {
        return new ResponseEntity<>(postService.createPost(post),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updatePost(@PathVariable Long id, @RequestBody BlogPost post) {
     postService.updatePost(id, post);
        return new ResponseEntity<>(
            postService.getPostById(id), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        Optional<BlogPost> optionalPost = postRepo.findById(id); // returns Optional

        if (optionalPost.isEmpty()) {
            return new ResponseEntity<>("Post ID not found", HttpStatus.NOT_FOUND);
        }

        postRepo.delete(optionalPost.get());
        return new ResponseEntity<>(optionalPost.get(), HttpStatus.OK);
    }

}
