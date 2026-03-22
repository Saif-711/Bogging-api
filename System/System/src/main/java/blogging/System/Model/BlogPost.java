package blogging.System.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "blogs")
public class BlogPost {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title shouldn't be Empty")
    private String title;
    @NotBlank(message = "Content shouldn't be Empty")
    private String content;

    @NotBlank(message = "Category shouldn't be Empty")
    private String category;
    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt=LocalDateTime.now();
    private LocalDateTime updatedAt=LocalDateTime.now();
    @ElementCollection
    private List<String>tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Category shouldn't be Empty") String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank(message = "Category shouldn't be Empty") String category) {
        this.category = category;
    }

    public @NotNull(message = "createdAt is required") LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(@NotNull(message = "createdAt is required") LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public @NotBlank(message = "Title shouldn't be Empty") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title shouldn't be Empty") String title) {
        this.title = title;
    }

    public @NotBlank(message = "Content shouldn't be Empty") String getContent() {
        return content;
    }

    public void setContent(@NotBlank(message = "Content shouldn't be Empty") String content) {
        this.content = content;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
