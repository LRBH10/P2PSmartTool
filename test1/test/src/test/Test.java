package test;



import test.view.IChatView;
import javax.swing.SwingUtilities;

import test.view.ChatFrame;

public abstract class Test extends inria.communicationprotocol.CommunicationProtocolFacade {

	protected IChatView view = null;
	
	public Test () {
		//view = getView ();
		//SwingUtilities.invokeLater(new Runnable() {
       //     public void run() {
       //         view = getView ();
        //    }
        //});
	}
	
	public void input( String expeditor, java.lang.String parameter) {
		
		System.out.println("["+expeditor+"] :"+parameter );
		getView().messageArrived(expeditor, parameter);
		
	}

	public abstract void output( java.lang.String parameter);

	public abstract void output( String destination, java.lang.String parameter);
	
	
	public IChatView getView() {
		if (view == null) {
			view = new ChatFrame(this);
		}
		return view;
	}

	@Override
	protected void neighbourJustConnected(String name, String service) {
		if (service.equals("test")) {
			System.out.println(getIdName() + " can now talk to " + name);
			getView().addNeighbour(name);
		}
	}
	
	public void disconnectInput(String expeditor) {
		// TODO Auto-generated method stub
		
	}

	public void shutdown(String expeditor) {
		// TODO Auto-generated method stub
		
	}

	public Object requestTree(String expeditor) {
		// TODO Auto-generated method stub
		return null;
	}

	public void quit(String expeditor) {
		// TODO Auto-generated method stub
		
	}

}
