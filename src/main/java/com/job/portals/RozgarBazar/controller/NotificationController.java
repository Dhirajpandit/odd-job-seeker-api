//package com.job.portals.RozgarBazar.controller;
//
//import com.job.portals.RozgarBazar.entity.Notification;
//import com.job.portals.RozgarBazar.service.NotificationService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/notifications")
//public class NotificationController {
//
//    @Autowired
//    private NotificationService notificationService;
//
//    @PostMapping
//    public ResponseEntity<Notification> createNotification(@RequestBody Notification request) {
//        Notification notification = notificationService.createNotification(
//                request.getUserId(),
//                request.getMessage(),
//                request.getType()
//        );
//        return new ResponseEntity<>(notification, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable Long userId) {
//        List<Notification> notifications = notificationService.getUserNotifications(userId);
//        return new ResponseEntity<>(notifications, HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}/read")
//    public ResponseEntity<Notification> markAsRead(@PathVariable Long id) {
//        Optional<Notification> notification = notificationService.markNotificationAsRead(id);
//        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//}
