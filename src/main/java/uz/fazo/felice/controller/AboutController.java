package uz.fazo.felice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fazo.felice.payload.AboutDto;
import uz.fazo.felice.service.AboutService;

import java.util.List;

@RestController
@RequestMapping("/api/abouts")
public class AboutController {

    private final AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping
    public ResponseEntity<List<AboutDto>> getAllAbouts() {
        List<AboutDto> abouts = aboutService.getAll();
        return ResponseEntity.ok(abouts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AboutDto> getAboutById(@PathVariable Long id) {
        AboutDto about = aboutService.getById(id);
        return ResponseEntity.ok(about);
    }

    @PostMapping
    public ResponseEntity<AboutDto> createAbout(@RequestBody AboutDto aboutDto) {
        AboutDto savedAbout = aboutService.save(aboutDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAbout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutDto> updateAbout(@PathVariable Long id, @RequestBody AboutDto aboutDto) {
        AboutDto updatedAbout = aboutService.update(id, aboutDto);
        return ResponseEntity.ok(updatedAbout);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbout(@PathVariable Long id) {
        aboutService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
