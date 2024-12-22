package com.onlineshopping.userservice.mapper;

import com.onlineshopping.userservice.dto.UserDTO;
import com.onlineshopping.userservice.entity.UserInfo;
import com.onlineshopping.userservice.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    @Mapping(source = "roles", target = "roles", qualifiedByName = "rolesToString")
    UserInfo toEntity(UserDTO userDTO);

    @Named("rolesToString")
    default String mapRoles(List<Role> roles) {
        if (roles == null) {
            return "";
        }
        return roles.stream()
                .map(Role::getName) // Assuming Role has a getName() method
                .collect(Collectors.joining(","));
    }
}