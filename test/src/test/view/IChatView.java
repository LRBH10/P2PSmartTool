package test.view;

public interface IChatView {

	public void addNeighbour(String name);
	
	public void messageArrived(String expeditor, String message);
	
	
	public void messageDebug(String expeditor, String message);
	
	public void addConnected(String expeditor);
}
