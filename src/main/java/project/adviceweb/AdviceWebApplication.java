package project.adviceweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.adviceweb.model.*;
import project.adviceweb.repository.*;

import java.time.LocalDate;

@SpringBootApplication
public class AdviceWebApplication implements CommandLineRunner {

	@Value("(${advice-web.message})")
	String message;

	private final AnswerRepository answerRepository;
	private final CategoryRepository categoryRepository;
	private final CommentRepository commentRepository;
	private final QuestionRepository questionRepository;
	private final UserRepository userRepository;

	public AdviceWebApplication(AnswerRepository answerRepository, CategoryRepository categoryRepository, CommentRepository commentRepository, QuestionRepository questionRepository, UserRepository userRepository) {
		this.answerRepository = answerRepository;
		this.categoryRepository = categoryRepository;
		this.commentRepository = commentRepository;
		this.questionRepository = questionRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AdviceWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(message);

		User user1 = createUser(1L, "jane1", "jane1@mail.com","123");
		System.out.println(user1);

		Category category1 = createCategory(1L, "recipes", "lunch");
		System.out.println(category1);

		Question question1 = createQuestion(1L, 1L, "What are you cooking for lunch?");
		System.out.println(question1);

		Answer answer1 = createAnswer(1L, 1L, 1L, "potato salad", 4L);
		System.out.println(answer1);

		Comment comment1 = createComment(1L, 1L, 1L, "good idea, sounds delicious");


	}

	private User createUser(Long userId, String displayedName, String email, String password) {
		User user = User.builder()
				.userId(userId)
				.displayedName(displayedName)
				.email(email)
				.password(password)
				.build();

		return userRepository.save(user);
	}

	private Category createCategory(Long id, String type, String name) {
		Category category = Category.builder()
				.id(id)
				.type(type)
				.name(name)
				.build();

		return categoryRepository.save(category);
	}

	private Question createQuestion(Long id, Long userId, String content) {
		Question question = new Question();
		question.setId(id);
		question.setUserId(userId);
		question.setContent(content);
		question.setQuestionDate(LocalDate.now());

		return questionRepository.save(question);
	}

	private Answer createAnswer(Long answerId, Long userId, Long questionId, String content, Long evaluation) {
		Answer answer = Answer.builder()
				.answerId(answerId)
				.userId(userId)
				.questionId(questionId)
				.content(content)
				.evaluation(evaluation)
				.build();

		return answerRepository.save(answer);
	}

	private Comment createComment(Long commentId, Long answerId, Long userId, String content) {
		Comment comment = new Comment();
		comment.setCommentId(commentId);
		comment.setAnswerId(answerId);
		comment.setUserId(userId);
		comment.setContent(content);
		comment.setCommentDate(LocalDate.now());

		return commentRepository.save(comment);
	}


}
