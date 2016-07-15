/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import jdbc.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author Romulo
 */
@WebFilter("/*")
public class FiltroConexao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            Connection connection = new ConnectionFactory().getConnection();

            // pendurando a connection na requisição      
            request.setAttribute("conexao", connection);

            chain.doFilter(request, response);
            
            // fechando a conexão
            connection.close();
        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }

    @Override
    public void destroy() {
    }

}
