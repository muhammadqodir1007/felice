package uz.fazo.felice.mapper;

import org.springframework.stereotype.Service;
import uz.fazo.felice.entity.Menu;
import uz.fazo.felice.payload.MenuDto;

@Service
public class MenuMapperImpl implements MenuMapper {

    @Override
    public MenuDto menuToMenuDto(Menu menu) {
        if (menu == null) return null;

        MenuDto menuDto = new MenuDto();
        menuDto.setId(menu.getId());
        menuDto.setName(menu.getName());
        menuDto.setPrice(menuDto.getPrice());
        menuDto.setUrl(menu.getUrl());
        return menuDto;
    }

    @Override
    public Menu menuDtoToMenu(MenuDto menuDto) {
        if (menuDto == null) return null;
        Menu menu = new Menu();
        menu.setId(menuDto.getId());
        menu.setName(menuDto.getName());
        menu.setUrl(menuDto.getUrl());
        menu.setPrice(menuDto.getPrice());
        return menu;
    }

    @Override
    public Menu updateMenuDto(Menu menu, MenuDto menuDto) {
        if (menuDto == null) return null;

        if (menuDto.getDescription() != null) {
            menu.setDescription(menuDto.getDescription());
        }
        if (menuDto.getName() != null) {
            menu.setName(menuDto.getName());
        }
        if (menuDto.getUrl() != null) {
            menu.setUrl(menuDto.getUrl());
        }
        if (menuDto.getPrice() == 0) {
            menu.setPrice(menuDto.getPrice());
        }
        return menu;

    }
}
