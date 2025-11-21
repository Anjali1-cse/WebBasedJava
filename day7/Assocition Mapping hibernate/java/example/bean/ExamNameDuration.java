package example.bean;

public class ExamNameDuration {
    
	
	private String examNmae;
	private int ExamDuration;
	
	
	

	public ExamNameDuration() {
		super();
	}
	
	public ExamNameDuration(String examNmae, int examDuration) {
		super();
		this.examNmae = examNmae;
		ExamDuration = examDuration;
	}

	public String getExamNmae() {
		return examNmae;
	}
	public void setExamNmae(String examNmae) {
		this.examNmae = examNmae;
	}
	public int getExamDuration() {
		return ExamDuration;
	}
	public void setExamDuration(int examDuration) {
		ExamDuration = examDuration;
	}


}
