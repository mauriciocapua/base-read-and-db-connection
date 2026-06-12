package br.com.application.repository;


import br.com.application.dto.UserDTO;
import br.com.application.entity.UserEntity;

import java.sql.*;

public class UserRepositry {

    public UserEntity save(UserDTO user) {

        String sql =
                "INSERT INTO USERS(name, age) VALUES (?, ?)";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, user.name());
            preparedStatement.setInt(2, user.age());

            preparedStatement.executeUpdate();

            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {
                    Integer id = keys.getInt(1);

                    return new UserEntity(
                            id,
                            user.name(),
                            user.age()
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
