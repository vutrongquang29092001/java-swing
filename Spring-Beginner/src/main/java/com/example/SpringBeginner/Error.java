package com.example.SpringBeginner;

public enum Error {
    NOT_FOUND(404,"Không tìm thấy"),
    UNAUTHORIZED(401,"Không được cấp quyền"),
    INVALID_INPUT_PARAMS(400,"Thiếu dữ liệu đầu vào");
    private int code;
    private String message;
    private Error(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
