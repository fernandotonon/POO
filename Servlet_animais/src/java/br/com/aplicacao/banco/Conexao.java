/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplicacao.banco;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tonon
 */
public class Conexao {
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/poo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=GMT-4&autoDeserialize=true";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // Conectar ao banco
    public static Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;
    }    
}
