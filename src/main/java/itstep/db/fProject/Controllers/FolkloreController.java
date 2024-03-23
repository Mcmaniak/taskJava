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
    public String home() {
        // Read the content of index.html file
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Folklore Application</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f4f4f4;\n" +
                "            margin: 0;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        h1, h2 {\n" +
                "            color: #333;\n" +
                "        }\n" +
                "        p {\n" +
                "            color: #555;\n" +
                "        }\n" +
                "        code {\n" +
                "            background-color: #f0f0f0;\n" +
                "            padding: 2px 5px;\n" +
                "            border-radius: 3px;\n" +
                "        }\n" +
                "        pre {\n" +
                "            background-color: #f0f0f0;\n" +
                "            padding: 10px;\n" +
                "            border-radius: 5px;\n" +
                "            white-space: pre-wrap;\n" +
                "        }\n" +
                "        ol {\n" +
                "            list-style-type: decimal;\n" +
                "            padding-left: 20px;\n" +
                "        }\n" +
                "        li {\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "        a {\n" +
                "            color: #007bff;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "        a:hover {\n" +
                "            text-decoration: underline;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Welcome to the Folklore Application!</h1>\n" +
                "    <p>This application allows you to manage folklore data.</p>\n" +
                "    <h2>How to Use:</h2>\n" +
                "    <ol>\n" +
                "        <li>To create a new folklore entry, send a POST request to <code>/folklores</code> with the following JSON payload:</li>\n" +
                "        <pre>\n" +
                "            {\n" +
                "                \"title\": \"Title of the folklore\",\n" +
                "                \"originCountry\": \"Country of origin\",\n" +
                "                \"description\": \"Description of the folklore\",\n" +
                "                \"story\": \"The story of the folklore\",\n" +
                "                \"characters\": [\"Character 1\", \"Character 2\", ...]\n" +
                "            }\n" +
                "        </pre>\n" +
                "        <li>To retrieve all folklore entries, send a GET request to <code>/folklores</code>.</li>\n" +
                "        <li>To retrieve a specific folklore entry, send a GET request to <code>/folklores/{id}</code> where <code>{id}</code> is the ID of the folklore entry.</li>\n" +
                "        <li>To update a folklore entry, send a PUT request to <code>/folklores/{id}</code> with the following JSON payload:</li>\n" +
                "        <pre>\n" +
                "            {\n" +
                "                \"title\": \"New title\",\n" +
                "                \"originCountry\": \"New country\",\n" +
                "                \"description\": \"New description\",\n" +
                "                \"story\": \"New story\",\n" +
                "                \"characters\": [\"New Character 1\", \"New Character 2\", ...]\n" +
                "            }\n" +
                "        </pre>\n" +
                "        <li>To delete a folklore entry, send a DELETE request to <code>/folklores/{id}</code> where <code>{id}</code> is the ID of the folklore entry.</li>\n" +
                "    </ol>\n" +
                "</body>\n" +
                "</html>"; // Read the file content here
        return htmlContent;
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
