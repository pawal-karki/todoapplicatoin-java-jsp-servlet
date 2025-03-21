package model;

public class TodoModel {
	private int id;
	private String title;
	private String description;
	private Boolean completed;
	public TodoModel(int id, String title, String description, Boolean completed) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = completed;
	}
	public TodoModel(String title, String description, Boolean completed) {
		super();
		this.title = title;
		this.description = description;
		this.completed = completed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	 public String toString() {
	        return "TodoModel{" +
	                "id=" + id +
	                ", title='" + title + '\'' +
	                ", description='" + description + '\'' +
	                ", completed=" + completed +
	                '}';
	    }

}
