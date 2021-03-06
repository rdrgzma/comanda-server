package com.comanda.server.enums;

public enum StatusPedido {
	ABERTO(0,"ABERTO"),
	ENCERRAMENTO(1,"EM ENCERRAMENTO"),
	FINALIZADO(2,"FINALIZADO"),
	CANCELADO(3,"CANCELADO"); 
	
	private Integer cod;
	private String status;
	
	private StatusPedido(Integer cod, String status) {
		this.cod = cod;
		this.status = status;
	}

	public Integer getCod() {
		return cod;
	}

	public String getStatus() {
		return status;
	}
	
    public static StatusPedido toEnumCod(Integer cod) {
    		if(cod == null) {
    			return null;
    		} 
    		
    		for( StatusPedido s : StatusPedido.values()) {
    			if(cod.equals(s.getCod())) {
    				return s;
    			}
    		}
    		
    		throw new IllegalArgumentException("Status Invalido: "+cod);
    }
    
    public static StatusPedido toEnumString(String str) {
		if(str.isEmpty()) {
			return null;
		} 
		
		for( StatusPedido s : StatusPedido.values()) {
			if(str.equalsIgnoreCase(s.getStatus())) {
				return s;
			}
		}
		
		throw new IllegalArgumentException("Status Invalido: "+str);
    }
}
