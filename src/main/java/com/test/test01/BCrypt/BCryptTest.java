package com.test.test01.BCrypt;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @ClassName: com.test.test01.BCrypt.BCrypt
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/5/9 16:27
 * @Version: 1.0
 */
public class BCryptTest {

    public static void main(String[] args) {
        //加密
        String password = "12345";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);
        password = "123456";
        //解密
        boolean checkpw = BCrypt.checkpw(password,hashed );
        System.out.println(checkpw);
        /*PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String test1=  passwordEncoder.encode("admin");
        System.out.println(test1);
        String test2=  passwordEncoder.encode("admin");
        System.out.println(test2);
        System.out.println(passwordEncoder.matches("admin",test1));
        System.out.println(passwordEncoder.matches("admin",test2));*/

        /*String password2 = "12345";
        String hashed2 = BCrypt.hashpw(password2, BCrypt.gensalt());
        System.out.println(hashed);

        //解密
        boolean checkpw2 = BCrypt.checkpw(password2,hashed2 );
        System.out.println(checkpw);*/
    }

}
