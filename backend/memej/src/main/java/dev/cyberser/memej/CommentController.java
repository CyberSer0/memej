package dev.cyberser.memej;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/comment")
public class CommentController {
    
    @Autowired
    private CommentRepository commentRepository;

    // COMMENTS ENDPOINTS
    @GetMapping("/all")
    public List<Comment> getMemes() {
        return commentRepository.findAll();
    }

    // COMMENT ENDPOINTS
    @GetMapping("/get/{id}")
    public Comment getTagById(@PathVariable Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
    }

    @PostMapping("/post")
    public Comment createComment(@Valid @RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping("/put/{id}")
    public Comment updateComment(@PathVariable Long id, @Valid @RequestBody Comment commentDetails) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
        comment.setAuthor(commentDetails.getAuthor());
        comment.setComments(comment.getComments());
        comment.setContent(comment.getContent());
        Comment updatedComment = commentRepository.save(comment);
        return updatedComment;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
        commentRepository.delete(comment);
        return ResponseEntity.ok().build();
    }
}
