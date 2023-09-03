package com.example.passwordvalidatorchallenge.Controllers;

import com.example.passwordvalidatorchallenge.Dtos.ErrorDTO;
import com.example.passwordvalidatorchallenge.Dtos.PasswordDTO;
import com.example.passwordvalidatorchallenge.Services.ValidatorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate-password")
public class PasswordController {
    @Autowired
    ValidatorService validatorService;

    @PostMapping
    public ResponseEntity<String> passwordValidation(@RequestBody PasswordDTO passwordDTO) {

        System.out.println(passwordDTO.getPassword());
        ErrorDTO errorDTO = validatorService.validatePassword(passwordDTO);
        System.out.println(errorDTO.getError());
        if (errorDTO.getError() == "valido"){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }
        else{
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO.getError());
        }
    }

}
