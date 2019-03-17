
public class grid_list {
	private String grid11 = "";
	private String grid12 = "";
	private String grid13 = "";
	private String grid21 = "";
	private String grid22 = "";
	private String grid23 = "";
	private String grid31 = "";
	private String grid32 = "";
	private String grid33 = "";
	
	public String getGrid11() {
		return grid11;
	}
	public void setGrid11(String grid11) {
		this.grid11 = grid11;
	}
	public String getGrid12() {
		return grid12;
	}
	public void setGrid12(String grid12) {
		this.grid12 = grid12;
	}
	public String getGrid13() {
		return grid13;
	}
	public void setGrid13(String grid13) {
		this.grid13 = grid13;
	}
	public String getGrid21() {
		return grid21;
	}
	public void setGrid21(String grid21) {
		this.grid21 = grid21;
	}
	public String getGrid22() {
		return grid22;
	}
	public void setGrid22(String grid22) {
		this.grid22 = grid22;
	}
	public String getGrid23() {
		return grid23;
	}
	public void setGrid23(String grid23) {
		this.grid23 = grid23;
	}
	public String getGrid31() {
		return grid31;
	}
	public void setGrid31(String grid31) {
		this.grid31 = grid31;
	}
	public String getGrid32() {
		return grid32;
	}
	public void setGrid32(String grid32) {
		this.grid32 = grid32;
	}
	public String getGrid33() {
		return grid33;
	}
	public void setGrid33(String grid33) {
		this.grid33 = grid33;
	}

	public void setGrid(String id, String temp) {
		if ("11".equals(id) && grid11=="") {
			this.grid11 = temp;
		}
		else if("12".equals(id) && grid12==""){
			this.grid12 = temp;
		}
		else if("13".equals(id) && grid13==""){
			this.grid13 = temp;
		}
		else if("21".equals(id) && grid21==""){
			this.grid21 = temp;
		}
		else if("22".equals(id) && grid22==""){
			this.grid22 = temp;
		}
		else if("23".equals(id) && grid23==""){
			this.grid23 = temp;
		}
		else if("31".equals(id) && grid31==""){
			this.grid31 = temp;
		}
		else if("32".equals(id) && grid32==""){
			this.grid32 = temp;
		}
		else if("33".equals(id) && grid33==""){
			this.grid33 = temp;
		}
	}
}
