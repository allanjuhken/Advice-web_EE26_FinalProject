package project.adviceweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import project.adviceweb.model.User;
import project.adviceweb.repository.*;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AdviceWebApplication implements CommandLineRunner {
	@Value("(${advice-web.message})")
	String message;

	//private final UserRepository userRepository;
	private final AnswerRepository answerRepository;
	//private final CategoryRepository categoryRepository;
	//private final CommentRepository commentRepository;
	//private final QuestionRepository questionRepository;

	public AdviceWebApplication( AnswerRepository answerRepository) {
		//this.userRepository = userRepository;
		this.answerRepository = answerRepository;
		//this.categoryRepository = categoryRepository;
		//this.commentRepository = commentRepository;
		//this.questionRepository = questionRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(AdviceWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(1L, "jane4","jane4@mail.com","123123");


	}

}