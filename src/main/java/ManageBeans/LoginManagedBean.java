package ManageBeans;

import Dao.UsuarioDAO;
import com.mycompany.sistemaloginjsf.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginManagedBean implements Serializable {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario = new Usuario();

    public String envia() {

        usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
        if (usuario == null) {
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
            return null;
        } else {
            return "/main";
        }

    }

    public String insere() throws Exception {

        String recebe;

        if (usuarioDAO.inserirUsuario(usuario)) {

            usuario.setNomeUsuario(usuario.getNomeUsuario());
            usuario.setSenha(usuario.getSenha());
            usuario.setEmail(usuario.getEmail());
            usuario.setCidade(usuario.getCidade());
            usuario.setTelefone(usuario.getTelefone());
            usuario.setCpf(usuario.getCpf());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário cadastrado com sucesso!"));
            recebe = "/index";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro no cadastro de usuário!"));
            recebe = null;
        }

        return recebe;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
