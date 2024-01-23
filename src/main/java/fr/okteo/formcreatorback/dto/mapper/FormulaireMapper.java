package fr.okteo.formcreatorback.dto.mapper;

import fr.okteo.formcreatorback.dto.FormulaireDto;
import fr.okteo.formcreatorback.model.Formulaire;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface FormulaireMapper {
    Formulaire toEntity(FormulaireDto formulaireDto);

    List<FormulaireDto> entityToDTOList(List<Formulaire> model);

    FormulaireDto toDto(Formulaire formulaire);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Formulaire partialUpdate(FormulaireDto formulaireDto, @MappingTarget Formulaire formulaire);

    Formulaire dtoToEntity(FormulaireDto formulaire);
}