package uz.fazo.felice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fazo.felice.payload.MenuDto;
import uz.fazo.felice.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public ResponseEntity<List<MenuDto>> findAllMenus() {
        List<MenuDto> menus = menuService.findAllMenus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuDto> findMenuById(@PathVariable Long id) {
        MenuDto menuDto = menuService.findById(id);
        return ResponseEntity.ok(menuDto);
    }

    @PostMapping
    public ResponseEntity<MenuDto> createMenu(@RequestBody MenuDto menuDto) {
        MenuDto savedMenu = menuService.save(menuDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMenu);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MenuDto> updateMenu(@PathVariable Long id, @RequestBody MenuDto menuDto) {
        MenuDto updatedMenu = menuService.update(id, menuDto);
        return ResponseEntity.ok(updatedMenu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
