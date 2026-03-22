package blogging.System.Repo;

import blogging.System.Model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository <BlogPost, Long> {
    
}
