package uz.fazo.felice.mapper;

import org.springframework.stereotype.Component;
import uz.fazo.felice.entity.About;
import uz.fazo.felice.payload.AboutDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AboutMapperImpl implements AboutMapper {

    @Override
    public AboutDto aboutToAboutDto(About about) {
        if (about == null) {
            return null;
        }
        AboutDto aboutDto = new AboutDto();
        aboutDto.setId(about.getId());
        aboutDto.setAbout1(about.getAbout1());
        aboutDto.setAbout2(about.getAbout2());
        return aboutDto;
    }

    @Override
    public About aboutDtoToAbout(AboutDto aboutDto) {
        if (aboutDto == null) {
            return null;
        }
        About about = new About();
        about.setId(aboutDto.getId());
        about.setAbout1(aboutDto.getAbout1());
        about.setAbout2(aboutDto.getAbout2());
        return about;
    }

    @Override
    public List<AboutDto> mapAboutsToAboutDtoList(List<About> abouts) {
        return abouts.stream()
                .map(this::aboutToAboutDto)
                .collect(Collectors.toList());
    }
}
