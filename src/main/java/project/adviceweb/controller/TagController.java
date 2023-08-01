package project.adviceweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.adviceweb.exception.TagNotFoundException;
import project.adviceweb.model.Tag;
import project.adviceweb.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        Tag createdTag = tagService.createTag(tag);
        return ResponseEntity.ok(createdTag);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
//        tagService.deleteTag(id);
//        return ResponseEntity.noContent().build();
//    }


    @GetMapping("/by-name/{name}")
    public ResponseEntity<Tag> findByName(@PathVariable String name) throws TagNotFoundException {
        Tag tag = tagService.findByName(name);
        return ResponseEntity.ok(tag);
    }
}
