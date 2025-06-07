package com.helpdeskhub.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationDTO {
    private String recipient;
    private Integer ticketId;
    private String ticketTitle;
    private String commentText;
    private String employeeName;
    private String status;
}
