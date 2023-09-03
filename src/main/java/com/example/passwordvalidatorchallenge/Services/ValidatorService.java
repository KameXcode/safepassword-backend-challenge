package com.example.passwordvalidatorchallenge.Services;

import com.example.passwordvalidatorchallenge.Dtos.ErrorDTO;
import com.example.passwordvalidatorchallenge.Dtos.PasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class ValidatorService {


        private String maisculaError = "A senha deve conter pelo menos uma letra maiúscula.";
        private String minusculaError = "A senha deve conter pelo menos uma letra minúscula";
        private String dnumericoError = "A senha deve conter pelo menos um dígito numérico.";
        private String specialError = "A senha deve conter pelo menos um caractere especial (e.g., !@#$%).";
        private String oneMaiusculaError = "A senha deve conter pelo menos uma letra maiúscula.";
        private String eightCaracteresError =  "A senha deve conter pelo menos 8 caracteres.";
        public ErrorDTO validatePassword(PasswordDTO passwordDTO) {
            ValidatorService validatorService = new ValidatorService();;
            var password = passwordDTO.getPassword();
            String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%])[A-Za-z\\d@#$!%]{8,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            if (!matcher.matches()) {
                if (!password.matches("^(?=.*[A-Z]).*$")) {
                    return new ErrorDTO(validatorService.getMaisculaError());
                }
                if (!password.matches("^(?=.*[a-z]).*$")) {
                    return new ErrorDTO(validatorService.getMinusculaError());
                }
                if (!password.matches("^(?=.*\\d).*$")) {
                    return new ErrorDTO(validatorService.getDnumericoError());
                    }
                if (!password.matches("^(?=.*[@#$!%]).*$")) {
                    return new ErrorDTO(validatorService.getSpecialError());
                    }
                if (password.length() < 8) {
                    return new ErrorDTO (validatorService.getEightCaracteresError());
                }
            }
            return new ErrorDTO("valido");
        }

    public String getSpecialError() {
        return specialError;
    }

    public void setSpecialError(String specialError) {
        this.specialError = specialError;
    }

    public String getMaisculaError() {
        return maisculaError;
    }

    public void setMaisculaError(String maisculaError) {
        this.maisculaError = maisculaError;
    }

    public String getMinusculaError() {
        return minusculaError;
    }

    public void setMinusculaError(String minusculaError) {
        this.minusculaError = minusculaError;
    }

    public String getDnumericoError() {
        return dnumericoError;
    }

    public void setDnumericoError(String dnumericoError) {
        this.dnumericoError = dnumericoError;
    }

    public String getOneMaiusculaError() {
        return oneMaiusculaError;
    }

    public void setOneMaiusculaError(String oneMaiusculaError) {
        this.oneMaiusculaError = oneMaiusculaError;
    }

    public String getEightCaracteresError() {
        return eightCaracteresError;
    }

    public void setEightCaracteresError(String eightCaracteresError) {
        this.eightCaracteresError = eightCaracteresError;
    }
}


