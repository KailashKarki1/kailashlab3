package com.example.kailashlab3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    public TextField password;
    public TextField email;
    public Button logIn;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String Password = password.getText();
        String Email = email.getText();

        if(Email.equals("")&&Password.equals("") ) {
            welcomeText.setText("Email and Password Field is Empty!");
        }else {
            String jdbcUrl = "jdbc:mysql://localhost:3306/kailashLab3";
            String dbUser = "root";
            String dbPassword = "";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                String query = "SELECT * FROM loginpage WHERE Email ='"+Email+"' AND Password = '"+Password+"'";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    try {
                        Parent mainScene = FXMLLoader.load(getClass().getResource("dashboard.fxml")); // Adjust path as necessary
                        Stage mainStage = new Stage();
                        mainStage.setTitle("Main Application");
                        mainStage.setScene(new Scene(mainScene));

                        Stage currentStage = (Stage) logIn.getScene().getWindow();
                        currentStage.close();

                        mainStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    welcomeText.setText("Invalid Username or Password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }}}