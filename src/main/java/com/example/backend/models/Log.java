package com.example.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Entity
@Table(name = "log")
public class Log {
    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private Date loginTime;
    private Date logoutTime;
    private String note;

    public Log(Account account, Date loginTime, Date logoutTime, String note) {
        this.account = account;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.note = note;
    }

    public Log(Long id, Account account, Date loginTime, Date logoutTime, String note) {
        this.id = id;
        this.account = account;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.note = note;
    }

    public Log() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", account=" + account +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", note='" + note + '\'' +
                '}';
    }
}
