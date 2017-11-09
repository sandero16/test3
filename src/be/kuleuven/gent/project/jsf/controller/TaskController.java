package be.kuleuven.gent.project.jsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import be.kuleuven.gent.project.data.Task;
import be.kuleuven.gent.project.ejb.TaskManagementEJBLocal;
import be.kuleuven.gent.project.ejb.UserManagementEJBLocal;

@Named
@ViewScoped
public class TaskController implements Serializable{
	private static final long serialVersionUID = -3737221385235612830L;
	
	@EJB
	private TaskManagementEJBLocal taskEJB;
	
	@EJB
	private UserManagementEJBLocal userEJB;
	
	private Task task = new Task();

	public String createTask() {
		taskEJB.createTask(task);
		return "tasks.faces?faces-redirect=true";
	}
	
	public List<Task> findIncompletedPatientTasks(){
		return taskEJB.findIncompletedPatientTasks(null);
	}

	public void findTask() {
		task = taskEJB.findTask(task.getId());
	}
	
	public String updateTask() {
		taskEJB.updateTask(task);
		return "tasks.faces?faces-redirect=true";
	}
	
	public String fileTaskReport() {
		taskEJB.fileTaskReport(task);
		return "tasks.faces?faces-redirect=true";
	}

	public List<Task> findIncompletedTasks() {
		return taskEJB.findIncompletedTasks();
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}
