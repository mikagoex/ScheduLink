package schedulink.schedulink;

import android.app.Application;

/**
 * Created by Michael on 16-03-02.
 */
public class Global extends Application {

    private Uzer mainUzer;

    public Global() {
        this.mainUzer = new Uzer("Mike", "temp@email.com"); //temporary, remove later
    }

    public Uzer getMainUzer() {
        return mainUzer;
    }

    public void setMainUzer(Uzer mainUzer) {
        this.mainUzer = mainUzer;
    }


}
