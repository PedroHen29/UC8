/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.bcrypt.mcv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import login.bcrypt.mcv.database.Conexao;
import login.bcrypt.mcv.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class usuarioDao {
    public static boolean salvar(Usuario usuario) {

        String sql = "INSERT INTO usuarios (email, senha) VALUES (?, ?)";

        String senhaHash = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, senhaHash);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Usuario buscarEmail(String email) {

        String sql = "SELECT * FROM usuarios WHERE email = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("senha")// pega a senha criptografada
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
