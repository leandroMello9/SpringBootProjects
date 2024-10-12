package com.validate.validate.service;

import com.validate.validate.domain.dtos.UserDto;
import com.validate.validate.exceptions.UnprocessingEntityException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
@Primary
public class UserService implements IUserService{

    @Override
    public UserDto create(UserDto user, BindingResult result) throws UnprocessingEntityException {
        if(result.hasErrors()) {
            throw new UnprocessingEntityException("Validate error : " + result.getFieldError().getDefaultMessage(), 422, "Method: UserService.create");

        }
        return user;
    }
}
