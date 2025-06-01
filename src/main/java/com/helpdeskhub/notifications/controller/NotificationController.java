package com.helpdeskhub.notifications.controller;

import com.helpdeskhub.notifications.dto.NotificationRequestDTO;
import com.helpdeskhub.notifications.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private EmailNotificationService emailService;

    @PostMapping("/new-comment")
    public ResponseEntity<String> notifyNewComment(@RequestBody NotificationRequestDTO request) {
        emailService.sendNewCommentNotification(request.getRecipient(),
                request.getTicketId(), request.getTicketTitle(), request.getCommentText());
        return ResponseEntity.ok("Comment notification sent");
    }

    @PostMapping("/agent-assigned")
    public ResponseEntity<String> notifyAgentAssigned(@RequestBody NotificationRequestDTO request) {
        emailService.sendAgentAssignedNotification(request.getRecipient(),
                request.getTicketId(), request.getTicketTitle(), request.getAgentName());
        return ResponseEntity.ok("Agent assignment notification sent");
    }

    @PostMapping("/status-changed")
    public ResponseEntity<String> notifyStatusChanged(@RequestBody NotificationRequestDTO request) {
        emailService.sendStatusChangedNotification(request.getRecipient(),
                request.getTicketId(), request.getTicketTitle(), request.getStatus());
        return ResponseEntity.ok("Status change notification sent");
    }
}