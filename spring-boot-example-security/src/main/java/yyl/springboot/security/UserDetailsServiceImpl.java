package yyl.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

// @Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username: " + username);

        // 根据用户名，查找到对应的密码，与权限
        // TODO 此处只是示例，用户名与密码一致
        String password = passwordEncoder.encode(username);
        System.out.println("password: " + password);

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        User user = new User(username, password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

        return user;
    }
}
// | [org.springframework.security.core.userdetails.UserDetails] 接口方法：
// | // 登录用户名
// | String getUsername();
// | // 密码信息
// | String getPassword();
// | // 权限信息
// | Collection<? extends GrantedAuthority> getAuthorities();
// | // 帐户是否过期
// | boolean isAccountNonExpired();
// | // 帐户是否被冻结
// | boolean isAccountNonLocked();
// | // 帐户密码是否过期
// | boolean isCredentialsNonExpired();
// | // 帐号是否可用
// | boolean isEnabled();
