package fr.okteo.formcreatorback.dto.mapper;

import fr.okteo.formcreatorback.dto.ParametrageAvanceDto;
import fr.okteo.formcreatorback.model.ParametrageAvance;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParametrageAvanceMapper {
    ParametrageAvance toEntity(ParametrageAvanceDto parametrageAvanceDto);

    ParametrageAvanceDto toDto(ParametrageAvance parametrageAvance);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ParametrageAvance partialUpdate(ParametrageAvanceDto parametrageAvanceDto, @MappingTarget ParametrageAvance parametrageAvance);

    List<ParametrageAvanceDto> entityToDTOList(List<ParametrageAvance> allByFormulaireId);
}