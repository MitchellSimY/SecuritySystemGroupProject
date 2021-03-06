package states;

import events.AllDoorCloseEvent;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * StayCountDoorOpenState class. Singleton class
 * Class that determines the handleEvent of said class
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
public class StayCountDoorOpenState extends SecuritySystemState implements Notifiable {
	private static StayCountDoorOpenState instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private StayCountDoorOpenState() {
	}

	/**
	 * returning the instance
	 * 
	 * @return the instance object
	 */
	public static StayCountDoorOpenState instance() {
		if (instance == null) {
			instance = new StayCountDoorOpenState();
		}
		return instance;
	}

	/**
	 * Entering unarmed state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showTimeLeft
		(SecuritySystemContext.instance().getTimer().getTimeValue());
		//timer.start();
	}

	@Override
	public void leave() {
		//timer.stop();
		
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft
		(SecuritySystemContext.instance().getTimer().getTimeValue());
	}

	@Override
	public void handleEvent(SixtySecondEvent event) throws InterruptedException {
		SecuritySystemContext.instance().changeState(UnarmedStage.instance());
		SecuritySystemContext.instance().getTimer().stop();
		SecuritySystemContext.instance().setTimer(null);
	}

	@Override
	public void handleEvent(AllDoorCloseEvent event) {
		SecuritySystemContext.instance().changeState(StayCountDoorClosedState.instance());
	}

}
