

public class Person {
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		//return "회원가입 [ 이름 : " + name + ", 나이 : " + age + "]";
		return name + " " + age;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
