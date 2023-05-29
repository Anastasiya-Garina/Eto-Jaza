package com.example.mother_pls_help;

public class User {
    private String first_name;
    private String last_name;
    private String middle_name;
    private String nickname;
    private String email;
    private String password;
    private String codeword;
    private String date_birth;

    public User() {

    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodeword() {
        return codeword;
    }

    public void setCodeword(String codeword) {
        this.codeword = codeword;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public User(String first_name, String last_name, String middle_name, String nickname, String email, String password, String codeword, String date_birth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.codeword = codeword;
        this.date_birth = date_birth;
    }

}
