package testdata;

import models.RegistrationModel;
import utils.FakeMessageGenerator;

public class PrepareRegistrationData {

    public static RegistrationModel getValidRegistration() {
        String password = FakeMessageGenerator.generatePassword();
        return RegistrationModel
                .builder()
                .zipCode(FakeMessageGenerator.generateFiveDigitsZipCode())
                .firstName(FakeMessageGenerator.generateFirstName())
                .lastName(FakeMessageGenerator.generateLastName())
                .email(FakeMessageGenerator.generateEmail())
                .password(password)
                .confirmPassword(password)
                .build();
    }

    public static RegistrationModel getRegistrationWithoutFirstName() {
        String password = FakeMessageGenerator.generatePassword();
        return RegistrationModel
                .builder()
                .zipCode(FakeMessageGenerator.generateFiveDigitsZipCode())
                .lastName(FakeMessageGenerator.generateLastName())
                .email(FakeMessageGenerator.generateEmail())
                .password(password)
                .confirmPassword(password)
                .build();
    }

    public static RegistrationModel getRegistrationDataWithoutLastName() {
        String password = FakeMessageGenerator.generatePassword();
        return RegistrationModel
                .builder()
                .zipCode(FakeMessageGenerator.generateFiveDigitsZipCode())
                .firstName(FakeMessageGenerator.generateFirstName())
                .email(FakeMessageGenerator.generateEmail())
                .password(password)
                .confirmPassword(password)
                .build();
    }
}
