package uz.fazo.felice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.fazo.felice.entity.Menu;
import uz.fazo.felice.mapper.MenuMapper;
import uz.fazo.felice.payload.MenuDto;
import uz.fazo.felice.repository.MenuRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
    MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Override
    public List<MenuDto> findAllMenus() {
        return menuRepository.findAll().stream().map(menuMapper::menuToMenuDto).collect(Collectors.toList());
    }

    @Override
    public MenuDto findById(Long id) {
        return menuMapper.menuToMenuDto(menuRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    @Override
    public MenuDto save(MenuDto menuDto) {
        return menuMapper.menuToMenuDto(menuRepository.save(menuMapper.menuDtoToMenu(menuDto)));
    }

    @Override
    public void deleteById(Long id) {
        menuRepository.deleteById(id);

    }

    @Override
    public MenuDto update(Long id, MenuDto menuDto) {
        Menu menu = menuRepository.findById(id).orElseThrow(NullPointerException::new);
        Menu menu1 = menuMapper.updateMenuDto(menu, menuDto);
        return menuMapper.menuToMenuDto(menu1);

    }
}
