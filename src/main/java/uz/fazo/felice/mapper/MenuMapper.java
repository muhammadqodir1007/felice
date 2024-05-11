package uz.fazo.felice.mapper;

import org.mapstruct.Mapper;
import uz.fazo.felice.entity.Menu;
import uz.fazo.felice.payload.MenuDto;

@Mapper
public interface MenuMapper {

    MenuDto menuToMenuDto(Menu menu);

    Menu menuDtoToMenu(MenuDto menuDto);

    Menu updateMenuDto(Menu menu, MenuDto menuDto);


}
