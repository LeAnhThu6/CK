package com.example.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
        @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email"),
        @NamedQuery(name = "Account.findByEmailAndPassword", query = "SELECT a FROM Account a WHERE a.email = :email AND a.password = :password"),
        @NamedQuery(name = "Account.findByEmailAndStatus", query = "SELECT a FROM Account a WHERE a.email = :email AND a.status = :status"),
        @NamedQuery(name = "Account.findByEmailAndRole", query = "SELECT a FROM Account a WHERE a.email = :email AND a.role = :role"),
        @NamedQuery(name = "Account.findByEmailAndPasswordAndStatus", query = "SELECT a FROM Account a WHERE a.email = :email AND a.password = :password AND a.status = :status"),
        @NamedQuery(name = "Account.findByEmailAndPasswordAndRole", query = "SELECT a FROM Account a WHERE a.email = :email AND a.password = :password AND a.role = :role"),
        @NamedQuery(name = "Account.findByEmailAndStatusAndRole", query = "SELECT a FROM Account a WHERE a.email = :email AND a.status = :status AND a.role = :role"),
        @NamedQuery(name = "Account.findByEmailAndPasswordAndStatusAndRole", query = "SELECT a FROM Account a WHERE a.email = :email AND a.password = :password AND a.status = :status AND a.role = :role"),
        @NamedQuery(name = "Account.findByFullName", query = "SELECT a FROM Account a WHERE a.fullName = :fullName"),
        @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
        @NamedQuery(name = "Account.findByPhone", query = "SELECT a FROM Account a WHERE a.phone = :phone"),
        @NamedQuery(name = "Account.findByStatus", query = "SELECT a FROM Account a WHERE a.status = :status"),
        @NamedQuery(name = "Account.findByRole", query = "SELECT a FROM Account a WHERE a.role = :role"),
        @NamedQuery(name = "Account.findByFullNameAndPassword", query = "SELECT a FROM Account a WHERE a.fullName = :fullName AND a.password = :password"),
        @NamedQuery(name = "Account.findByFullNameAndStatus", query = "SELECT a FROM Account a WHERE a.fullName = :fullName AND a.status = :status"),
})
public class Account {
    @Id
    @Column(nullable = false, name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String password;
    private String email;
    private String phone;
    private String status;
    private String role;

    public Account(String fullName, String password, String email, String phone, String status, String role) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.role = role;
    }



    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
