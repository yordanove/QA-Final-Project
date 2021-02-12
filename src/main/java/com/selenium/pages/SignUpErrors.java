package com.selenium.pages;

public enum SignUpErrors {
    BIRTH_DATE_ERROR_MESSAGE("The birthday error does not seem to be right"),               // These are named with underscores and capitals to comply with convention (SonarLint)
    EMAIL_ERROR_MESSAGE("The email error does not seem to be right"),
    EXPECTED_BIRTH_DATE_ERROR("That doesn’t look right, please re-enter your birthday."),
    EXPECTED_EMAIL_ERROR("This email address is not available for sign up, try something else"),

    EXPECTED_PASSWORD_ERROR("Your password isn’t strong enough, try making it longer."),
    EXPECTED_PHONE_ERROR("That doesn’t look right, please re-enter your phone number."),
    PASSWORD_ERROR_MESSAGE("The password error does not seem to be right"),
    PHONE_ERROR_MESSAGE("The phone error does not seem to be right");

    private final String errorMessage;

    SignUpErrors(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
