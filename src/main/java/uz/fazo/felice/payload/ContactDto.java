package uz.fazo.felice.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String phone;
    private String email;
}
