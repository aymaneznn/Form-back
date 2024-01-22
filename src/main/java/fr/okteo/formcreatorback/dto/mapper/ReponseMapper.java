package fr.okteo.formcreatorback.dto.mapper;

import fr.okteo.formcreatorback.dto.ReponseDto;
import fr.okteo.formcreatorback.model.Reponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReponseMapper {
    Reponse toEntity(ReponseDto reponseDto);

    List<ReponseDto> entityToDTOList(List<Reponse> model);
    ReponseDto toDto(Reponse reponse);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reponse partialUpdate(ReponseDto reponseDto, @MappingTarget Reponse reponse);

    Reponse dtoToEntity(ReponseDto reponseDto);
}