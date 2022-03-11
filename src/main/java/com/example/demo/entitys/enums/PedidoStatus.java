package com.example.demo.entitys.enums;

public enum PedidoStatus {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	DELIVERED(3),
	CANCELADO(4);
	
	private int code;
	
	private PedidoStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static PedidoStatus valorPedido(int code) {
		
		for(PedidoStatus pedido : PedidoStatus.values()) {
			if(pedido.getCode() == code) {
				return pedido;
			}
		}
		throw new IllegalArgumentException("codigo null");
	}
	
}
