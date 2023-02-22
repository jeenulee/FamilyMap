package Result;
import Model.Event;

public class EventResult {

    Event[] data;
    private boolean success;


    /**
     * This is a constructor for the Event Results
     * @param data
     * @param success
     */
    public EventResult(Event[] data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public Event[] getData() {
        return data;
    }

    public void setData(Event[] data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
