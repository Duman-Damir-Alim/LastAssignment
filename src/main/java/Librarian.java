public class Librarian implements User {
    private int lib_id;
    private String username;
    private String password;

    public Librarian(int lib_id, String username, String password) {
        this.lib_id = lib_id;
        this.username = username;
        this.password = password;
    }

    public int getLib_id() {
        return lib_id;
    }

    public void setLib_id(int lib_id) {
        this.lib_id = lib_id;
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
}
