package buttons;

import events.CancelPressEvent;
import events.StayPressEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecuritySystemContext;
import states.SecuritySystemState;

/**
 * CancelButton class.
 * extends GUIButton class. The button gets the String from GUIDisplay.
 * The handle event will determine what events are to happen.
 * 
 * @author  Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 *
 */

public class CancelButton extends GUIButton implements EventHandler<ActionEvent> {
	
	
	/**
	 * CancelButton Constructor. 
	 * Takes the super and uses the string for naming the button
	 * 
	 * @param string
	 */
	public CancelButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		/**
		 * Making a string for the current state 
		 * Has to be in the handle method.
		 */
		
			SecuritySystemContext.instance().handleEvent(CancelPressEvent.instance());
		} 

		
		
	}


