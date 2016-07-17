/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos;

/**
 *
 * @author Romulo
 */
public enum TipoIngresso {
    Meia, Inteira;

    public static TipoIngresso getTipo(int valor) {
        switch(valor) {
            case 0:
                return Meia;
            case 1:
                return Inteira;
        }
        return null;
    }

}
