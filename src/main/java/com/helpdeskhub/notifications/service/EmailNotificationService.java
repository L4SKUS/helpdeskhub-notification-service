package com.helpdeskhub.notifications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendNewCommentNotification(String recipient, String ticketId, String ticketTitle, String commentText) {
        String subject = "New Comment on Your Ticket #" + ticketId;
        String message = "Hello,\n\nA new comment has been added to your ticket titled \"" + ticketTitle + "\".\n\n"
                + "Comment:\n" + commentText + "\n\n"
                + "View your ticket for more details.\n\nHelpdesk Team";
        sendEmail(recipient, subject, message);
    }

    public void sendEmployeeAssignedNotification(String recipient, String ticketId, String ticketTitle, String employeeName) {
        String subject = "Helpdesk Employee Has Been Assigned to Your Ticket #" + ticketId;
        String message = "Hello,\n\nEmployee " + employeeName + " has been assigned to your ticket titled \"" + ticketTitle + "\".\n\n"
                + "They will contact you shortly.\n\nHelpdesk Team";
        sendEmail(recipient, subject, message);
    }

    public void sendStatusChangedNotification(String recipient, String ticketId, String ticketTitle, String status) {
        String subject = "Status Changed for Your Ticket #" + ticketId;
        String message = "Hello,\n\nThe status of your ticket \"" + ticketTitle + "\" (ID: " + ticketId + ") has changed to: " + status + ".\n\n"
                + "You can view the ticket for more information.\n\nHelpdesk Team";
        sendEmail(recipient, subject, message);
    }

    private void sendEmail(String recipient, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
