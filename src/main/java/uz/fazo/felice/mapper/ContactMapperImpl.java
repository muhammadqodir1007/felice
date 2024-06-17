package uz.fazo.felice.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import uz.fazo.felice.entity.Contact;
import uz.fazo.felice.payload.ContactDto;

import java.util.List;

@Component
public class ContactMapperImpl implements ContactMapper {



    @Override
    public ContactDto contactToContactDto(Contact contact) {
        if (contact == null) return null;
        ContactDto contactDto = new ContactDto();
        contactDto.setId(contact.getId());
        contactDto.setEmail(contact.getEmail());
        contactDto.setPhone(contact.getPhone());
        return contactDto;
    }

    @Override
    public Contact contactDtoToContact(ContactDto contactDto) {
        if (contactDto == null) return null;
        Contact contact = new Contact();
        contact.setId(contactDto.getId());
        contact.setEmail(contactDto.getEmail());
        contact.setPhone(contactDto.getPhone());
        return contact;
    }

}
