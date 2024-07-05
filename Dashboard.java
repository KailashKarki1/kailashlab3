package com.example.kailashlab3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.net.ssl.SSLSession;
import java.io.IOException;

public class Dashboard {
    public Button Admin;
    public Button Employee;
    public Button logout;

    public void admin(ActionEvent actionEvent) {
            try {
                Parent mainScene = FXMLLoader.load(getClass().getResource("admin.fxml")); // Adjust path as necessary
                Stage mainStage = new Stage();
                mainStage.setTitle("Main Application");
                mainStage.setScene(new Scene(mainScene));

                Stage currentStage = (Stage) Admin.getScene().getWindow();
                currentStage.close();

                mainStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void employee(ActionEvent actionEvent) {
        try {
            Parent mainScene = FXMLLoader.load(getClass().getResource("employee.fxml")); // Adjust path as necessary
            Stage mainStage = new Stage();
            mainStage.setTitle("Main Application");
            mainStage.setScene(new Scene(mainScene));

            Stage currentStage = (Stage) Employee.getScene().getWindow();
            currentStage.close();

            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void logout(ActionEvent actionEvent) {
        try {
            Parent mainScene = FXMLLoader.load(getClass().getResource("hello-view.fxml")); // Adjust path as necessary
            Stage mainStage = new Stage();
            mainStage.setTitle("Main Application");
            mainStage.setScene(new Scene(mainScene));

            Stage currentStage = (Stage) logout.getScene().getWindow();
            currentStage.close();

            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
