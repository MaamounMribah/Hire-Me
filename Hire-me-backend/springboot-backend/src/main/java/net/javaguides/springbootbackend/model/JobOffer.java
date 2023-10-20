package net.javaguides.springbootbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jobOffers")
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pubId;
    @Column(name = "description")
    private String description;
    @Column(name = "skill")
    private String skill;
    @Column(name = "titre")
    private String titre;
    @Column(name = "user_pub")
    private String userPub;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public JobOffer(){

    }

    public JobOffer(String description, String skill, String titre, String userPub) {
        this.description = description;
        this.skill = skill;
        this.titre = titre;
        this.userPub = userPub;
    }

    public int getPubId() {
        return pubId;
    }

    public void setPubId(int pubId) {
        this.pubId = pubId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getUserPub() {
        return userPub;
    }

    public void setUserPub(String userPub) {
        this.userPub = userPub;
    }
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
