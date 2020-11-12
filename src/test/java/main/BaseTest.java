package main;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeEach
    void setUp() {
open("https://alfabank.ru/");
    }
}
