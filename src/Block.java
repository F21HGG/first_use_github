
public class Block {
	boolean live=false;
	int number=0;
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Block() {
	}
	public Block(boolean live, int number) {
		this.live = live;
		this.number = number;
	}
	
	
}
