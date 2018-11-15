package com.carolinathomaz.api.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Diario implements Serializable{
     private static final long serialVersionUID = 1L;

     private String id;
     private String palavra;
     private String obs;
     private Date date;
     
     
	public Diario(String id, String palavra, String obs, Date date) {
		this.id = id;
		this.palavra = palavra;
		this.obs = obs;
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diario other = (Diario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Diario [id=");
		builder.append(id);
		builder.append(", palavra=");
		builder.append(palavra);
		builder.append(", obs=");
		builder.append(obs);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
     
     
	
}
