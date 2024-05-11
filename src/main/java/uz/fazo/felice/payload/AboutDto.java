package uz.fazo.felice.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AboutDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String about1;

    private String about2;


}
