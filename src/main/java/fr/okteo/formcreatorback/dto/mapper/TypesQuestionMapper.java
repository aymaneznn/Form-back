package fr.okteo.formcreatorback.dto.mapper;

import fr.okteo.formcreatorback.dto.TypesQuestionDto;
import fr.okteo.formcreatorback.model.TypesQuestion;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypesQuestionMapper {
    TypesQuestion toEntity(TypesQuestionDto typesQuestionDto);

    List<TypesQuestionDto> entityToDTOList(List<TypesQuestion> model);

    TypesQuestionDto toDto(TypesQuestion typesQuestion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TypesQuestion partialUpdate(TypesQuestionDto typesQuestionDto, @MappingTarget TypesQuestion typesQuestion);

    TypesQuestionDto entityToDTO(TypesQuestion typeQuestion);
}