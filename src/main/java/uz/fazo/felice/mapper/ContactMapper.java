package uz.fazo.felice.mapper;

import org.mapstruct.Mapper;
import uz.fazo.felice.entity.Contact;
import uz.fazo.felice.payload.ContactDto;

import java.util.List;

@Mapper
public interface ContactMapper {

    ContactDto contactToContactDto(Contact contact);

    Contact contactDtoToContact(ContactDto contactDto);

}
