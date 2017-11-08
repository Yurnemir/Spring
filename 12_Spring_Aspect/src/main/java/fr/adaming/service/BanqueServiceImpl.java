package fr.adaming.service;

public class BanqueServiceImpl implements IBanqueService {

	private double solde = 200;
	
	@Override
	public double retrait(double somme) {
		if(solde >= somme){
			return solde-somme;
		} else {
			throw new IllegalArgumentException("Pas assez d'argent");
		}
		
	}

}
