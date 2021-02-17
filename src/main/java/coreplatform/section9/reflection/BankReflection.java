package coreplatform.section9.reflection;

public class BankReflection implements ReflectionTest{

	private int id;
	private String type;
	
	public BankReflection() {
		super();
	}

	public BankReflection(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BankReflection [id=" + id + ", type=" + type + "]";
	}
	
}
