package com.example.benproject.infra;

public class ApiResponse<T> {

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

        public ApiResponseBuilder<T> concatMessageIfPresent(String str) {
            if (this.message != null && str != null)
                this.message += " " + str;
            return this;
        }

        public ApiResponseBuilder<T> ok() {
            return this.status(Code.OK);
        }

        public ApiResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResponse<T> build() {
            if (this.code == 0 || this.message == null)
                throw new RuntimeException();
            return new ApiResponse<>(this);
        }
    }


}
