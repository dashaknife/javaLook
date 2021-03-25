package Volos.clothes.model.enums;

import Volos.clothes.exception.WrongInputException;

public enum RoleType {
    User ("User"),
    Editor ("Editor"),
    Admin ("Admin"),;
    private String role_s;

    RoleType(String role_s) {
        this.role_s = role_s;
    }

    public String getRole_s() {
        return role_s;
    }

    public static RoleType getTypeByUrl(String url) throws WrongInputException {
        for (RoleType env : values()) {
            if (env.getRole_s().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("None role found with url: [" + url + "]");
    }

    @Override
    public String toString() {
        return "Role: "+ role_s;
    }
}
