// package com.cyh.base.entity;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.Collection;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import lombok.AccessLevel;
// import lombok.Builder;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.NoArgsConstructor;

// @EqualsAndHashCode( of = {"id"})
// @NoArgsConstructor(access = AccessLevel.PROTECTED)
// @Getter
// @Entity
// public class Member extends BaseTimeEntity implements UserDetails {

//     private static final long serialVersionUID = 1L;

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String email;
//     private String pwd;
//     private LocalDateTime lastLoginTime;

//     @Builder
//     public Member(Long id, String email, String pwd, LocalDateTime lastLoginTime) {
//         this.id = id;
//         this.email = email;
//         this.pwd = pwd;
//         this.lastLoginTime = lastLoginTime;
//     }

//     // 계정의 권한목록을 리턴
//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {

//         Collection <GrantedAuthority> collector = new ArrayList<>();

//         collector.add(() ->{
//             return "계정별 등록할 권한";
//         });

//         return collector;
//     }

//     @Override
//     public String getPassword() {
//         return this.pwd;
//     }

//     @Override
//     public String getUsername() {
//         return this.email;
//     }

//     // 계정 만료여부 (true : 만료)
//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     // 계정 잠금여부 (true : 잠기지 않음)
//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     // 비밀번호 만료 여부 (true : 만료 안됨)
//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     // 계정 사용가능 여부 (true : 가능)
//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
// }
