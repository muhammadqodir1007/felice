package uz.fazo.felice.service;

import uz.fazo.felice.payload.MenuDto;

import java.util.List;

public interface MenuService {

    List<MenuDto> findAllMenus();

    MenuDto findById(Long id);

    MenuDto save(MenuDto menuDto);

    void deleteById(Long id);

    MenuDto update(Long id, MenuDto menuDto);

}
