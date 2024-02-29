package fr.okteo.formcreatorback.dto.mapper;

import fr.okteo.formcreatorback.dto.QuestionDto;
import fr.okteo.formcreatorback.model.Question;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {FormulaireMapper.class, TypesQuestionMapper.class})
public interface QuestionMapper {
    List<QuestionDto> entityToDTOList(List<Question> model);

    @Mapping(target = "formulaire", ignore = true)
    Question dtoToEntity(QuestionDto questionDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Question partialUpdate(QuestionDto questionDto, @MappingTarget Question question);
}
