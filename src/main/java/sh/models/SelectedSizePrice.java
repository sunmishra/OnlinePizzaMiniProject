package sh.models;

import java.util.Arrays;

public class SelectedSizePrice {
	private String sp[];
	public SelectedSizePrice() {
		this.sp = new String[0];
	}
	public String[] getSp() {
		return sp;
	}
	public void setSp(String[] sp) {
		this.sp = sp;
	}
	@Override
	public String toString() {
		return "SelectedSizePrice [sp=" + Arrays.toString(sp) + "]";
	}
	
}
