package Result;

public class LoadResult {

    private String message;
    private boolean success;

    /**
     * this is a constructor to load the results
     * @param message
     * @param success
     */
    public LoadResult(String message, boolean success) {
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
