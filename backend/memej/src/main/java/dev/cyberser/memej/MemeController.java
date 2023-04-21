package dev.cyberser.memej;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/meme")
public class MemeController {
    
    @Autowired
    private MemeRepository memeRepository;

    // MEMES ENDPOINTS
    @GetMapping("/all")
    public List<Meme> getMemes() {
        return memeRepository.findAll();
    }

    // MEME ENDPOINTS
    @GetMapping("/get/{id}")
    public Meme getMemeById(@PathVariable Long id) {
        return memeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meme", "id", id));
    }

    @PostMapping("/post")
    public Meme createMeme(@Valid @RequestBody Meme meme) {
        return memeRepository.save(meme);
    }

    @PutMapping("/put/{id}")
    public Meme updateMeme(@PathVariable Long id, @Valid @RequestBody Meme memeDetails) {
        Meme meme = memeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meme", "id", id));
        meme.setTitle(memeDetails.getTitle());
        meme.setUrl(memeDetails.getUrl());
        Meme updatedMeme = memeRepository.save(meme);
        return updatedMeme;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMeme(@PathVariable Long id) {
        Meme meme = memeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meme", "id", id));
        memeRepository.delete(meme);
        return ResponseEntity.ok().build();
    }
    
}
