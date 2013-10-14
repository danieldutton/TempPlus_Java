package observer;

import model.Temperature;

public interface Observer {

    public void update(Temperature temperature);

    public void setSubject(Subject sub);
}
