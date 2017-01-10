package mybatis.mapper;

import java.util.List;


/**
 * 作为一对多的使用：一个班级有多个学生
 * @author Administrator
 *
 */

public class ClassesOne {
	
	private  int id;
	private String  name;
	private Teacher teacher;
	private List<Student> student;
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
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "ClassesOne [id=" + id + ", name=" + name + ", teacher="
				+ teacher + ", student=" + student + "]";
	}
	
	
	
	
	
	
	

}
