//package com.job.portals.RozgarBazar.service;
//
//import com.job.portals.RozgarBazar.entity.Notification;
//import com.job.portals.RozgarBazar.repository.NotificationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class NotificationService {
//
//    @Autowired
//    private NotificationRepository notificationRepository;
//
//    public Notification createNotification(Long userId, String message, Notification.NotificationType type) {
//        Notification notification = new Notification();
//        notification.setUserId(userId);
//        notification.setMessage(message);
//        notification.setType(type);
//        return notificationRepository.save(notification);
//    }
//
//    public List<Notification> getUserNotifications(Long userId) {
//        return notificationRepository.findByUserId(userId);
//    }
//
//    public Optional<Notification> markNotificationAsRead(Long id) {
//        Optional<Notification> notification = notificationRepository.findById(id);
//        notification.ifPresent(n -> {
//            n.setRead(true);
//            notificationRepository.save(n);
//        });
//        return notification;
//    }
//}
