package edu.drexel.TrainDemo.models;

public class SearchModel {
    private String fromStop;
    private String toStop;

	public SearchModel(){
		
	}

    public SearchModel(String fromStop, String toStop) {
        this.fromStop = fromStop;
        this.toStop = toStop;
    }


    public String getFromStop() {
        return fromStop;
    }

    public void setFromStop(String fromStop) {
        this.fromStop = fromStop;
    }

    public String getToStop() {
        return toStop;
    }

    public void setToStop(String toStop) {
        this.toStop = toStop;
    }
}

