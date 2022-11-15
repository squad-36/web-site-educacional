package gen.connection.entidades;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailsImpl implements UserDetails {
	 private Usuario usuario;

	    public UserDetailsImpl(Usuario usuario) {
	        this.usuario = usuario;
	    }

		
//		  @Override public Collection<? extends GrantedAuthority> getAuthorities() {
//		  Perfil perfil = usuario.getPermissao().getNome_permissao().equals("ALUNO") ?
//		  Perfil.ADMIN : Perfil.USER;
//		  
//		  return AuthorityUtils.createAuthorityList(perfil.toString()); }
//		 

	    @Override
	    public String getPassword() {
	        return usuario.getSenha();
	    }

	    @Override
	    public String getUsername() {
	        return usuario.getEmail();
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        // TODO Auto-generated method stub
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        // TODO Auto-generated method stub
	        return true;
	    }

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
}
