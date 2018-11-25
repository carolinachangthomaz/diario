package com.carolinathomaz.api.dto;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import com.carolinathomaz.api.domain.Diario;

public class DiarioDto {

	private String id;
    private String palavra;
    private String obs;
    private String  date;
    
    
	public DiarioDto() {
	}
	
	public DiarioDto(Diario diario) {
		this.id = diario.getId();
		this.palavra = diario.getPalavra();
		this.obs = diario.getObs();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String dateFormat = diario.getDate().format(formatters);
		this.date = dateFormat;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
		DiarioDto other = (DiarioDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}
