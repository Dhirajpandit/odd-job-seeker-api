//package com.job.portals.RozgarBazar.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.validation.constraints.NotNull;
//import java.util.Date;
//
//@Entity
//public class Notification {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull
//    private Long userId;
//
//    @NotNull
//    private String message;
//
//    @NotNull
//    @Enumerated(EnumType.STRING)
//    private NotificationType type;
//
//    private boolean read = false;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt = new Date();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public NotificationType getType() {
//        return type;
//    }
//
//    public void setType(NotificationType type) {
//        this.type = type;
//    }
//
//    public boolean isRead() {
//        return read;
//    }
//
//    public void setRead(boolean read) {
//        this.read = read;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public enum NotificationType {
//        INFO,
//        WARNING,
//        ERROR
//    }
//}
