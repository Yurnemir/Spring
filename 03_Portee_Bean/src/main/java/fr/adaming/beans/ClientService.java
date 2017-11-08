package fr.adaming.beans;

import java.io.Serializable;

public class ClientService implements Serializable {

	private String message;
	
	public ClientService(){
		super();
	}

	public ClientService(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ClientService [message=" + message + "]";
	}
	
}
