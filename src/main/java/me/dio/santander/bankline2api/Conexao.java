package me.dio.santander.bankline2api;

import me.dio.santander.bankline2api.model.Correntista;

import java.sql.*;

public class Conexao extends Correntista {
    public static void main( String[] args ) {
        try{
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_conexao", "postgres", "");
            if (conexao != null) {
            System.out.println( "Banco de dados conectado com sucesso! 🎉");
            Statement stm = conexao.createStatement();
            consultaDados(stm);
            insereDados(stm);

        } else{
            System.out.println("Conexão falhou, tente novamente.");
        }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insereDados(Statement stm) {

        throw new UnsupportedOperationException("Unimplemented method 'insereDados'");
    }

    static void consultaDados(Statement stm){
        String sql = "select id, nome, conta from usuario";
        try {
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
            System.out.println("id: " + result.getInt("id") + ", Nome: " + result.getString("nome") + ", Conta: " + result.getString("conta"));
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void inseriDados(Statement stm){
        String sql = "insert into usuario (nome, conta) values ('Maria', '04578-0')";
        try {
            stm.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}