package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

import javax.swing.JOptionPane;

import Controlador.CLogin;
import Vista.VCorresponsal;
import Vista.VLogin;
import Vista.Paneles.Consulta;
import Vista.Paneles.Principal;

public class MCorresponsal {

    // En un futuro guardar en que corresponsal se realiza la operacion

    PreparedStatement preparedStatement;
    ResultSet resultSet;

    Conexion conexion = new Conexion();
    Cliente cliente = new Cliente();
    Corresponsal corresponsal = new Corresponsal();
    public Usuario usuario;
    String tipo;
    public double saldoCliente;
    NumberFormat format = NumberFormat.getInstance(new Locale("es", "COL"));

    String accion = cliente.getAccion();
    Encriptacion encriptacion = new Encriptacion();

    Connection connection = null;
    Double retirado;

    // ___________________________________________________________________//

    public UsuarioFactory getUsuarioFactory(String userType) {
        if (userType.equals("U")) {
            return new ClienteFactory();
        } else if (userType.equals("C")) {
            return new CorresponsalFactory();
        }
        return null;
    }
    // ___________________________________________________________________//

    public void actualizarCliente() {

        try {
            connection = conexion.getConection();
            preparedStatement = connection.prepareStatement("UPDATE usuarios SET dinero = ? WHERE nID = ?");
            preparedStatement.setDouble(1, this.cliente.getDinero());
            preparedStatement.setString(2, this.cliente.getID());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actualizarCorresponsal(MLogin mLogin) {
        try {
            connection = conexion.getConection();
            preparedStatement = connection.prepareStatement("UPDATE usuarios SET dinero = ? WHERE nID = ?");
            preparedStatement.setDouble(1, this.corresponsal.getCupo());
            preparedStatement.setString(2, mLogin.corresponsal.getID());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registrar(String accion, Double monto, Cliente clienteP, MLogin mLogin) {
        try {
            connection = conexion.getConection();
            preparedStatement = connection
                    .prepareStatement("INSERT INTO movimientos (nID, fecha, nID_Des, accion, monto) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, "C" + mLogin.corresponsal.getID());
            preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            preparedStatement.setString(3, this.cliente.getID());
            preparedStatement.setString(4, accion);
            preparedStatement.setDouble(5, monto);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public boolean verificador() {
        VLogin vLogin = new VLogin();
        MVerificacion verificacion = new MVerificacion();
        CLogin cLogin = new CLogin(vLogin, verificacion);
        vLogin.setVisible(true);
        if (verificacion.estado) {
            return true;
        } else {
            return false;
        }

    }

    public void mostrarDatos(VCorresponsal vCorresponsal, MLogin mLogin, Principal p) {
        try {
            connection = Conexion.getConection();
            preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE nID = ?");
            preparedStatement.setString(1, mLogin.corresponsal.getID());
            System.out.println(mLogin.corresponsal.getID());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                mLogin.corresponsal.setCupo(resultSet.getDouble("dinero"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        vCorresponsal.lblNombre.setText(mLogin.corresponsal.getNombre());
        vCorresponsal.lblId.setText(mLogin.corresponsal.getID());
        vCorresponsal.lblFecha.setText(java.time.LocalDateTime.now().toLocalDate().toString());
        p.lbl_Saldo.setText(format.format(mLogin.corresponsal.getCupo()));

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM frases WHERE id=?");
            preparedStatement.setString(1, String.valueOf(Math.floor(Math.random() * 10 + 1)));
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            vCorresponsal.txtFrase.setText(resultSet.getString(2) + "\n-\"" + resultSet.getString(3) + "\"");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void volver(VCorresponsal vCorresponsal) {
        VLogin vLogin = new VLogin();
        MLogin mLogin = new MLogin();
        CLogin cLogin = new CLogin(vLogin, mLogin);
        vLogin.setVisible(true);
        vCorresponsal.dispose();
    }

    public Cliente buscarCliente(String username) {
        Connection connection = Conexion.getConection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE nID = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                UsuarioFactory factory = getUsuarioFactory(resultSet.getString("rango"));
                usuario = factory.crearUsurio();

                usuario.setID(resultSet.getString("nID"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setApellido(resultSet.getString("apellido"));
                usuario.setContrasena(resultSet.getString("contrasena"));
                usuario.setFechaN(resultSet.getDate("fNacimiento"));
                tipo = resultSet.getString("genero");
                usuario.setSexo(tipo.charAt(0));
                tipo = resultSet.getString("rango");
                usuario.setRango(tipo.charAt(0));

                if (usuario instanceof Cliente) {
                    cliente = (Cliente) usuario;
                    cliente.setDinero(resultSet.getDouble("dinero"));
                    saldoCliente = cliente.getDinero();
                    return cliente;
                } else if (usuario instanceof Corresponsal) {
                    JOptionPane.showMessageDialog(null, "Datos no validos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Datos no validos", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return cliente;
    }

    public void trasferir(VCorresponsal vCorresponsal, Principal p, MLogin mLogin) {
        Double dinero;
        accion = "Transferencia";

        Cliente clienteP = buscarCliente(p.PConsignar.ID.getText());

        try {
            connection = conexion.getConection();
            preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE nID = ?");
            preparedStatement.setString(1, p.PConsignar.ID.getText());

            if (p.PConsignar.monto.getText().equals("") || p.PConsignar.ID.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Hay campos vacio");
            } else {
                retirado = Double.parseDouble(p.PConsignar.monto.getText());
                resultSet = preparedStatement.executeQuery();
                if (retirado <= 0 || retirado > clienteP.getDinero()) {
                    JOptionPane.showMessageDialog(null, "Valor no validos");
                } else {
                    Double dineroU = resultSet.getDouble("dinero");
                    dineroU = dineroU + retirado;
                    dinero = clienteP.getDinero() - retirado;
                    clienteP.setDinero(dinero);
                    corresponsal.setCupo(corresponsal.getCupo() - retirado);
                    System.out.println(corresponsal.getCupo() - retirado);

                    preparedStatement = connection
                            .prepareStatement("UPDATE usuarios SET dinero = '" + dineroU + "' WHERE nID = ?");
                    preparedStatement.setString(1, clienteP.getID());
                    preparedStatement.executeUpdate();

                    actualizarCliente();
                    actualizarCorresponsal(mLogin);

                    if (p.PConsignar.ID.getText().equals(clienteP.getID())) {
                        JOptionPane.showMessageDialog(null, "No se puede hacer la transaccion a su propia cuenta");
                        p.PConsignar.ID.setText(null);
                        p.PConsignar.monto.setText(null);
                    } else {
                        int res = preparedStatement.executeUpdate();
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "Transferencia exitosa");
                            registrar(accion, dinero, clienteP, mLogin);
                            p.PConsignar.ID.setText(null);
                            p.PConsignar.monto.setText(null);

                        } else {
                            JOptionPane.showMessageDialog(null, "Ocurrio un error");
                            p.PConsignar.ID.setText(null);
                            p.PConsignar.monto.setText(null);
                        }
                    }

                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void consultar(VCorresponsal vCorresponsal, Principal p) {
        Cliente clienteP = buscarCliente(p.PConsultar.ID.getText());
        if (clienteP.getContrasena().equals(encriptacion.encriptar(p.PConsultar.contrasena.getText()))) {
            Consulta recibo = new Consulta();
            LocalDate fechaActual = LocalDate.now();

            recibo.nombre.setText(clienteP.getNombre() + " " + clienteP.getApellido());
            recibo.saldo.setText(String.valueOf(clienteP.getDinero()));
            recibo.lblDate.setText(String.valueOf(fechaActual));
            recibo.setLocationRelativeTo(null);
            recibo.setVisible(true);

        } else {
            System.out.println("nop");
            JOptionPane.showMessageDialog(null, "Datos no validos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void retirar(VCorresponsal vCorresponsal, Principal p, MLogin mLogin) {
        Double dinero;
        retirado = 0.0;
        accion = "Retirar";
        corresponsal.setCupo(mLogin.corresponsal.getCupo());
        Cliente clienteP = buscarCliente(p.PRetirar.ID.getText());

        if (clienteP.getContrasena().equals(encriptacion.encriptar(p.PRetirar.Contrasena.getText()))) {
            if (p.PRetirar.monto.getText().equals("")) {
                p.PRetirar.monto.setText("0");
            }

            retirado = Double.parseDouble(p.PRetirar.monto.getText());

            if (p.PRetirar.monto.getText().equals("0")) {
                p.PRetirar.monto.setText(null);
                JOptionPane.showMessageDialog(null, "No se a ingresado ningun valor");
            } else if (retirado > clienteP.getDinero() && retirado > corresponsal.getCupo()) {
                JOptionPane.showMessageDialog(null, "No hay suficiente dinero en la cuenta");
                p.PRetirar.monto.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Transaccion exitosa");
                dinero = clienteP.getDinero() - retirado;
                clienteP.setDinero(dinero);
                corresponsal.setCupo(corresponsal.getCupo() - retirado);
                System.out.println(retirado);

                p.PRetirar.monto.setText(null);
                actualizarCorresponsal(mLogin);
                actualizarCliente();
                registrar(accion, dinero, clienteP, mLogin);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datos no validos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consignar(VCorresponsal vCorresponsal, Principal p, MLogin mLogin) {
        Double dinero;
        accion = "Consignar";
        Cliente clienteP = buscarCliente(p.PConsignar.ID.getText());

        try {
            connection = conexion.getConection();
            if (p.PConsignar.monto.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "No se ha ingresado ningun valor");
            } else {
                retirado = Double.parseDouble(p.PConsignar.monto.getText());
                preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE nID = ?");
                preparedStatement.setString(1, clienteP.getID());

                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    Double dineroU = resultSet.getDouble("dinero");
                    dineroU = dineroU + retirado;

                    preparedStatement = connection.prepareStatement("UPDATE usuarios SET dinero = ? WHERE nID = ?");
                    preparedStatement.setDouble(1, dineroU);
                    preparedStatement.setString(2, clienteP.getID());

                    dinero = dineroU;
                    clienteP.setDinero(dinero);

                    int res = preparedStatement.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Transferencia exitosa");
                    }
                    registrar(accion, dinero, clienteP, mLogin);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error");
                    p.PConsignar.monto.setText(null);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}