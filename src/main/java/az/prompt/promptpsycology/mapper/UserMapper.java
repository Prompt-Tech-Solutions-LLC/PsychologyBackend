package az.prompt.promptpsycology.mapper;

import az.prompt.promptpsycology.dto.UserDto;
import az.prompt.promptpsycology.jpa.entity.UserJpa;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto fromUserJpa(UserJpa user);
}
