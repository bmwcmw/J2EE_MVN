package j2ee.mvn.a_prediction;

import java.io.Serializable;

public class Prediction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5099356422068933375L;
	
	private String who; // person
	private String what; // his/her prediction

	public Prediction() {
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getWho() {
		return this.who;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public String getWhat() {
		return this.what;
	}
}