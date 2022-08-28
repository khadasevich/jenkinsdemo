package utils;

import com.github.javafaker.Faker;

public class FakeMessageGenerator {

    public static String generateFourDigitsZipCode() {
        Faker faker = new Faker();
        return faker.numerify("####");
    }

    public static String generateFiveDigitsZipCode() {
        Faker faker = new Faker();
        return faker.numerify("#####");
    }

    public static String generateFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateLastName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generatePassword() {
        Faker faker = new Faker();
        return faker.letterify("???@1");
    }

    public static String generateAccountName() {
        return new Faker().company().name();
    }

    public static String generatePhone() {
        return new Faker().phoneNumber().phoneNumber();
    }
}
