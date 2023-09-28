package factory;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;



public class ConnectionFactory {
	
	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hotelalurabd");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("Grt1508*");
		
		this.dataSource = (DataSource) comboPooledDataSource;
	}
	
	public Connection recuperarConexao() {
		try {
			return this.dataSource.getConnection();
		}
		catch(SQLException e){
			throw new RuntimeException(e.getMessage());
		}
		
	}
}


