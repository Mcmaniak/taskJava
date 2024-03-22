package itstep.db.fProject.Services;

import itstep.db.fProject.Entities.Folklore;
import itstep.db.fProject.Repositories.FolkloreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class FolkloreService {

    @Autowired
    private FolkloreRepo folkloreRepo;

    public Folklore createFolklore(Folklore folklore){
        return folkloreRepo.save(folklore);

    }

    public Folklore getFolkloreById(Long id){
        return folkloreRepo.findById(id).orElse(null);
    }

    public List<Folklore> getAllFolklore(){
        return folkloreRepo.findAll();
    }

    public Folklore updateFolklore(Long id, Folklore updatedFolklore) {
        Folklore existingFolklore = folkloreRepo.findById(id).orElse(null);

        if (existingFolklore != null) {
            // Update only the specified fields with non-null values
            if (updatedFolklore.getTag() != null) {
                existingFolklore.setTag(updatedFolklore.getTag());
            }

            if (updatedFolklore.getTitle() != null) {
                existingFolklore.setTitle(updatedFolklore.getTitle());
            }

            if (updatedFolklore.getOriginCountry() != null) {
                existingFolklore.setOriginCountry(updatedFolklore.getOriginCountry());
            }

            if (updatedFolklore.getDescription() != null) {
                existingFolklore.setDescription(updatedFolklore.getDescription());
            }

            if (updatedFolklore.getStory() != null) {
                existingFolklore.setStory(updatedFolklore.getStory());
            }

            if (updatedFolklore.getCharacters() != null) {
                existingFolklore.setCharacters(updatedFolklore.getCharacters());
            }

            // Add similar checks for other fields as needed

            return folkloreRepo.save(existingFolklore);
        }

        return null; // or throw an exception if folklore with given id is not found
    }


    public void deleteFolklore(Long id) {
        folkloreRepo.deleteById(id);
    }
}
