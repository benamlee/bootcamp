package com.example.demoresttemplate.infra;

public class ApiResponse<T> {
    // attribute name by default same as JSON field name after serialization
    private int code;
    private String message;
    private T data;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public static <T> ApiResponseBuilder<T> builder() {
        return new ApiResponseBuilder<>();
    }

    private ApiResponse(ApiResponseBuilder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    public static class ApiResponseBuilder<T> {
        private int code;
        private String message;
        private T data;

        public ApiResponseBuilder<T> status(Code code) {
            this.code = code.getCode();
            this.message = code.getDesc();
            return this;
        }

        // public ApiResponseBuilder<T> ok() {
        // this.code = Code.OK.getCode();
        // this.message = Code.OK.getDesc();
        // return this;
        // }

        public ApiResponseBuilder<T> ok() {
            return this.status(Code.OK);
        }

        public ApiResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResponse<T> build() {
            if (this.code == 0 || this.message == null)
                throw new RuntimeException(); // 封死.state要有野
            return new ApiResponse<>(this);
        }

        // builder pattern作用，只能在build object時set好attribute，之後就冇得再set改變

    }
}

// {
// "code" : 200,
// "message" : "OK",
// "data" : [

// ],
// "error" : [
// "", ""
// ]
// }
