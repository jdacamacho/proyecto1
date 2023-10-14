package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios;

import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface GestionarUsuarioGatewayInt {
    public Usuario guardar(Usuario objUsuario);
    public Usuario modificar(int identificacionUsuario,Usuario objUsuario);
    public List<Usuario> listar();
    public boolean existeUsuario(int identificacionUsuario);
    public Usuario consultarUsuario(int identificacionUsuario);
    public Usuario buscarPorLogin(Login login);
}
