package fr.okteo.formcreatorback.dto.mapper;

import fr.okteo.formcreatorback.dto.GestionUtilisateurDto;
import fr.okteo.formcreatorback.model.GestionUtilisateur;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GestionUtilisateurMapper {
    GestionUtilisateur toEntity(GestionUtilisateurDto gestionUtilisateurDto);

    GestionUtilisateurDto toDto(GestionUtilisateur gestionUtilisateur);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    GestionUtilisateur partialUpdate(GestionUtilisateurDto gestionUtilisateurDto, @MappingTarget GestionUtilisateur gestionUtilisateur);

    List<GestionUtilisateurDto> entityToDTOList(List<GestionUtilisateur> allByFormulaireId);
}