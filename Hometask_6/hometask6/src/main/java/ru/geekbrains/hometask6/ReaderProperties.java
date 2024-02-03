package ru.geekbrains.hometask6;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application.reader")
public class ReaderProperties {

    private int maxAllowedBooks;

    public int getMaxAllowedBooks() {
        return maxAllowedBooks;
    }

    public void setMaxAllowedBooks(int maxAllowedBooks) {
        this.maxAllowedBooks = maxAllowedBooks;
    }

}
