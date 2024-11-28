package com.example.exambyte.domainLayer.model;
import java.util.Objects;
import java.util.regex.Pattern;


// verwende RECOٍRD
public class Email{
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);
    private String emailAdresse;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(emailAdresse, email.emailAdresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAdresse);
    }

    public Email(String emailAdresse) {
        this.emailAdresse = emailAdresse;
    }

    public boolean isValid(){
        return PATTERN.matcher(emailAdresse).matches();
    }

    public String getEmailAdresse() {
        return emailAdresse;
    }

    public void setEmailAdresse(String emailAdresse) {
        this.emailAdresse = emailAdresse;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailAdresse='" + emailAdresse + '\'' +
                '}';
    }
}
