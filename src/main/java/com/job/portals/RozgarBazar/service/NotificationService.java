package com.job.portals.RozgarBazar.service;

import com.job.portals.RozgarBazar.entity.Notification;
import com.job.portals.RozgarBazar.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.job.portals.RozgarBazar.exception.NotificationNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public Notification createNotification(Long userId, String message, Notification.NotificationType type) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setType(type);
        return notificationRepository.save(notification);
    }

    public List<Notification> getUserNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    @Transactional
    public Optional<Notification> markNotificationAsRead(Long id) {
        Optional<Notification> optionalNotification = notificationRepository.findById(id);

        if (optionalNotification.isEmpty()) {
            throw new NotificationNotFoundException("Notification not found with ID: " + id);
        }

        Notification notification = optionalNotification.get();
        notification.setRead(true);
        notificationRepository.save(notification);

        return Optional.of(notification);
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found with ID: " + id));
    }
}
