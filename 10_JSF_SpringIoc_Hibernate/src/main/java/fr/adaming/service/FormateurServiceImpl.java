package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IFormateurDao;
import fr.adaming.model.Formateur;

@Service("fService") // // anotation pour le definir comme un bean
@Transactional // pour specifer au conten eur spring que toutes les methodes de
				// la classe sont transactionnelles
public class FormateurServiceImpl implements IFormateurService {

	@Autowired
	private IFormateurDao formateurDao;

	// un setters pour l'injection de dependance
	public void setFormateurDao(IFormateurDao formateurDao) {
		this.formateurDao = formateurDao;
	}

	@Override
	public Formateur isExist(Formateur f) {
		return formateurDao.isExist(f);
	}

}
