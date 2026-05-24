

public class Login {

    private String username;
    private String password;
    private String cellphone;

    // Username validation
    public boolean checkUserName(String username) {

        return username.contains("_")
                && username.length() <= 5;
    }

    // Password validation
    public boolean checkPasswordComplexity(String password) {

        boolean capital = false;
        boolean number = false;
        boolean special = false;

        for (char c : password.toCharArray()) {

            if (Character.isUpperCase(c)) {
                capital = true;
            }

            if (Character.isDigit(c)) {
                number = true;
            }

            if (!Character.isLetterOrDigit(c)) {
                special = true;
            }
        }

        return password.length() >= 8
                && capital
                && number
                && special;
    }

    // Cellphone validation
    public boolean checkCellPhoneNumber(String cellphone) {

        return cellphone.matches("^\\+27\\d{9}$");
    }

    // Register user
    public String registerUser(
            String username,
            String password,
            String cellphone
    ) {

        if (!checkUserName(username)) {

            return "Username is incorrectly formatted.";
        }

        if (!checkPasswordComplexity(password)) {

            return "Password is incorrectly formatted.";
        }

        if (!checkCellPhoneNumber(cellphone)) {

            return "Cellphone number incorrectly formatted.";
        }

        this.username = username;
        this.password = password;
        this.cellphone = cellphone;

        return "User registered successfully.";
    }

    // Login user
    public boolean loginUser(
            String username,
            String password
    ) {

        return this.username.equals(username)
                && this.password.equals(password);
    }

    // Login status message
    public String returnLoginStatus(
            boolean loginStatus,
            String username
    ) {

        if (loginStatus) {

            return "Welcome " + username
                    + ", it is great to see you again.";
        }

        return "Username or password incorrect.";
    }
}
