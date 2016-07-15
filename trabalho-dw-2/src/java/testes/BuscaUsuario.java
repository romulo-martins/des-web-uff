/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.UsuarioDao;
import model.Usuario;

/**
 *
 * @author Romulo
 */

public class BuscaUsuario {

    public static void main(String[] args) {

        UsuarioDao dao = new UsuarioDao();
        Usuario usuario = dao.getUsuario("ujoao");
        System.out.println(usuario);

    }

}
