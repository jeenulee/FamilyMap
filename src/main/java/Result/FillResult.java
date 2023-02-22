package Result;

public class FillResult {

    private String message;
    private boolean success;

    /**
     * This is a constructor for the Fill Result class
     * @param message
     * @param success
     */
    public FillResult(String message, boolean success) {
        this.message = message;
        this.success = success;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
