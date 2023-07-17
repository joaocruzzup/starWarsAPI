package org.example;


import org.example.view.MenuView;
import org.example.view.RebeldeView;

import static org.example.connection.Conexao.getConnection;

public class Main {
    public static void main(String[] args) {
        MenuView menu = new MenuView();
        menu.iniciar();
    }
}
