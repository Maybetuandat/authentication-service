package com.example.authentication_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationServiceApplication {

	public static void main(String[] args) {
		ensureDatabaseExists();
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}
	private static void ensureDatabaseExists() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"; 
        String user = "postgres";
        String password = "123456"; 
        String dbName = "authentication"; 

        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
             Statement statement = connection.createStatement()) {
            var resultSet = statement.executeQuery("SELECT 1 FROM pg_database WHERE datname = '" + dbName + "'");
            if (!resultSet.next()) {
                statement.executeUpdate("CREATE DATABASE " + dbName);
                System.out.println("✅ Đã tự động tạo Database: " + dbName);
            } else {
                System.out.println("ℹ️ Database " + dbName + " đã tồn tại.");
            }
        } catch (Exception e) {
            System.err.println("⚠️ Không thể tự tạo DB: " + e.getMessage());
        }
    }

}
