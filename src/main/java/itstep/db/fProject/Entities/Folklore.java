package itstep.db.fProject.Entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Folklore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable
    private String title;

    @Nullable
    private String originCountry;
    private String description;
    private String story;

    //tag - myth or legend
    private String tag;

    @Getter
    @ElementCollection
    private Set<String> characters = new HashSet<>();

    public Folklore(){

    }

    public Folklore(String title, String originCountry, String description, String story, String tag, Set<String> characters){
        this.title = title;
        this.originCountry = originCountry;
        this.description = description;
        this.story = story;
        this.tag = tag;
        this.characters = characters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(@Nullable String originCountry) {
        this.originCountry = originCountry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setCharacters(Set<String> characters) {
        this.characters.clear(); // Clear existing characters
        if (characters != null) {
            this.characters.addAll(characters); // Add new characters
        }
    }

}
