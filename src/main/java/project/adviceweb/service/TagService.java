package project.adviceweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.adviceweb.exception.TagNotFoundException;
import project.adviceweb.model.Tag;
import project.adviceweb.repository.TagRepository;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

//    public void deleteTag(Long id) {
//        Optional<Tag> tag = tagRepository.findById(id);
//        tag.ifPresent(tagRepository::delete);
//    }

    public Tag findByName(String name) throws TagNotFoundException{
        Tag tag = tagRepository.findByName(name);
        if (tag == null)
            throw new TagNotFoundException("Tag not found",6);
        return tag;
    }

}
