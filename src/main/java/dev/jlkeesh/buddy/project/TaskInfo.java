package dev.jlkeesh.buddy.project;

import java.time.Instant;

/**
 * A Projection for the {@link Task} entity
 */
public interface TaskInfo {
    String getName();

    Instant getCreatedAt();
}