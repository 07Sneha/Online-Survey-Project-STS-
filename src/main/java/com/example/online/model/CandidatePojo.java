package com.example.online.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Candidate")
public class CandidatePojo {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "priority", nullable = false)
    private int priority;

    @Column(name = "authority", nullable = false)
    private String authority;
    
         public CandidatePojo() {
		
	        }

    public CandidatePojo(String firstName, String lastName, String email, String password, int priority, String authority) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.priority = priority;
        this.authority = authority;
    }
    
    
  
    public Long getId() {
	return id;}

     public String getFirstName() {
	      return firstName;
       }

     public void setFirstName(String firstName) {
	       this.firstName = firstName;
        }

     public String getLastName() {
	          return lastName;
        }

     public void setLastName(String lastName) {
	          this.lastName = lastName;
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

     public int getPriority() {
	        return priority;
          }

     public void setPriority(int priority) {
	      this.priority = priority;
         }

     public String getAuthority() {
	       return authority;
           }

     public void setAuthority(String authority) {
	        this.authority = authority;
           }
	
}
