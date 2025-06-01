package com.helpdeskhub.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationRequestDTO {
    private String recipient;
    private String ticketId;
    private String ticketTitle;
    private String commentText;
    private String agentName;
    private String status;
}
