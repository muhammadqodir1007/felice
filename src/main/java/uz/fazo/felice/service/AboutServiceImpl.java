package uz.fazo.felice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.fazo.felice.entity.About;
import uz.fazo.felice.mapper.AboutMapper;
import uz.fazo.felice.payload.AboutDto;
import uz.fazo.felice.repository.AboutRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;
    private final AboutMapper aboutMapper;

    @Override
    public List<AboutDto> getAll() {
        List<About> allAbouts = aboutRepository.findAll();
        return aboutMapper.mapAboutsToAboutDtoList(allAbouts);
    }

    @Override
    public AboutDto getById(Long id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("About not found with id: " + id));
        return aboutMapper.aboutToAboutDto(about);
    }

    @Override
    public AboutDto save(AboutDto aboutDto) {
        About about = aboutMapper.aboutDtoToAbout(aboutDto);
        About savedAbout = aboutRepository.save(about);
        return aboutMapper.aboutToAboutDto(savedAbout);
    }

    @Override
    public AboutDto update(Long id, AboutDto aboutDto) {
        About existingAbout = aboutRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("About not found with id: " + id));

        About updatedAbout = aboutMapper.aboutDtoToAbout(aboutDto);
        existingAbout.setAbout1(updatedAbout.getAbout1());
        existingAbout.setAbout2(updatedAbout.getAbout2());

        About savedAbout = aboutRepository.save(existingAbout);
        return aboutMapper.aboutToAboutDto(savedAbout);
    }

    @Override
    public void delete(Long id) {
        aboutRepository.deleteById(id);
    }

}
