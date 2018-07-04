package models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

@Entity
@Table(name="games")
public class Game {

    private int id;
    private String title;
    private Genre genre;
    private List<Console> consoles;

    public Game(){
        }

    public Game(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
        this.consoles = new ArrayList<Console>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="genre")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @ManyToMany
    @JoinTable(name="console_id",
            joinColumns = {@JoinColumn(name="game_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name ="console_id", nullable = false, updatable = false)})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public List<Console> getConsoles() {
        return consoles;
    }

    public void setConsoles(List<Console> consoles) {
        this.consoles = consoles;
    }

    public void addConsole(Console console){
        this.consoles.add(console);
    }
}
