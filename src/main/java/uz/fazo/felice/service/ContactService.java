package uz.fazo.felice.service;

import uz.fazo.felice.payload.ContactDto;

import java.util.List;

public interface ContactService {


    List<ContactDto> findAll();

    ContactDto save(ContactDto contactDto);

    ContactDto findById(Long id);

    void deleteById(Long id);

    ContactDto update(Long id, ContactDto contactDto);


}
