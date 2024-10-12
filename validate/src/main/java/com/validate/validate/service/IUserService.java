package com.validate.validate.service;

import com.validate.validate.domain.dtos.UserDto;
import com.validate.validate.exceptions.UnprocessingEntityException;
import org.springframework.validation.BindingResult;

public interface IUserService {
    UserDto create(UserDto user, BindingResult result) throws UnprocessingEntityException;
}
