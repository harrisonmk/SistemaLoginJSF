package ManageBeans;

import Dao.UsuarioDAO;
import modelo.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "LoginMB")
@RequestScoped
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
    
     public String logout() {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuario = null;
        return "/index.xhtml?faces-redirect=true";
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
            recebe = "/index.xhtml";
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
