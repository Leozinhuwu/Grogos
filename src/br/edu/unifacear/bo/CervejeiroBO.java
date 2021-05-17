package br.edu.unifacear.bo;



import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.dao.CervejeiroDao;

public class CervejeiroBO {
	private static CervejeiroDao cervejeiroCrud = new CervejeiroDao();
	
	public void registerCervejeiro(Cervejeiro usuario) throws Exception {
	
		cervejeiroCrud.save(usuario);
	}
	
	public String findUserName(Cervejeiro user) throws Exception{
		String name = cervejeiroCrud.findName(user);
		return name;
	}
	
	public Object findCervejeiro(Cervejeiro cervejeiro) {
		// TODO Auto-generated method stub
		return cervejeiroCrud.findSingleObj(cervejeiro);
	}

	public void deletar(Cervejeiro cervejeiro) throws Exception {
		cervejeiroCrud.delete(cervejeiro);
		
	}

}
