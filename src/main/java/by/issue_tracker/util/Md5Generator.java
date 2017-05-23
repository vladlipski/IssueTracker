package by.issue_tracker.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Md5Generator {

    public String generate(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] bytePassword = md.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytePassword)
                stringBuffer.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
