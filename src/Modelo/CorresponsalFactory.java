package Modelo;

public class CorresponsalFactory implements UsuarioFactory{

    @Override
    public Usuario crearUsurio() {
        return new Corresponsal();
    }
    
}
