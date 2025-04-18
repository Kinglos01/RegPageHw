package com.example.regpagehw;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.regex.Pattern;

public class HelloController {

    @FXML
    private TextField firstText;
    @FXML
    private TextField lastText;
    @FXML
    private TextField emailText;
    @FXML
    private TextField dobText;
    @FXML
    private TextField zipText;
    @FXML
    private Button addUser;

    /**
     * Represents a regular expression pattern used to validate user names.
     * The pattern enforces the following rules:
     * - The name must start with any character (e.g., a letter, digit, or symbol).
     * - It must include only alphabetic characters (uppercase or lowercase).
     * - The length of the name must be between 2 and 25 characters (inclusive).
     */

    String namePattern = "^.[a-zA-Z]{2,25}$";
    Pattern name =  Pattern.compile(namePattern);

    String emailPattern = "^[a-zA-Z0-9._%$!-]+@farmingdale\\.edu$";
    Pattern email =  Pattern.compile(emailPattern);

    String dobPattern = "^[0-9]{2}+/[0-9]{2}/[0-9]{4}$";
    Pattern dob =  Pattern.compile(dobPattern);

    String zipPattern = "^[0-9]{5}$";
    Pattern zip =  Pattern.compile(zipPattern);

    HelloApplication loader = new HelloApplication();

    /***
     *@method eligibleChecker then checks to see if the new inputs are valid
     * Then it returns @param addUser.setDisable(false) if they are valid
     */

    public void eligibleChecker(){
        if (isFirstValid() && isLastValid() && isEmailValid() && isDobValid() && isZipValid()) {
            addUser.setDisable(false);
        }
        else{addUser.setDisable(true);}
    }

    @FXML
    public void addUserButtonClicked() throws IOException {
       System.out.println("User added!");
       loader.setRoot("nextPage");
    }

    public boolean isFirstValid(){
        return name.matcher(firstText.getText()).matches();
    }

    public boolean isLastValid(){
        return name.matcher(lastText.getText()).matches();
    }

    public boolean isEmailValid(){
        return email.matcher(emailText.getText()).matches();
    }

    public boolean isDobValid(){
        return dob.matcher(dobText.getText()).matches();
    }

    public boolean isZipValid(){
        return zip.matcher(zipText.getText()).matches();
    }


    @FXML
    private void firstTyped(){
       eligibleChecker();

    }

    @FXML
    private void lastTyped(){
        eligibleChecker();
    }

    @FXML
    private void emailTyped(){
        eligibleChecker();
    }

    @FXML
    private void dobTyped(){
        eligibleChecker();
    }

    @FXML
    private void zipTyped(){
        eligibleChecker();
    }


}
