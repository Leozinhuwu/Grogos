package br.edu.unifacear.bd;

import javax.persistence.*;

public class CBanco {
	static EntityManagerFactory con = Persistence.createEntityManagerFactory("Nome_Da_Unit_De_Persistencia");

	public static EntityManager getConnection() { // getConnection() {
		return con.createEntityManager();
	}

}
