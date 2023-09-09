package com.ms.exception;

/**
 * This is @CustomErrorResponse class.
 */
public class CustomApiResponse {
    /**
     * This is success.
     */
    private boolean success;
    /**
     * This is object.
     */
    private Object object;

    /**
     * This is isSuccess.
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * This is setSuccess.
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * This is getObject.
     * @return object
     */
    public Object getObject() {
        return object;
    }

    /**
     * This is setObject.
     * @param object
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * This is CustomApiResponse.
     * @param success
     * @param object
     */
    public CustomApiResponse(boolean success, Object object) {
        super();
        this.success = success;
        this.object = object;
    }

    /**
     * This is CustomApiResponse.
     */
    public CustomApiResponse() {
        super();
    }
}
