package jp.co.brightstar.dvd.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class User {
	private String username;
    private String password;
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
}
}
