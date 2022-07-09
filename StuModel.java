package Assignment2;

public class StuModel {
	private int id;
	private String name;
	private int math_mark;
	private int sc_mark;
	
	public StuModel() {
		
	}
	
	public StuModel(String name,int id, int math_mark, int sc_mark) {
		this.name = name;
		this.id=id;
		this.math_mark = math_mark;
		this.sc_mark = sc_mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMath_mark() {
		return math_mark;
	}

	public void setMath_mark(int math_mark) {
		this.math_mark = math_mark;
	}

	public int getSc_mark() {
		return sc_mark;
	}

	public void setSc_mark(int sc_mark) {
		this.sc_mark = sc_mark;
	}

}
