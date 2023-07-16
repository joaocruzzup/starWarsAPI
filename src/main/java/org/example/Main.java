package org.example;


import org.example.view.RebeldeView;

import static org.example.connection.Conexao.getConnection;

public class Main {
    public static void main(String[] args) {
        RebeldeView menu = new RebeldeView();
        menu.iniciar();

    }
}
