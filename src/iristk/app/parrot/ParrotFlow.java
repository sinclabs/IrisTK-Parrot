package iristk.app.parrot;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class ParrotFlow extends iristk.flow.Flow {

	private int yoda;

	private void initVariables() {
	}

	public int getYoda() {
		return this.yoda;
	}

	public void setYoda(int value) {
		this.yoda = value;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("yoda")) return this.yoda;
		return null;
	}


	public ParrotFlow() {
		initVariables();
	}

	@Override
	public State getInitialState() {return new Start();}


	public class Start extends State implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 7
			try {
				EXECUTION: {
					int count = getCount(1334729950) + 1;
					incrCount(1334729950);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("Hi there, I am the angry parrot!");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 7, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 9
					Listen state2 = new Listen();
					flowThread.gotoState(state2, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 9, 26)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 7, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Listen extends Silence {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 14
			try {
				EXECUTION: {
					int count = getCount(1212899836) + 1;
					incrCount(1212899836);
					iristk.flow.DialogFlow.listen state3 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 14, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 14, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 17
			try {
				count = getCount(1174290147) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1174290147);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state4 = new iristk.flow.DialogFlow.say();
						StringCreator string5 = new StringCreator();
						// Line: 17
						string5.append(event.get("text"));
						if(string5.toString().toLowerCase().contains("shut up")){
							if(yoda == 1)
								yoda = 0;
							
							  
							state4.setText("okay! okay! bite me!");
							if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 17, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 19, 14)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if(string5.toString().toLowerCase().contains("yoda") || yoda == 1){
							if(yoda == 0)
								yoda = 1;
							 StringCreator result = new StringCreator();
							 String s = string5.toString();
							 String shuffledString = ""; 
//							 URL url = new URL("http://api.funtranslations.com/translate/yoda.json?text="+s);
//							 
//						      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//						      conn.setRequestMethod("GET");
//						      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//						      String line;
//						      while ((line = rd.readLine()) != null) {
//						         result.append(line);
//						      }
//						      rd.close();
//						       
						        while (s.length() != 0)
						        {
						            int index = (int) Math.floor(Math.random() * s.length());
						            char c = s.charAt(index);
						            s = s.substring(0,index)+s.substring(index+1);
						            shuffledString += c;
						        }
							 // String a = result.toString().split(":")[4].split(",")[0];
							state4.setText(shuffledString);
							if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 17, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 19, 14)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						else{
							state4.setText(string5.toString());
							if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 17, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 19, 14)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 19
						
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 17, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Silence extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 24
			try {
				count = getCount(1607460018) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1607460018);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state6 = new iristk.flow.DialogFlow.say();
						StringCreator string7 = new StringCreator();
						string7.append("Are you gonna talk or what?");
						state6.setText(string7.toString());
						if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 24, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 26
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 26, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Admin\\dev\\furhatos\\app\\parrot\\src\\iristk\\app\\parrot\\ParrotFlow.xml"), 24, 38));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
