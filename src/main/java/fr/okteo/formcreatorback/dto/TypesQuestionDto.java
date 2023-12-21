package fr.okteo.formcreatorback.dto;

import fr.okteo.formcreatorback.model.TypesQuestion;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link TypesQuestion}
 */
@Value
public class TypesQuestionDto implements Serializable {
    Integer id;
    String type;
}