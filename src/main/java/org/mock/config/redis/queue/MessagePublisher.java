package org.mock.config.redis;

public interface MessagePublisher {
    void publish(final String message);
}
