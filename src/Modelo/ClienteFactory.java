package Modelo;

public class ClienteFactory implements UsuarioFactory {
    @Override
    public Usuario crearUsurio() {
        return new Cliente();
    }
    
}
