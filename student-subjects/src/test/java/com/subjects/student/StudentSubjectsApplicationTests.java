package com.subjects.student;

import com.subjects.student.reposi.StudentRepo;
import com.subjects.student.subjectEntity.StudentScores;
import com.subjects.student.subjectEntity.Subjects;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class StudentSubjectsApplicationTests {

	@Autowired
	private StudentRepo studentRepo;

	@Container
	protected static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.4"));

	@Container
	protected static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.6.1")
			.asCompatibleSubstituteFor("apache/kafka"));

	@Container
	protected static GenericContainer<?> zipkin = new GenericContainer<>(DockerImageName.parse("openzipkin/zipkin:2.23"))
			.withExposedPorts(9411);

	@BeforeAll
	static void startContainers() {
		postgres.start();
		kafka.start();
		zipkin.start();
	}

	@AfterAll
	static void stopContainers() {
		postgres.stop();
		kafka.stop();
		zipkin.stop();
	}

	@DynamicPropertySource
	static void registerDynamicProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgres::getJdbcUrl);
		registry.add("spring.datasource.username", postgres::getUsername);
		registry.add("spring.datasource.password", postgres::getPassword);
		registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
		registry.add("management.tracing.sampling.probability", () -> 1.0); // Enable full tracing for tests
		registry.add("management.zipkin.tracing.endpoint", () -> "http://" + zipkin.getHost() + ":" + zipkin.getMappedPort(9411) + "/api/v2/spans");
	}

	@Test
	void testSubjectScoreSave()
	{
		StudentScores score = new StudentScores(10.0,20.1,37.8,56.11,02.0);
		Subjects subjects =new Subjects();
				subjects.setStudentName("Musa John Daniel");
				subjects.setStudentSubjectScore(score);
			//	.build();
		Subjects newSubject = studentRepo.save(subjects);
		Assertions.assertSame(newSubject,subjects);
	}

}
