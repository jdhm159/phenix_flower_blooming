package com.dexin.phenixflowerblooming.shiro;

import java.io.*;
import lombok.Data;

@Data
public class AccountProfile implements Serializable {
    private Integer id;
    private String username;
    private String image;
    private Integer isPoverty;
    private Integer isVolunteer;
    private Integer isAdministrator;
}