package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IFormateurDAO;
import fr.adaming.model.Formateur;

@Service
@Transactional
public class FormateurServiceImpl implements IFormateurService {

	@Autowired
	private IFormateurDAO formateurDAO;

	public void setFormateurDAO(IFormateurDAO formateurDAO) {
		this.formateurDAO = formateurDAO;
	}

	@Override
	public Formateur getFormateurByMail(String mail) {
		return formateurDAO.getFormateurByMail(mail);
	}

}
