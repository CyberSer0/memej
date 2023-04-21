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
@RequestMapping("/tag")
public class TagController {
    
    @Autowired
    private TagRepository tagRepository;

    // TAGS ENDPOINTS
    @GetMapping("/all")
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    // TAG ENDPOINTS
    @GetMapping("/get/{id}")
    public Tag getTagById(@PathVariable Long id)
    {
        return tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));
    }

    @PostMapping("/post")
    public Tag createTag(@Valid @RequestBody Tag tag) {
        return tagRepository.save(tag);
    }

    @PutMapping("/put/{id}")
    public Tag updateTag(@PathVariable Long id, @Valid @RequestBody Tag tagDetails) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));
        tag.setName(tagDetails.getName());
        Tag updatedTag = tagRepository.save(tag);
        return updatedTag;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Long id) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));
        tagRepository.delete(tag);
        return ResponseEntity.ok().build();
    }
}
