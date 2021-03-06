package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma){
		
		final String sql = "SELECT nome "+
				   "FROM parola "+
				   "WHERE nome=?";

		String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root";

		boolean corretto=false;

		try {
				Connection conn = DriverManager.getConnection(jdbcUrl);
				PreparedStatement st = conn.prepareStatement(sql);

				st.setString(1, anagramma);
				
				ResultSet rs = st.executeQuery();

				if (rs.next()) 
					corretto=true;

		conn.close();
	
		return corretto;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		}

	}
