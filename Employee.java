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

public class Employee implements Initializable {
    public TextField xSalary;
    public TextField xEmployeeName;
    public TextField xPhoneNumber;
    public TextField xEN;
    public Label welcomeText;
    public TableView tableView;
    public TableColumn EN;
    public TableColumn EmployeeName;
    public TableColumn Salary;
    public TableColumn PhoneNumber;
    public Button backme;
    ObservableList<admintable> list = FXCollections.observableArrayList();

    @FXML
    public void View(ActionEvent actionEvent) {
        String EN = xEN.getText();
        String jdbcUrl = "jdbc:mysql://localhost:3306/kailashlab3";
        String dbUser = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM emloyeetable WHERE EN='" + EN + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                String UserName = resultSet.getString("EmployeeName");
                String PhoneNumber = resultSet.getString("PhoneNumber");
                String Address = resultSet.getString("Salary");

                xEmployeeName.setText(String.valueOf(EmployeeName));
                xPhoneNumber.setText(PhoneNumber);
                xSalary.setText(String.valueOf(Salary));
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
            String query = "SELECT * FROM emloyeetable";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int EN = resultSet.getInt("EN");
                String EmployeeName = resultSet.getString("EmployeeName");
                int PhoneNumber = resultSet.getInt("PhoneNumber");
                String Salary = resultSet.getString("Salary");
                list.add(new admintable(EN, EmployeeName, PhoneNumber, Salary));
            }
            tableView.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EN.setCellValueFactory(new PropertyValueFactory<>("EN"));
        EmployeeName.setCellValueFactory(new PropertyValueFactory<>("EmployeeName"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        tableView.setItems(list);
    }

    @FXML
    public void Create(ActionEvent actionEvent) {
        String EmployeeName = xEmployeeName.getText();
        int PhoneNumber = Integer.parseInt(xPhoneNumber.getText());
        String Salary = xSalary.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/kailashlab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `emloyeetable` (`EmployeeName`, `PhoneNumber`, `Salary`) VALUES ('" + EmployeeName + "', '" + PhoneNumber + "', '" + Salary + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Update(ActionEvent actionEvent) {
        String SN = xEN.getText();
        String EmployeeName = xEmployeeName.getText();
        int PhoneNumber = Integer.parseInt(xPhoneNumber.getText());
        String Salary = xSalary.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/kailashlab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `emloyeetable` SET `EmployeeName`='" + EmployeeName + "', `PhoneNumber`='" + PhoneNumber + "', `Salary`='" + Salary + "' WHERE `EN`='" + EN + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Delete(ActionEvent actionEvent) {
        String SN = xEN.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/kailashlab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `emloyeetable` WHERE `EN`='" + EN + "'";
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
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public static int yearsalary(int a){
        int yearly = a *12 ;
        return yearly;
    }
}
