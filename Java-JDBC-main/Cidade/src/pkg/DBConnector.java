package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
	
	public Connection connection;
	
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC","root","info2k21");
	
		return connection;
	}

    
    public ResultSet select(String sql) throws Exception {
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery();
        return resultado;
}
    
    public void inserir(String sql) throws Exception {
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.execute();
        connection.commit();
    }
	
	 public void inserirCidade(Cidade cidade) throws SQLException{
         String sql = "insert into cidade(id, nome, cep, uf) values(?,?,?,?);";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setInt(1, cidade.getId());
         stm.setString(2, cidade.getNome()); 
         stm.setString(3, cidade.getCep());
         stm.setString(4, cidade.getUf());
         stm.execute();
         connection.commit();
     }
	 
	
}
