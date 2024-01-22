package fr.okteo.formcreatorback.dto.mapper;

import fr.okteo.formcreatorback.dto.QuestionDto;
import fr.okteo.formcreatorback.model.Question;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionMapper {
    Question toEntity(QuestionDto questionDto);

    List<QuestionDto> entityToDTOList(List<Question> model);

    QuestionDto toDto(Question question);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Question partialUpdate(QuestionDto questionDto, @MappingTarget Question question);

    Question dtoToEntity(QuestionDto questionDto);

    Object entityToDTO(Question question);
}