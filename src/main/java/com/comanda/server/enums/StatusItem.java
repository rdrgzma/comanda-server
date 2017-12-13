package com.comanda.server.enums;

public enum StatusItem {
	INCLUIDO(0,"INCLUIDO"),
	ATENDIMENTO(1,"EM ATENDIMENTO"),
	ATENDIDO(2,"ATENDIDO"),
	CANCELADO(3,"CANCELADO");
	
	private Integer cod;
	private String status;
	
	private StatusItem(Integer cod, String status) {
		this.cod = cod;
		this.status = status;
	}

	public Integer getCod() {
		return cod;
	}

	public String getStatus() {
		return status;
	}
	
    public static StatusItem toEnumCod(Integer cod) {
    		if(cod == null) {
    			return null;
    		} 
    		
    		for( StatusItem s : StatusItem.values()) {
    			if(cod.equals(s.getCod())) {
    				return s;
    			}
    		}
    		
    		throw new IllegalArgumentException("Status Invalido: "+cod);
    }
    
    public static StatusItem toEnumString(String str) {
		if(str.isEmpty()) {
			return null;
		} 
		
		for( StatusItem s : StatusItem.values()) {
			if(str.equalsIgnoreCase(s.getStatus())) {
				return s;
			}
		}
		
		throw new IllegalArgumentException("Status Invalido: "+str);
    }
}
