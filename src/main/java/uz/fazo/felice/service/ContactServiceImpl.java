package uz.fazo.felice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.fazo.felice.entity.Contact;
import uz.fazo.felice.mapper.ContactMapper;
import uz.fazo.felice.payload.ContactDto;
import uz.fazo.felice.repository.ContactRepository;
import uz.fazo.felice.telegram.SenderTelegramBot;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public List<ContactDto> findAll() {
        return contactRepository.findAll().stream().map(contactMapper::contactToContactDto).collect(Collectors.toList());
    }

    @Override
    public ContactDto save(ContactDto contactDto) {
        Contact save = contactRepository.save(contactMapper.contactDtoToContact(contactDto));
        return contactMapper.contactToContactDto(save);
    }

    @Override
    public ContactDto findById(Long id) {
        return contactRepository.findById(id).map(contactMapper::contactToContactDto).orElseThrow(NullPointerException::new);

    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);

    }

    @Override
    public ContactDto update(Long id, ContactDto contactDto) {
        Contact contact = contactRepository.findById(id).orElseThrow(NullPointerException::new);
        contact.setEmail(contactDto.getEmail());
        contact.setPhone(contactDto.getPhone());
        return contactMapper.contactToContactDto(contactRepository.save(contact));
    }
}
