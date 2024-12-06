package org.formation.service.event;

import lombok.Data;

@Data
public class TicketStatusEvent {

	private Long ticketId;
	
	long orderId;

	
	private String status;
	
	
}
