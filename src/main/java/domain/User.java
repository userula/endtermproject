package domain;

import java.util.Date;

public class User {
    private static int id_gen = 0;
    private static int max = 0;
    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Date birthday;
    private String role;
    private Playlist playlist;

    public User(int id, String name, String surname, String username, String password, Date birthday, String role) {
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
        setBirthday(birthday);
        setRole(role);
    }

    public User(int id, String name, String surname, String username, Date birthday) {
        setId(id);
        setName(name);
        setSurname(surname);
        setUsername(username);
        setBirthday(birthday);
    }

    public User(int id, String name, String surname, String username, Date birthday, String role) {
        setId(id);
        setName(name);
        setSurname(surname);
        setUsername(username);
        setBirthday(birthday);
        setRole(role);
    }

    public void addPlaylist()
    {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
