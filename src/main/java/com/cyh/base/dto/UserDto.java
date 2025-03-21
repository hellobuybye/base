package com.cyh.base.dto;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cyh.base.validate.SampleValidates;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class UserDto extends BaseDto implements UserDetails{

    // @NotEmpty(groups = SampleValidates.Group1.class, message = "test message 1")
    private String userId;
    // @NotEmpty(groups = SampleValidates.Group1.class, message = "test message 22")
    private String password;
    private String hashedPassword;
    
    private String name;

    


    // 계정의 권한목록을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // Collection <GrantedAuthority> collector = new ArrayList<>();

        // collector.add(() ->{
        //     return "계정별 등록할 권한";
        // });

        // return collector;

        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    // 계정 만료여부 (true : 유효, false : 만료)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정 잠금여부 (true : 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호 만료 여부 (true : 만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 사용가능 여부 (true : 가능)
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password){
                
        this.password = password;
        
        if( isNull(password) ){
            this.setHashedPassword(null);
        }else{
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();        
            this.setHashedPassword(encoder.encode(password));
        }
        
    }

}
