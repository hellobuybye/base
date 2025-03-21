// package com.cyh.base.entity;

// import lombok.Getter;
// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.LastModifiedDate;
// import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// import javax.persistence.EntityListeners;
// import javax.persistence.MappedSuperclass;
// import java.time.LocalDateTime;

// @Getter
// @MappedSuperclass
// @EntityListeners(AuditingEntityListener.class)
// public class BaseTimeEntity {

//     @CreatedDate
//     private LocalDateTime registerTime;

//     @LastModifiedDate
//     private LocalDateTime	updateTime;
// }