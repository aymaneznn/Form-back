package fr.okteo.formcreatorback.dto.mapper;

import fr.okteo.formcreatorback.dto.UtilisateurDto;
import fr.okteo.formcreatorback.model.Utilisateur;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UtilisateurMapper {
    Utilisateur toEntity(UtilisateurDto utilisateurDto);

    UtilisateurDto toDto(Utilisateur utilisateur);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Utilisateur partialUpdate(UtilisateurDto utilisateurDto, @MappingTarget Utilisateur utilisateur);
}