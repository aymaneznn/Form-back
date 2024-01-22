package fr.okteo.formcreatorback.dto.mapper;

import fr.okteo.formcreatorback.dto.DonneesStatistiqueDto;
import fr.okteo.formcreatorback.model.DonneesStatistique;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DonneesStatistiqueMapper {
    DonneesStatistique toEntity(DonneesStatistiqueDto donneesStatistiqueDto);

    DonneesStatistiqueDto toDto(DonneesStatistique donneesStatistique);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DonneesStatistique partialUpdate(DonneesStatistiqueDto donneesStatistiqueDto, @MappingTarget DonneesStatistique donneesStatistique);

    List<DonneesStatistiqueDto> entityToDTOList(List<DonneesStatistique> allByFormulaireId);
}