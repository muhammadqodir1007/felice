package uz.fazo.felice.mapper;

import org.mapstruct.Mapper;
import uz.fazo.felice.entity.About;
import uz.fazo.felice.payload.AboutDto;

import java.util.List;

@Mapper
public interface AboutMapper {



    AboutDto aboutToAboutDto(About about);
    About aboutDtoToAbout(AboutDto aboutDto);

    List<AboutDto> mapAboutsToAboutDtoList(List<About> abouts);
}
