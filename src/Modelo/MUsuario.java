package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controlador.CLogin;
import Vista.VLogin;
import Vista.VUsuario;

public class MUsuario {

//	VLogin vLogin = new VLogin();
	NumberFormat format = NumberFormat.getInstance(new Locale("es", "COL"));
	Conexion conexion = new Conexion();
	Cliente cliente = new Cliente();

	Double retirado;
	Double dinero;

	Connection connection = null;
	String accion = cliente.getAccion();

	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public void salir(VUsuario vUsuario) {

		VLogin vLogin = new VLogin();
		MLogin mLogin = new MLogin();
		CLogin cLogin = new CLogin(vLogin, mLogin);
		vLogin.setVisible(true);
		vUsuario.dispose();
	}

	public void abrirVTransferir(VUsuario vUsuario) {
		vUsuario.panelP.setVisible(false);
		vUsuario.panelT.setVisible(true);

	}
	
   public void listaTransacciones(VUsuario vUsuario, MLogin mLogin){
        String rango;
        String sql;
        String dinero;
        String usuarios[] = new String[5];
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("ID destino");
        model.addColumn("Fecha");
        model.addColumn("Accion");
        model.addColumn("Dinero");
        
        vUsuario.table.setModel(model);

        rango = String.valueOf(mLogin.cliente.getRango());
            try {
            
            if(rango.equals("A")){
                sql = "SELECT * FROM movimientos ORDER BY fecha DESC";
            }else{
                sql = "SELECT * FROM movimientos WHERE nID= ? OR nID_Des= ? ORDER BY fecha DESC";
            }
            
            
//            NumberFormat nf = NumberFormat.getInstance(new Locale("es", "COL"));
            connection = conexion.getConection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mLogin.cliente.getID());
            preparedStatement.setString(2, mLogin.cliente.getID());
            resultSet = preparedStatement.executeQuery();
        
            
            while(resultSet.next()==true){
                dinero = format.format(resultSet.getDouble(5));

                usuarios[0] = resultSet.getString(1);
                usuarios[1] = resultSet.getString(3);
                usuarios[2] = resultSet.getString(2);
                usuarios[3] = resultSet.getString(4);
                usuarios[4] = dinero;
                model.addRow(usuarios);
            }
            vUsuario.table.setModel(model);
            vUsuario.table.getColumnModel().getColumn(2).setPreferredWidth(150);
            vUsuario.table.getTableHeader().setReorderingAllowed(false);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   

	public void abrirVMovimientos(VUsuario vUsuario, MLogin mLogin) {
		vUsuario.panelP.setVisible(false);
		vUsuario.panelM.setVisible(true);
		listaTransacciones(vUsuario, mLogin);

	}

	public void volver(VUsuario vUsuario) {
		vUsuario.panelP.setVisible(true);
		vUsuario.panelT.setVisible(false);
		vUsuario.panelM.setVisible(false);
	}

	public void mostrarDatos(VUsuario vUsuario, MLogin mLogin) {
		try {
			connection = Conexion.getConection();
			preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE nID = ?");
			preparedStatement.setString(1, mLogin.cliente.getID());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				mLogin.cliente.setDinero(resultSet.getDouble("dinero"));
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}

//		NumberFormat nf = NumberFormat.getInstance(new Locale("es", "COL"));
		
		vUsuario.lblNombre.setText(mLogin.cliente.getNombre());
		vUsuario.lblApellido.setText(mLogin.cliente.getApellido());
		vUsuario.lblId.setText(mLogin.cliente.getID());
		vUsuario.lblFecha.setText(java.time.LocalDateTime.now().toLocalDate().toString());
		vUsuario.lblDinero.setText(format.format(mLogin.cliente.getDinero()));
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM frases WHERE id=?");
			preparedStatement.setString(1, String.valueOf(Math.floor(Math.random()*10+1)));
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			vUsuario.txtFrase.setText(resultSet.getString(2)+"\n-\""+resultSet.getString(3)+"\"");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
   public void actualizar(MLogin mLogin) {
        try {
            connection = conexion.getConection();
            preparedStatement = connection.prepareStatement("UPDATE usuarios SET dinero = ? WHERE nID = ?");
            preparedStatement.setDouble(1, mLogin.cliente.getDinero());
            preparedStatement.setString(2, mLogin.cliente.getID());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registrar(MLogin mLogin, VUsuario vUsuario) {
        try {
            connection = conexion.getConection();
            preparedStatement = connection.prepareStatement("INSERT INTO movimientos (nID, fecha, nID_Des, accion, monto) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, mLogin.cliente.getID());
            preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            preparedStatement.setString(3, vUsuario.id.getText());
            preparedStatement.setString(4, accion);
            preparedStatement.setDouble(5, retirado);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

	public void trasferir(VUsuario vUsuario, MLogin mLogin) {
		accion = "Transferencia";
		try {
			connection = conexion.getConection();
			preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE nID = ?");
			preparedStatement.setString(1, vUsuario.id.getText());

			
			if (vUsuario.monto.getText().equals("") || vUsuario.id.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Hay campos vacio");
			} else {
				retirado = Double.parseDouble(vUsuario.monto.getText());
				resultSet = preparedStatement.executeQuery();
				
				if (retirado <= 0 || retirado > mLogin.cliente.getDinero() || resultSet.next() != true) {
					JOptionPane.showMessageDialog(null, "Valor no validos");
				} else {
					Double dineroU = resultSet.getDouble("dinero");
					dineroU = dineroU + retirado;
					dinero = mLogin.cliente.getDinero() - retirado;
					mLogin.cliente.setDinero(dinero);

					preparedStatement = connection.prepareStatement("UPDATE usuarios SET dinero = '" + dineroU + "' WHERE nID = ?");
					preparedStatement.setString(1, vUsuario.id.getText());
					preparedStatement.executeUpdate();

					actualizar(mLogin);

					if (vUsuario.id.getText().equals(mLogin.cliente.getID())) {
						JOptionPane.showMessageDialog(null, "No se puede hacer la transaccion a su propia cuenta");
						vUsuario.id.setText(null);
						vUsuario.monto.setText(null);
					} else {
						int res = preparedStatement.executeUpdate();
						if (res > 0) {
							JOptionPane.showMessageDialog(null, "Transferencia exitosa");
							registrar(mLogin,vUsuario);
							vUsuario.id.setText(null);
							vUsuario.monto.setText(null);

						} else {
							JOptionPane.showMessageDialog(null, "Ocurrio un error");
							vUsuario.id.setText(null);
							vUsuario.monto.setText(null);
						}
					}

				}
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
