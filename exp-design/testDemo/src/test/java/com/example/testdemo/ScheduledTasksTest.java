package com.example.testdemo;

import com.example.testdemo.schedule.ScheduledTasks;
import org.awaitility.Durations;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;


import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;

@SpringBootTest
public class ScheduledTasksTest {

	@SpyBean
	ScheduledTasks tasks;

	@Test
	public void reportCurrentTime() {
		await().atMost(Durations.TEN_SECONDS).untilAsserted(() -> {
			verify(tasks, atLeast(2)).reportCurrentTime();
		});
	}
}