package br.com.stefanini.stefaninifood.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.stefanini.stefaninifood.dao.UsuarioDao;
import br.com.stefanini.stefaninifood.modelo.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Usuario usuario = new Usuario();
	UsuarioDao usuarioDao = new UsuarioDao();

	public String efetuarLogin() {

		if (this.usuarioDao.existeUsuario(usuario)) {
			return "home?faces-redirect=true";
		} else {
			return "";
		}

	}

	public String logout() {
		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
