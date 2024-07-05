package com.example.kailashlab3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Admin implements Initializable {
    public TableColumn SN;
    public TableColumn UserName;
    public TableColumn PhoneNumber;
    public TableColumn Address;
    public TextField xAddress;
    public TextField xPhoneNumber;
    public TextField xUserName;
    public TextField xSN;
    public Label welcomeText;
    public TableView tableView;
    public Button backme;
    ObservableList<admintable> list = FXCollections.observableArrayList();

    @FXML
    public void View(ActionEvent actionEvent) {
        String SN = xSN.getText();
        String jdbcUrl = "jdbc:mysql://localhost:3306/kailashlab3";
        String dbUser = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM admintable WHERE SN='" + SN + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                String UserName = resultSet.getString("UserName");
                String PhoneNumber = resultSet.getString("PhoneNumber");
                String Address = resultSet.getString("Address");

                xUserName.setText(UserName);
                xPhoneNumber.setText(PhoneNumber);
                xAddress.setText(Address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Load(ActionEvent actionEvent) {
        populateTable();
    }

    public void populateTable() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/kailashlab3";
        String dbUser = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM admintable";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int SN = resultSet.getInt("SN");
                String UserName = resultSet.getString("UserName");
                int PhoneNumber = resultSet.getInt("PhoneNumber");
                String Address = resultSet.getString("Address");
                list.add(new admintable(SN, UserName, PhoneNumber, Address));
            }
            tableView.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SN.setCellValueFactory(new PropertyValueFactory<>("SN"));
        UserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        tableView.setItems(list);
    }

    @FXML
    public void Create(ActionEvent actionEvent) {
        String UserName = xUserName.getText();
        int PhoneNumber = Integer.parseInt(xPhoneNumber.getText());
        String Address = xAddress.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/kailashlab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `admintable` (`UserName`, `PhoneNumber`, `Address`) VALUES ('" + UserName + "', '" + PhoneNumber + "', '" + Address + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Update(ActionEvent actionEvent) {
        String SN = xSN.getText();
        String UserName = xUserName.getText();
        int PhoneNumber = Integer.parseInt(xPhoneNumber.getText());
        String Address = xAddress.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/kailashlab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `admintable` SET `UserName`='" + UserName + "', `PhoneNumber`='" + PhoneNumber + "', `Address`='" + Address + "' WHERE `SN`='" + SN + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Delete(ActionEvent actionEvent) {
        String SN = xSN.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/kailashlab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `admintable` WHERE `SN`='" + SN + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Back(ActionEvent actionEvent) {
        try {
            Parent mainScene = FXMLLoader.load(getClass().getResource("dashboard.fxml")); // Adjust path as necessary
            Stage mainStage = new Stage();
            mainStage.setTitle("Main Application");
            mainStage.setScene(new Scene(mainScene));

            Stage currentStage = (Stage) backme.getScene().getWindow();
            currentStage.close();

            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

