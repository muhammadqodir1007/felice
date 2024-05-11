package uz.fazo.felice.service;

import uz.fazo.felice.payload.AboutDto;

import java.util.List;

public interface AboutService {


    List<AboutDto> getAll();

    AboutDto getById(Long id);

    AboutDto save(AboutDto about);

    AboutDto update(Long id, AboutDto about);

    void delete(Long id);


}
