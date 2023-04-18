package com.example;

import io.grpc.stub.StreamObserver;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class ProjectControllerGetIntegrationTest {

    @Inject
    ProjectController projectController;

    @Test
    void whenGetProject_shouldReturnProjects() {
        projectController.getProjects(ProjectsRequest.newBuilder().build(), new StreamObserver<>() {
            @Override
            public void onNext(Projects projects) {
                assertEquals(2, projects.getProjectCount());
                Project project1 = projects.getProject(0);
                assertEquals(1, project1.getId());
                assertEquals("Project 1", project1.getName());
                Project project2 = projects.getProject(1);
                assertEquals(2, project2.getId());
                assertEquals("Project 2", project2.getName());
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        });
    }
}
