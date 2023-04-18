package com.example;

import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;


@Singleton
public class ProjectController extends ProjectServiceGrpc.ProjectServiceImplBase {

    @Override
    public void getProjects(ProjectsRequest request, StreamObserver<Projects> responseObserver) {
        // mock data
        var response = Projects.newBuilder()
                .addProject(Project.newBuilder()
                        .setId(1)
                        .setName("Project 1"))
                .addProject(Project.newBuilder()
                        .setId(2)
                        .setName("Project 2"))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
