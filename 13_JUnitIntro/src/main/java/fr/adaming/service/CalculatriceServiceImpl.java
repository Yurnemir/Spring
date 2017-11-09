package fr.adaming.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatriceServiceImpl implements ICalculatriceService {

	@Override
	public Long addition(Long a, Long b) {
		return a + b;
	}

	@Override
	public Character lireSymbole() {
		return new Character(' ');
	}

}
