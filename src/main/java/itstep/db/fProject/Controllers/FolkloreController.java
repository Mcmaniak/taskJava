package itstep.db.fProject.Controllers;

import itstep.db.fProject.Entities.Folklore;
import itstep.db.fProject.Services.FolkloreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folklores")
public class FolkloreController {
    @Autowired
    private FolkloreService folkloreService;

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @PostMapping
    public ResponseEntity<Folklore> createFolklore(@RequestBody Folklore folklore) {
        try {
            Folklore createdFolklore = folkloreService.createFolklore(folklore);
            return new ResponseEntity<>(createdFolklore, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception for debugging purposes
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Folklore> getFolkloreById(@PathVariable Long id){
        Folklore folklore = folkloreService.getFolkloreById(id);
        return new ResponseEntity<>(folklore, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Folklore>> getAllFolklore(){
        List<Folklore> folklores = folkloreService.getAllFolklore();
        return new ResponseEntity<>(folklores, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Folklore> updateFolklore(@PathVariable Long id, @RequestBody Folklore updatedFolklore) {
        Folklore updated = folkloreService.updateFolklore(id, updatedFolklore);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFolklore(@PathVariable Long id){
        folkloreService.deleteFolklore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
