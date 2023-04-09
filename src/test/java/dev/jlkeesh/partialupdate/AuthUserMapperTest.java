package dev.jlkeesh.partialupdate;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AuthUserMapperTest {

    @Test
    void toEntity() {
        AuthUser authUser = null;//new AuthUser("1", "jl", "john.lgd65@gmail.com", "123", "ADMIN");
        AuthUserCreateDTO dto = new AuthUserCreateDTO("1", null, "dev.jlkeesh@gmail.com", "MANAGER");
        AuthUserMapper mapper = Mappers.getMapper(AuthUserMapper.class);
        mapper.toEntity(dto, authUser);
        System.out.println(authUser);
    }
}