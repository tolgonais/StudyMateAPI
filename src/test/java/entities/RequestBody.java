package entities;

import lombok.Data;

@Data
public class RequestBody {
    private String email;
    private String password;
    private String text;
    private int groupId;

}

