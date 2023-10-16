package inf.restaurar.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import inf.restaurar.todolist.user.IUserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

            var servletPath = request.getServletPath();

            if(servletPath.startsWith("/tasks/")){
                //Pega autenticação (usuário e senha)
                var authorization = request.getHeader("Authorization");

                //Remove a palavra basic da autenticação
                var authEncoded = authorization.substring("Basic".length()).trim();

                byte[] authDencoded = Base64.getDecoder().decode(authEncoded);

                var authString = new String(authDencoded);

                //Recebe as credenciais, e separa em usuario e senha
                String[] credentials = authString.split(":");
                String username = credentials[0];
                String password = credentials[1];

                //Validar usuário
                var user = this.userRepository.findByUsername(username);

                if(user == null) {
                    response.sendError(401);
                }else{
                    //Validar senha
                    var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                    if(passwordVerify.verified){
                        request.setAttribute("idUser", user.getId());
                        filterChain.doFilter(request, response);
                    }else{
                        response.sendError(401);
                    }

                    //Segue viagem


                }
            }else{
                filterChain.doFilter(request, response);
            }
    }
}
